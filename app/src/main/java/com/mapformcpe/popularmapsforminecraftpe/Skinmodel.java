package com.mapformcpe.popularmapsforminecraftpe;

public class Skinmodel {
    String type;
    int anh;

    public Skinmodel() {
    }

    public Skinmodel(String type, int anh) {
        this.type = type;
        this.anh = anh;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAnh() {
        return anh;
    }

    public void setAnh(int anh) {
        this.anh = anh;
    }
}
