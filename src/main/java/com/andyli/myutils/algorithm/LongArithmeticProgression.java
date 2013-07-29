/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andyli.myutils.algorithm;

/**
 *
 * @author yanli
 */
public class LongArithmeticProgression {

    public int findLongestArithmeticProgress(int[] a) {
        int maxLen = 0;

        if (a.length< 2) {
            return 0;
        }

        if (a.length < 3) {
            return 2;
        }

        int[][] l = new int[a.length][a.length];
        
        for (int middle = 1; middle < a.length - 1; middle++) {

            int first = middle - 1;
            int third = middle + 1;
            
            while(first > -1 && third < a.length) {
                if (a[first] + a[third] == a[middle] * 2) {
                    l[middle][third] = l[first][middle] + 1;
                    
                    if (l[middle][third] > maxLen) {
                        maxLen = l[middle][third];
                    }
                    third++;
                    first--;
                } else if (a[first] + a[third] < a[middle] * 2) {
                    third++;
                } else {
                    first--;
                }
            }
        }

        return maxLen+2;
    }
}
