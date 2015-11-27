import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Quote {
    private final LocalDate date;
    private final String email;
    private final String partner;

    public Quote(LocalDate date, String email, String partner) {
        this.date = date;
        this.email = email;
        this.partner = partner;
    }

    public static Quote from(String line) {
        String[] parts = line.split(";");

        LocalDate parsed = LocalDate.parse(parts[0], DateTimeFormatter.ofPattern("yyyy/MM/dd"));

        return new Quote(parsed, parts[1], parts[2]);
    }

    public LocalDate getDate() {
        return date;
    }

    public String getEmail() {
        return email;
    }

    public String getPartner() {
        return partner;
    }

    @Override
    public String toString() {
        return "Quote{" +
                        "date='" + date + '\'' +
                        ", email='" + email + '\'' +
                        ", partner='" + partner + '\'' +
                        '}';
    }
}
