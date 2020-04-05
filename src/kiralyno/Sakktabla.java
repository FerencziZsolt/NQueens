/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiralyno;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

/**
 *
 * @author Zsolt
 */
public class Sakktabla extends JFrame {
    
    private final int N=8;

    private final JLabel slots[][] = new JLabel[N][N];
    private static int[][] sakktabla;
    
    public Sakktabla() {
        Backtrack b = new Backtrack();

        setLayout(new GridLayout(N, N));
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                slots[i][j] = new JLabel();
                slots[i][j].setBorder(new LineBorder(Color.black));
                add(slots[i][j]);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j % 2 == 0 && i % 2 == 0) {
                    slots[i][j].setOpaque(true);
                    slots[i][j].setBackground(Color.BLACK);
                }
            }

        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j % 2 == 1 && i % 2 == 1) {
                    slots[i][j].setOpaque(true);
                    slots[i][j].setBackground(Color.BLACK);
                }
            }

        }
        sakktabla = b.getTabla();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (sakktabla[i][j] == 1) {
                    slots[i][j].setOpaque(true);
                    slots[i][j].setBackground(Color.RED);                    
                }
            }
        }

        setSize(700, 700);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
