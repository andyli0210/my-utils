/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andyli.myutils.problem;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.Test;

/**
 *
 * @author yan
 */
public class P2560Test {

    @Test
    public void test() {

        P2560 p2560 = new P2560();
        String input = "4\n"
                + "1.0 1.0\n"
                + "0.0 0.0\n"
                + "2.0 1.0\n"
                + "3.0 1.0\n";
        
        
        InputStream in = new ByteArrayInputStream(input.getBytes());
        
        p2560.output(in);
    }
}
