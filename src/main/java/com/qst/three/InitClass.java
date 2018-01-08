package com.qst.three;

public class InitClass {

    private MySwing mySwing;

    private String s;

    private Integer i;

    private int j;

    private byte b;

    public MySwing getMySwing() {
        return mySwing;
    }

    public void setMySwing(MySwing mySwing) {
        this.mySwing = mySwing;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public Integer getI() {
        return i;
    }

    public void setI(Integer i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public byte getB() {
        return b;
    }

    public void setB(byte b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "InitClass{" +
                "mySwing=" + mySwing +
                ", s='" + s + '\'' +
                ", i=" + i +
                ", j=" + j +
                ", b=" + b +
                '}';
    }
}
