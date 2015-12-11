import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

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
        Map<String,List<Quote>> collect = StreamSupport.stream(quotes.spliterator(), false)
                .collect(Collectors.groupingBy(Quote::getEmail));
        return collect.entrySet().stream()
                .map(e -> e.getValue().stream().findFirst().orElse(null))
                .collect(toSet());
    }
}
