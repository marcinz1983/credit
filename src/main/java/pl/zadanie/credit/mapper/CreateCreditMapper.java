package pl.zadanie.credit.mapper;

import pl.zadanie.credit.controller.request.CreateCreditRequest;
import pl.zadanie.credit.controller.request.CreateCustomerRequest;
import pl.zadanie.credit.controller.request.SearchCustomerRequest;
import pl.zadanie.credit.controller.response.CreateCustomerResponse;
import pl.zadanie.credit.controller.response.CreditCreateResponse;
import pl.zadanie.credit.controller.response.CustomerSearchResponse;
import pl.zadanie.credit.model.Credit;

public interface CreateCreditMapper {

    SearchCustomerRequest mapCreateCreditRequestToSearchCustomerRequest(CreateCreditRequest request);

    CreateCustomerRequest mapCreateCreditRequestToCreateCustomerRequest(CreateCreditRequest request);

    Credit mapCreateCreditResponseToEntity(CreateCreditRequest request, CreateCustomerResponse response);

    Credit mapSearchCustomerResponseToEntity(CreateCreditRequest request, CustomerSearchResponse response);

    CreditCreateResponse mapEntityToCreditCreateResponse(Credit credit);
}
