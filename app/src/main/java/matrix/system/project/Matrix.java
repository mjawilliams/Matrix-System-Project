package matrix.system.project;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

public class Matrix {
    private int rows;
    private int columns;
    private double[][]matrix;
    private int decimalMax = 2;
    private DecimalFormat dmf = new DecimalFormat();

    // Initialise an empty Matrix
    public Matrix(int rows, int columns){
        this.rows = rows;
        this.columns = columns;
        this.matrix = new double[rows][columns];
    }

    // Initialise and fill a Matrix with an Array
    public Matrix(double[][] arr){
        int colLength = arr[0].length;
        for(int i=0;i<arr.length;i++){
            if(arr[i].length != colLength){
                return;
            }
        }
        this.rows = arr.length;
        this.columns = arr[0].length;
        matrix = arr;
    }

    // Fill a Matrix by a string after being initialised (Sets size)
    // String must be structured: "2,3,4,5" any excess numbers past the size are discarded
    public void fill(String s){
        Scanner sc = new Scanner(s);
        sc.useDelimiter(",");
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(sc.hasNext()){
                matrix[i][j] = sc.nextDouble();
                }
            }
        }
    }

    public void fillRandom(int low,int high){
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

    // Returns a new Matrix with the Element change
    /*public Matrix setElement(int row, int col, double value){
        Matrix retMatrix = new Matrix(rows,columns);
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                retMatrix.matrix[i][j] = matrix[i][j];
            }
        }
        retMatrix.matrix[row][col] = value;
        return retMatrix;
    }*/

    // Change an Element in the Matrix
    public void setElement(int row, int col, double value){
        matrix[row][col] = value;
    }

    // Set the Decimal Max for formatting
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
                // Difference in size between current and largest for spacing
                diff = widths[j] - nextAdd.length();    
                for(int l=0;l<diff;l++){
                    sb.append(" ");
                }
                sb.append(nextAdd);
                if(j != matrix[i].length-1){
                    sb.append(", ");
                }
            }
            sb.append(")\n");
        }
        return sb.toString();
    }

    // Returns an array of the size of the largest number in each column
    private int[] columnWidths(){
        int[] retArr = new int[columns];
        int currentLongest = 0;
        String value;
        for(int j=0;j<columns;j++){
            for(int k=0;k<rows;k++){
                value = formatValue(matrix[k][j]);
                if(value.length() > currentLongest){
                    currentLongest = value.length();
                }
            }
            retArr[j] = currentLongest;
            currentLongest = 0;
        }
        return retArr;
    }

    // Formats Non-Decimal Doubles into Ints
    private String formatValue(double n){
        dmf.setMaximumFractionDigits(decimalMax);
        if(n % 1 == 0){
            return Integer.toString((int)(n));
        } else {
            return dmf.format(n);
        }
    }

}


