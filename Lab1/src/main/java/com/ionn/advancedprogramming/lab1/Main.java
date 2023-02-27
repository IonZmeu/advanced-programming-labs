package com.ionn.advancedprogramming.lab1;
/*
* Lab 1 . Zmeu Ion 2E4
* */
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.compulsory();
        main.homeWork();
        //main.bonus();

    }

    private void compulsory(){
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

    private void homeWork() {
        long startTime = System.nanoTime();
        System.out.println("Write the number for latin square");
        Scanner in = new Scanner(System.in);
        boolean bigNumber = false;
        int n = in.nextInt();
        if (n > 30000){
            bigNumber = true;
        }
        int k = n + 1;
        for (int i = 1; i <= n; i++)
        {
            int temp = k;

            while (temp <= n)
            {
                if(!bigNumber){
                    System.out.print(temp + " ");
                }
                temp++;
            }

            for (int j = 1; j < k; j++)
                if(!bigNumber){
                    System.out.print(j + " ");
                }

            k--;
            if(!bigNumber){
                System.out.println();
            }
        }
        long endTime = System.nanoTime();
        if(bigNumber){
        System.out.println((endTime-startTime)/1000000 + " milliseconds");
        }
    }

    //tried but failed
    private void bonus(){

    }

    //function used for compulsory
    public int digitSum(int number){
        int answer = 0;
        while (number != 0) {
            int digit = number % 10;
            answer += digit;
            number /= 10;
        }
        return answer;
    }
}