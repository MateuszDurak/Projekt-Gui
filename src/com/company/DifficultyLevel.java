package com.company;

import javax.swing.*;
import java.awt.*;


public class DifficultyLevel extends JFrame {

    public DifficultyLevel(){
        setVisible(true);
        setPreferredSize(new Dimension(300, 300));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        this.setTitle("Select Difficult Level");
        add(levelPanel(), BorderLayout.CENTER);
        setResizable(false);
        pack();
    }
    JComponent levelPanel(){
        JPanel panel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.PAGE_AXIS);
        setMaximumSize(new Dimension(400, 400));
        panel.setLayout(boxLayout);

        panel.setBackground(new java.awt.Color(148, 137, 204));

        JLabel tekst = new JLabel("Select grid size: ");
        tekst.setFont(tekst.getFont().deriveFont(32f));
        tekst.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(tekst);

        panel.add(Box.createVerticalStrut(20));

        String[] rozmiar ={"4x4 - EASY", "6x6 - MEDIUM", "8x8 - HARD", "10x10 - PPJ"};
        JList lista = new JList<>(rozmiar);
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lista.setSelectionBackground(Color.LIGHT_GRAY);
        lista.setAlignmentX(Component.CENTER_ALIGNMENT);
        lista.setBackground(new java.awt.Color(184, 147, 204));
        lista.addListSelectionListener(e -> {
            System.out.println(lista.getSelectedIndex());
        });
        panel.add(lista);

        panel.add(Box.createVerticalStrut(20));

        JButton btStart = new JButton("Start");
        btStart.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(btStart);
        btStart.setBackground(new java.awt.Color(66, 204, 138));
        btStart.addActionListener(e -> {EventQueue.invokeLater(() -> {

            if(lista.getSelectedIndex() == 0) {
                new Game4x4();
            }
            else if(lista.getSelectedIndex() == 1) {
                new Game6x6();
            }
            else if(lista.getSelectedIndex() == 2) {
                new Game8x8();
            }
            else if(lista.getSelectedIndex() == 3) {
                new Game10x10();
            }

        });

        });



    return panel;
    }

}
