package schulte.markus.service.intervals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IntegerIntervalTest {

  @Test
  void correctInterval() {
    final var integerInterval = new IntegerInterval(-13, 7);

    Assertions.assertEquals(-13, integerInterval.start());
    Assertions.assertEquals(7, integerInterval.end());
  }

  @Test
  void intervalWithWrongOrder() {
    final var integerInterval = new IntegerInterval(2, -2);

    Assertions.assertEquals(-2, integerInterval.start());
    Assertions.assertEquals(2, integerInterval.end());
  }
}
