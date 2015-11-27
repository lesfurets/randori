import java.util.*;

public class QuoteService implements QuoteProcessor {

    public List<Quote> getAllQuotesSortedByDate(Iterable<Quote> quotes) {
        if (quotes == null) {
            throw new IllegalArgumentException("Quotes list must be not null BITCH !!!");
        }
        List<Quote> sortedQuotes = new ArrayList<>();
        quotes.forEach(sortedQuotes::add);
        sortedQuotes.sort(Comparator.comparing(Quote::getDate));
        return sortedQuotes;
    }

    public Set<Quote> getDistinctQuotes(Iterable<Quote> quotes) {
        Set<Quote> emails = new HashSet<>();
        quotes.forEach(emails::add);
        return emails;
    }

    // SortedSet<?> getQuotesWithDistinctNamesSortedByDate();     // Et pour 1M quotes avec 10 noms?
}
