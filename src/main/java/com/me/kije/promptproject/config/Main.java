package com.me.kije.promptproject.config;
import java.util.Scanner;

public class Main {
    // 각 자리수의 합을 계산하는 메서드
    public static int calculateSumOfDigits(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    // 가장 작은 생성자를 찾는 메서드
    public static int findSmallestConstructor(int n) {
        for (int i = 1; i <= n; i++) {
            if (i + calculateSumOfDigits(i) == n) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // 입력 받기
        scanner.close();

        // 결과 출력
        System.out.println(findSmallestConstructor(N));
    }
}
