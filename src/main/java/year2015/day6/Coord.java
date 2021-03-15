package year2015.day6;

import java.util.Objects;

public class Coord {
    
    private int column;
    private int row;
    
    
    private Coord(int column, int row) {
        this.column = column;
        this.row = row;
    }
    
    public static Coord of(int column, int row) {
        return new Coord(column, row);
    }
    
    public int getColumn() {
        return column;
    }
    
    public int getRow() {
        return row;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coord coord = (Coord) o;
        return getColumn() == coord.getColumn() &&
                   getRow() == coord.getRow();
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(getColumn(), getRow());
    }
}
