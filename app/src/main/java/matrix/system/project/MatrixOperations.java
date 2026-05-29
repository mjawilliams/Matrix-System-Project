package matrix.system.project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MatrixOperations {
    private Map<Matrix,Double> map = new HashMap<>();

    public double getDeterminant(Matrix m){
        double retNum = 0;
        if(!(m.isSquare())){
            System.out.println("This Matrix doesn't have a determinant");
            return 0;
        }
        if(m.getRows() == 2){
            retNum = determinant2x2(m);
        }
        if(m.getRows() == 3){
            retNum = determinant3x3(m);
        }
        if(m.getRows() > 3){
            retNum = determinantRec(m);
        }
        return retNum;
    }

    private double determinant2x2(Matrix m){
        double retNum;
        retNum = (m.getElement(0,0)*m.getElement(1, 1)) - (m.getElement(1, 0)* m.getElement(0, 1));
        return retNum;
    }
    //Replace these Matrix creation methods with the new method once created
    private double determinant3x3(Matrix m){
        double retNum;
        Matrix sub1 = new Matrix(2,2);
        Matrix sub2 = new Matrix(2,2);
        Matrix sub3 = new Matrix(2,2);
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
            sub1.setElement(i,j,m.getElement(i+1,j+1));
            sub2.setElement(i,j,m.getElement(i+1,j));
            sub3.setElement(i,j,m.getElement(i+1,j));
            }
            sub2.setElement(0,1,m.getElement(1,2));
            sub2.setElement(1,1,m.getElement(2,2));
        }
        retNum = (((m.getElement(0, 0))*(determinant2x2(sub1))) - ((m.getElement(0, 1))*determinant2x2(sub2)) + (m.getElement(0, 2))*determinant2x2(sub3));
        return retNum;
    }

    private double determinantRec(Matrix m){
        double total = 0;
        if(m.getRows() == 2){
            return determinant2x2(m);
        }
        if(m.getRows() == 3){
            return determinant3x3(m);
        }
        for(int i=0;i<m.getColumns();i++){
            total += (Math.pow(-1,i+2))*m.getElement(0,i) * determinantRec(subMatrix(m,i));
        }
        return total;
    }

    private double determinantMemo(Matrix m){
        double total = 0;
        double nextDet = 0;
        if(m.getRows() == 2){
            return determinant2x2(m);
        }
        if(m.getRows() == 3){
            return determinant3x3(m);
        }
        for(int i=0;i<m.getColumns();i++){
            if(map.containsKey(m)){
                total += (Math.pow(-1,i+2))*m.getElement(0,i) * map.get(m);
            } else {
                nextDet = determinantMemo(subMatrix(m,i));
                Matrix sub = subMatrix(m, i);
                total += (Math.pow(-1,i+2))*m.getElement(0,i) * nextDet;
                map.put(sub,nextDet);
            }
        }
        return total;
    }

    private Matrix subMatrix(Matrix m, int n){
        Matrix retMatrix = new Matrix(m.getRows()-1, m.getColumns()-1);
        int colIndex = 0;
        for(int i=0;i<m.getColumns();i++){
            if(i != n){
                for(int j=0;j<m.getRows()-1;j++){
                    retMatrix.setElement(j, colIndex, m.getElement(j+1, i));
                }
                colIndex++;
            }
        }
        return retMatrix;
    }
}
