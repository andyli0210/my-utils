/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andyli.myutils.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author yanli
 */
public class ConvexHull {

    public boolean isAntiClockWise(Point P1, Point P2, Point P3) {

        //double P2P1Diff = (P2.x - P1.x) / (P2.y - P1.y);
        //double P3P1Diff = (P3.x - P1.x) / (P3.y - P1.y);
        
        //change the division formula to multipy formula in case two points
        //has the same y value and we may divide by 0 !
        
        return (P2.x - P1.x) * (P3.y - P1.y) < (P2.y - P1.y) * (P3.x - P1.x);
    }

    public List<Point> getConvexHullPoint(List<Point> points) {
        List<Point> hullPoints = new ArrayList<Point>();

        Collections.sort(points);

        Point P1 = points.get(0);
        
        Point P2 = points.get(1);

        int p1Index = 0;

        hullPoints.add(P1);
        while (!P2.equals(points.get(0))) {
            P2 = points.get((p1Index+1)%points.size());
            
            for (int i = 0; i < points.size(); i++) {
                Point P3 = points.get(i);

                if (!P3.equals(P1) && !P3.equals(P2) && !isAntiClockWise(P1, P2, P3)) {
                    P2 = P3;
                    p1Index = i;
                }
            }
            
            hullPoints.add(P2);
            P1 = P2;
        } 

        return hullPoints;
    }
    
}

