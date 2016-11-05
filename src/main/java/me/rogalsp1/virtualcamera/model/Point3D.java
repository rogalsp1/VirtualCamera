package me.rogalsp1.virtualcamera.model;

/**
 * Created by rogalsp1 on 15.10.16.
 */
public class Point3D {

    private double x;
    private double y;
    private double z;
    private double w;

    public Point3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = 1;
    }

    public Point3D(double x, double y, double z, double w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public Point3D(double[][] vector) {
        this.x = vector[0][0];
        this.y = vector[1][0];
        this.z = vector[2][0];
        this.w = vector[3][0];

    }

    public double[][] vector() {
        double t[][] = {
                {this.x},
                {this.y},
                {this.z},
                {this.w}
        };
        return t;
    }

    public void normalize() {
        this.x = this.x / this.w;
        this.y = this.y / this.w;
        this.z = this.z / this.w;
        this.w = this.w / this.w;
    }

    public double[][] matrix() {
        double t[][] = {
                {this.x},
                {this.y},
                {this.z},
                {this.w}
        };
        return t;
    }

    void przemnozPrzezMacierzINormalizuj(Matrix mac) {
        double[][] wsp = Matrix.multiply(mac.getMatrix(), this.matrix());
        this.noweWspolrzedne(wsp[0][0], wsp[1][0], wsp[2][0], wsp[3][0]);
        this.normalize();
    }

    public void noweWspolrzedne(double x, double y, double z, double w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double getW() {
        return w;
    }

    public void setW(double w) {
        this.w = w;
    }
}
