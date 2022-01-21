package pl.zadanie.credit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.zadanie.credit.controller.request.CreateCreditRequest;
import pl.zadanie.credit.controller.response.CreditCreateResponse;
import pl.zadanie.credit.controller.response.GetCreditsResponse;
import pl.zadanie.credit.service.CreditService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("")
public class CreditController {

private final CreditService creditService;

    @Autowired
    public CreditController(CreditService creditService) {
        this.creditService = creditService;
    }

    @PostMapping
    ResponseEntity<CreditCreateResponse> createCredit(@Valid @RequestBody CreateCreditRequest request){
        CreditCreateResponse response = creditService.createCredit(request);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @GetMapping
    ResponseEntity<List<GetCreditsResponse>> getCredits(){
        List<GetCreditsResponse> allCredits = creditService.getAllCredits();
        return  new ResponseEntity<>(allCredits,HttpStatus.OK);
    }


}
