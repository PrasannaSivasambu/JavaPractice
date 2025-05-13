package org.example;

public class StringIsRotationOfAnother {

    static  boolean checkStringIsRotationOfAnother(String s1,String s2){
        StringBuilder s = new StringBuilder(s1+s1);
        if(s.toString().contains(s2)) return true;
        return  false;
    }

    public static void main(String[] args) {
      System.out.println(checkStringIsRotationOfAnother("abcd","cdab"));
    }
}
