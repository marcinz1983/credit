package pl.zadanie.credit.service;


import pl.zadanie.credit.controller.request.CreateCreditRequest;
import pl.zadanie.credit.controller.response.CreditCreateResponse;
import pl.zadanie.credit.controller.response.GetCreditsResponse;

import java.util.List;

public interface CreditService {

    CreditCreateResponse createCredit(CreateCreditRequest request);

    List<GetCreditsResponse> getAllCredits();
}

