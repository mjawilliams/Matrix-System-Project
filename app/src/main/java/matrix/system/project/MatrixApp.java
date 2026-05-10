package matrix.system.project;

public class MatrixApp {
    public static void main(String[]args){
        LinearOperations linOp = new LinearOperations();
        /*Matrix matrix1 = new Matrix(3,3);
        matrix1.fillRandom(0,9,2);
        System.out.println(matrix1);
        Matrix matrix2 = new Matrix(3,3);
        matrix2.fillRandom(-5,5,0);
        System.out.println(matrix2);
        Matrix matrix3 = linOp.addMatricies(matrix1, matrix2);
        System.out.println(matrix3);
        Matrix matrix4 = linOp.subtractMatricies(matrix1, matrix2);
        System.out.println(matrix4);
        Matrix matrix5 = linOp.scaleMatrix(matrix1, 5);
        System.out.println(matrix5);
        */
        Matrix matrix2 = new Matrix(5,3);
        matrix2.fillRandom(0, 100, 0);
        Matrix matrix3 = new Matrix(3,3);  
        matrix3.fillRandom(0, 100, 0); 
        Matrix matrixResult = linOp.multiplyMatrix(matrix2, matrix3);
        System.out.println(matrix2);
        System.out.println(matrix3);
        System.out.println(matrixResult);



    }
}
