package pl.zadanie.credit.mapper.impl;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import pl.zadanie.credit.controller.response.CustomerDTO;
import pl.zadanie.credit.controller.response.GetCreditsResponse;
import pl.zadanie.credit.controller.response.GetCustomersResponse;
import pl.zadanie.credit.model.Credit;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GetCreditsMapperImplTest {

    GetCreditsMapperImpl getCreditsMapper = new GetCreditsMapperImpl();

    @Test
    void mapFromEntityTuGetCustomerRequest() {
    }

    @Test
    void mapCreditAndCustomerToGetCreditResponse() {
        //given
        GetCreditsResponse getCreditsResponse = new GetCreditsResponse(
                "Marcin","Marcin","87103195338","Hipoteczny",1000d,100,20);
        List<GetCreditsResponse> creditsResponseList = List.of(getCreditsResponse);
        Credit credit = new Credit(100,"Hipoteczny",20,1000d);
        List creditList = List.of(credit);
        CustomerDTO customerDTO = new CustomerDTO(20,"Marcin","Marcin","87103195338");
        GetCustomersResponse customersResponse = new GetCustomersResponse(List.of(customerDTO));

        //when
       var response = getCreditsMapper.mapCreditAndCustomerToGetCreditResponse(creditList,customersResponse);

       //then
        Assert.assertEquals(creditsResponseList,response);

    }
}