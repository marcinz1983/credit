package pl.zadanie.credit.mapper.impl;

import org.springframework.stereotype.Component;
import pl.zadanie.credit.controller.request.CreateCreditRequest;
import pl.zadanie.credit.controller.request.CreateCustomerRequest;
import pl.zadanie.credit.controller.request.SearchCustomerRequest;
import pl.zadanie.credit.controller.response.CreateCustomerResponse;
import pl.zadanie.credit.controller.response.CreditCreateResponse;
import pl.zadanie.credit.controller.response.CustomerSearchResponse;
import pl.zadanie.credit.mapper.CreateCreditMapper;
import pl.zadanie.credit.model.Credit;

@Component
public class CreateCreditMapperImpl implements CreateCreditMapper {


    @Override
    public SearchCustomerRequest mapCreateCreditRequestToSearchCustomerRequest(CreateCreditRequest request) {
        return SearchCustomerRequest.builder()
                .withPesel(request.getPesel())
                .build();
    }

    @Override
    public CreateCustomerRequest mapCreateCreditRequestToCreateCustomerRequest(CreateCreditRequest request) {
        return CreateCustomerRequest.builder()
                .withFirstName(request.getName())
                .withLastName(request.getSurname())
                .withPesel(request.getPesel())
                .build();
    }

    @Override
    public Credit mapCreateCreditResponseToEntity(CreateCreditRequest request, CreateCustomerResponse response) {
        return Credit.builder()
                .withCreditName(request.getCreditName())
                .withCustomerId(response.getCustomerId())
                .withValue(request.getValue())
                .build();
    }

    @Override
    public Credit mapSearchCustomerResponseToEntity(CreateCreditRequest request, CustomerSearchResponse response) {
        Integer customerId = response.getSearchResult().stream()
                .map(id -> id.getCustomerId())
                .findFirst()
                .orElseThrow(()-> new RuntimeException("Can't find CustomerId from CustomerSearchResponse"));
        return Credit.builder()
                .withCreditName(request.getCreditName())
                .withCustomerId(customerId)
                .withValue(request.getValue())
                .build();

    }

    @Override
    public CreditCreateResponse mapEntityToCreditCreateResponse(Credit credit) {
        return CreditCreateResponse.builder()
                .withCreditId(credit.getId())
                .build();
    }
}
