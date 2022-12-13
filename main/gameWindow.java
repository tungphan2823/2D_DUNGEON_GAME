package main;

import javax.swing.JFrame;

public class gameWindow {
    private JFrame jframe;
    public gameWindow(gamePanel gamePanel) {
        jframe = new JFrame();
        jframe.setVisible(true);
        jframe.add(gamePanel);
        jframe.setResizable(false);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setLocationRelativeTo(null);
        jframe.pack();

    }
} 
