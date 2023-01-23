package br.com.update.payment;

import br.com.update.payment.services.DeletePaymentProvider;
import br.com.update.payment.services.GetListPaymentProvider;
import br.com.update.payment.services.UpdatePaymentProvider;
import br.com.update.payment.readerfile.ReaderCSV;
import java.util.HashMap;
import java.util.List;
import br.com.update.payment.model.PaymentProviderDto;
import br.com.update.payment.model.SellerDTO;

public class Main {

    public static void main(String[] args) {
        var sellers = new ReaderCSV("files/results.csv").getValuesFromFile();
        var listPaymentProvider = getListPaymentProvider(sellers);
        deletePaymentProvider(listPaymentProvider);
        updateListPaymentProvider(listPaymentProvider);
    }

    private static HashMap<String,
            List<PaymentProviderDto>> getListPaymentProvider(List<SellerDTO> sellers) {

        HashMap<String, List<PaymentProviderDto>> listPaymentProvider = new HashMap<>();

        sellers.forEach(seller -> {
            listPaymentProvider.put(
                    seller.getId(),
                    new GetListPaymentProvider(
                            seller.getId(),seller.getAccessTokenEcommerce())
                            .getListPaymentProvider());
        });
        return listPaymentProvider;
    }

    private static void updateListPaymentProvider
            (HashMap<String, List<PaymentProviderDto>> listPaymentProvider) {

        listPaymentProvider.forEach((key, value) -> {
            if (value != null && !value.isEmpty()){
                value.forEach(e -> new UpdatePaymentProvider(key,e.id)
                        .updatePaymentProvider(e));
            }
        });
    }

    private static void deletePaymentProvider(HashMap<String, List<PaymentProviderDto>> listPaymentProvider) {
        listPaymentProvider.forEach((key, value) -> {
            if (value != null && !value.isEmpty()){
                value.forEach(e -> new DeletePaymentProvider(key,e.id)
                        .deletePaymentProvider(e));
            }
        });
    }
}