package ch02;

import java.util.Scanner;
import java.util.Arrays;

class InvertArray {
    static void swap(int[] a, int idx1, int idx2){
        int temp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = temp;
    }

    static void reverse(int[] a){
        for(int i = 0; i<a.length/2;i++){
            swap(a,i,a.length-i-1);
        }
    }

    public static void main(String[ ] args){

        Scanner stdIn = new Scanner(System.in);

        System.out.print("점수의 개수: ");
        int num = stdIn.nextInt();

        int[] scores = new int[num];

        for(int i = 0;i<num;i++) {
            System.out.print("scores[" + i + "] : ");
            scores[i] = stdIn.nextInt();
        }

        reverse(scores);

        System.out.println("점수를 역순으로 정렬했습니다.");
        System.out.println("scores = "+Arrays.toString(scores));
    }
}
