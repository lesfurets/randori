import java.util.List;
import java.util.Set;

public interface QuoteProcessor {
    List<Quote> getAllQuotesSortedByDate(Iterable<Quote> quotes);
    Set<Quote> getDistinctQuotes(Iterable<Quote> quotes);
    // SortedSet<?> getQuotesWithDistinctNamesSortedByDate();     // Et pour 1M quotes avec 10 noms?
}
