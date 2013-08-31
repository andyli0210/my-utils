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
public class P1394Test {

    @Test
    public void test() {
        P1394 p1394 = new P1394();

        String input = "3\n"
                + "Tuttlingen\n"
                + "Constance\n"
                + "Freiburg\n"
                + "3\n"
                + "2\n"
                + "0949 Tuttlingen\n"
                + "1006 Constance\n"
                + "2\n"
                + "1325 Tuttlingen\n"
                + "1550 Freiburg\n"
                + "2\n"
                + "1205 Constance\n"
                + "1411 Freiburg\n"
                + "0800\n"
                + "Tuttlingen\n"
                + "Freiburg\n"
                + "2\n"
                + "Ulm\n"
                + "Vancouver\n"
                + "1\n"
                + "2\n"
                + "0100 Ulm\n"
                + "2300 Vancouver\n"
                + "0800\n"
                + "Ulm\n"
                + "Vancouver\n"
                + "0";
        
        InputStream in = new ByteArrayInputStream(input.getBytes());
        
        p1394.run(in);
    }
}
