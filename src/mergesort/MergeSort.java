package mergesort;

public class MergeSort {
    private int[] arr;

    public MergeSort(int[] arr) {
        this.arr = arr;
    }

    public int[] getArray() {
        return arr;
    }

    private void merge(int array[], int L, int mid, int R) {

        int[] left = new int[mid - L + 1];
        int[] right = new int[R - mid];

        for (int i = 0; i < left.length; i++) {
            left[i] = array[L + i];
        }
        for (int i = 0; i < right.length; i++) {
            right[i] = array[mid + 1 + i];
        }

        int arrIndex;
        int leftIndex = 0;
        int rightIndex = 0;

        for (arrIndex = L; leftIndex < left.length && rightIndex < right.length; arrIndex++) {
            if (leftIndex < left.length && left[leftIndex] < right[rightIndex]) {
                array[arrIndex] = left[leftIndex];
                leftIndex++;
            } else if (rightIndex < right.length) {
                array[arrIndex] = right[rightIndex];
                rightIndex++;
            }
        }

        for (; arrIndex < R + 1; arrIndex++) {
            if (rightIndex >= right.length) {
                array[arrIndex] = left[leftIndex];
                leftIndex++;
            } else if (leftIndex >= left.length) {
                array[arrIndex] = right[rightIndex];
                rightIndex++;
            }
        }
    }

    void mergeSort(int arr[], int left, int r) {
        if (left < r) {
            int m = (left + r) / 2;
            mergeSort(arr, left, m);
            mergeSort(arr, m + 1, r);
            merge(arr, left, m, r);
        }
    }

    public int binarysearch(int L, int R, int num, int[] arr) {
        if (L <= R) {
            int m = (L + R) / 2;
            if (arr[m] == num) {
                return m;
            } else if (arr[m] < num) {
                return binarysearch(m + 1, R, num, arr);
            } else {
                return binarysearch(L, m - 1, num, arr);
            }
        }
        return -1;
    }

}
