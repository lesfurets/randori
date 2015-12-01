import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.SortedSet;

import org.junit.Test;

public class QuoteProcessorTest {

    @Test
    public void should_send_reverse_alpha_ordered_filtered_from_email_exclusive_set() {
        String excludedEmail = "b@b.com";
        Quote quoteExcluded = Quote.from("2014/11/23;a@a.com;provider");
        Quote quoteIncludedAsEqual = Quote.from("2014/11/23;" + excludedEmail + ";provider");
        Quote quoteIncluded = Quote.from("2014/11/23;c@c.com;provider");

        QuoteProcessor quoteProcessor = new QuoteService();

        SortedSet<Quote> quotesWithDistinctEmailsSortedInReversAlphaFrom = quoteProcessor
                        .getQuotesWithDistinctEmailsSortedInReversAlphaFrom(Arrays.asList(quoteExcluded,
                                        quoteIncludedAsEqual, quoteIncluded), excludedEmail);

        assertThat(quotesWithDistinctEmailsSortedInReversAlphaFrom).containsExactly(
                        quoteIncluded
        );
    }
}
