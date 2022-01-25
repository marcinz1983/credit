package pl.zadanie.credit.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder(setterPrefix = "with")
public class GetCustomersRequest {

    @NotNull(message = "List of customer Ids can not be empty")
    private List<Integer> customersIds;
}
