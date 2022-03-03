package model;

public class Bug {
    private int bugId;
    private String name;
    private String location;
    private int price;
    private int[] timeArray;
    private int[] monthArrayNorthern;
    private int[] monthArraySouthern;

    public Bug(int bugId, String name, String location, int price, int[] timeArray, int[] monthArrayNorthern, int[] monthArraySouthern) {
        this.bugId = bugId;
        this.name = name;
        this.location = location;
        this.price = price;
        this.timeArray = timeArray;
        this.monthArrayNorthern = monthArrayNorthern;
        this.monthArraySouthern = monthArraySouthern;
    }
}
