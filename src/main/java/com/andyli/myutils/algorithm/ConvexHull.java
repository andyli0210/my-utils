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

    public static class Point implements Comparable<Point> {

        private double x;
        private double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

        @Override
        public int hashCode() {
            int hash = 3;
            hash = 97 * hash + (int) (Double.doubleToLongBits(this.x) ^ (Double.doubleToLongBits(this.x) >>> 32));
            hash = 97 * hash + (int) (Double.doubleToLongBits(this.y) ^ (Double.doubleToLongBits(this.y) >>> 32));
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Point other = (Point) obj;
            if (this.x != other.x) {
                return false;
            }
            if (this.y != other.y) {
                return false;
            }
            return true;
        }

        @Override
        public String toString() {
            return x + "," + y;
        }

        public int compareTo(Point o) {
            if (this.x < o.x) {
                return -1;
            }
            if (this.x > o.x) {
                return 1;
            }

            return 0;
        }
    }

    private static boolean isAntiClockWise(Point P1, Point P2, Point P3) {

        double P2P1Diff = (P2.x - P1.x) / (P2.y - P1.y);
        double P3P1Diff = (P3.x - P1.x) / (P3.y - P1.y);

        return (P3P1Diff > P2P1Diff);
    }

    public static List<Point> getConvexHullPoint(List<Point> points) {
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
    
    public static void main(String[]arg) {
//        Point points[] = {{0.0, 3.0}, {2.0, 2.0}, {1.0, 1.0}, {2.0, 1.0},
//                      {3.0, 0.0}, {0.0, 0.0}, {3.0, 3.0}};
        
        List<ConvexHull.Point> points = new ArrayList<ConvexHull.Point>();
        
        points.add(new ConvexHull.Point(1, 3));
        points.add(new ConvexHull.Point(2, 2));
        points.add(new ConvexHull.Point(1, 1));
        points.add(new ConvexHull.Point(2, 1));
        points.add(new ConvexHull.Point(3, 0));
        points.add(new ConvexHull.Point(0, 0));
        points.add(new ConvexHull.Point(3, 3));
        
        List<Point> hullPoints = getConvexHullPoint(points);
        
        for (Point point : hullPoints) {
            System.out.println(point);
        }
    }
}

