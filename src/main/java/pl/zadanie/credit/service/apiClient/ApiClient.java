package pl.zadanie.credit.service.apiClient;

import org.springframework.web.bind.annotation.RequestBody;
import pl.zadanie.credit.controller.request.CreateCustomerRequest;
import pl.zadanie.credit.controller.request.GetCustomersRequest;
import pl.zadanie.credit.controller.request.SearchCustomerRequest;
import pl.zadanie.credit.controller.response.CreateCustomerResponse;
import pl.zadanie.credit.controller.response.CustomerSearchResponse;
import pl.zadanie.credit.controller.response.GetCustomersResponse;

public interface ApiClient {

    CustomerSearchResponse searchCustomer( SearchCustomerRequest request);

    CreateCustomerResponse createCustomer( CreateCustomerRequest request);

    GetCustomersResponse getCustomers (GetCustomersRequest request);
}
