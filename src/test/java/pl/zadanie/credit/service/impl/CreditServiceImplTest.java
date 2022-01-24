package pl.zadanie.credit.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import pl.zadanie.credit.controller.request.CreateCreditRequest;
import pl.zadanie.credit.controller.response.CreateCustomerResponse;
import pl.zadanie.credit.controller.response.CreditCreateResponse;
import pl.zadanie.credit.mapper.CreateCreditMapper;
import pl.zadanie.credit.mapper.GetCreditsMapper;
import pl.zadanie.credit.model.Credit;
import pl.zadanie.credit.repository.CreditRepository;
import pl.zadanie.credit.service.apiClient.impl.ApiClientImpl;

import static org.junit.jupiter.api.Assertions.*;

class CreditServiceImplTest {

    private CreditServiceImpl creditService;

    @Mock
    private  CreditRepository creditRepository;
    @Mock
    private  ApiClientImpl customerApi;
    @Mock
    private  CreateCreditMapper createCreditMapper;
    @Mock
    private  GetCreditsMapper getCreditsMapper;

    @BeforeEach
    void setUp() {creditService = new CreditServiceImpl(creditRepository,customerApi,createCreditMapper,getCreditsMapper);
    }

    //TODO
    @Test
    void createCredit() {
        CreateCreditRequest creditRequest = new CreateCreditRequest
                ("Marcin","Marcin","67030545473","Hipoteczny",1000d);
        CreditCreateResponse creditCreateResponse = new CreditCreateResponse(10);

        Mockito.when(createCreditMapper.mapCreateCreditRequestToCreateCustomerRequest(creditRequest));
        Credit creditToSave = createCreditMapper.mapCreateCreditResponseToEntity(creditRequest,new CreateCustomerResponse(5));

    }

    @Test
    void getAllCredits() {
    }
}