package day.day01.test;

import day.day01.src.No283_MoveZeroes;
import day.util.AssertUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class No283_MoveZeroes_Test {

    @Test
    public void test() {
        No283_MoveZeroes a = new No283_MoveZeroes();
        int[] expect = new int[]{1,3,12,0,0};
        int[] nums = new int[]{2,1,0,3,12};
        List<Integer> expectResults = Arrays.stream(expect)
                .boxed()
                .collect(Collectors.toList());
        List<Integer> realResults = Arrays.stream(a.moveZeroes(nums))
                .boxed()
                .collect(Collectors.toList());
        AssertUtil.assertArrayCommonEquals(expectResults, realResults);
    }
}
