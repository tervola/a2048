package com.codenjoy.dojo.a2048.client;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by user on 7/22/2015.
 */
public class temp {
    public static void main(String[] args) {
        int maximum = 4;
        int minimum = 1;
        Random rn = new Random();
        int range = maximum - minimum + 1;
        int randomNum =  rn.nextInt(range) + minimum;

        System.out.println(randomNum);

    }
}
