package br.com.update.payment.readerfile;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import br.com.update.payment.model.SellerDTO;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class ReaderCSV {

    private String file;

    public ReaderCSV(String file){
        this.file = file;
    }

    public List<SellerDTO> getValuesFromFile(){

        FileReader reader = null;
        Iterable<CSVRecord> records = null;
        List<SellerDTO> sellers = new ArrayList<>();

        try {
            reader = new FileReader(file);
            records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for(CSVRecord record : records ) {
            String idNuvem = record.get("id");
            String accessTokenEcommerce = record.get("accessTokenEcommerce");
            if (idNuvem != null && accessTokenEcommerce != null) {
                sellers.add(SellerDTO.builder().id(idNuvem).accessTokenEcommerce(accessTokenEcommerce).build());
            }
        }

        return sellers;
    }

}
