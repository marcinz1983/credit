package pl.zadanie.credit.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder(setterPrefix = "with")
public class GetCreditsResponse {


    private String name;

    private String surname;

    private String pesel;

    private String creditName;

    private Double value;

    private Integer creditId;

}
