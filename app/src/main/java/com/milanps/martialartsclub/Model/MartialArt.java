package com.milanps.martialartsclub.Model;

/**
 * Milan Pop Stefanija
 */
public class MartialArt {

    private int martialArtID;
    private String martialArtName;
    private int martialArtPrice;
    private String martialArtColor;

    public MartialArt(int id, String name, int price, String color) {
        setMartialArtID(id);
        setMartialArtName(name);
        setMartialArtPrice(price);
        setMartialArtColor(color);
    }

    public int getMartialArtID() {
        return martialArtID;
    }

    public String getMartialArtName() {
        return martialArtName;
    }

    public int getMartialArtPrice() {
        return martialArtPrice;
    }

    public String getMartialArtColor() {
        return martialArtColor;
    }

    public void setMartialArtID(int martialArtID) {
        this.martialArtID = martialArtID;
    }

    public void setMartialArtName(String martialArtName) {
        this.martialArtName = martialArtName;
    }

    public void setMartialArtPrice(int martialArtPrice) {
        this.martialArtPrice = martialArtPrice;
    }

    public void setMartialArtColor(String martialArtColor) {
        this.martialArtColor = martialArtColor;
    }
}
