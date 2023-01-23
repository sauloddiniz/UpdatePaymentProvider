package br.com.update.payment.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Rate {
    @JsonProperty("payment_method_type")
    public String paymentMethodType;
    @JsonProperty("rates_definition")
    public ArrayList<RatesDefinition> ratesDefinition;
}
