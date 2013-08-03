/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andyli.myutils.test;

/**
 *
 * @author yan
 */
import java.util.Queue;

public class MyFolder<T, U> implements Folder<T, U>
{
    public U fold(U u, Queue<T> ts, Function2<T, U, U> function)
    {
        if(u == null || ts == null || function == null)
            throw new IllegalArgumentException();

        while(!ts.isEmpty()) {
            u = function.apply(ts.poll(), u);
        }

        // The recursive implementation will overflow the stack for
        // any data set of real size, your job is to implement a
        // non-recursive solution
        // return fold(function.apply(ts.poll(), u), ts, function);
        return u;
    }
}
