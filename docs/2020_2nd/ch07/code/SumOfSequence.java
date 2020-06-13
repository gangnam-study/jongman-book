package yeje1;

// 문제: n 이라는 정수가 주어졌을 때 1 + 2 + 3 + ... + n 의 값을 구하라

public class SumOfSequence {
    public int recursiveSum(int n) {
        if (n == 1) return 1;

        return n + recursiveSum(n - 1);
    }

    public int fastSum(int n) {
        if (n == 1) return 1;

        if (n % 2 == 1) {
            // n이 홀수일때
            return fastSum(n - 1) + n;
        } else {
            // n이 짝수일때
            return 2 * fastSum(n/2) + (n/2)*(n/2);


        }
    }

    public static void main(String[] args) {
        SumOfSequence solution = new SumOfSequence();

        // 재귀 호출을 이용한 풀이
        int result1 = solution.recursiveSum(10000);

        // 분할 정복을 이용한 풀이
        // (1 + 2 + 3 + 4) + (5 + 6 + 7 + 8)
        // (1 + 2 + 3 + 4) + (4+1 + 4+2 + 4+3 + 4+4)
        // (1 + 2 + 3 + 4) + (8/2+1 + 8/2+2 + 8/2+3 + 8/2+4)
        // (1 + 2 + 3 + ... + n/2) + (n/2+1 + n/2+2 + n/2+3 + n/2+4 + ... + n/2+n/2)
        // (1 + 2 + 3 + ... + n/2) + (1 + 2 + 3 + ... + n/2) + (n/2)*(n/2)
        // 2 * fastSum(n/2) + (n/2)*(n/2)
        int result2 = solution.fastSum(10000);
    }
}
