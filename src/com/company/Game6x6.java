package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;


public class Game6x6 extends JFrame {

    private int counter = 0;
    private long sec =0;
    private int matched = 0;

    public Game6x6(){
        setVisible(true);
        setPreferredSize(new Dimension(300, 300));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        this.setTitle("Memory The Game");
        add(gamePanel(), BorderLayout.CENTER);
        add(timerPanel(), BorderLayout.PAGE_END);
        pack();
    }



    JComponent gamePanel(){
        JPanel gPanel = new JPanel();
        setMaximumSize(new Dimension(400, 400));
        gPanel.setBackground(new Color(148, 137, 204));

        ArrayList<JButton> btn = new ArrayList<>();
        gPanel.setLayout(new GridLayout(6, 6));
        File sciezka = new File("icons6x6");
        File[] tabSciezka = sciezka.listFiles();
        int tab[] = new int[36];
        for(int i = 0; i < 36; i++){
            tab[i] = i;
            tab[i+1] = i;
            i ++;
        }



        for(int i = 0; i < 36; i++) {
            btn.add(new JButton());
        }
        for (JButton q : btn) {
            gPanel.add(q);
        }
        Collections.shuffle(btn);
        ArrayList<JButton> dopasowania = new ArrayList();


        for (int i = 0; i < 36; i++) {
            int finalI = i;
            btn.get(i).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    EventQueue.invokeLater(()-> {
                        btn.get(finalI).setIcon(new ImageIcon(new ImageIcon((String.valueOf(tabSciezka[finalI]))).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
                        btn.get(finalI).setText(String.valueOf(tab[finalI]));
                        counter++;
                        dopasowania.add(btn.get(finalI));
                        btn.get(finalI).setEnabled(false);
                        btn.get(finalI).setDisabledIcon((new ImageIcon(new ImageIcon((String.valueOf(tabSciezka[finalI]))).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH))));
                    });
                    if(dopasowania.size() == 2) {

                        if(!(dopasowania.get(0).getText().equals(dopasowania.get(1).getText()))) {


                            for (JButton q : dopasowania) {
                                q.setIcon(new ImageIcon());
                                q.setText("");
                                q.setEnabled(true);
                            }
                        }
                        else {
                            dopasowania.get(0).setEnabled(false);
                            dopasowania.get(1).setEnabled(false);
                            matched++;


                        }
                        btn.get(finalI).setEnabled(true);
                        dopasowania.clear();

                    }
                    int i =0;
                    for(JButton a : btn){
                        if(a.isEnabled()){
                            i++;
                        }
                    }
                    if(i == 1){

                        String nazwa = JOptionPane.showInputDialog(null, "Podaj pseudonim: ", "Zapisz swój wynik!!!",  JOptionPane.INFORMATION_MESSAGE);
                        if(nazwa != null){
                            try {
                                PrintWriter writer = new PrintWriter("Ranking\\"+nazwa+".txt");
                                writer.println(nazwa);
                                writer.println(counter*36/sec);
                                writer.println(sec);
                                writer.println("Grid: 6x6");
                                writer.close();
                            } catch (FileNotFoundException ex) {
                                ex.printStackTrace();
                            }
                            setVisible(false);
                            dispose();
                        }
                    }




                }


            });


        }






        return gPanel;
    }

    JComponent timerPanel(){
        JPanel tPanel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(tPanel, BoxLayout.PAGE_AXIS);
        setMaximumSize(new Dimension(400, 400));
        tPanel.setLayout(boxLayout);
        tPanel.setBackground(new java.awt.Color(50, 204, 64));


        new Thread(() -> {
            long start = System.currentTimeMillis();
            JLabel time = new JLabel();
            tPanel.add(time);
            while (true) {
                long end = System.currentTimeMillis() - start;
                long toSec = end / 1000;
                EventQueue.invokeLater(() -> {
                    time.setText("Timer: "+String.valueOf(toSec));
                    sec = toSec;


                });
                try {

                    Thread.sleep(100);

                } catch (Exception e) {
                }
            }
        }).start();


        return tPanel;
    }
}
