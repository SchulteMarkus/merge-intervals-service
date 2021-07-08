package schulte.markus.service.intervals;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
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
              description = "abc",
              content = {
                @Content(
                    example =
                        "[{\"start\":0,\"end\":1},{\"start\"0,\"end\"2},{\"start\"2,\"end\"5}]")
              })
          final List<IntegerInterval> intervals) {
    return intervalsMerger.merge(intervals);
  }

  @Path("/test")
  @POST
  public List<IntegerInterval> returnIntervals(final List<IntegerInterval> intervals) {
    return intervals;
  }
}
