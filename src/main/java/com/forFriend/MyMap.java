package com.forFriend;

/**
 * Created by shihuashun on 2016/12/27.
 */
public class MyMap {
    public String getAreaA() {
        return areaA;
    }

    public void setAreaA(String areaA) {
        this.areaA = areaA;
    }

    public String getAreaB() {
        return areaB;
    }

    public void setAreaB(String areaB) {
        this.areaB = areaB;
    }

    public String getAreaC() {
        return areaC;
    }

    public void setAreaC(String areaC) {
        this.areaC = areaC;
    }

    public String getAreaD() {
        return areaD;
    }

    public void setAreaD(String areaD) {
        this.areaD = areaD;
    }

    public String getAreaE() {
        return areaE;
    }

    public void setAreaE(String areaE) {
        this.areaE = areaE;
    }

    public String getAreaF() {
        return areaF;
    }

    public void setAreaF(String areaF) {
        this.areaF = areaF;
    }

    public String getAreaG() {
        return areaG;
    }

    public void setAreaG(String areaG) {
        this.areaG = areaG;
    }

    public String getAreaH() {
        return areaH;
    }

    public void setAreaH(String areaH) {
        this.areaH = areaH;
    }

    public String getAreaI() {
        return areaI;
    }

    public void setAreaI(String areaI) {
        this.areaI = areaI;
    }

    public String getAreaJ() {
        return areaJ;
    }

    public void setAreaJ(String areaJ) {
        this.areaJ = areaJ;
    }

    public String getAreaK() {
        return areaK;
    }

    public void setAreaK(String areaK) {
        this.areaK = areaK;
    }

    public double getAreaL() {
        return areaL;
    }

    public void setAreaL(double areaL) {
        this.areaL = areaL;
    }

    public double getAreaM() {
        return areaM;
    }

    public void setAreaM(double areaM) {
        this.areaM = areaM;
    }

    public double getAreaN() {
        return areaN;
    }

    public void setAreaN(double areaN) {
        this.areaN = areaN;
    }

    public String areaA;
    public String areaB;
    public String areaC;
    public String areaD;
    public String areaE;
    public String areaF;
    public String areaG;
    public String areaH;
    public String areaI;
    public String areaJ;
    public String areaK;
    public double areaL;
    public double areaM;
    public double areaN;

    public static void main(String[] args) {
        MyMap myMap = new MyMap();
        myMap.setAreaA("110101000000");

    }

    public void setParam(String param, int areaNum){
        switch (areaNum){
            case 1:
                setAreaA(param);
                break;
            case 2:
                setAreaB(param);
                break;
            case 3:
                setAreaC(param);
                break;
            case 4:
                setAreaD(param);
                break;
            case 5:
                setAreaE(param);
                break;
            case 6:
                setAreaF(param);
                break;
            case 7:
                setAreaG(param);
                break;
            case 8:
                setAreaH(param);
                break;
            case 9:
                setAreaI(param);
                break;
            case 10:
                setAreaJ(param);
                break;
            case 11:
                setAreaK(param);
                break;
            default:
                System.out.print("参数错误");
                break;
        }
    }

    @Override
    public String toString(){
        String result = getAreaA() + " " + getAreaB() + " " + getAreaC() + " " + getAreaD() + " "
                        + getAreaE() + " " + getAreaF() + " " + getAreaG() + " " + getAreaH() + " "
                        + getAreaI() + " " + getAreaJ() + " " + getAreaK();
        return result;
    }

}
