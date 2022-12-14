package year2015.day9;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Day9 {

    private List<Travel> travels = new ArrayList<>();


    public int part1() {

        Set<String> uniqueStationNamesOfRoute = closestStations();
        avoidStationRepeat("Dublin");
        return 0;
    }


    private void avoidStationRepeat(String stationName) {
        List<Travel> toRemoveTravels = travels.stream()
                .filter(travel -> travel.getStations().get(0).equals(stationName) || travel.getStations().get(1).equals(stationName))
                .collect(Collectors.toList());


    }

    private HashSet<String> closestStations() {

        Travel closestStations = travels.stream()
                .min(Comparator.comparing(Travel::getDistance)).get();

        return new HashSet<String>(closestStations.getStations().stream()
                .map(Station::getStationName)
                .collect(Collectors.toList()));
    }


    public void loadDatasFromFile(BufferedReader br) {

        try {
            String line;
            while ((line = br.readLine()) != null) {

                String[] words = line.split("\\sto\\s|\\s=\\s");
                Station station1 = new Station(words[0]);
                Station station2 = new Station(words[1]);
                int distance = Integer.parseInt(words[2]);

                Travel travel = new Travel();
                travel.addStation(station1)
                        .addStation(station2)
                        .setDistance(distance);

                travels.add(travel);
                System.out.println();
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Cannot read file, ", ioe);
        }
    }

}
