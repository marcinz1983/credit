package pl.zadanie.credit.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.pl.PESEL;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder(setterPrefix = "with")
public class CreateCreditRequest {

    @NotNull(message = "Name cannot be null")
    private String name;

    @NotNull(message = "Surname cannot be null")
    private String surname;

    @PESEL(message = "Invalid PESEL")
    private String pesel;

    @NotNull(message = "Credit name can not be null")
    private String creditName;

    @Column(name = "Value can not be null")
    private Double value;
}
