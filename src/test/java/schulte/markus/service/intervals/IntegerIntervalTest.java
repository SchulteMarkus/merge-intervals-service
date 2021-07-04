package schulte.markus.service.intervals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IntegerIntervalTest {

  @Test
  void equals() {
    final IntegerInterval integerInterval1 = new IntegerInterval(-13, 7);
    final IntegerInterval integerInterval2 = new IntegerInterval(-13, 7);

    Assertions.assertNotSame(integerInterval1, integerInterval2);
    Assertions.assertEquals(integerInterval1, integerInterval2);
  }
}
