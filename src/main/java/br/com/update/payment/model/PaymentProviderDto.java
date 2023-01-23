package br.com.update.payment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class PaymentProviderDto {

    public String id;
    public String storeId;
    public int appId;
    @JsonProperty("public_name")
    public Object publicName;
    public String name;
    public String description;
    @JsonProperty("logo_urls")
    public LogoUrls logoUrls;
    @JsonProperty("configuration_url")
    public Object configurationUrl;
    @JsonProperty("support_url")
    public Object supportUrl;
    @JsonProperty("checkout_js_url")
    public String checkoutJsUrl;
    @JsonProperty("checkout_payment_options")
    public ArrayList<CheckoutPaymentOption> checkoutPaymentOptions;
    @JsonProperty("rates_url")
    public Object ratesUrl;
    @JsonProperty("supported_currencies")
    public ArrayList<String> supportedCurrencies;
    public ArrayList<Object> features;
    @JsonProperty("supported_payment_methods")
    public ArrayList<SupportedPaymentMethod> supportedPaymentMethods;
    public ArrayList<Rate> rates;
    public boolean enabled;

    private String code;
    private String message;
    @JsonIgnore
    private String tokenNuvem;
    @JsonIgnore
    public int countNumberQuantityPaymentProvider;
}
