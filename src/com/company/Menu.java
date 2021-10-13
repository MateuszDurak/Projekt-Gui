package com.company;


import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class Menu extends JFrame {


    public Menu(){
        setVisible(true);
        setPreferredSize(new Dimension(300, 300));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        add(menuPanel(), BorderLayout.CENTER);
        this.setTitle("Memory The Game");
        pack();
        setResizable(false);

    }

    JComponent menuPanel(){

        JPanel panel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.PAGE_AXIS);
        setMaximumSize(new Dimension(400, 400));
        panel.setLayout(boxLayout);

        panel.setBackground(new java.awt.Color(148, 137, 204));



        JLabel banner = new JLabel("<html><center>Memory The game<br>s21415</center></html>", SwingConstants.CENTER);
        banner.setFont(banner.getFont().deriveFont(32f));
        banner.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(banner);


        panel.add(Box.createVerticalStrut(20));

        JButton btStart = new JButton("Start new game");
        btStart.setAlignmentX(Component.CENTER_ALIGNMENT);
        btStart.addActionListener(e -> {EventQueue.invokeLater(() -> {
           new DifficultyLevel();

        });

        });
        btStart.setBackground(new java.awt.Color(66, 204, 138));
        panel.add(btStart);

        panel.add(Box.createVerticalStrut(20));

        JButton btRanking = new JButton("Ranking");
        btRanking.setAlignmentX(Component.CENTER_ALIGNMENT);
        btRanking.setBackground(new java.awt.Color(66, 204, 138));
        btRanking.addActionListener(e -> {EventQueue.invokeLater(() -> {
            try {
                new Rank();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        });

        });
       
        panel.add(btRanking);

        panel.add(Box.createVerticalStrut(20));

        JButton btExit = new JButton("Exit");
        btExit.addActionListener(e -> System.exit(0));
        btExit.setAlignmentX(Component.CENTER_ALIGNMENT);
        btExit.setBackground(new java.awt.Color(66, 204, 138));
        panel.add(btExit);

        panel.add(Box.createVerticalStrut(20));


        return panel;

    }


}
