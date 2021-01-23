package year2015.day2;

import java.util.Arrays;

public class Present {

    private int length;
    private int width;
    private int height;
    private int needPaper;
    private int needRibbon;

    public Present(int length, int width, int height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getNeedPaper() {
        int[] dimensions = {length, width, height};
        Arrays.sort(dimensions);
        return (dimensions[0] * dimensions[1]) * 3 + (dimensions[1] * dimensions[2]) * 2 + (dimensions[2] * dimensions[0]) * 2;
    }

    public int getNeedRibbon() {
        int[] dimensions = {length, width, height};
        Arrays.sort(dimensions);
        return dimensions[0] * 2 + dimensions[1] * 2 + dimensions[0] * dimensions[1] * dimensions[2];
    }
}
