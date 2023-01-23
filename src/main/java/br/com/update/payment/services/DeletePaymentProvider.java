package br.com.update.payment.services;

import br.com.update.payment.model.PaymentProviderDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class DeletePaymentProvider {

    private String URL;

    private ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

    public DeletePaymentProvider(String idCliente, String idPaymentProvider){
        this.URL = String.format("https://api.nuvemshop.com.br/v1/%s/payment_providers/%s", idCliente, idPaymentProvider);
    }
    public void deletePaymentProvider(PaymentProviderDto paymentProvider){
        if (paymentProvider.countNumberQuantityPaymentProvider > 0){
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(URL))
                    .method("DELETE", HttpRequest.BodyPublishers.noBody())
                    .header("Authentication", paymentProvider.getTokenNuvem())
                    .build();

            try {
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                System.out.println(response.statusCode());
            } catch (MismatchedInputException ignored) {

            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
