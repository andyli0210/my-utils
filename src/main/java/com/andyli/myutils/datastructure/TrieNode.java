/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andyli.myutils.datastructure;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yanli
 */
public class TrieNode {

    private char value;
    private List<TrieNode> children = new ArrayList<TrieNode>();

    public boolean search(String text) {
        if (text == null || text.length() == 0) {
            return true;
        }

        char first = text.charAt(0);
        TrieNode child = getChild(first);
        if (child != null) {
            return search(text.substring(1));
        }

        return false;
    }

    public void insert(String text) {
        char first = text.charAt(0);

        TrieNode child = getChild(first);
        if (child == null) {
            child = new TrieNode();
            child.setValue(first);
            children.add(child);
        }
        
        child.insert(text.substring(0));
    }

    private TrieNode getChild(char c) {
        for (TrieNode child : children) {
            if (child.getValue() == c) {
                return child;
            }
        }

        return null;
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }
}
