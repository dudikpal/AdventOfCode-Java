package year2015.day9;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Travel {

    private List<Station> stations = new ArrayList<>();

    private int distance;

    public Travel addStation(Station station) {
        if (stations.size() < 2) {
            stations.add(station);
        }
        return this;
    }

    public void addDistance(int distance) {
        this.distance = distance;
    }
}
