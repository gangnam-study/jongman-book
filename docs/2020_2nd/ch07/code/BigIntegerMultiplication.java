package yeje3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BigIntegerMultiplication {
    // 카라츠바 곱셈
    public int[] karatsuba(int[] a, int[] b) {
        int an = a.length;
        int bn = b.length;

        // a가 b보다 짧을 경우 둘을 바꾼다
        if (an < bn) return karatsuba(b, a);

        // base case 1 : a 나 b 가 비어있는 경우
        if (an == 0 || bn == 0) return new int[0];

        // base case 2 : a가 비교적 짧은 경우 O(n^2) 곱셈으로 변경한다
        if (an <= 2) return multiply(a, b);

        int half = an / 2;
        // a 와 b 를 밑에서 half 자리와 나머지로 분리한다
        // 복잡하니까 a 와 b 의 자릿수가 동일하다고 가정하자 (책에 나온 코드는 자릿수가 다른 경우도 계산가능)
        int[] a0 = Arrays.copyOfRange(a, 0, half);
        int[] a1 = Arrays.copyOfRange(a, half, an);
        int[] b0 = Arrays.copyOfRange(b, 0, Math.min(half, bn));
        int[] b1 = Arrays.copyOfRange(b, Math.min(half, bn), bn);

        // z2 = a1 * b1
        int[] z2 = karatsuba(a1, b1);

        // z0 = a0 * b0
        int[] z0 = karatsuba(a0, b0);

        // z1 = (a0 + a1) * (b0 + b1) - z0 - z2
        int[] z1 = sub(sub(karatsuba(add(a0, a1), add(b0, b1)), z0), z2);

        // ret = z0 + (z1 * 10^half) + (z2 * 10^(half*2))
        int[] ret = add(add(z0, powerOf10(z1, half)), powerOf10(z2, half*2));
        return ret;
    }

    // return a + b
    private int[] add(int[] a, int[] b) {
        int[] result = new int[Math.max(a.length, b.length) + 1];
        for (int i = 0; i < Math.max(a.length, b.length) + 1; i++) {
            int ai = i < a.length ? a[i] : 0;
            int bi = i < b.length ? b[i] : 0;
            result[i] = ai + bi;
        }
        return normalize(result);
    }

    // return a - b
    private int[] sub(int[] a, int[] b) {
        int[] result = new int[Math.max(a.length, b.length)];
        for (int i = 0; i < Math.max(a.length, b.length); i++) {
            int ai = i < a.length ? a[i] : 0;
            int bi = i < b.length ? b[i] : 0;
            result[i] = ai - bi;
        }
        return normalize(result);
    }

    // return a * 10^exp
    private int[] powerOf10(int[] a, int exp) {
        int[] result = new int[a.length + exp];
        for (int i = 0; i < a.length; i++) {
            result[exp + i] = a[i];
        }
        return result;
    }

    // O(n^2) 곱셈
    public int[] multiply(int[] a, int[] b) {
        int an = a.length;
        int bn = b.length;
        int[] c = new int[an + bn + 1];
        for (int i = 0; i < an; i++) {
            for (int j = 0; j < bn; j++) {
                c[i + j] += a[i] * b[j];
            }
        }
        return normalize(c);
    }

    private int[] normalize(int[] c) {
        for (int i = 0; i + 1 < c.length; i++) {
            if (c[i] >= 0) {
                c[i + 1] += c[i] / 10;
                c[i] = c[i] % 10;
            } else {
                int borrow = (Math.abs(c[i]) + 9) / 10;
                c[i + 1] -= borrow;
                c[i] += borrow * 10;
            }
        }
        // 앞에 붙은 0 지우기
        List<Integer> list = Arrays.stream(c).boxed().collect(Collectors.toList());
        while(list.size() > 0 && list.get(list.size() - 1) == 0) list.remove(list.size() - 1);
        return list.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
        BigIntegerMultiplication solution = new BigIntegerMultiplication();
        int[] a = {7, 2, 4, 1}; // 1427
        int[] b = {6, 6, 3, 2}; // 2366

        int[] c = solution.karatsuba(a, b);
        for (int i = c.length - 1; i >= 0; i--) {
            System.out.print(c[i]);
        }
        System.out.println();
    }
}
