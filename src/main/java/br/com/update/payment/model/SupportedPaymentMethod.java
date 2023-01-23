package br.com.update.payment.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class SupportedPaymentMethod {
    @JsonProperty("payment_method_type")
    public String paymentMethodType;
    @JsonProperty("payment_methods")
    public ArrayList<String> paymentMethods;
    public Installments installments;
    public Object discount;
}
