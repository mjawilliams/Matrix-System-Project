package matrix.system.project;

import java.text.DecimalFormat;
import java.util.Random;

public class Matrix {
    public int rows;
    public int columns;
    double[][]matrix;


    public Matrix(int rows, int columns){
        this.rows = rows;
        this.columns = columns;
        this.matrix = new double[rows][columns];
        Random rng = new Random();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                matrix[i][j] = rng.nextDouble(10);
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
        dmf.setMaximumFractionDigits(2);
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


