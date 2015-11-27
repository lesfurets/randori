import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;

public class QuoteTest {
    @Test
    public void shouldParseQuoteFromString() {
        Quote quote = Quote.from("2015/11/29;mathieu@lol.com;33");

        assertEquals(quote.getDate(), LocalDate.of(2015, 11, 29));
        assertEquals(quote.getPartner(), "33");
        assertEquals(quote.getEmail(), "mathieu@lol.com");

    }
}