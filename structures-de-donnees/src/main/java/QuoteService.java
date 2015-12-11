import java.util.*;
import java.util.stream.StreamSupport;

import static java.util.Comparator.comparing;
import static java.util.function.BinaryOperator.maxBy;
import static java.util.stream.Collectors.*;

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

        return StreamSupport.stream(quotes.spliterator(), false)
                .collect(groupingBy(Quote::getEmail, reducing(maxBy(comparing(Quote::getDate)))))
                .values().stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(toSet());
    }

    @Override
    public SortedSet<Quote> getQuotesWithDistinctEmailSortedInReversAlpha(Iterable<Quote> quotes) {
        SortedSet<Quote> result = new TreeSet<>(comparing(Quote::getEmail).reversed());
        result.addAll(getDistinctQuoteByEmail(quotes));
        return result;
    }
}
