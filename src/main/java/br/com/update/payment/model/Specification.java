package br.com.update.payment.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Specification {
    public int installments;
    @JsonProperty("interest_rate")
    public String interestRate;
    @JsonProperty("applies_to")
    public ArrayList<Object> appliesTo;
}
