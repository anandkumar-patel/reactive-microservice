package fm.model;

import java.util.List;

public record PolicyContentResponse(Policy policy, List<AutoMobile> autos, List<House> houses) {
}
