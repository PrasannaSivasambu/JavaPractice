package org.example;

public class LongestPalindromeSubsequenceContiguous {

    static String findLongestPalindromeSubsequenceContiguous(String s){
        StringBuilder str = new StringBuilder();
        int i=0 , j=0;
        while (j<s.length()){

            if(s.substring(i,j+1).length()>1) {
                if (new StringBuilder(s.substring(i, j + 1)).reverse().equals(s.substring(j, j + 1))) {
                    if (str.length() < s.substring(i, j + 1).length()) {
                        str.replace(0, str.length(), s);
                    }

                }
            }

            j++;


        }
        return ";";
    }

    public static void main(String[] args) {
        String s="sasgiamadambadg";
        System.out.println( findLongestPalindromeSubsequenceContiguous(s.toLowerCase()) );
        int i=9%2;
        System.out.print(i);
    }
}
