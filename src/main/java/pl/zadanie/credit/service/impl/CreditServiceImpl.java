package pl.zadanie.credit.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.zadanie.credit.controller.CustomerController;
import pl.zadanie.credit.controller.request.CreateCreditRequest;
import pl.zadanie.credit.controller.request.SearchCustomerRequest;
import pl.zadanie.credit.controller.response.CreateCustomerResponse;
import pl.zadanie.credit.controller.response.CreditCreateResponse;
import pl.zadanie.credit.controller.response.CustomerSearchResponse;
import pl.zadanie.credit.controller.response.GetCreditsResponse;
import pl.zadanie.credit.controller.response.GetCustomersResponse;
import pl.zadanie.credit.mapper.CreateCreditMapper;
import pl.zadanie.credit.mapper.GetCreditsMapper;
import pl.zadanie.credit.model.Credit;
import pl.zadanie.credit.repository.CreditRepository;
import pl.zadanie.credit.service.CreditService;

import java.util.List;

@Service
public class CreditServiceImpl implements CreditService {

    private final CreditRepository creditRepository;
    private final CustomerController customerController;
    private final CreateCreditMapper createCreditMapper;
    private final GetCreditsMapper getCreditsMapper;

    @Autowired
    public CreditServiceImpl(CreditRepository creditRepository, CustomerController customerController, CreateCreditMapper createCreditMapper, GetCreditsMapper getCreditsMapper) {
        this.creditRepository = creditRepository;
        this.customerController = customerController;
        this.createCreditMapper = createCreditMapper;
        this.getCreditsMapper = getCreditsMapper;
    }

    @Override
    public CreditCreateResponse createCredit(CreateCreditRequest request) {
        Credit creditToSave;
        SearchCustomerRequest customer = createCreditMapper.mapCreateCreditRequestToSearchCustomerRequest(request);
        CustomerSearchResponse findCustomer = customerController.searchCustomer(customer);
        if(findCustomer.getSearchResult().isEmpty()){
            CreateCustomerResponse createCustomerResponse = customerController.createCustomer(
                   createCreditMapper.mapCreateCreditRequestToCreateCustomerRequest(request));
            creditToSave = createCreditMapper.mapCreateCreditResponseToEntity(request,createCustomerResponse);
        }else {
            creditToSave = createCreditMapper.mapSearchCustomerResponseToEntity(request, findCustomer);
        }
       Credit savedCredit = creditRepository.save(creditToSave);
        return createCreditMapper.mapEntityToCreditCreateResponse(savedCredit);
    }


    @Override
    public List<GetCreditsResponse> getAllCredits() {
      List<Credit> allCreditsFromDB = creditRepository.findAll();
      GetCustomersResponse customers =customerController.getCustomers(getCreditsMapper.mapFromEntityTuGetCustomerRequest(allCreditsFromDB));
        List<GetCreditsResponse> getCreditsResponse = getCreditsMapper.mapCreditAndCustomerToGetCreditResponse(allCreditsFromDB,customers);
        return getCreditsResponse;
    }
}
