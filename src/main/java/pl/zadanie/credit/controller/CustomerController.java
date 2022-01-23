package pl.zadanie.credit.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import pl.zadanie.credit.controller.request.CreateCustomerRequest;
import pl.zadanie.credit.controller.request.GetCustomersRequest;
import pl.zadanie.credit.controller.request.SearchCustomerRequest;
import pl.zadanie.credit.controller.response.CreateCustomerResponse;
import pl.zadanie.credit.controller.response.CustomerSearchResponse;
import pl.zadanie.credit.controller.response.GetCustomersResponse;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private RestTemplate restTemplate;

    private static String apiHost;

    @Autowired
    public CustomerController(RestTemplate restTemplate, @Value("${api.host.customerUrl}") String apiHost) {
        this.restTemplate = restTemplate;
        this.apiHost = apiHost;
    }

    @PostMapping("/search")
    public CustomerSearchResponse searchCustomer(@RequestBody SearchCustomerRequest request) {
        ResponseEntity<CustomerSearchResponse> response = restTemplate.postForEntity(apiHost+"/customer/search",request,CustomerSearchResponse.class);
        return response.getBody();
    }

    @PostMapping
    public CreateCustomerResponse createCustomer(@RequestBody CreateCustomerRequest request) {
        ResponseEntity<CreateCustomerResponse> response = restTemplate.postForEntity(apiHost+"/customer",request,CreateCustomerResponse.class);
        return response.getBody();
    }

    @PostMapping("/filtered")
    public GetCustomersResponse getCustomers (@RequestBody GetCustomersRequest request) {
        ResponseEntity<GetCustomersResponse> response = restTemplate.postForEntity(apiHost+"/customer/filtered",request,GetCustomersResponse.class);
        return response.getBody();
    }


}
