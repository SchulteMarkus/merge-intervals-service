package schulte.markus.service.intervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class IntervalsMerger {

  /**
   * Merge overlapping intervals, such as [1, 2], [8, 10], [1, 3] to [1, 3], [8, 10].
   *
   * <p>Basic idea of implementation is to first sort the possibly overlapping incoming intervals by
   * start, and merge afterwards. When the given intervals are sorted by start, the end values of
   * two sequent intervals can be compared to decide if the intervals have to be merged or can be
   * used both.
   *
   * <p>Complexity is driven by sorting of given intervals, {@link List#sort(Comparator)} gives the
   * runtime and space complexity details.
   *
   * <p>Runtime complexity: Sorting + linear scan of list = O(n * log(n) + n) = O(n * log(n))
   *
   * <p>Space complexity: Sorting + constant new list allocation = O(n/2 + 1) = O(n/2)
   */
  public List<IntegerInterval> merge(final List<IntegerInterval> intervals) {
    if (intervals == null || intervals.isEmpty()) {
      return Collections.emptyList();
    }

    /*
     * The incoming intervals will get sorted. For this reason - to not modify the order
     * of the original list - use a copy. Using this, this method can handle unmodifiable lists,
     * too. It does not have to be taken care of the list elements, as they are immutable.
     */
    final var intervalsCopy = new ArrayList<>(intervals);

    intervalsCopy.sort(Comparator.comparingInt(IntegerInterval::start));

    final var mergedIntervals = new LinkedList<IntegerInterval>();
    for (final var interval : intervalsCopy) {
      if (mergedIntervals.isEmpty()) {
        mergedIntervals.add(interval);
        continue;
      }

      if (mergedIntervals.getLast().end() < interval.start()) {
        // Checked interval is behind already merged intervals - can just be appended.
        mergedIntervals.add(interval);
      } else {
        // Checked interval is within last merged one - merge those two.
        final var lastMergedInterval = mergedIntervals.pollLast();

        final var endOfInterval = Math.max(lastMergedInterval.end(), interval.end());
        final var mergedInterval = new IntegerInterval(lastMergedInterval.start(), endOfInterval);

        mergedIntervals.add(mergedInterval);
      }
    }

    return mergedIntervals;
  }
}
