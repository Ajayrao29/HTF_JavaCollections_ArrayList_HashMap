package org.example;

class Phone {
    private int id;
    private String name;
    private String brand;
    private double cost;
    private int camPix;
    private String dob;

    public Phone(int id, String name, String brand, double cost, int camPix, String dob) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.cost = cost;
        this.camPix = camPix;
        this.dob = dob;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getBrand() { return brand; }
    public double getCost() { return cost; }
    public int getCamPix() { return camPix; }
    public String getDob() { return dob; }

    @Override
    public String toString() {
        return id + " " + name + " " + brand + " " + cost + " " + camPix + " " + dob;
    }
}
