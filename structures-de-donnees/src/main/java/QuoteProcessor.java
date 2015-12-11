import java.util.List;
import java.util.Set;
import java.util.SortedSet;

public interface QuoteProcessor {
    List<Quote> getAllQuotesSortedByDate(Iterable<Quote> quotes); // should return quotes sorted by date
    Set<Quote> getDistinctQuotes(Iterable<Quote> quotes); // should return quotes that are distinct by all fields
    Set<Quote> getDistinctQuoteByEmail(Iterable<Quote> quotes); // should return quotes that have distinct emails
    SortedSet<Quote> getQuotesWithDistinctEmailSortedInReversAlpha(Iterable<Quote> quotes); // should return quotes that have distinct emails and are sorted by email in reverse alphabetical order
    // SortedSet<Quote> getQuotesWithDistinctEmailsSortedInReversAlphaFrom(Iterable<Quote> quotes, String fromEmail); // same problem, but start from some specific email inclusive
}
