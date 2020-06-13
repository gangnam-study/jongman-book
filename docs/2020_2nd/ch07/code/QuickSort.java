package yeje2;

// 퀵소트
public class QuickSort {
    public void sort(int[] arr, int leftIdx, int rightIdx) {
        if (leftIdx >= rightIdx) {
            return;
        }

        int pivotIdx = partition(arr, leftIdx, rightIdx);
        sort(arr, leftIdx, pivotIdx - 1);
        sort(arr, pivotIdx + 1, rightIdx);
    }

    private int partition(int[] arr, int leftIdx, int rightIdx) {
        int pivotValue = arr[(leftIdx + rightIdx) / 2];
        while (leftIdx < rightIdx) {
            while(arr[leftIdx] < pivotValue) leftIdx++;
            while(arr[rightIdx] > pivotValue) rightIdx--;
            if (leftIdx < rightIdx) {
                // swap
                int temp = arr[leftIdx];
                arr[leftIdx] = arr[rightIdx];
                arr[rightIdx] = temp;
            }
        }
        return leftIdx; // 파티션 과정이 끝나면 최종적으로 leftIdx가 피봇의 인덱스가 된다
    }

    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5, 11};

        QuickSort solution = new QuickSort();
        solution.sort(arr, 0, arr.length - 1);
    }
}
