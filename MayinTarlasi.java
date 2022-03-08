package com.company;

import java.util.Random;
import java.util.Scanner;

public class MayinTarlasi {
    Random rand = new Random();
    Scanner scanf = new Scanner(System.in);

    int rowN , colN , size ;
    int map[][] ;
    int board[][];
    boolean game = true;

    MayinTarlasi (int rowNumber , int colNumber){
        this.rowN = rowNumber;
        this.colN = colNumber;
        this.map = new int[rowNumber][colNumber];
        this.board = new int[rowNumber][colNumber];
        this.size = rowNumber * colNumber;
    }

    public void run(){
        int satir , sutun ,success = 0;
        
        prepareGame();
        print(map);
        System.out.println("Oyun Başlıyor !!");
        while(game){
            print(board);
            System.out.print("\nSatır : ");
            satir = scanf.nextInt();
            System.out.print("Sütun : ");
            sutun = scanf.nextInt();
            if (satir <0 || satir > rowN-1){
                System.out.println("Geçersiz sayı girdiniz.");
                continue;
            }
            if (sutun <0 || sutun > colN-1){
                System.out.println("Geçersiz sayı girdiniz.");
                continue;
            }
            if (map [satir][sutun] != -1){
                System.out.println("Mayın yok :)\n");
                checkMine(satir, sutun);
                success++;
                if(success == (size - (size/4))){
                    System.out.println("Oyunu kazandınız.");
                    break;
                }
            }
            else{
                System.out.println("GAME OVER :(");
                game = false;
            }
        }

    }

    public void prepareGame(){
        int randRow, randCol, count=0;
        while(count != size/4){
            randRow = rand.nextInt(rowN);
            randCol = rand.nextInt(colN);

            if(map[randRow][randCol] != -1){
                map[randRow][randCol] = -1;
                count++;
            } } }

    public void print(int arr[][]){
        for (int i = 0 ; i < arr.length ; i++){
            for (int j=0 ; j < arr[0].length ; j++){
                if (arr[i][j] >= 0){
                    System.out.print(" ");
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void checkMine(int sat,int sut){
        if(map[sat][sut] == 0){
            if ((sut < colN -1) && map[sat][sut+1] == -1){
                board[sat][sut +1] =1;}
            if ((sat < rowN -1) && map[sat+1][sut] == -1){
                board[sat+1][sut] =1;}
            if ((sat > 0)&& map[sat-1][sut] == -1){
                board[sat-1][sut]=1 ;}
            if ((sut > 0) && map[sat][sut-1] == -1){
                board[sat][sut-1]=1;}
            if ((sut < colN -1) && (sat > 0) && map[sat-1][sut+1] == -1){
                board[sat-1][sut+1]=1;}
            if((sut < colN -1) && (sat < rowN -1) && map[sat+1][sut+1] == -1){
                board[sat+1][sut+1]=1;}
            if ((sat > 0) && (sut > 0 ) && map[sat -1 ][sut -1 ] == -1){
                board[sat -1 ][sut -1 ]=1;}
            if ((sat < rowN -1) && (sut > 0 ) && map[sat +1 ][sut -1 ] == -1){
                board[sat +1 ][sut -1 ]=1;}
            if (board[sat][sut] == 0){
                board[sat][sut] = -2;}
            /*for(int i = 0 ; i <= rowN ; i++){
                for (int j = 0 ; j <= colN ; j++){
                    if(board[i][j] == 0){

                    }
                    else{
                        System.out.println("Oyunu kazandınız :)");
                        break;
                    }
                }
            }*/
        }
    }
}
