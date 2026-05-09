package matrix.system.project;

public class MatrixApp {
    public static void main(String[]args){
        Matrix matrix1 = new Matrix(3,3);
        matrix1.fillRandomDouble(0,9,2);
        System.out.println(matrix1);
        Matrix matrix2 = new Matrix(2,2);
        matrix2.fillRandomInt(-5,5);
        System.out.println(matrix2);







    }
}
