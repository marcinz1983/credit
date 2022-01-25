package pl.zadanie.credit.controller.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.pl.PESEL;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder(setterPrefix = "with")
public class CreateCustomerRequest {

    @NotNull(message = "First name can not be null")
    private String firstName;

    @NotNull(message = "Last name can not be null")
    private String lastName;

    @PESEL(message = "Invalid PESEL")
    private String pesel;
}
