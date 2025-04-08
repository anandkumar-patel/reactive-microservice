package exp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PersonalUmbrellaLineResponse {

    private List<Vehicles> vehiclesList;
}
