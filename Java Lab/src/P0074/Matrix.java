package P0074;

public class Matrix {
    public void displayMenu(){
        System.out.println("=========== Calculator Program ===========");
        System.out.println("1. Addition matrixes");
        System.out.println("2. Subtraction matrixes");
        System.out.println("3. Multiplication matrixes");
        System.out.println("4. Exit");
        System.out.print("Your choice: ");
    }

    public int[][] inputMaxtrix(int n){
        System.out.print("Enter Row Matrix " + n + ": ");
        int row = Validation.checkRowandColumn();
        System.out.print("Enter Column Matrix " + n + ": ");
        int col = Validation.checkRowandColumn();
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("Enter Matrix" + n + "[" + (i + 1) + "]" + "[" + (j + 1) + "]:");
                matrix[i][j] = Validation.checkInt();
            }
        }
        return matrix;
    }


    private void displayMatrix(int[][] matrix){
        int row = matrix.length;
        int col = matrix[0].length;
        for(int i = 0;i < row;i++) {
            for(int j = 0;j < col;j++){
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println();
        }   
    }

    private boolean checkConditionOfAdd(int[][] matrix1,int[][] matrix2){
        int row1 = matrix1.length;
        int column1 = matrix1[0].length;
        int row2 = matrix2.length;
        int column2 = matrix2[0].length;
        if(row1 == row2 && column1 == column2){
            return true;
        }
        return false;
    }

    public void addMaxtrix(int[][] matrix1,int[][] matrix2){
        if(checkConditionOfAdd(matrix1, matrix2) == false){
            System.out.println("Can't not add two matrix");
            return;
        }
        System.out.println("----------- Results -----------");
        displayMatrix(matrix1);
        System.out.println("+");
        displayMatrix(matrix2);
        System.out.println("=");
        int[][] result = add(matrix1, matrix2);
        displayMatrix(result);
    }

    private int [][] add(int[][] matrix1,int[][] matrix2){
        int row = matrix1.length;
        int col = matrix1[0].length;
        int result[][] = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result[i][j] = (matrix1[i][j] + matrix2[i][j]);
            }
        }
        return result;       
    }


    public void subMatrix(int[][] matrix1,int[][] matrix2){
        if(checkConditionOfAdd(matrix1, matrix2) == false){
            System.out.println("Can't not sub two matrix");
            return;
        }
        System.out.println("----------- Results -----------");
        displayMatrix(matrix1);
        System.out.println("-");
        displayMatrix(matrix2);
        System.out.println("=");
        int [][] result = subtract(matrix1, matrix2);
        displayMatrix(result);
    }

    private int[][] subtract(int[][] matrix1,int[][] matrix2){
        int row = matrix1.length;
        int col = matrix1[0].length;
        int result[][] = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result[i][j] = (matrix1[i][j] - matrix2[i][j]);
            }
        }
        return result;
    }


    
    private boolean checkConditionOfMul(int[][] matrix1,int[][] matrix2){
        int column1 = matrix1[0].length;
        int row2 = matrix2.length;
        if(column1 == row2){
            return true;
        }
        return false;
    }

    public void multiMatrix(int[][] matrix1,int[][] matrix2){
        if(checkConditionOfMul(matrix1, matrix2) == false){
            System.out.println("Can't not multiple two matrix");
            return;
        }

        System.out.println("----------- Results -----------");
        displayMatrix(matrix1);
        System.out.println("*");
        displayMatrix(matrix2);
        System.out.println("=");
        int [][] result = multiple(matrix1, matrix2);
        displayMatrix(result);
    }

    private int[][] multiple(int[][] matrix1,int[][] matrix2){
        int row1 = matrix1.length;
        int column1 = matrix1[0].length;
        int column2 = matrix2[0].length;
        int matrixResult[][] = new int[row1][column2];

        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < column2; j++) {
                matrixResult[i][j] = 0;
            }
        }


        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < column2; j++) {
                for (int k = 0; k < column1; k++) {
                    matrixResult[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return matrixResult;
    }

}
