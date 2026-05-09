package matrix.system.project;

import java.text.DecimalFormat;
import java.util.Random;

public class Matrix {
    private int rows;
    private int columns;
    private double[][]matrix;
    private int decimalMax;


    public Matrix(int rows, int columns){
        this.rows = rows;
        this.columns = columns;
        this.matrix = new double[rows][columns];
        this.decimalMax = 0;

    }

    public void fillRandom(int low,int high, int decimalMax){
        this.decimalMax = decimalMax;
        DecimalFormat nf1 = new DecimalFormat();
        nf1.setMaximumFractionDigits(decimalMax);
        Random rng = new Random();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                matrix[i][j] = Double.parseDouble(nf1.format(rng.nextDouble(low,high)));
            }
        }
    }

    public boolean isSquare(){
        return rows == columns;
    }

    public double getElement(int row, int col){
        return matrix[row][col];
    }

    public void setElement(int row, int col, double value){
        matrix[row][col] = value;
    }

    public void setDecimalMax(int newMax){
        this.decimalMax = newMax;
    }
    public int getDecimalMax(){
        return decimalMax;
    }
    public int getColumns(){
        return columns;
    }
    public int getRows(){
        return rows;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        DecimalFormat dmf = new DecimalFormat();
        dmf.setMaximumFractionDigits(decimalMax);
        for(int i=0;i<matrix.length;i++){
            sb.append("(");
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]%1 == 0){
                    sb.append((int)(matrix[i][j]));
                } else {
                    sb.append(dmf.format(matrix[i][j]));
                }
                if(j != matrix[i].length-1){
                    sb.append(", ");
                }
            }
            sb.append(")\n");
        }
        return sb.toString();
    }
}


