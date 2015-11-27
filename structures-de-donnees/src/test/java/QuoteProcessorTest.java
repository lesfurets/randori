import static org.assertj.core.api.Assertions.assertThat;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

public class QuoteProcessorTest {

    private QuoteProcessor quoteProcessor;

    @Before
    public void setUp() throws Exception {
        quoteProcessor = new QuoteService();
    }

    @Test
    public void should_be_sorted_by_date() {
        Quote quoteYesterday = Quote.from("2015/11/26;mathieu@lol.com;33");
        Quote quoteToday = Quote.from("2015/11/27;mathieu@lol.com;33");
        Quote quoteTomorrow = Quote.from("2015/11/28;mathieu@lol.com;33");
        List<Quote> quotes = Arrays.asList(quoteToday, quoteTomorrow, quoteYesterday);
        List<Quote> allQuotesSortedByDate = quoteProcessor.getAllQuotesSortedByDate(quotes);

        assertThat(allQuotesSortedByDate).containsExactly(quoteYesterday, quoteToday, quoteTomorrow);

        List<Quote> empty = Collections.emptyList();
        assertThat(quoteProcessor.getAllQuotesSortedByDate(empty)).isEmpty();
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_if_iterable_is_null() {
        assertThat(quoteProcessor.getAllQuotesSortedByDate(null)).isEmpty();
    }

    @Test
    public void should_return_distinct_emails() {
        Quote quote1 = Quote.from("2015/11/26;mathieu@lol.com;33");
        Quote quote2 = Quote.from("2015/11/26;mathieu@lol.com;33");
        List<Quote> quotes = Arrays.asList(quote1, quote2);

        assertThat(quoteProcessor.getDistinctQuotes(quotes)).containsExactly(quote1);
    }
}
