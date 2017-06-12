
package com.HavanaClub.parser;

import java.util.Arrays;

/**
 * Created by admin on 6/10/2017.
 */
public class Main {

    public static void main(String[] args) {

        int [] number = {4,9,3,7,8};
        int [] check = {3,7};

        findArray(number, check);

    }

    public static int findArray(int[] array, int[] subArray) {

        if(array.length >= subArray.length){
            int index = array[0];
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < subArray.length; j++) {
                    System.out.println("array = " + array[i]);
                    System.out.println("sub = " + subArray[j]);
                    if(array[i] == subArray[j]){
                        System.out.println("in");
                        index = i;
                        break;
                    }
                }
            }
            System.out.println(index);
        }


        return -1;
    }

}
