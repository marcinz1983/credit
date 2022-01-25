package pl.zadanie.credit.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.pl.PESEL;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder(setterPrefix = "with")
public class SearchCustomerRequest {

    @PESEL(message = "Invalid PESEL")
    private String pesel;

}
