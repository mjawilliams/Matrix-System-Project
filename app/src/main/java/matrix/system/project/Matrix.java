package matrix.system.project;

import java.text.DecimalFormat;
import java.util.Random;

public class Matrix {
    public int rows;
    public int columns;
    double[][]matrix;
    int decimalMax;


    public Matrix(int rows, int columns){
        this.rows = rows;
        this.columns = columns;
        this.matrix = new double[rows][columns];
        this.decimalMax = 0;
    }

    public void fillRandomInt(int low,int high){
        Random rng = new Random();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                matrix[i][j] = rng.nextInt(low,high+1);
            }
        }
    }

    public void fillRandomDouble(int low,int high, int decimalMax){
        if(decimalMax < 0){
            System.out.println("Can't have a negative decimal");
            return;
        }
        if(decimalMax == 0){
            fillRandomInt(low,high);
            this.decimalMax = 0;
            return;
        }
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
        if(rows == columns){
            return true;
        } else if (rows != columns) {
            return false;
        }
        return false;
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
                } else if(decimalMax != 0){
                    sb.append(dmf.format(matrix[i][j]));
                } else {
                    sb.append(matrix[i][j]);
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


