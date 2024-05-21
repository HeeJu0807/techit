package ch02;

import java.util.Scanner;
public class MaxOfScores {
    static int maxOf(int[] scores) {

        int max = scores[0];
        for (int score : scores) {
            if (max < score) {
                max = score;
            }
        }
        return max;
    }

    // 학생 수를 입력받고, 학생 수만큼 점수를 입력받아 정수배열을 리턴하는 메소드
    static int[] inputScores(){
        Scanner sc = new Scanner(System.in);

        System.out.print("학생 수: ");
        int cnt = sc.nextInt();
        int[] scores = new int[cnt];

        for(int i = 0; i<cnt;i++){
            System.out.print("scores["+i+"] : ");
            scores[i] = sc.nextInt();
        }

        return scores;
    }

    public static void main(String [] args){
        int[] scores = inputScores();

        System.out.println("최댓값은 " + maxOf(scores) + "입니다.");

    }
}
