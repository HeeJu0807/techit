package com.example.day12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class IOExam2 {
    public static void main(String[] args) throws Exception {
        // 키보드로부터 한줄씩 입력받아 콘솔에 출력

        // 키보드 System.in
        // 한줄씩 읽기 위해 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br2 = new BufferedReader(new FileReader("a.txt"));

        String str = br.readLine();
        System.out.println(str);
        System.out.println(br2.readLine());
    }
}
