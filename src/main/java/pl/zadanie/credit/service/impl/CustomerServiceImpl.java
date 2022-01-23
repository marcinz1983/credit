package pl.zadanie.credit.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.zadanie.credit.controller.request.CreateCreditRequest;
import pl.zadanie.credit.controller.response.CustomerSearchResponse;
import pl.zadanie.credit.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

    RestTemplate restTemplate;

    @Autowired
    public CustomerServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public CustomerSearchResponse searchCustomer(CreateCreditRequest request) {

        return null;
    }
}
