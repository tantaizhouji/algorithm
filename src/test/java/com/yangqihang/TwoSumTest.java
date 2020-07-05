package com.yangqihang;

import com.yangqihang.util.ArrayUtil;
import org.junit.Test;

import static org.junit.Assert.*;

public class TwoSumTest {

    @Test
    public void twoSum() {
        int[] arr = {-3, 4, 3, 90};
        int[] ints = TwoSum.twoSum(arr, 0);
        ArrayUtil.printArray(ints);
    }
}