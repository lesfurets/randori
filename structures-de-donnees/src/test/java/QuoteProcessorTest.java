import static java.time.LocalDate.now;
import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.*;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class QuoteProcessorTest {

    private QuoteService quoteService = new QuoteService();

    @Test
    public void should_empty_list_when_no_quote() {
        // Given
        Iterable<Quote> emptyIterable = emptyList();

        // When
        List<Quote> quotes = quoteService.getAllQuotesSortedByDate(emptyIterable);

        // Then
        assertThat(quotes).isEmpty();
    }

    @Test
    public void should_return_same_quote_when_one_quote_is_given(){
        // Given
        Quote quote = new Quote(now(), "test@test.fr", "axa");
        Iterable<Quote> quoteIterable = asList(quote);

        // When
        List<Quote> quotes = quoteService.getAllQuotesSortedByDate(quoteIterable);

        //Then
        assertThat(quotes).containsExactly(quote);
    }

    @Test
    public void should_return_quotes_sorted_by_dates() throws Exception {
        // Given
        Quote quote = new Quote(now(), "test@test.fr", "axa");
        Quote olderQuote = new Quote(now().minusDays(1), "test@test.fr", "axa");
        Quote newerQuote = new Quote(now().plusDays(1), "test@test.fr", "axa");
        Iterable<Quote> quoteIterable = asList(quote, olderQuote, newerQuote);

        // When
        List<Quote> quotes = quoteService.getAllQuotesSortedByDate(quoteIterable);

        //Then
        assertThat(quotes).containsExactly(olderQuote, quote, newerQuote);
    }

    @Test
    public void should_return_same_quotes_when_no_duplicated_quote() throws Exception {
        // Given
        Quote quote1 = new Quote(now(), "test@test.fr", "axa");
        Quote quote2 = new Quote(now().minusDays(1), "test1@test.fr", "axa");
        Quote quote3 = new Quote(now().plusDays(1), "test2@test.fr", "amaguiz");
        Iterable<Quote> quoteIterable = asList(quote1, quote2, quote3);

        // When
        Set<Quote> quotes = quoteService.getDistinctQuotes(quoteIterable);

        //Then
        assertThat(quotes).containsOnly(quote1, quote2, quote3);
    }
    @Test
    public void should_return_deduplicated_quotes_when_duplicate_quotes_are_given() throws Exception {
        // Given
        Quote quote1 = new Quote(now(), "test@test.fr", "axa");
        Quote quote1Duplicate = new Quote(now(), "test@test.fr", "axa");
        Quote quote2 = new Quote(now().minusDays(1), "test1@test.fr", "axa");
        Quote quote3 = new Quote(now().plusDays(1), "test2@test.fr", "amaguiz");
        Iterable<Quote> quoteIterable = asList(quote1, quote2, quote3,quote1Duplicate);

        // When
        Set<Quote> quotes = quoteService.getDistinctQuotes(quoteIterable);

        //Then
        assertThat(quotes).containsOnly(quote1, quote2, quote3);
    }

    @Test
    public void should_return_same_quotes_when_no_duplicated_emails() throws Exception {
        // Given
        Quote quote1 = new Quote(now(), "test@test.fr", "axa");
        Quote quote2 = new Quote(now(), "test1@test.fr", "axa");
        Quote quote3 = new Quote(now(), "test2@test.fr", "axa");
        Iterable<Quote> quoteIterable = asList(quote1, quote2, quote3);

        // When
        Set<Quote> quotes = quoteService.getDistinctQuoteByEmail(quoteIterable);

        //Then
        assertThat(quotes).containsOnly(quote1, quote2, quote3);
    }

    @Test
    public void should_return_deduplicated_quotes_by_emails() throws Exception {
        // Given
        Quote quote = new Quote(now(), "test@test.fr", "axa");
        Quote quoteDuplicate = new Quote(now(), "test@test.fr", "amaguiz");
        Quote quote3 = new Quote(now(), "test2@test.fr", "axa");
        Iterable<Quote> quoteIterable = asList(quote, quoteDuplicate, quote3);

        // When
        Set<Quote> quotes = quoteService.getDistinctQuoteByEmail(quoteIterable);

        //Then
        assertThat(quotes).containsOnly(quote, quote3);
    }

}
