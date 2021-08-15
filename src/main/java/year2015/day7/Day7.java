package year2015.day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Day7 {
    
    private Map<String, Integer> wires = new HashMap<>();

    private List<String[]> commands = new ArrayList<>();

    private List<String[]> commandToRemove = new ArrayList<>();

    private static int counter = 1;


    public int part1(String wire) {

        commandToRemove.addAll(commands.stream()
                .filter(command -> Character.isDigit(command[0].charAt(0)) && command.length < 3)
                .collect(Collectors.toList()));
        commands.removeAll(commandToRemove);
        for (String[] command : commandToRemove) {
            wires.put(command[1], Integer.parseInt(command[0]));
        }
        commandToRemove.clear();

        return computeResult(wire);

    }

    public Integer part2(String wire, String wireToChange, int newValue) {

        commandToRemove.addAll(commands.stream()
                .filter(command -> Character.isDigit(command[0].charAt(0)) && command.length < 3)
                .collect(Collectors.toList()));
        commands.removeAll(commandToRemove);
        for (String[] command : commandToRemove) {
            wires.put(command[1], Integer.parseInt(command[0]));
        }
        commandToRemove.clear();
        wires.put(wireToChange, newValue);

        return computeResult(wire);
    }

    private Integer computeResult(String wire) {


        while (commands.size() > 0) {
            for (String[] command : commands) {

                if (commandProcessor(command)) {
                    commandToRemove.add(command);
                }
            }
            commands.removeAll(commandToRemove);
            commandToRemove.clear();
        }

        return wires.get(wire);
    }


    private boolean commandProcessor(String[] command) {

        if (command.length == 2 && wires.containsKey(command[0])) {
            wires.put(command[1], wires.get(command[0]));
            return true;
        }
        if (command.length == 3) {
            if (wires.containsKey(command[1])) {
                wires.put(command[2], ~wires.get(command[1]).intValue()& 0xffff);
                return true;
            }
            return false;
        }

        switch (command[1]) {

            case "AND" -> {
                if ((wires.containsKey(command[0]) || command[0].equals("1"))
                        && wires.containsKey(command[2])) {
                    if (command[0].equals("1")) {
                        wires.put(command[3], 1 & wires.get(command[2]));
                    } else {
                        wires.put(command[3], wires.get(command[0]) & wires.get(command[2]));
                    }
                    return true;
                }
                return false;
            }

            case "OR" -> {
                if ((wires.containsKey(command[0]) || Character.isDigit(command[0].charAt(0)))
                        && wires.containsKey(command[2]) || Character.isDigit(command[2].charAt(0))) {
                    wires.put(command[3], wires.get(command[0]) | wires.get(command[2]));
                    return true;
                }
                return false;
            }

            case "LSHIFT" -> {
                if (wires.containsKey(command[0])) {
                    wires.put(command[3], wires.get(command[0]).intValue() << Integer.parseInt(command[2]));
                    return true;
                }
                return false;
            }

            case "RSHIFT" -> {
                if (wires.containsKey(command[0])) {
                    wires.put(command[3], wires.get(command[0]).intValue() >> Integer.parseInt(command[2]));
                    return true;
                }
                return false;
            }

        }
        return false;
    }

    
    public void loadInputFromFile(BufferedReader br) {
        try {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.replace(" ->", "");
                String[] words = line.split(" ");
                
                /*if (words.length == 2) {
                    wires.put(words[1], Integer.parseInt(words[0]));
                }*/
                commands.add(words);
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Cannot read file, ", ioe);
        }
    }
    
}
