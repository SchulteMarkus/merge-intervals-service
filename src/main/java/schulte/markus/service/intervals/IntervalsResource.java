package schulte.markus.service.intervals;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

@Path("/merge-intervals")
public class IntervalsResource {

  @Inject IntervalsMerger intervalsMerger;

  @Operation(
      summary = "Calculate merged intervals",
      description = "Merges given intervals, e.g. [0, 1], [1, 2] => [0, 2]")
  @POST
  public List<IntegerInterval> mergeIntervals(
      @RequestBody(
              content = {
                @Content(
                  mediaType = MediaType.APPLICATION_JSON,
                  example = "[{\"start\":1,\"end\":2},{\"start\":0,\"end\":2},{\"start\":3,\"end\":5}]")
              })
          final List<IntegerInterval> intervals) {
    return intervalsMerger.merge(intervals);
  }
}
