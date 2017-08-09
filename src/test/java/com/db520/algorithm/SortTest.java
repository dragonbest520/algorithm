package com.db520.algorithm;

import org.junit.Test;

import java.util.Arrays;

public class SortTest {

    @Test
    public void bubbleSort() throws Exception {
        double[] array = {8, 5, 4, 1, 9, 6, 7, 3, 2};
        Sort.bubbleSort(array);
        System.out.println("bubbleSort result: " + Arrays.toString(array));
    }

    @Test
    public void selectionSort() throws Exception {
        double[] array = {8, 5, 4, 1, 9, 6, 7, 3, 2};
        Sort.selectionSort(array);
        System.out.println("selectionSort result: " + Arrays.toString(array));
    }

    @Test
    public void insertionSort() throws Exception {
        double[] array = {8, 5, 4, 1, 9, 6, 7, 3, 2};
        Sort.insertionSort(array);
        System.out.println("insertionSort result: " + Arrays.toString(array));
    }

    @Test
    public void heapSort() throws Exception {
        double[] array = {8, 5, 4, 1, 9, 6, 7, 3, 2};
        Sort.heapSort(array);
        System.out.println("heapSort result: " + Arrays.toString(array));

        double[] array2 = {8, 5, 4, 1, 9, 6, 7, 3, 2};
        Sort.heapSortDesc(array2);
        System.out.println("heapSortDesc result: " + Arrays.toString(array2));
    }

    @Test
    public void mergeSort() throws Exception {
        double[] array = {8, 5, 4, 1, 9, 6, 7, 3, 2};
        Sort.mergeSort(array);
        System.out.println("mergeSort result: " + Arrays.toString(array));
    }

    @Test
    public void quickSort() throws Exception {
        double[] array = {8, 5, 4, 1, 9, 6, 7, 3, 2};
        Sort.quickSort(array);
        System.out.println("quickSort result: " + Arrays.toString(array));
    }

}