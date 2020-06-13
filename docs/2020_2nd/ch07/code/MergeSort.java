package yeje2;

// 머지소트
public class MergeSort {
    public void sort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = (left + right) / 2;
        sort(arr, 0, mid);
        sort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1; // 왼쪽 배열의 크기
        int n2 = right - mid; // 오른쪽 배열의 크기
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];
        for (int i = 0; i < n1; i++) leftArr[i] = arr[i + left];
        for (int i = 0; i < n2; i++) rightArr[i] = arr[i + mid + 1];

        // 머지 시작
        int i = 0;
        int j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i] < rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 12, 11, 13, 5, 6, 7 };

        MergeSort solution = new MergeSort();
        solution.sort(arr, 0, arr.length - 1);
    }
}
