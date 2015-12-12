import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.Supplier;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class QuoteService implements QuoteProcessor {

    @Override
    public List<Quote> getAllQuotesSortedByDate(Iterable<Quote> quotes) {
        return StreamSupport.stream(quotes.spliterator(), false)
                .sorted(comparing(Quote::getDate))
                .collect(toList());
    }

    @Override
    public Set<Quote> getDistinctQuotes(Iterable<Quote> quotes) {
        return StreamSupport.stream(quotes.spliterator(), false)
                .collect(toSet());
    }

    @Override
    public Set<Quote> getDistinctQuoteByEmail(Iterable<Quote> quotes) {
        return distinctByEmail(quotes)
                .collect(toSet());
    }

    @Override
    public SortedSet<Quote> getQuotesWithDistinctEmailSortedInReversAlpha(Iterable<Quote> quotes) {
        Supplier<TreeSet<Quote>> treeSetSupplier =
            () -> new TreeSet<>(comparing(Quote::getEmail).reversed());
        return distinctByEmail(quotes)
            .collect(toCollection(treeSetSupplier));
    }

    private Stream<Quote> distinctByEmail(Iterable<Quote> quotes) {
        return StreamSupport.stream(quotes.spliterator(), false)
            .map(EMailEqualityQuote::new)
            .distinct()
            .map(EMailEqualityQuote::quote);
    }

    private static class EMailEqualityQuote {
        private final Quote quote;

        public EMailEqualityQuote(Quote quote) {
            this.quote = quote;
        }

        public Quote quote() {
            return quote;
        }

        @Override
        public int hashCode() {
            return Objects.hash(quote.getEmail());
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {return true;}
            if (obj == null || getClass() != obj.getClass()) {return false;}
            final EMailEqualityQuote other = (EMailEqualityQuote) obj;
            return Objects.equals(this.quote.getEmail(), other.quote.getEmail());
        }
    }
}
