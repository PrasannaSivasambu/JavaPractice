package org.example;

public class LongestCommonPrefix {

    static String findLongestCommonPrefix(String[] str){
        int i=1;
        StringBuilder s= new StringBuilder(str[0]);

        while (i<=str.length-1){
            StringBuilder sb=new StringBuilder();
            int j=0,k=0;
            while (j<s.length() && k<str[i].length()){
                if(s.charAt(j)==str[i].charAt(k)){
                   sb.append(s.charAt(j));
                }
                else break;
                j++;
                k++;
            }
            s=sb;
        i++;
        }
        return  s.toString();

    }

    public static void main(String[] args) {



     System.out.println( findLongestCommonPrefix( new String[]{"flower", "flow", "flight","fy"}) );
    }
}
