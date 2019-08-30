package com.ldp.gitdemo;

import java.util.Arrays;
import java.util.List;

public class ArrayList {
    public static void main(String[] args) {
        List<Integer> arr=new java.util.ArrayList<>(Arrays.asList(1,0,9,0,0,2,4,7));
        for (int i=0;i<arr.size();++i){
            if (arr.get(i)==0){
                arr.remove(i);
            }
        }
        for (int i=0;i<arr.size();i++){
            System.out.println(arr.toString());
        }
    }
}
