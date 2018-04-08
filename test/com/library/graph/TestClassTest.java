package com.library.graph;

import org.junit.Assert;
import org.junit.Test;

public class TestClassTest {
    @Test
    public void test_genstones(){
        int i = TestClass.gemstones(new String[]{"abcdde", "baccd", "eeabg"});
        Assert.assertEquals(2, i);
    }

    @Test
    public void test_move_zeroes(){
        int[] a = new int[]{0,1,0,3,12};
        TestClass.moveZeroes(a);
        System.out.println(a);
    }

    @Test
    public void test_move_no_zeroes(){
        int[] a = new int[]{2,1,4,3,12};
        TestClass.moveZeroes(a);
        System.out.println(a);
    }

    @Test
    public void test_move_no_initial_zeroes(){
        int[] a = new int[]{2,0,4,0,12};
        TestClass.moveZeroes(a);
        System.out.println(a);
    }

    @Test
    public void test_BuildTree(){
        int[] in = new int[]{2,1};
        int[] post = new int[]{2,1};
        TestClass tc = new TestClass();
        tc.buildTree(in,post);
    }

    @Test
    public void test_sumSubArray(){
        int[] in = new int[]{1,2,3,4,5};
        TestClass tc = new TestClass();
        tc.minSubArrayLen(11,in);
    }

    @Test
    public void test_regex(){
        System.out.println("11->33->".replaceAll("->$", ""));
    }

    @Test
    public void test_isValidBST(){
        TestClass.TreeNode n = new TestClass.TreeNode(1);
        n.left = new TestClass.TreeNode(1);
        TestClass tc = new TestClass();
        Assert.assertEquals(false, tc.isValidBST(n));
    }

    @Test
    public void test_asList() {
        int[] a = new int[]{1, 2, 3, 4};
    }
}