package pl.zadanie.credit.service;

import pl.zadanie.credit.controller.request.CreateCreditRequest;
import pl.zadanie.credit.controller.response.CustomerSearchResponse;

public interface CustomerService {


    CustomerSearchResponse searchCustomer(CreateCreditRequest request);
}
