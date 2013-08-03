/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andyli.myutils.test;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author yan
 */
public class MyFindArrayTest {
    
    @Test
    public void shouldFindSubArray() {
        MyFindArray myFindArray = new MyFindArray();
        
        int []a1 = new int[]{4,9,3,7,8};
        int []b1 = new int[]{3,7};
        
        Assert.assertEquals(2, myFindArray.findArray(a1, b1));
        
        int []a2 = new int[]{1,3,5};
        int []b2 = new int[]{1};
        
        Assert.assertEquals(0, myFindArray.findArray(a2, b2));
        
        int []a3 = new int[]{7,8,9};
        int []b3 = new int[]{8,9,10};
        
        Assert.assertEquals(-1, myFindArray.findArray(a3, b3));
    }
}
