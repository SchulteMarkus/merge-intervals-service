package schulte.markus.service.intervals;

/**
 * This record represents an Interval of integers (math) [a, b] as described on
 * <a href="https://en.wikipedia.org/wiki/Interval_(mathematics)#Including_or_excluding_endpoints">Wikipedia</a>, values are inclusive.
 *
 * @param start Start of the interval, value is inclusive.
 * @param end End of the interval, value is inclusive.
 */
public record IntegerInterval(int start, int end) {

}
