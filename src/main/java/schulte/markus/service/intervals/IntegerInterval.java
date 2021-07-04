package schulte.markus.service.intervals;

/**
 * This record represents an Interval of integers (math) [a, b] as described on
 * <a href="https://en.wikipedia.org/wiki/Interval_(mathematics)#Including_or_excluding_endpoints">Wikipedia</a>.
 *
 * @param start Start of the interval, value is inclusive. If start > end, the values are swapped.
 * @param end End of the interval, value is inclusive. If end < start, the values are swapped.
 */
public record IntegerInterval(int start, int end) {

  public IntegerInterval(final int start, final int end) {
    this.start = Math.min(start, end);
    this.end = Math.max(start,end);
  }
}
