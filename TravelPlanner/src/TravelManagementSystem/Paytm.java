package TravelManagementSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Paytm extends JFrame{
     public Paytm(){
        
        setBounds(600,220,800,600);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // JEditorPane j = new JEditorPane();
        // j.setEditable(false);   

        // try {
        //     j.setPage("https://paytm.com/electricity-bill-payment");
        // }catch (Exception e) {
        //     j.setContentType("text/html");
        //     j.setText("<html>Could not load</html>");
        // } 

        // JScrollPane scrollPane = new JScrollPane(j);     
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // getContentPane().add(scrollPane);
        // setPreferredSize(new Dimension(800,600));
        
        JButton back=new JButton("Back");
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        back.setBounds(610, 20, 80, 40);
        add(back);
        
        ImageIcon i1 = new ImageIcon("icons/PAYTM.png");
        Image i2 = i1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l4 = new JLabel(i3);
        l4.setBounds(10, 10, 500, 600);
        add(l4);

        
        setVisible(true);
    }
    public static void main(String[] args){
        new Paytm();
    }
}