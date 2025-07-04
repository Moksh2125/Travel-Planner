package TravelManagementSystem;

import java.awt.Color;
import java.awt.Image;

import javax.swing.*;
public class exp extends JFrame {

    public exp()
    {
        setBounds(100, 100, 800, 800);
        
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.BLACK);
        p1.setBounds(100, 100, 100, 100);
        add(p1);

        setVisible(true);
    }

    public static void main(String[] args) {
        new exp();
    }
}
