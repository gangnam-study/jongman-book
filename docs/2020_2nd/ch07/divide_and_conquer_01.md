7장 분할 정복 (Divide & Conquer)

- 주어진 문제를 둘 이상의 부분 문제로 나눈 뒤 각 문제에 대한 답을 재귀 호출을 이용해 계산하고, 각 부분 문제의 답으로부터 전체 문제의 답을 계산해 내는 방법

- 재귀 호출과 분할 정복의 차이

  ![](https://github.com/gangnam-study/jongman-book/raw/master/docs/2019_2nd/ch07/images/IMG_3566.jpg)

- 분할 정복의 세가지 구성 요소
  - 문제를 더 작은 문제로 분할하는 과정 (divide)
  - 각 문제에 대해 구한 답을 원래 문제에 대한 답으로 병합하는 과정 (merge)
  - 더이상 답을 분할하지 않고 곧장 풀 수 있는 매우 작은 문제 (base case)
- 예제: 수열의 빠른 합과 행렬의 빠른 제곱 (p.176)
  - 수열의 빠른 합
    - 코드: https://github.com/gangnam-study/jongman-book/blob/master/docs/2020_2nd/ch07/code/SumOfSequence.java
  - 행렬의 빠른 제곱
    - 코드: https://github.com/gangnam-study/jongman-book/blob/master/docs/2020_2nd/ch07/code/MatrixMultiplication.java
- 예제: 병합 정렬과 퀵 정렬 (p.180)
  - 병합 정렬
    - https://youtu.be/QAyl79dCO_k?t=41
    - 코드: https://github.com/gangnam-study/jongman-book/blob/master/docs/2020_2nd/ch07/code/MergeSort.java
  - 퀵 정렬
    - https://youtu.be/7BDzle2n47c?t=203
    - 코드: https://github.com/gangnam-study/jongman-book/blob/master/docs/2020_2nd/ch07/code/QuickSort.java
- 예제: 카라츠바의 빠른 곱셈 알고리즘 (p.183)
  - 두 큰 수를 곱하는 O(n<sup>2</sup>) 시간 알고리즘
  - 두 큰 수를 곱하는 O(n<sup>log3</sup>) 시간 알고리즘 (카라츠바 알고리즘)
  - https://github.com/gangnam-study/jongman-book/blob/master/docs/2020_2nd/ch07/code/BigIntegerMultiplication.java
