package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanf = new Scanner(System.in);
        int row,col;

        System.out.println("Mayın tarlasına hoşgeldiniz.\n0 : Mayın Yok     1 : 1 mayın var     -1 : Mayına Bastın     " +
                " -2 : Mayın olmayan yer işaretlenir\nOynamak istediğiniz boyutları giriniz : ");

        row = scanf.nextInt();
        col = scanf.nextInt();
        MayinTarlasi mayin = new MayinTarlasi(row,col);
        mayin.run();



    }
}
