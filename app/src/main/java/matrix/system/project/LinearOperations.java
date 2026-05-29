package matrix.system.project;

public class LinearOperations {

    public Matrix addMatrices(Matrix m1, Matrix m2){
        if(m1.getColumns() != m2.getColumns() || m1.getRows() != m2.getRows()){
            System.out.println("These 2 Matrices can't be added together");
            return null;
        }
        Matrix retMatrix = new Matrix(m1.getRows(),m1.getColumns());
        retMatrix.setDecimalMax(Math.max(m1.getDecimalMax(),m2.getDecimalMax()));
        for(int i=0;i<retMatrix.getRows();i++){
            for(int j=0;j<retMatrix.getColumns();j++){
                retMatrix.setElement(i, j,(m1.getElement(i, j) + m2.getElement(i, j)));
            }
        }
        return retMatrix;
    }

    public Matrix subtractMatrices(Matrix m1, Matrix m2){
        if(m1.getColumns() != m2.getColumns() || m1.getRows() != m2.getRows()){
            System.out.println("These 2 Matrices can't be subtracted from each other");
            return null;
        }
        Matrix retMatrix = new Matrix(m1.getRows(),m1.getColumns());
        retMatrix.setDecimalMax(Math.max(m1.getDecimalMax(),m2.getDecimalMax()));
        for(int i=0;i<retMatrix.getRows();i++){
            for(int j=0;j<retMatrix.getColumns();j++){
                retMatrix.setElement(i, j,(m1.getElement(i, j) - m2.getElement(i, j)));
            }
        }
        return retMatrix;
    }

    public Matrix scaleMatrix(Matrix m1, double num){
       Matrix retMatrix = new Matrix(m1.getRows(),m1.getColumns());
        retMatrix.setDecimalMax(m1.getDecimalMax());
        for(int i=0;i<retMatrix.getRows();i++){
            for(int j=0;j<retMatrix.getColumns();j++){
                retMatrix.setElement(i, j,(m1.getElement(i, j) * num));
            }
        }
        
       return retMatrix;
    }

    public Matrix multiplyMatrices(Matrix m1,Matrix m2){
        if(m1.getColumns() != m2.getRows()){
            System.out.println("These Matrices can't be multiplied");
            return null;
        }
        Matrix retMatrix = new Matrix(m1.getRows(),m2.getColumns());
        retMatrix.setDecimalMax(Math.max(m1.getDecimalMax(),m2.getDecimalMax()));
        for(int i=0;i<retMatrix.getRows();i++){
            for(int j=0;j<retMatrix.getColumns();j++){
                for(int k=0;k<retMatrix.getColumns();k++){
                retMatrix.setElement(i,j,retMatrix.getElement(i, j)+(m1.getElement(i,k)*m2.getElement(k, j)));
                }
            }
        }
        return retMatrix;
    }
}
