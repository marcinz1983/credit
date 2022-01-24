package pl.zadanie.credit.mapper.impl;

import org.springframework.stereotype.Component;
import pl.zadanie.credit.controller.request.GetCustomersRequest;
import pl.zadanie.credit.controller.response.GetCreditsResponse;
import pl.zadanie.credit.controller.response.GetCustomersResponse;
import pl.zadanie.credit.mapper.GetCreditsMapper;
import pl.zadanie.credit.model.Credit;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;


@Component
public class GetCreditsMapperImpl implements GetCreditsMapper {


    @Override
    public GetCustomersRequest mapFromEntityTuGetCustomerRequest(List<Credit> credits) {
        List<Integer> customersId = credits.stream()
                .map(id -> id.getCustomerId())
                .collect(Collectors.toList());
        return GetCustomersRequest.builder()
                .withCustomersIds(customersId)
                .build();
    }

    @Override
    public List<GetCreditsResponse> mapCreditAndCustomerToGetCreditResponse(List<Credit> creditList, GetCustomersResponse customers) {

        List<GetCreditsResponse> creditInProgress1 = customers.getCustomers().stream()
                .map(value -> new GetCreditsResponse(value.getFirstName(), value.getLastName(), value.getPesel(), null, null, null, value.getCustomerId()))
                .collect(Collectors.toList());

        List<GetCreditsResponse> creditInProgress2 = creditList.stream()
                .map(value -> new GetCreditsResponse(null, null, null, value.getCreditName(), value.getValue(), value.getId(), value.getCustomerId()))
                .collect(Collectors.toList());

        Map<Integer, GetCreditsResponse> credit1 = creditInProgress1.stream().collect(Collectors.toMap(GetCreditsResponse::getCustomerId, Function.identity()));
        Map<Integer, GetCreditsResponse> credit2 = creditInProgress2.stream().collect(Collectors.toMap(GetCreditsResponse::getCustomerId, Function.identity()));

        credit1.keySet().forEach(key -> credit1.merge(key,
                credit2.get(key),
                new BiFunction<GetCreditsResponse, GetCreditsResponse, GetCreditsResponse>() {
                    @Override
                    public GetCreditsResponse apply(GetCreditsResponse credit1, GetCreditsResponse credit2) {
                        credit1.setCreditName(credit2.getCreditName());
                        credit1.setValue(credit2.getValue());
                        credit1.setCreditId(credit2.getCreditId());
                        return credit1;
                    }
                }));

        List<GetCreditsResponse> creditsList = new ArrayList<GetCreditsResponse>(credit1.values());
        return creditsList;
    }

}
