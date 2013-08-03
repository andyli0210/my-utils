/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andyli.myutils.problem;

import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author yanli
 */
public class P1001Test {
    
    P1001 p1001 = new P1001();
    
    @Test
    public void shouldReverseString() {
        StringBuilder sb = new StringBuilder("abc");
        sb.reverse();
        Assert.assertEquals("cba", sb.toString());
         Assert.assertEquals(3,sb.length());
    }
    
    @Test
    public void shouldConvertToChar() {
        int i = 9;
        char c = (i+"").charAt(0);
        Assert.assertEquals('9', c);
    }
    
    @Test
    public void shouldAdd() {
        String a = "123";
        String b = "89";
        
        String result = p1001.add(a, b);
        Assert.assertEquals("212", result);
        result = p1001.add(b, a);
        Assert.assertEquals("212", result);
    }
    
    @Test
    public void shouldMultiplySingle() {
        String a = "123";
        int b = 5;
        
        String result = p1001.singleMultiply(a, b);
        Assert.assertEquals("615", result);
        Assert.assertEquals("1107", p1001.singleMultiply(a, 9));
    }
    
    @Test
    public void testMultiply() {
        String a = "123";
        String b = "89";
        
        String result = p1001.multiply(a, b);
        Assert.assertEquals("10947", result);
    }
    
}
