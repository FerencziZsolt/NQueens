/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiralyno;

import java.util.Random;

/**
 *
 * @author Zsolt
 */
public class Backtrack {

    private static final int N = 8;

    private static final int sor = N;
    private static final int oszlop = N;
    private static int tabla[][] = new int[sor][oszlop];

    public Backtrack() {
        alap();
        megold(0);
        //rajzol();
    }

    public void alap() {
        for (int i = 0; i < sor; i++) {
            for (int j = 0; j < oszlop; j++) {
                this.tabla[i][j] = 0;
            }
        }
    }

    public void rajzol() {
        for (int i = 0; i < sor; i++) {
            for (int j = 0; j < oszlop; j++) {
                System.out.print(tabla[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public void lerak(int x, int y) {
        tabla[x][y] = 1;
    }

    public void visszaallit(int x, int y) {
        tabla[x][y] = 0;
    }

    public boolean johely(int x, int y) {
        int i, j;

        for (i = 0; i < y; i++) {
            if (tabla[x][i] == 1) {
                return false;
            }
        }

        for (i = x, j = y; i >= 0 && j >= 0; i--, j--) {
            if (tabla[i][j] == 1) {
                return false;
            }
        }

        for (i = x, j = y; j >= 0 && i < N; i++, j--) {
            if (tabla[i][j] == 1) {
                return false;
            }

        }
        return true;
    }

    public boolean megold(int megoldasokszama) {        
        

        if (megoldasokszama >= N) {
            return true;
        }

        for (int i = 0; i < N; i++) {
            if (johely(i, megoldasokszama)) {
                lerak(i, megoldasokszama);
                if (megold(megoldasokszama + 1) == true) {

                    return true;

                }
                visszaallit(i, megoldasokszama);
            }
        }

        return false;

    }

    public int[][] getTabla() {
        return tabla;
    }

}
