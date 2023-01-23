package br.com.update.payment.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class RatesDefinition {
    @JsonProperty("percent_fee")
    public String percentFee;
    @JsonProperty("flat_fee")
    public FlatFee flatFee;
    @JsonProperty("plus_tax")
    public Object plusTax;
    @JsonProperty("days_to_withdraw_money")
    public int daysToWithdrawMoney;
}
