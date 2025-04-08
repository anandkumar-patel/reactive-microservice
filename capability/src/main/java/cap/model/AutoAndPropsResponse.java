package cap.model;

import cap.firmware.model.AutoMobile;
import cap.firmware.model.House;
import cap.firmware.model.User;

import java.util.List;

public record AutoAndPropsResponse(AutoMobile auto, List<House> props) {
}
