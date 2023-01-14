package year2017.day3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Day3 {

	private int target;

	private int x;

	private int y;

	private int data;

	private int step;

	private List<Square> matrix;

	public int part1(List <String> lines) {
		target = Integer.parseInt(lines.get(0));
		x = 0;
		y = 0;
		data = 1;
		step = 1;

		while (data < target) {
			spiral();
		}

		return Math.abs(x) + Math.abs(y);
	}

	public int part2(List <String> lines) {
		target = Integer.parseInt(lines.get(0));
		x = 0;
		y = 0;
		data = 1;
		step = 1;
		matrix = new ArrayList <>();
		matrix.add(new Square(0, 0, 1));

		while (data < target) {
			sumSpiral();
		}

		return data;
	}

	private void sumSpiral() {
		sumRight();
		sumUp();
		step++;
		sumLeft();
		sumDown();
		step++;
	}

	private int sumDown() {

		for (int i = 0; i < step; i++) {

			if (data >= target) {
				return data;
			}

			y--;
			int sum = 0;
			sum += getSquareValue(x, y + 1);

			for (int j = y - 1; j < y + 2; j++) {
				sum += getValueIfSquareExist(x + 1, j);
			}

			matrix.add(new Square(x, y, sum));
			data = sum;
		}
		return 0;
	}

	private int getValueIfSquareExist(int x, int y) {

		return squareExist(x, y) ? getSquareValue(x, y) : 0;
	}

	private boolean squareExist(int x, int y) {

		return matrix.stream()
				.anyMatch(square -> square.getX() == x
						&& square.getY() == y);
	}

	private int getSquareValue(int x, int y) {

		return 	matrix.stream()
				.filter(square -> square.getX() == x
						&& square.getY() == y)
				.findFirst()
				.get()
				.getValue();
	}

	private int sumLeft() {

		for (int i = 0; i < step; i++) {

			if (data >= target) {
				return data;
			}

			x--;
			int sum = 0;
			sum += getSquareValue(x + 1, y);

			for (int j = x - 1; j < x + 2; j++) {
				sum += getValueIfSquareExist(j, y - 1);
			}

			matrix.add(new Square(x, y, sum));
			data = sum;
		}

		return 0;
	}

	private int sumUp() {

		for (int i = 0; i < step; i++) {

			if (data >= target) {
				return data;
			}

			y++;
			int sum = 0;
			sum += getSquareValue(x, y - 1);

			for (int j = y - 1; j < y + 2; j++) {
				sum += getValueIfSquareExist(x - 1, j);
			}

			matrix.add(new Square(x, y, sum));
			data = sum;
		}
		return 0;
	}

	private int sumRight() {

		for (int i = 0; i < step; i++) {

			if (data >= target) {
				return data;
			}

			x++;
			int sum = 0;
			sum += getSquareValue(x - 1, y);

			for (int j = x - 1; j < x + 2; j++) {
				sum += getValueIfSquareExist(j, y + 1);
			}

			matrix.add(new Square(x, y, sum));
			data = sum;
		}
		return 0;
	}

	private void spiral() {
		right();
		up();
		step++;
		left();
		down();
		step++;
	}

	private int right() {
		for (int i = 0; i < step; i++) {
			if (data == target) {
				return data;
			}
			x++;
			data++;
		}
		return data;
	}

	private int up() {
		for (int i = 0; i < step; i++) {
			if (data == target) {
				return data;
			}
			y++;
			data++;
		}
		return data;
	}

	private int left() {
		for (int i = 0; i < step; i++) {
			if (data == target) {
				return data;
			}
			x--;
			data++;
		}
		return data;
	}

	private int down() {
		for (int i = 0; i < step; i++) {
			if (data == target) {
				return data;
			}
			y--;
			data++;
		}
		return data;
	}
}
