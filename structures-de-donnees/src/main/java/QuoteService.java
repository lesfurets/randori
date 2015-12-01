import java.util.*;

public class QuoteService implements QuoteProcessor {

    @Override
    public SortedSet<Quote> getQuotesWithDistinctEmailsSortedInReversAlphaFrom(Iterable<Quote> quotes, String
                    fromEmail) {
        TreeSet<Quote> quoteTreeSet = new TreeSet<>(Comparator.comparing(Quote::getEmail).reversed());
        quotes.forEach(quoteTreeSet::add);
        return quoteTreeSet.headSet(new Quote(null, fromEmail, null), false);
    }
}
