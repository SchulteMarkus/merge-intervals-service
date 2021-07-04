package schulte.markus.service.intervals;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class IntervalsMergerTest {

  private final IntervalsMerger intervalsMerger = new IntervalsMerger();

  @SuppressWarnings("unused")
  private static Stream<Arguments> mergeIntervals() {
    final var noIntervals = Arguments.of(null, Collections.emptyList());

    final var emptyIntervals = Arguments.of(Collections.emptyList(), Collections.emptyList());

    final var equalIntervalsEndIsStart =
        Arguments.of(
            Collections.singletonList(new IntegerInterval(-13, -13)),
            Collections.singletonList(new IntegerInterval(-13, -13)));

    final var equalIntervals =
        Arguments.of(
            List.of(
                new IntegerInterval(-1, 2), new IntegerInterval(1, 1), new IntegerInterval(-1, 2)),
            Collections.singletonList(new IntegerInterval(-1, 2)));

    final var oneOuterInterval =
        Arguments.of(
            List.of(
                new IntegerInterval(2, 3), new IntegerInterval(7, 9), new IntegerInterval(1, 10)),
            Collections.singletonList(new IntegerInterval(1, 10)));

    final var twoExclusiveIntervals =
        Arguments.of(
            List.of(new IntegerInterval(123, 127), new IntegerInterval(128, 141)),
            List.of(new IntegerInterval(123, 127), new IntegerInterval(128, 141)));

    final var givenIntervals =
        Arguments.of(
            List.of(
                new IntegerInterval(25, 30),
                new IntegerInterval(2, 19),
                new IntegerInterval(14, 23),
                new IntegerInterval(4, 8)),
            List.of(new IntegerInterval(2, 23), new IntegerInterval(25, 30)));

    return Stream.of(
        noIntervals,
        emptyIntervals,
        equalIntervalsEndIsStart,
        equalIntervals,
        oneOuterInterval,
        twoExclusiveIntervals,
        givenIntervals);
  }

  @ParameterizedTest
  @MethodSource
  void mergeIntervals(final List<IntegerInterval> intervals, final List<IntegerInterval> expected) {
    Assertions.assertEquals(expected, intervalsMerger.merge(intervals));
  }
}
