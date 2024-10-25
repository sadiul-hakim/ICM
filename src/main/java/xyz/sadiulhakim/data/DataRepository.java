package xyz.sadiulhakim.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import xyz.sadiulhakim.exception.ApplicationException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

@Component
public class DataRepository {
    private final File DATA = new ClassPathResource("static/data.json").getFile();

    private final ObjectMapper mapper;

    public DataRepository(ObjectMapper mapper) throws IOException {
        this.mapper = mapper;
    }

    public void save(Data data) {
        try {
            String dataText = mapper.writeValueAsString(data);
            Files.writeString(DATA.toPath(), dataText);
        } catch (Exception ex) {
            throw new ApplicationException("Could not save DATA.");
        }
    }

    public Data getData() {
        try {
            String dataText = Files.readString(DATA.toPath());
            return mapper.readValue(dataText, Data.class);
        } catch (Exception ex) {
            throw new ApplicationException("Could not retrieve DATA.");
        }
    }

    public void add(Transaction transaction) {
        Data data = getData();
        data.getTransactions().add(transaction);

        if (transaction.getType().equals(TransactionType.INCOME)) {
            data.setBalance(data.getBalance() + transaction.getAmount());
        } else {
            data.setBalance(data.getBalance() - transaction.getAmount());
        }
        save(data);
    }

    public void clear() {
        Data data = getData();
        data.setTransactions(new ArrayList<>());
        data.setBalance(0);
        save(data);
    }

    public void changePassword(String currentPassword, String newPassword) {
        Data data = getData();
        if (!data.getPassword().equals(currentPassword)) {
            throw new ApplicationException("Invalid password");
        }

        data.setPassword(newPassword);
        save(data);
    }
}
