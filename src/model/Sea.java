package model;

public class Sea {
    private int seaId;
    private String name;
    private String shadow;
    private int price;
    private String speed;
    private int[] timeArray;
    private int[] monthArrayNorthern;
    private int[] monthArraySouthern;

    public Sea(int seaId, String name, String shadow, int price, String speed, int[] timeArray, int[] monthArrayNorthern, int[] monthArraySouthern) {
        this.seaId = seaId;
        this.name = name;
        this.shadow = shadow;
        this.price = price;
        this.speed = speed;
        this.timeArray = timeArray;
        this.monthArrayNorthern = monthArrayNorthern;
        this.monthArraySouthern = monthArraySouthern;
    }
}
