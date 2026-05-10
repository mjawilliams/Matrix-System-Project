package matrix.system.project;

import java.text.DecimalFormat;
import java.util.Random;

public class Matrix {
    private int rows;
    private int columns;
    private double[][]matrix;
    private int decimalMax;
    private DecimalFormat dmf = new DecimalFormat();

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
        dmf.setMaximumFractionDigits(decimalMax);
        int[]widths = columnWidths();
        String nextAdd;
        int diff;
        for(int i=0;i<matrix.length;i++){
            sb.append("(");
            for(int j=0;j<matrix[i].length;j++){
                nextAdd = formatValue(matrix[i][j]);
                diff = widths[j] - nextAdd.length();
                if(diff % 2 != 0){
                    for(int l=0;l<(diff+1)/2;l++){
                    sb.append(" ");
                    }
                } else {
                    for(int l=0;l<diff/2;l++){
                    sb.append(" ");
                    }
                }
                sb.append(nextAdd);
                for(int l=0;l<diff/2;l++){
                sb.append(" ");
                }
                if(j != matrix[i].length-1){
                    sb.append(", ");
                }
            }
            sb.append(")\n");
        }
        return sb.toString();
    }

    public int[] columnWidths(){
        int[] retArr = new int[columns];
        int currentLongest = 0;
        String value;
        for(int j=0;j<columns;j++){
            for(int k=0;k<rows;k++){
                value = formatValue(matrix[k][j]);
                if(value.length() > currentLongest){
                    currentLongest = value.length();
                    }
                /*if(matrix[k][j]%1 == 0){
                    if((Integer.toString((int)matrix[k][j])).length() > currentLongest){
                    currentLongest = (Integer.toString((int)matrix[k][j])).length();
                    }
                } else if((Double.toString(matrix[k][j])).length() > currentLongest){
                    currentLongest = (Double.toString(matrix[k][j])).length();
                }
                    */
                
            }
        retArr[j] = currentLongest;
        currentLongest = 0;
        }
        return retArr;
    }

    public String formatValue(double n){
        dmf.setMaximumFractionDigits(decimalMax);
        if(n % 1 == 0){
            return Integer.toString((int)(n));
        } else {
            return dmf.format(n);
        }
    }

}


