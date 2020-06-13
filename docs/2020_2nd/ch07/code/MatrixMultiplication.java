package yeje1;

// 문제: A 라는 정방행렬이 주어졌을 때, A^m 을 구하라

class SquareMatrix {
    int size;
    int[][] values;

    SquareMatrix(int size) {
        this.size = size;
        this.values = new int[size][size];
    }

    public SquareMatrix multiply(SquareMatrix anotherMatrix) {
        SquareMatrix result = new SquareMatrix(size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    result.values[i][j] += this.values[i][k] * anotherMatrix.values[k][j];
                }
            }
        }
        return result;
    }
}

public class MatrixMultiplication {
    public SquareMatrix pow(SquareMatrix A, int m) {
        // base case: A^0 == 1
        if (m == 0) return identityMatrix(A.size);

        if (m % 2 == 1) {
            // m이 홀수일때
            return pow(A, m-1).multiply(A);
        } else {
            // m이 짝수일때
            SquareMatrix half = pow(A, m/2);
            return half.multiply(half);
        }
    }

    public SquareMatrix identityMatrix(int n) {
        SquareMatrix matrix = new SquareMatrix(n);
        for (int i = 0; i < n; i++) {
            matrix.values[i][i] = 1;
        }
        return matrix;
    }

    public static void main(String[] args) {
        MatrixMultiplication solution = new MatrixMultiplication();

        SquareMatrix matrix = new SquareMatrix(4);
        matrix.values[0][0] = 1;
        matrix.values[0][1] = 1;
        matrix.values[0][2] = 1;
        matrix.values[0][3] = 1;
        SquareMatrix result = matrix.multiply(matrix);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.println(result.values[i][j]);
            }
        }
    }
}
