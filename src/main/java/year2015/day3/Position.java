package year2015.day3;

import java.util.Objects;

public class Position {
    private int xCoord;
    private int yCoord;

    public Position(int xCoord, int yCoord) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }

    public int getxCoord() {
        return xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return getxCoord() == position.getxCoord() &&
                getyCoord() == position.getyCoord();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getxCoord(), getyCoord());
    }
}
