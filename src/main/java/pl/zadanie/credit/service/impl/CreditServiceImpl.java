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
import pl.zadanie.credit.mapper.CreateCreditMapper;
import pl.zadanie.credit.model.Credit;
import pl.zadanie.credit.repository.CreditRepository;
import pl.zadanie.credit.service.CreditService;

import java.util.List;

@Service
public class CreditServiceImpl implements CreditService {

    private final CreditRepository creditRepository;
    private final CustomerController customerController;
    private final CreateCreditMapper createCreditMapper;

    @Autowired
    public CreditServiceImpl(CreditRepository creditRepository, CustomerController customerController, CreateCreditMapper createCreditMapper) {
        this.creditRepository = creditRepository;
        this.customerController = customerController;
        this.createCreditMapper = createCreditMapper;
    }

    @Override
    public CreditCreateResponse createCredit(CreateCreditRequest request) {
        Credit creditToSave;
        SearchCustomerRequest customer = createCreditMapper.mapCreateCreditRequestToSearchCustomerRequest(request);
        CustomerSearchResponse customerFromRestCustomer = customerController.searchCustomer(customer);
        if(customerFromRestCustomer.getSearchResult().isEmpty()){
            CreateCustomerResponse createCustomerResponse = customerController.createCustomer(
                   createCreditMapper.mapCreateCreditRequestToCreateCustomerRequest(request));
            creditToSave = createCreditMapper.mapCreateCreditResponseToEntity(request,createCustomerResponse);
        }else {
            creditToSave = createCreditMapper.mapSearchCustomerResponseToEntity(request, customerFromRestCustomer);
        }
       Credit savedCredit = creditRepository.save(creditToSave);
        return createCreditMapper.mapEntityToCreditCreateResponse(savedCredit);
    }


    @Override
    public List<GetCreditsResponse> getAllCredits() {
       //return creditRepository.findAll();
        return null;
    }
}
