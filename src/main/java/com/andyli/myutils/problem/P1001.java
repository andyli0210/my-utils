/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andyli.myutils.problem;

/**
 *
 * @author yanli
 */
public class P1001 {
    
    protected String multiply(String a, String b) {
        StringBuilder sb1 = new StringBuilder(a);
        StringBuilder sb2 = new StringBuilder(b);
        sb1.reverse();
        sb2.reverse();
        
        String result = "";
        for (int i=0; i<sb2.length(); i++) {
            int n = Integer.parseInt(sb2.charAt(i) +"");
            StringBuilder singleResult = new StringBuilder(singleMultiply(a, n));
            for (int j=0; j<i; j++) {
                singleResult.append('0');
            }
            
            if (!result.isEmpty()) {
                result = add(result, singleResult.toString());
            } else {
                result = singleResult.toString();
            }
        }
        
        return result;
    }
    
    protected String singleMultiply(String a, int b) {
        StringBuilder sb = new StringBuilder(a);
        sb.reverse();
        int carry = 0;
        for (int i=0; i<sb.length(); i++) {
            int n = Integer.parseInt(sb.charAt(i)+"");
            int sum = n * b + carry;
            carry = sum / 10;
            sum = sum - carry * 10;
            sb.setCharAt(i, (sum + "").charAt(0));
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    protected String add(String a, String b) {
        StringBuilder sb1 = new StringBuilder(a);
        StringBuilder sb2 = new StringBuilder(b);
        sb1.reverse();
        sb2.reverse();

        int length = sb1.length() > sb2.length() ? sb1.length() : sb2.length();
        int reminder = 0;
        int add1 = 0;
        int add2 = 0;
        for (int i = 0; i < length; i++) {
            if (sb1.length() <= i) {
                add1 = 0;
                sb1.append("0");
            } else {
                add1 = Integer.parseInt(sb1.charAt(i) + "");
            }
            if (sb2.length() <= i) {
                add2 = 0;
            } else {
                add2 = Integer.parseInt(sb2.charAt(i) + "");
            }
            
            int sum = add1 + add2 + reminder;
            reminder = sum / 10;
            sum = sum - reminder * 10;
            sb1.setCharAt(i, (sum + "").charAt(0));
        }
        if (reminder > 0) {
            sb1.append(reminder);
        }
        
        return sb1.reverse().toString();
    }
}
