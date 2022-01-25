package pl.zadanie.credit.service.apiClient.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.zadanie.credit.controller.request.CreateCustomerRequest;
import pl.zadanie.credit.controller.request.GetCustomersRequest;
import pl.zadanie.credit.controller.request.SearchCustomerRequest;
import pl.zadanie.credit.controller.response.CreateCustomerResponse;
import pl.zadanie.credit.controller.response.CustomerSearchResponse;
import pl.zadanie.credit.controller.response.GetCustomersResponse;
import pl.zadanie.credit.service.apiClient.ApiClient;

@Service
public class ApiClientImpl implements ApiClient {

    private final RestTemplate restTemplate;
    private static String apiHost;
    private static final String SEARCH_CUSTOMER_URL = "/customer/search";
    private static final String CREATE_CUSTOMER_URL = "/customer";
    private static final String FILTERED_CUSTOMER_URL = "/customer/filtered";

    @Autowired
    public ApiClientImpl(RestTemplate restTemplate, @Value("${api.host.customerUrl}") String apiHost) {
        this.restTemplate = restTemplate;
        this.apiHost = apiHost;
    }


    @Override
    public CustomerSearchResponse searchCustomer(SearchCustomerRequest request) {
        ResponseEntity<CustomerSearchResponse> response = restTemplate.postForEntity(apiHost + SEARCH_CUSTOMER_URL,
                request, CustomerSearchResponse.class);
        return response.getBody();
    }

    @Override
    public CreateCustomerResponse createCustomer(CreateCustomerRequest request) {
        ResponseEntity<CreateCustomerResponse> response = restTemplate.postForEntity(apiHost + CREATE_CUSTOMER_URL,
                request, CreateCustomerResponse.class);
        return response.getBody();
    }

    @Override
    public GetCustomersResponse getCustomers(GetCustomersRequest request) {
        ResponseEntity<GetCustomersResponse> response = restTemplate.postForEntity(apiHost + FILTERED_CUSTOMER_URL,
                request, GetCustomersResponse.class);
        return response.getBody();
    }

}
