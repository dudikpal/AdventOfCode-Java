package year2015.day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;


public class Day6 {
    
    private List<Instruction> instructions;
    private Map<Coord, StateOfLight> lights;
    private Map<Coord, Integer> brightness;
    
    
    public int part1() {
        createLights();
        int counter = 0;
        for (Instruction instruction : instructions) {
            processInstructionToLightState(instruction);
        }
        for (StateOfLight state : lights.values()) {
            if (state == StateOfLight.ON) {
                counter++;
            }
        }
        return counter;
    }
    
    
    public int part2() {
        createLights();
        int counter = 0;
        for (Instruction instruction : instructions) {
            processInstructionToBrightness(instruction);
        }
        for (int brightness : brightness.values()) {
            counter += brightness;
        }
        return counter;
    }
    
    
    private void processInstructionToLightState(Instruction instruction) {
        
        for (int column = instruction.getStartColumn(); column <= instruction.getEndColumn(); column++) {
            for (int row = instruction.getStartRow(); row <= instruction.getEndRow(); row++) {
                lights.put(Coord.of(column, row), lightStateChanger(instruction.getCommand(), lights.get(Coord.of(column, row))));
            }
        }
    }
    
    
    private void processInstructionToBrightness(Instruction instruction) {
        
        for (int column = instruction.getStartColumn(); column <= instruction.getEndColumn(); column++) {
            for (int row = instruction.getStartRow(); row <= instruction.getEndRow(); row++) {
                brightness.put(Coord.of(column, row), brightnessChanger(instruction.getCommand(), brightness.get(Coord.of(column, row))));
            }
        }
    }
    
    
    private int brightnessChanger(Command command, int brightness) {
        if (command == Command.TURN_ON) {
            return brightness + 1;
        }
        if (command == Command.TOGGLE) {
            return brightness + 2;
        }
        if (command == Command.TURN_OFF && brightness != 0) {
            return brightness - 1;
        }
        return brightness;
    }
    
    
    private StateOfLight lightStateChanger(Command command, StateOfLight stateOfLight) {
        
        if (command == Command.TURN_ON) {
            return StateOfLight.ON;
        }
        if (command == Command.TURN_OFF) {
            return StateOfLight.OFF;
        }
        if (command == Command.TOGGLE) {
            if (stateOfLight == StateOfLight.ON) {
                return StateOfLight.OFF;
            }
        }
        return StateOfLight.ON;
    }
    
    
    private void createLights() {
        lights = new HashMap<>(1000_000);
        brightness = new HashMap<>(1000_000);
        for (int column = 0; column < 1000; column++) {
            for (int row = 0; row < 1000; row++) {
                lights.put(Coord.of(column, row), StateOfLight.OFF);
                brightness.put(Coord.of(column, row), 0);
            }
        }
    }
    
    
    public void readWordsFromFile(BufferedReader reader) {
        String line;
        instructions = new ArrayList<>();
        try {
            while ((line = reader.readLine()) != null) {
                line = line.replace(',', ' ').replace("turn ", "");
                String[] words = line.split(" ");
                Command command = parseCommand(words[0]);
                int startColumn = Integer.parseInt(words[1]);
                int startRow = Integer.parseInt(words[2]);
                int endColumn = Integer.parseInt(words[4]);
                int endRow = Integer.parseInt(words[5]);
                instructions.add(new Instruction(command, startColumn, startRow, endColumn, endRow));
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Cannot read file, ", ioe);
        }
    }
    
    
    private Command parseCommand(String command) {
        if (command.equals("on")) {
            return Command.TURN_ON;
        }
        if (command.equals("off")) {
            return Command.TURN_OFF;
        }
        if (command.equals("toggle")) {
            return Command.TOGGLE;
        }
        return null;
    }
}
