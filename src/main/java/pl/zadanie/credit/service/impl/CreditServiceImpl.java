package pl.zadanie.credit.service.impl;

import org.springframework.stereotype.Service;
import pl.zadanie.credit.controller.request.CreateCreditRequest;
import pl.zadanie.credit.controller.response.CreditCreateResponse;
import pl.zadanie.credit.controller.response.GetCreditsResponse;
import pl.zadanie.credit.service.CreditService;

import java.util.List;

@Service
public class CreditServiceImpl implements CreditService {

    @Override
    public CreditCreateResponse createCredit(CreateCreditRequest request) {
        return null;
    }

    @Override
    public List<GetCreditsResponse> getAllCredits() {
        return null;
    }
}
