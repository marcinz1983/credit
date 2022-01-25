package pl.zadanie.credit.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder(setterPrefix = "with")
public class CustomerDTO {

    private Integer customerId;

    private String firstName;

    private String lastName;

    private String pesel;

}
