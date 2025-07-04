package TravelManagementSystem;

import javax.swing.*;
import java.awt.*;

public class Loading extends JFrame implements Runnable{

    JProgressBar bar;
    Thread t;
    JLabel username;
    String UserName;

    Loading(String UserName)
    {
        t = new Thread(this);
        this.UserName = UserName; 
        setBounds(500,200,650,400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("Travel and Tourism Planner");
        text.setBounds(50,20,600,40);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Raleway",Font.BOLD,35));
        add(text);

        bar = new JProgressBar();
        bar.setBounds(150, 100, 300, 35);
        bar.setStringPainted(true);
        add(bar);

        JLabel loading = new JLabel("Loding please wait...");
        loading.setBounds(230,130,170,30);
        loading.setForeground(Color.RED);
        loading.setFont(new Font("Raleway",Font.BOLD,16));
        add(loading);

        username = new JLabel("Welcome "+UserName);
        username.setBounds(20, 310, 400, 40);
        username.setForeground(Color.RED);
        username.setFont(new Font("Raleway",Font.BOLD,16));
        add(username);
        t.start();
        setVisible(true);
    }
    public static void main(String[] args) {
        new Loading("");
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <=101; i++) {
                int max = bar.getMaximum();
                int value = bar.getValue();
                if (value<max) {
                    bar.setValue(bar.getValue()+1);
                }
                else{
                    setVisible(false);
                    new Dashboard(UserName);
                }
                Thread.sleep(50);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
