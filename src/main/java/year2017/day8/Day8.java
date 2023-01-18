package year2017.day8;

import java.util.*;

public class Day8 {

	private Map <String, Integer> registers;

	private int highestDuringProcess;

	public int part1(List <String> lines) {

		calculateRegisters(lines);

		return Collections.max(registers.values());
	}

	public int part2(List <String> lines) {

		calculateRegisters(lines);

		return highestDuringProcess;
	}

	private void calculateRegisters(List <String> lines) {
		registers = new HashMap <>();

		for (String line : lines) {
			String[] operationArray = line.replaceAll("if.*$", "").split(" ");
			String[] conditionArray = line.replaceAll("^.*if\s", "").split(" ");

			boolean condition = getCondition(conditionArray);

			if (condition) {
				runOperation(operationArray);
				int actualHighestValue = Collections.max(registers.values());

				if (highestDuringProcess < actualHighestValue) {
					highestDuringProcess = actualHighestValue;
				}
			}
		}
	}

	private void runOperation(String[] operationArray) {
		String registerKey = operationArray[0];
		String operation = operationArray[1];
		int operationValue = Integer.parseInt(operationArray[2]);
		createRegisterIfNotExist(registerKey);

		switch (operation) {
			case "inc":
				registers.put(registerKey, registers.get(registerKey) + operationValue);
				break;
			case "dec":
				registers.put(registerKey, registers.get(registerKey) - operationValue);
				break;
		}
	}

	private boolean getCondition(String[] conditionArray) {
		String registerKey = conditionArray[0];
		String conditionSign = conditionArray[1];
		int conditionValue = Integer.parseInt(conditionArray[2]);
		createRegisterIfNotExist(registerKey);

		switch (conditionSign) {
			case "<":
				return registers.get(registerKey) < conditionValue;
			case "<=":
				return registers.get(registerKey) <= conditionValue;
			case ">":
				return registers.get(registerKey) > conditionValue;
			case ">=":
				return registers.get(registerKey) >= conditionValue;
			case "==":
				return registers.get(registerKey) == conditionValue;
			case "!=":
				return registers.get(registerKey) != conditionValue;
		}
		return false;
	}

	private void createRegisterIfNotExist(String registerName) {
		if (!registers.containsKey(registerName)) {
			registers.put(registerName, 0);
		}
	}
}
