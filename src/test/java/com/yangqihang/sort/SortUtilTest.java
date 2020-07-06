package com.yangqihang.sort;

import com.yangqihang.generate.GenerateUtil;
import com.yangqihang.util.ArrayUtil;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SortUtilTest {

    @Test
    public void selectionSort() {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = GenerateUtil.generateRandomArray(maxSize, maxValue);
            int[] arr2 = ArrayUtil.copyArray(arr1);
            SortUtil.selectionSort(arr1);
            SortUtil.baseSort(arr2);
            if (!ArrayUtil.isEquals(arr1, arr2)) {
                succeed = false;
                ArrayUtil.printArray(arr1);
                ArrayUtil.printArray(arr2);
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }

    @Test
    public void bubbleSort() {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = GenerateUtil.generateRandomArray(maxSize, maxValue);
            int[] arr2 = ArrayUtil.copyArray(arr1);
            SortUtil.bubbleSort(arr1);
            SortUtil.baseSort(arr2);
            if (!ArrayUtil.isEquals(arr1, arr2)) {
                succeed = false;
                ArrayUtil.printArray(arr1);
                ArrayUtil.printArray(arr2);
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }

    @Test
    public void insertSort() {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = GenerateUtil.generateRandomArray(maxSize, maxValue);
            int[] arr2 = ArrayUtil.copyArray(arr1);
            SortUtil.insertSort(arr1);
            SortUtil.baseSort(arr2);
            if (!ArrayUtil.isEquals(arr1, arr2)) {
                succeed = false;
                ArrayUtil.printArray(arr1);
                ArrayUtil.printArray(arr2);
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
}