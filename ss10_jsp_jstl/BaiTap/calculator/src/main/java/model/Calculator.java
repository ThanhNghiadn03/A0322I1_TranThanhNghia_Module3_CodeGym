package model;

public class Calculator {
    private double num1;
    private double num2;

    public Calculator(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public Calculator() {
    }

    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }
    public double addTwoNum() {
        return this.num1+this.num2;
    }
    public double subTwoNum() {
        return this.num1-this.num2;
    }
    public double multiTwoNum() {
        return this.num1*this.num2;
    }
    public double divdeTwoNum() {
        return this.num1/this.num2;
    }
}
