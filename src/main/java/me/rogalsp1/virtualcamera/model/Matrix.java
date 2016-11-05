package me.rogalsp1.virtualcamera.model;

import java.util.Arrays;

/**
 * Created by rogalsp1 on 15.10.16.
 */
public class Matrix {
    private double matrix[][];

    public Matrix(double[][] matrix) {
        this.matrix = matrix;
    }

    public static double[][] identityMatrix() {
        double[][] matrix= {
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        };
        return matrix;
    }

    public static double[][] projectionMatrix(double d) {
        double[][] matrix = {
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 1 / d, 0}
        };
        return matrix;

    }

    public static double[][] translationMatrix(double Tx, double Ty, double Tz) {
        double[][] matrix = {
                {1, 0, 0, Tx},
                {0, 1, 0, Ty},
                {0, 0, 1, Tz},
                {0, 0, 0, 1}
        };
        return matrix;
    }

    public static double[][] rotationOX(double fi) {
        double[][] mac = {
                {1, 0, 0, 0},
                {0, Math.cos(fi), -1 * Math.sin(fi), 0},
                {0, Math.sin(fi), Math.cos(fi), 0},
                {0, 0, 0, 1}
        };
        return mac;
    }

    public static double[][] rotationOY(double fi) {
        double[][] mac = {
                {Math.cos(fi), 0, Math.sin(fi), 0},
                {0, 1, 0, 0},
                {-1 * Math.sin(fi), 0, Math.cos(fi), 0},
                {0, 0, 0, 1}
        };
        return mac;
    }

    public static double[][] rotationOZ(double fi) {
        double[][] mac = {
                {Math.cos(fi), -1 * Math.sin(fi), 0, 0},
                {Math.sin(fi), Math.cos(fi), 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        };
        return mac;
    }

    public static double[][] multiply(double a[][], double b[][]) {
        int aRows = a.length,
                aColumns = a[0].length,
                bRows = b.length,
                bColumns = b[0].length;

        if (aColumns != bRows) {
            throw new IllegalArgumentException("A:Rows: " + aColumns + " did not match B:Columns " + bRows + ".");
        }

        double[][] resultant = new double[aRows][bColumns];

        for (int i = 0; i < aRows; i++) {
            for (int j = 0; j < bColumns; j++) {
                for (int k = 0; k < aColumns; k++) {
                    resultant[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        return resultant;
    }


    public double[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(double[][] matrix) {
        this.matrix = matrix;
    }
}
