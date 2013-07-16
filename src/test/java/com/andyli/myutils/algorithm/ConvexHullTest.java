/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andyli.myutils.algorithm;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author yan
 */
public class ConvexHullTest {
    
    private List<Point> points;
    
    ConvexHull convexHull = new ConvexHull();

    @Before
    public void setup() {
        points = new ArrayList<Point>();
        
        points.add(new Point(0, 3));
        points.add(new Point(2, 2));
        points.add(new Point(1, 1));
        points.add(new Point(2, 1));
        points.add(new Point(3, 0));
        points.add(new Point(0, 0));
        points.add(new Point(3, 3));
        
    }

    @Test
    public void shouldGetOritation() {
        
        Point p1 = new Point(0, 3);
        Point p2 = new Point(0,0);
        Point p3 = new Point(3,0);
        
        Assert.assertFalse(convexHull.isAntiClockWise(p1, p2, p3));
        Assert.assertTrue(convexHull.isAntiClockWise(p2, p1, p3));
        Assert.assertTrue(convexHull.isAntiClockWise(p3, p2, p1));
    }
    
    @Test
    public void shoudlGetHullPoints() {
         List<Point> hullPoints = convexHull.getConvexHullPoint(points);
         
         for (Point point : hullPoints) {
             System.out.println(point);
         }
         
    }
}
