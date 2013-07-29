/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andyli.myutils.algorithm;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author yanli
 */
public class LongArithmeticProgressionTest {
    
    @Test
    public void shouldFindLongestArithmeticProgress() {
        LongArithmeticProgression arithmeticProgression = new LongArithmeticProgression();
        
        
        int[] a = new int[]{1, 7, 10, 15, 27, 29};
        int[] b = new int[]{5, 10, 15, 20, 25, 30};
        int[] c = new int[]{1, 7, 10, 13, 14, 19};
        int[] d = new int[]{1, 7, 10, 15, 27, 29};
        int[] e = new int[]{2, 4, 6, 8, 10};
        
        Assert.assertEquals(3, arithmeticProgression.findLongestArithmeticProgress(a));
        Assert.assertEquals(6, arithmeticProgression.findLongestArithmeticProgress(b));
        Assert.assertEquals(4, arithmeticProgression.findLongestArithmeticProgress(c));
        Assert.assertEquals(3, arithmeticProgression.findLongestArithmeticProgress(d));
        Assert.assertEquals(5, arithmeticProgression.findLongestArithmeticProgress(e));
        
    }
}
