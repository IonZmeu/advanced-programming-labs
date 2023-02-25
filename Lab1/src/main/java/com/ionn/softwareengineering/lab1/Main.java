package com.ionn.softwareengineering.lab1;

public class Main {

    public static void main(String[] args) {
        compulsory();
        //int n = Integer.parseInt(args[0]);
        //homeWork(n);
        //bonus();

    }

    private static void compulsory(){
        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        int n = (int) (Math.random() * 1000000);
        int binaryAsDecimal = Integer.parseInt("10101", 2);
        int hexadecimalAsDecimal = Integer.parseInt("FF", 16);
        n = n * 3;
        n = n + binaryAsDecimal;
        n = n + hexadecimalAsDecimal;
        n = n * 6;
        while(n > 9){
            n=digitSum(n);
        }
        System.out.println("Willy-nilly, this semester I will learn " + languages[n]);
    }

    private static void homeWork(int n){
        int[][] latinSquare = new int[n][n];
        int k = n + 1;
        for (int i = 1; i <= n; i++)
        {
            // This loops runs only after
            // first iteration of outer
            // loop. It prints
            // numbers from n to k
            int temp = k;

            while (temp <= n)
            {
                System.out.print(temp + "b");
                temp++;
            }
            // This loop prints numbers from
            // 1 to k-1.
            for (int j = 1; j < k; j++)
                System.out.print(j + " ");

            k--;
            System.out.println();
        }
    }
    private static void bonus(){

    }
    public static int digitSum(int number){
        int answer = 0;
        while (number != 0) {
            int digit = number % 10;
            answer += digit;
            number /= 10;
        }
        return answer;
    }
}