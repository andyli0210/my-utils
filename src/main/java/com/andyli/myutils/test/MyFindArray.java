/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andyli.myutils.test;

/**
 *
 * @author yan
 */

public class MyFindArray implements FindArray {
    public int findArray(int[] array, int[] subArray) {
        if (array.length == 0 || subArray.length == 0 || array.length < subArray.length) {
            return -1;
        }
        
        String str = "";
        for (int i=0; i<array.length; i++) {
            str += array[i];
        }
        
        String subStr = "";
        for (int j=0; j<subArray.length; j++) {
            subStr += subArray[j];
        }
        
        return str.indexOf(subStr);
    }
}
