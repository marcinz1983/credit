package pl.zadanie.credit.mapper;

import pl.zadanie.credit.controller.request.GetCustomersRequest;
import pl.zadanie.credit.controller.response.GetCreditsResponse;
import pl.zadanie.credit.controller.response.GetCustomersResponse;
import pl.zadanie.credit.model.Credit;

import java.util.List;

public interface GetCreditsMapper {

    GetCustomersRequest mapFromEntityTuGetCustomerRequest(List<Credit> credits);

    List<GetCreditsResponse>  mapCreditAndCustomerToGetCreditResponse(List<Credit> creditList, GetCustomersResponse customers);

}
