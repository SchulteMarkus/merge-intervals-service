package schulte.markus.service.intervals;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/intervals")
public class IntervalsResource {

  @Inject IntervalsMerger intervalsMerger;

  @Path("/{integer-intervals}/merge")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<IntegerInterval> mergeIntervals(
      @PathParam("integer-intervals") final List<IntegerInterval> intervals) {
    return intervalsMerger.merge(intervals);
  }
}
