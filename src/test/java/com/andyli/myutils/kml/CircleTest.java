/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andyli.myutils.kml;

import org.junit.Test;

/**
 *
 * @author yanli
 */
public class CircleTest {
    
    private Circle kmlCircle = new Circle();
    
    @Test
    public void shouldGenerateKmlCircle() {
        
        String circleString = kmlCircle.kmlPolygon(150.07743, -36.42666, 50, 30, 0);
        
        System.out.println(circleString);
    }
}
