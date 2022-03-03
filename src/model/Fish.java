package model;

import java.util.Arrays;

public class Fish {

    private int fishId;
    private String name;
    private String shadow;
    private String location;
    private int price;
    private int[] timeArray;
    private int[] monthArrayNorthern;
    private int[] monthArraySouthern;

    public Fish(int fishId, String name, String shadow, String location, int price, int[] timeArray, int[] monthArrayNorthern, int[] monthArraySouthern) {
        this.fishId = fishId;
        this.name = name;
        this.shadow = shadow;
        this.location = location;
        this.price = price;
        this.timeArray = timeArray;
        this.monthArrayNorthern = monthArrayNorthern;
        this.monthArraySouthern = monthArraySouthern;
    }

    @Override
    public String toString() {
        return "Fish{" +
                "fishId=" + fishId +
                ", name='" + name + '\'' +
                ", shadow='" + shadow + '\'' +
                ", location='" + location + '\'' +
                ", price=" + price +
                ", timeArray=" + Arrays.toString(timeArray) +
                ", monthArrayNorthern=" + Arrays.toString(monthArrayNorthern) +
                ", monthArraySouthern=" + Arrays.toString(monthArraySouthern) +
                '}';
    }
}
