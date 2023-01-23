package br.com.update.payment.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class LogoUrls {
    @JsonProperty("400x120")
    public String _400x120;
    @JsonProperty("160x100")
    public String _160x100;
}
