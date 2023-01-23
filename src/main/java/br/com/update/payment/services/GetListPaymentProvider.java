package br.com.update.payment.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import br.com.update.payment.model.PaymentProviderDto;

public class GetListPaymentProvider {
    private String tokenNuvem;
    private String URL = null;
    private ObjectMapper mapper = new ObjectMapper();

    public GetListPaymentProvider(final String idCliente, final String tokenNuvem){
        this.tokenNuvem = "bearer "+tokenNuvem;
        this.URL = String.format("https://api.nuvemshop.com.br/v1/%s/payment_providers", idCliente);
    }

    public List<PaymentProviderDto> getListPaymentProvider(){

        List<PaymentProviderDto> providerDto = null;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL))
                .header("Authentication",tokenNuvem)
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            providerDto = mapper.readValue(response.body(), new TypeReference<List<PaymentProviderDto>>(){});
            int i = 0;
            for(PaymentProviderDto provider : providerDto) {
                provider.setTokenNuvem(tokenNuvem);
                provider.countNumberQuantityPaymentProvider = i;
                i++;
            };
        } catch (MismatchedInputException e) {
            return null;
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return providerDto;
    }

}
