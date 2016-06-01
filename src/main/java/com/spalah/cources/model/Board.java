package com.spalah.cources.model;


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



    public void setDrum(int[][] drum) {
        this.drum = drum;
    }
}
