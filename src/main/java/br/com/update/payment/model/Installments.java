package br.com.update.payment.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Installments {
    @JsonProperty("min_installment_value")
    public ArrayList<MinInstallmentValue> minInstallmentValue;
    public ArrayList<Specification> specification;
}
