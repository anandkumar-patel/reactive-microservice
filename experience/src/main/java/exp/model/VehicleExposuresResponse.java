package exp.model;

import java.util.List;

public record VehicleExposuresResponse(List<Vehicles> vehicles, List<UWIssues> issues) {
}
