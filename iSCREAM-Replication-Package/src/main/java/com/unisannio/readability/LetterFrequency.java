/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unisannio.readability;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Michele Fredella
 */
public class LetterFrequency {

//    public static void main(String[] args) {
//
//        String string = "Object ret = body.eval(callstack, interpreter);boolean breakout = false; if(ret instanceof ReturnControl){ switch(((ReturnControl)ret).kind ){case RETURN return ret;";
//        System.out.println(letterFrequency(string));
//    }
    public static int letterFrequency(String a) {
        char[] chars = a.toCharArray();
        HashMap<Character, Integer> countMap = new HashMap<Character, Integer>();
        for (char aChar : chars) {
            if (countMap.containsKey(aChar)) {
                countMap.put(aChar, countMap.get(aChar) + 1);
            } else {
                countMap.put(aChar, 1);
            }
        }

        //determine max occurence
        int max = 0;
        for (Integer i : countMap.values()) {
            if (max < i) {
                max = i;
            }
        }
        int massimo = 0;
        //print all satisfiying max occurrence
        for (Map.Entry<Character, Integer> e : countMap.entrySet()) {
            if (e.getValue() == max) {
                massimo = max;
            }
        }
        return massimo;
    }
}
