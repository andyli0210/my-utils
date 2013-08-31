/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andyli.myutils.problem;

import java.io.InputStream;
import java.util.Scanner;

/**
 *
 * @author yan
 */
public class P2560 {

    private class Freckle {

        double x;
        double y;

        public Freckle(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public static void main(String[]args) {
        P2560 p2560 = new P2560();
        p2560.output(System.in);
    }
    
    public void output(InputStream in) {
        Scanner scanner = new Scanner(in);
        int freckleNum = scanner.nextInt();
        Freckle[] freckles = new Freckle[freckleNum];
        for (int i = 0; i<freckleNum; i++) {
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            Freckle freckle = new Freckle(x, y);
            freckles[i] = freckle;
        }
        
        double minDist = minDist(freckles);
        System.out.printf("%.2f",minDist);     
    }

    private double minDist(Freckle[] freckles) {
        double minDistance = 0;
        boolean[] inTree = new boolean[freckles.length];
        double[] minDists = new double[freckles.length];
        for (int i = 0; i < freckles.length; i++) {
            minDists[i] = Double.MAX_VALUE;
        }

        int newNode = 0;

        while (inTree[newNode] == false) {
            inTree[newNode] = true;

            double minDist = Double.MAX_VALUE;
            int nextNode = newNode;
            for (int i = 0; i < freckles.length; i++) {
                if (!inTree[i]) {
                    double dist = getDistance(freckles[i], freckles[newNode]);
                    if (dist < minDists[i]) {
                        minDists[i] = dist;
                    }

                    if (minDists[i] < minDist) {
                        minDist = minDists[i];
                        nextNode = i;
                    }
                }
            }
            
            if (nextNode != newNode) {
                newNode = nextNode;
                minDistance += minDist;
            }
        }

        return minDistance;
    }

    private double getDistance(Freckle a, Freckle b) {
        double dist = Math.pow((a.x - b.x), 2) + Math.pow((a.y - b.y), 2);
        dist = Math.sqrt(dist);
    
        return dist;
    }
}
