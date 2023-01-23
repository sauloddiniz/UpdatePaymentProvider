package br.com.update.payment.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import br.com.update.payment.model.PaymentProviderDto;

public class UpdatePaymentProvider {

    private String URL;

    private ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

    public UpdatePaymentProvider(String idCliente, String idPaymentProvider){
        this.URL = String.format("https://api.nuvemshop.com.br/v1/%s/payment_providers/%s", idCliente, idPaymentProvider);
    }
    public void updatePaymentProvider(PaymentProviderDto providerDto){

        updateRatesPaymentProvider(providerDto);

        String jsonObject = null;

        try {
            jsonObject = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(providerDto);
            System.out.println(jsonObject);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL))
                .method("PUT", HttpRequest.BodyPublishers.ofString(jsonObject))
                .header("Authentication", providerDto.getTokenNuvem())
                .header("Content-Type","application/json")
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.statusCode());
        } catch (MismatchedInputException ignored) {

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void updateRatesPaymentProvider(PaymentProviderDto providerDto) {
        providerDto.rates.forEach(e -> {
            if (e.paymentMethodType.equals("boleto")){
                e.ratesDefinition.get(0).daysToWithdrawMoney = 2;
                e.ratesDefinition.get(0).flatFee.value = "2.99";
                e.ratesDefinition.get(0).percentFee = "0";
            }
            if (e.paymentMethodType.equals("credit_card")){
                e.ratesDefinition.get(0).daysToWithdrawMoney = 14;
                e.ratesDefinition.get(0).flatFee.value = "0.40";
                e.ratesDefinition.get(0).percentFee = "2.39";
            }
            if (e.paymentMethodType.equals("pix")){
                e.ratesDefinition.get(0).daysToWithdrawMoney = 0;
                e.ratesDefinition.get(0).flatFee.value = "0";
                e.ratesDefinition.get(0).percentFee = "1.00";
            }
            if (e.paymentMethodType.equals("wallet")){
                e.ratesDefinition.get(0).daysToWithdrawMoney = 0;
                e.ratesDefinition.get(0).flatFee.value = "0";
                e.ratesDefinition.get(0).percentFee = "0";
            }
        });
    }
}
