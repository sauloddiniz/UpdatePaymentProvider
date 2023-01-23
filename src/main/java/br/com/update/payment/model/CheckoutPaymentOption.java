package br.com.update.payment.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class CheckoutPaymentOption {
    public String id;
    public String name;
    public String description;
    @JsonProperty("logo_url")
    public String logoUrl;
    @JsonProperty("supported_billing_countries")
    public ArrayList<String> supportedBillingCountries;
    @JsonProperty("supported_payment_method_types")
    public ArrayList<String> supportedPaymentMethodTypes;
    @JsonProperty("integration_type")
    public String integrationType;
}
