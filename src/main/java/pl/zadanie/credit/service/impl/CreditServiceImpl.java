package pl.zadanie.credit.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.zadanie.credit.controller.request.CreateCreditRequest;
import pl.zadanie.credit.controller.response.CreditCreateResponse;
import pl.zadanie.credit.controller.response.GetCreditsResponse;
import pl.zadanie.credit.repository.CreditRepository;
import pl.zadanie.credit.service.CreditService;

import java.util.List;

@Service
public class CreditServiceImpl implements CreditService {

    private final CreditRepository creditRepository;

    @Autowired
    public CreditServiceImpl(CreditRepository creditRepository) {
        this.creditRepository = creditRepository;
    }

    @Override
    public CreditCreateResponse createCredit(CreateCreditRequest request) {
        return null;
    }

    @Override
    public List<GetCreditsResponse> getAllCredits() {
       //return creditRepository.findAll();
        return null;
    }
}
