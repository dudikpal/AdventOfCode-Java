package year2015.day6;

public class Instruction {
    
    private Command command;
    private int startColumn;
    private int startRow;
    private int endColumn;
    private int endRow;
    
    public Instruction(Command command, int startColumn, int startRow, int endColumn, int endRow) {
        this.command = command;
        this.startColumn = startColumn;
        this.startRow = startRow;
        this.endColumn = endColumn;
        this.endRow = endRow;
    }
    
    public Command getCommand() {
        return command;
    }
    
    public int getStartColumn() {
        return startColumn;
    }
    
    public int getStartRow() {
        return startRow;
    }
    
    public int getEndColumn() {
        return endColumn;
    }
    
    public int getEndRow() {
        return endRow;
    }
}
