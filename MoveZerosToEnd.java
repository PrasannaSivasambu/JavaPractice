package org.example;

import java.util.Arrays;

public class MoveZerosToEnd {
    static int[] doMoveZerosToEnd(int[] i){
        int x=0,y=1;
        while(y<=i.length-1){
            if(i[x]==0){
                if(i[y]!=0) {
                    int temp = i[y];
                    i[y] = i[x];
                    i[x] = temp;
                    x++;
                    y++;
                }
                else{
                    y++;
                }
            }
            else {
                x++;
                y++;
            }
        }
        return  i;
    }

    public static void main(String[] args) {

     System.out.println(Arrays.toString(doMoveZerosToEnd( new int[]{1,2,14,0,3,54,89,0,0,98,12,34,0,11,23,0,23,0,23,5,0,0,0,78,87,0, 1, 0, 3, 12})));
    }
}
