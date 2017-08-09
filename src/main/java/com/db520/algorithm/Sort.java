package com.db520.algorithm;

import java.util.Arrays;

/**
 * Eight Sort Algorithms
 * @Author db520 [dragonbest520@gmail.com]
 * @Date 2017-08-08
 */
public class Sort {

    /**
     * BubbleSort
     * @param array
     */
    public static double[] bubbleSort(double[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if(array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
        return (array);
    }

    /**
     * SelectionSort
     * @param array
     * @return
     */
    public static double[] selectionSort(double[] array) {
        for (int i = 0; i < array.length; i++) {
            int index = array.length - i - 1;
            for (int j = 0; j < array.length - i - 1; j++) {
                if(array[j] > array[index]) {
                    index = j;
                }
            }
            swap(array, array.length - i - 1, index);
        }
        return array;
    }

    /**
     * InsertionSort
     * @param array
     * @return
     */
    public static double[] insertionSort(double[] array) {
        for (int i = 1; i < array.length; i++) {
            double temp = array[i];
            int index = i;
            for (int j = i - 1; j >= 0; j--) {
                if(array[j] > temp) {
                    array[j + 1] = array[j];
                    index = j;
                }
            }
            array[index] = temp;
        }
        return array;
    }

    /**
     * HeapSort default is heapSortAsc
     * @param array
     * @return
     */
    public static double[] heapSort(double[] array) {
        return heapSortAsc(array);
    }

    /**
     * HeapSortAsc
     * @param array
     * @return
     */
    public static double[] heapSortAsc(double[] array) {
        for (int i = 0; i < array.length; i++) {
            maxHeap(array, array.length - i);
            swap(array, 0, array.length - i - 1);
        }
        return array;
    }

    /**
     * HeapSortDesc
     * @param array
     * @return
     */
    public static double[] heapSortDesc(double[] array) {
        for (int i = 0; i < array.length; i++) {
            minHeap(array, array.length - i);
            swap(array, 0, array.length - i - 1);
        }
        return array;
    }

    public static double[] mergeSort(double[] array) {
        divideMergeArray(array, 0, array.length - 1);
        return array;
    }

    /**
     * QuickSort
     * @param array
     * @return
     */
    public static double[] quickSort(double[] array) {
        quickSortArray(array, 0, array.length - 1);
        return array;
    }

    /**
     * ShellSort
     * @param array
     * @return
     */
    public static double[] shellSort(double[] array) {
        for (int i = array.length / 2; i >= 1; i = i / 2) {
            for (int j = 0; j < i; j++) {
                for (int k = j + i; k < array.length; k = k + i) {
                    double base = array[k];
                    int index = k;
                    for (int l = k - i; l >= 0; l = l - i) {
                        if(array[l] > base) {
                            array[l + i] = array[l];
                            index = l;
                        }
                        array[index] = base;
                    }
                }
            }
        }
        return array;
    }

    /**
     * RadixLSDSort
     * @param array
     * @return
     */
    public static int[] radixLSDSort(int[] array) {
        int maxNumLength = getMaxNumLength(array);
        radixLSDSortArray(array, maxNumLength);
        return array;
    }

    /**
     * RadixMSDSort
     * @param array
     * @return
     */
    public static int[] radixMSDSort(int[] array) {
        int maxNumLength = getMaxNumLength(array);
        radixMSDSortArray(array, maxNumLength);
        return array;
    }

    /**
     * swap two elements of array
     * @param array
     * @param x
     * @param y
     */
    public static void swap(double[] array, int x, int y) {
        if(x != y) {
            double temp = array[x];
            array[x] = array[y];
            array[y] = temp;
        }
    }

    /**
     * construct unsorted array to maxHeap
     * @param array has 2 part, unsorted(from 0 to unSortedLength - 1) and sorted(from unSortedLength to array.length - 1)
     * @param unSortedLength is the length of unsorted array part
     */
    private static void maxHeap(double[] array, int unSortedLength) {
        for (int i = unSortedLength - 1; i >= 0; i--) {
            if(hasChild(array, i, unSortedLength)) {
                int maxValIndex = getLeftChildIndex(i);
                if(hasRightChild(array, i, unSortedLength)) {
                    if(array[getLeftChildIndex(i)] < array[getRightChildIndex(i)]) {
                        maxValIndex = getRightChildIndex(i);
                    }
                }
                if(array[i] < array[maxValIndex]) {
                    swap(array, i, maxValIndex);
                }
            }
        }
    }

    /**
     * construct unsorted array to minHeap
     * @param array has 2 part, unsorted(from 0 to unSortedLength - 1) and sorted(from unSortedLength to array.length - 1)
     * @param unSortedLength is the length of unsorted array part
     */
    private static void minHeap(double[] array, int unSortedLength) {
        for (int i = unSortedLength - 1; i >= 0; i--) {
            if(hasChild(array, i, unSortedLength)) {
                int minValIndex = getLeftChildIndex(i);
                if(hasRightChild(array, i, unSortedLength)) {
                    if(array[getLeftChildIndex(i)] > array[getRightChildIndex(i)]) {
                        minValIndex = getRightChildIndex(i);
                    }
                }
                if(array[i] > array[minValIndex]) {
                    swap(array, i, minValIndex);
                }
            }
        }
    }

    public static boolean hasChild(double[] array, int index) {
        return hasLeftChild(array, index);
    }

    private static boolean hasChild(double[] array, int index, int unSeqLength) {
        return hasLeftChild(array, index, unSeqLength);
    }

    private static boolean hasLeftChild(double[] array, int index) {
        return hasLeftChild(array, index, array.length);
    }

    public static boolean hasRightChild(double[] array, int index) {
        return hasRightChild(array, index, array.length);
    }

    private static boolean hasLeftChild(double[] array, int index, int unSeqLength) {
        if(unSeqLength > getLeftChildIndex(index)) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean hasRightChild(double[] array, int index, int unSeqLength) {
        if(unSeqLength > getRightChildIndex(index)) {
            return true;
        } else {
            return false;
        }
    }

    private static int getLeftChildIndex(int index) {
        return 2 * index + 1;
    }

    private static int getRightChildIndex(int index) {
        return 2 * index + 2;
    }

    /**
     * DivideMergeArray
     * @param array
     * @param left The left index of array
     * @param right The right index of array
     * @return
     */
    private static void divideMergeArray(double[] array, int left, int right) {
        if(left < right) {
            int mid = (left + right) / 2;
            divideMergeArray(array, left, mid);
            divideMergeArray(array, mid + 1, right);
            mergeTwoArrays(array, left, mid, right);
        }
    }

    /**
     * mergeTwoArrays from array
     * 1st array index is left to mid
     * 2nd array index is mid + 1 to right
     * @param array
     * @param left
     * @param mid
     * @param right
     * @return
     */
    private static void mergeTwoArrays(double[] array, int left, int mid, int right) {
        double[] mergedArray = new double[right + 1 - left];
        int i = left, j = mid + 1, k = 0;
        for (; i < mid + 1 && j < right + 1;) {
            if(array[i] < array[j]) {
                mergedArray[k++] = array[i++];
            } else {
                mergedArray[k++] = array[j++];
            }
        }
        for (; i < mid + 1;) {
            mergedArray[k++] = array[i++];
        }
        for (; j < right + 1;) {
            mergedArray[k++] = array[j++];
        }
        for (int l = 0; l < right + 1 - left;) {
            array[left + l] = mergedArray[l++];
        }
    }

    private static void quickSortArray(double[] array, int left, int right) {
        if(left < right) {
            int mid = adjustArray(array, left, right);
            quickSortArray(array, left, mid - 1);
            quickSortArray(array, mid + 1, right);
        }
    }

    private static int adjustArray(double[] array, int left, int right) {
        double base = array[left];
        while (right > left) {
            while (right > left && array[right] > base) {
                right--;
            }

            if(right > left) {
                array[left] = array[right];
                left++;
            }

            while (right > left && array[left] < base) {
                left++;
            }

            if(right > left) {
                array[right] = array[left];
                right--;
            }
        }
        array[right] = base;
        return right;
    }

    public static int getMaxNumLength(int[] array) {
        int maxNumLength = 1;
        if(array.length > 0) {
            int maxValue = array[0];
            for (int anArray : array) {
                if (anArray > maxValue) {
                    maxValue = anArray;
                }
            }
            while(Math.pow(10, maxNumLength) < maxValue) {
                maxNumLength++;
            }
        }
        return maxNumLength;
    }

    private static void radixLSDSortArray(int[] array, int maxNumLength) {
        int index = 0;
        int[] orderNum = new int[10];
        int[][] container = new int[10][array.length];
        for (int i = 0; i < maxNumLength; i++) {
            for (int anArray : array) {
                int num = (int) ((anArray / Math.pow(10, i)) % 10);
                container[num][orderNum[num]] = anArray;
                orderNum[num]++;
            }
            for (int j = 0; j < 10; j++) {
                if(orderNum[j] != 0) {
                    for (int k = 0; k < orderNum[j]; k++) {
                        array[index] = container[j][k];
                        index++;
                    }
                }
                orderNum[j] = 0;
            }
            index = 0;
        }
    }

    private static void radixMSDSortArray(int[] array, int maxNumLength) {
        if(maxNumLength > 0) {
            int index = 0;
            int[] orderNum = new int[10];
            int[][] container = new int[10][array.length];

            for (int anArray : array) {
                int num = (int) ((anArray / Math.pow(10, maxNumLength - 1)) % 10);
                container[num][orderNum[num]] = anArray;
                orderNum[num]++;
            }
            maxNumLength--;

            for (int i = 0; i < 10; i++) {
                if(orderNum[i] > 1) {
                    int[] newArray = new int[orderNum[i]];
                    System.arraycopy(container[i], 0, newArray, 0, orderNum[i]);
                    radixMSDSortArray(newArray, maxNumLength);
                    System.arraycopy(newArray, 0, container[i], 0, orderNum[i]);
                }
            }

            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < orderNum[i]; j++) {
                    array[index] = container[i][j];
                    index++;
                }
            }
        }
    }

    public static void main(String[] args) {
        double[] array = {8, 5, 4, 1, 9, 6, 7, 3, 2};
        Sort.bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }

}
