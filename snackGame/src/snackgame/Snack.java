/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snackgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author toqa khaled
 */
public class Snack extends JPanel implements KeyListener, ActionListener {

    private ImageIcon title;
    private ImageIcon Up;
    private ImageIcon Down;
    private ImageIcon Right;
    private ImageIcon Left;
    private ImageIcon snack;
    private ImageIcon eat;

    boolean left = false;
    boolean right = false;
    boolean up = false;
    boolean down = false;

    private Timer time;
    private Random random = new Random();

    private int snakeLenght = 3;
    private int move = 0;
    private int score = 0;
    private int[] width = new int[750];
    private int[] hight = new int[750];
    private int[] eatWidthPosition = {25, 50, 75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350, 375, 400, 425, 450, 475, 500,
        525, 550, 575, 600, 625, 650, 675, 700, 725, 750, 775, 800, 825, 850};
    private int[] eatHightPosition = {75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350, 375, 400, 425, 450, 475, 500,
        525, 550, 575, 600, 625};
    private int widthPosition = random.nextInt(34);
    private int hightPosition = random.nextInt(23);

    Snack() {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        time = new Timer(100, this);
        time.start();

    }

    public void paint(Graphics g) {
        if (move == 0) { // defualt position of the snack
            width[2] = 50;
            width[1] = 75;
            width[0] = 100;

            hight[2] = 100;
            hight[1] = 100;
            hight[0] = 100;

        }
        g.setColor(Color.BLUE);
        g.drawRect(24, 10, 851, 55);

        title = new ImageIcon("D:\\Projects\\snakeGame\\photo\\title.png");
        title.paintIcon(this, g, 25, 11);

        g.setColor(Color.BLUE);
        g.drawRect(24, 74, 851, 577);

        g.setColor(Color.BLACK);
        g.fillRect(25, 75, 850, 575);

        g.setColor(Color.WHITE);
        g.setFont(new Font("arial", Font.PLAIN, 14));
        g.drawString("Score: " + score, 780, 50);

        Right = new ImageIcon("D:\\Projects\\snakeGame\\photo\\right.png");
        Right.paintIcon(this, g, width[0], hight[0]);

        for (int i = 0; i < snakeLenght; i++) {
            if (i == 0 && up) {
                Up = new ImageIcon("D:\\Projects\\snakeGame\\photo\\up.png");
                Up.paintIcon(this, g, width[i], hight[i]);
            }
            if (i == 0 && down) {
                Down = new ImageIcon("D:\\Projects\\snakeGame\\photo\\down.png");
                Down.paintIcon(this, g, width[i], hight[i]);
            }
            if (i == 0 && right) {
                Right = new ImageIcon("D:\\Projects\\snakeGame\\photo\\right.png");
                Right.paintIcon(this, g, width[i], hight[i]);
            }
            if (i == 0 && left) {
                Left = new ImageIcon("D:\\Projects\\snakeGame\\photo\\left.png");
                Left.paintIcon(this, g, width[i], hight[i]);
            }
            if (i != 0) {
                snack = new ImageIcon("D:\\Projects\\snakeGame\\photo\\body.png");
                snack.paintIcon(this, g, width[i], hight[i]);
            }
        }
        eat = new ImageIcon("D:\\Projects\\snakeGame\\photo\\eat.png");
        if ((eatWidthPosition[widthPosition] == width[0]) && (eatHightPosition[hightPosition] == hight[0])) {
            score++;
            snakeLenght++;
            widthPosition = random.nextInt(34);
            hightPosition = random.nextInt(23);
        }
        eat.paintIcon(this, g, eatWidthPosition[widthPosition], eatHightPosition[hightPosition]);
        for (int i=1;i<snakeLenght;i++){ // if it touch his body.
            if(width[i]==width[0] && hight[i]==hight[0]){
                up=false;
                down=false;
                right=false;
                left=false;
                
                g.setColor(Color.WHITE);
                g.setFont(new Font("arial", Font.BOLD, 50));
                g.drawString("GAME OVER" , 300, 300);
                
                g.setFont(new Font("arial", Font.PLAIN, 20));
                g.drawString("Press Space To RESTART" , 350, 340);
                
                
            }
            
        }
        g.dispose();
    }
    // 4 methods come from keyListener.

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            move = 0;
            score = 0;
            snakeLenght = 3;
            repaint();

        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            move++;
            up = true;
            if (!down) {
                up = true;
            } else {
                up = false;
                down = true;
            }
            left = false;
            right = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            move++;
            down = true;
            if (!up) {
                down = true;
            } else {
                down = false;
                up = true;
            }
            left = false;
            right = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            move++;
            right = true;
            if (!left) {
                right = true;
            } else {
                right = false;
                left = true;
            }
            up = false;
            down = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            move++;
            left = true;
            if (!right) {
                left = true;
            } else {
                left = false;
                right = true;
            }
            up = false;
            down = false;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        time.start();
        if (up) {
            for (int i = snakeLenght; i >= 0; i--) {
                width[i + 1] = width[i];
            }
            for (int j = snakeLenght; j >= 0; j--) {
                if (j == 0) {
                    hight[j] = hight[j] - 25;
                } else {
                    hight[j] = hight[j - 1];
                }

                if (hight[j] < 75) {
                    hight[j] = 628;
                }
            }
            repaint();
        }
        if (down) {
            for (int i = snakeLenght; i >= 0; i--) {
                width[i + 1] = width[i];
            }
            for (int j = snakeLenght; j >= 0; j--) {
                if (j == 0) {
                    hight[j] = hight[j] + 25;
                } else {
                    hight[j] = hight[j - 1];
                }

                if (hight[j] > 625) {
                    hight[j] = 75;
                }
            }
            repaint();

        }
        if (right) {
            for (int i = snakeLenght; i >= 0; i--) {
                hight[i + 1] = hight[i];
            }
            for (int j = snakeLenght; j >= 0; j--) {
                if (j == 0) {
                    width[j] = width[j] + 25;
                } else {
                    width[j] = width[j - 1];
                }

                if (width[j] > 850) {
                    width[j] = 25;
                }
            }
            repaint();
        }
        if (left) {
            for (int i = snakeLenght; i >= 0; i--) {
                hight[i + 1] = hight[i];
            }
            for (int j = snakeLenght; j >= 0; j--) {
                if (j == 0) {
                    width[j] = width[j] - 25;
                } else {
                    width[j] = width[j - 1];
                }

                if (width[j] < 25) {
                    width[j] = 850;
                }
            }
            repaint();
        }
    }

}
