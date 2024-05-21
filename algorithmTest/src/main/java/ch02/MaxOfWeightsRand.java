package ch02;

import java.util.Scanner;
import java.util.Random;
public class MaxOfWeightsRand {
    static int maxOf(int[] weights){
        int max = weights[0];
        for (int i = 1; i < weights.length; i++){
            if(weights[i] > max)
                max = weights[i];
        }
        return max;
    }

    public static void main(String[ ] args){
        Random rand = new Random();
        Scanner stdIn = new Scanner(System.in);

        System.out.println("몸무게의 최댓값을 구합니다.");
        System.out.print("사람 수: ");
        int num = stdIn.nextInt();

        int[] weights = new int[num];

        for(int i = 0;i<num;i++){
            weights[i] = 40 + rand.nextInt(60   );
            System.out.println("weights[" + i + "] : " + weights[i]);

        }

        System.out.println("최댓값은 " + maxOf(weights) + "입니다.");
    }
}
