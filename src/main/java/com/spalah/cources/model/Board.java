package com.spalah.cources.model;


import java.util.Arrays;
import java.util.Random;

public class Board {
    private int coll;
    private int row;
    private int items;
    private int[][] drum;

    public Board() {
        this.coll = 5; // Количество барабанов по ТЗ
        this.row = 3; // Количество строчек в каждом барабане по ТЗ
        this.items = 5; // Иконок по ТЗ

    }

    public Board(int coll, int row, int items) {
        this.coll = coll;
        this.row = row;
        this.items = items;

    }

    public int[][] makeDrums()
    {
        int [][] drums = new int[coll][row];
        //Заполнить двумерный массив
        return drums;
    }

    public void spin(){
       drum = new int[coll][row];
        Random rnd = new Random();
        for (int i=0;i < drum.length;i++) {
            for (int j=0;j < drum[i].length;j++) {
                drum[i][j]=rnd.nextInt(5) + 1;
            }
        }
        toString();


    }

    public void setDrum(int[][] drum) {
        this.drum = drum;
    }

    public int[][] getDrum() {
        return drum;
    }

    @Override
    public String toString() {

        //goodlook sout
//        for (int i=0;i < drum.length;i++) {
//            for (int j=0;j < drum[i].length;j++){
//                System.out.print(drum[i][j]+" ");
//            }
//        }
        return "<Поле{ " + Arrays.toString(drum) +'}';
    }


}
