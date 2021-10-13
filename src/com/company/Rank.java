package com.company;

import javax.swing.*;
import java.awt.*;


import java.io.*;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class Rank extends JFrame {
    public Rank() throws IOException {
        setVisible(true);
        setPreferredSize(new Dimension(300, 300));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        this.setTitle("Ranking");
        add(mainPanel(), BorderLayout.CENTER);
        add(leftPanel(), BorderLayout.CENTER);
        setResizable(false);
        repaint();
        pack();
    }
    JComponent mainPanel() throws IOException {
        JPanel rankPanel = new JPanel();
        rankPanel.setBackground(new java.awt.Color(148, 137, 204));
        BoxLayout boxLayout = new BoxLayout(rankPanel, BoxLayout.Y_AXIS);
        setMaximumSize(new Dimension(400, 400));
        rankPanel.setLayout(boxLayout);
        Set<Result> results = new TreeSet<>(new ResultPorownanie());
        File sciezka = new File("Ranking");
        File[] tabSciezka = sciezka.listFiles();
        if (tabSciezka != null) {
            int res;
            long sec;
            String nazwa, grid;
            for (File result : tabSciezka) {
                FileReader reader = new FileReader(result);
                BufferedReader bufferedreader = new BufferedReader(reader);
                nazwa = bufferedreader.readLine();
                res = Integer.parseInt(bufferedreader.readLine());
                sec = Long.parseLong(bufferedreader.readLine());
                grid = bufferedreader.readLine();


                results.add(new Result(nazwa, res, grid, sec));
            }
        }
            ArrayList<JLabel> labels = new ArrayList<>();

            for(Result r : results){

               labels.add(new JLabel("<html>"+String.valueOf(r)+"<br/></html>"));

            }
            if(results.size()==1) {
                labels.get(0).setOpaque(true);
                labels.get(0).setBackground((new java.awt.Color(179, 204, 30)));

            }
            else if(results.size()==2) {
            labels.get(0).setOpaque(true);
            labels.get(1).setOpaque(true);
            labels.get(0).setBackground((new java.awt.Color(179, 204, 30)));
            labels.get(1).setBackground((new java.awt.Color(174, 174, 174)));
        } else{
                labels.get(0).setOpaque(true);
                labels.get(1).setOpaque(true);
                labels.get(2).setOpaque(true);
                labels.get(0).setBackground((new java.awt.Color(179, 204, 30)));
                labels.get(1).setBackground((new java.awt.Color(174, 174, 174)));
                labels.get(2).setBackground((new java.awt.Color(138, 69, 35)));
            }



            for(JLabel j : labels){

                j.setFont(j.getFont().deriveFont(16f));
                j.setHorizontalAlignment(JLabel.CENTER);
                j.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
                rankPanel.add(j);

            }






        return rankPanel;
    }
    JComponent leftPanel() throws IOException {

        JPanel panel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        setMaximumSize(new Dimension(400, 400));
        panel.setLayout(boxLayout);
        panel.setBackground(new java.awt.Color(50, 204, 64));


        JScrollPane pane = new JScrollPane(mainPanel(), ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        panel.add(pane);


       // panel.add(vscroll);









        return panel;
    }



}


