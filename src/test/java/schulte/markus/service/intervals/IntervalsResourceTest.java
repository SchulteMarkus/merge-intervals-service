package schulte.markus.service.intervals;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import java.util.Collections;
import javax.ws.rs.core.MediaType;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

@QuarkusTest
public class IntervalsResourceTest {

  @InjectMock private IntervalsMerger intervalsMerger;

  @Test
  public void mergeIntervals() {
    final var givenIntegerIntervalsToMerge = Collections.singletonList(new IntegerInterval(13, 37));
    final var mergedIntervals = Collections.singletonList(new IntegerInterval(42, 42));
    Mockito.when(intervalsMerger.merge(givenIntegerIntervalsToMerge)).thenReturn(mergedIntervals);

    given()
        .header("Content-type", MediaType.APPLICATION_JSON)
        .and()
        .body(givenIntegerIntervalsToMerge)
        .when()
        .post("merge-intervals")
        .then()
        .statusCode(200)
        .body("size()", is(1))
        .body("[0].start", is(42))
        .body("[0].end", is(42));
  }
}
