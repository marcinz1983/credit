package pl.zadanie.credit.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.zadanie.credit.controller.request.CreateCreditRequest;
import pl.zadanie.credit.controller.response.CustomerSearchResponse;
import pl.zadanie.credit.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

    private RestTemplate restTemplate;

    private static String apiHost;

    @Autowired
    public CustomerServiceImpl(RestTemplate restTemplate, @Value("${api.host.customerUrl}") String apiHost) {
        this.restTemplate = restTemplate;
        this.apiHost = apiHost;
    }

    @Override
    public CustomerSearchResponse searchCustomer(CreateCreditRequest request) {

        return null;
    }
}
