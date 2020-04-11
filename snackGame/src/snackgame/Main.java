/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snackgame;

import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author toqa khaled
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       JFrame jframe =new JFrame();
       Snack snack=new Snack();
       jframe.setBounds(10, 10, 905, 700);
       jframe.setBackground(Color.BLACK);
       jframe.setResizable(false);
       jframe.setVisible(true);
       jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       jframe.add(snack);
    }
    
}
