package matrix.system.project;

public class MatrixApp {
    public static void main(String[]args){
        LinearOperations linOp = new LinearOperations();
        MatrixOperations matOp = new MatrixOperations();
        /*Matrix matrix1 = new Matrix(3,3);
        matrix1.fillRandom(0,9,2);
        System.out.println(matrix1);
        Matrix matrix2 = new Matrix(3,3);
        matrix2.fillRandom(-5,5,0);
        System.out.println(matrix2);
        Matrix matrix3 = linOp.addMatrices(matrix1, matrix2);
        System.out.println(matrix3);
        Matrix matrix4 = linOp.subtractMatrices(matrix1, matrix2);
        System.out.println(matrix4);
        Matrix matrix5 = linOp.scaleMatrix(matrix1, 5);
        System.out.println(matrix5);
        
        Matrix matrix2 = new Matrix(5,3);
        matrix2.fillRandom(0, 100, 0);
        Matrix matrix3 = new Matrix(3,3);  
        matrix3.fillRandom(0, 100, 0); 
        Matrix matrixResult = linOp.multiplyMatrices(matrix2, matrix3);
        System.out.println(matrix2);
        System.out.println(matrix3);
        System.out.println(matrixResult);
        */
        //Matrix matrix3 = new Matrix(3,3);  
        //matrix3.fillRandom(100, 10);
        double[][]fillArr = {{1000,30,90000},{40,500,3},{6,9,2}};
        Matrix matrix4 = new Matrix(fillArr); 
        System.out.println(matrix4);
        //System.out.println(matOp.getDeterminant(matrix3));
        Matrix matrix2 = matrix4.transpose();
        System.out.println(matrix2);
    }
}
