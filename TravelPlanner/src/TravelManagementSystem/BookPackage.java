package TravelManagementSystem;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BookPackage extends JFrame implements ActionListener{

    Choice cpackage;
    JTextField tfpersons;
    String username;
    JLabel labelusername,labelid,labelnumber,labelphone,labelprice;
    JButton checkprice,bookpackage,back;
    public BookPackage(String UserName)
    {
        this.username=UserName;

        setBounds(350, 200, 1100, 500);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text = new JLabel("BOOK PACKAGE");
        text.setBounds(100, 10, 200, 30);
        text.setFont(new Font("Tahoma",Font.BOLD,20));

        JLabel lblusername = new JLabel("UserName");
        lblusername.setBounds(40,70,100,20);
        lblusername.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblusername);

        labelusername = new JLabel();
        labelusername.setBounds(250,70,200,20);
        add(labelusername);

        JLabel lblpackage = new JLabel("Select package");
        lblpackage.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblpackage.setBounds(40,110,150,20);
        add(lblpackage);

        cpackage = new Choice();
        cpackage.add("Goa, India");
        cpackage.add("Ladakh, India");
        cpackage.add("Kerala, India");
        cpackage.setBounds(250, 110, 200, 20);
        add(cpackage);

        JLabel lbltotalperson = new JLabel("Total Persons");
        lbltotalperson.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbltotalperson.setBounds(40,150,150,25);
        add(lbltotalperson);

        tfpersons = new JTextField("1");
        tfpersons.setBounds(250, 150, 200, 25);
        add(tfpersons);

        JLabel lblid = new JLabel("ID");
        lblid.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblid.setBounds(40,190,150,25);
        add(lblid);

        labelid = new JLabel();
        labelid.setBounds(250,190,200,25);
        add(labelid);

        JLabel lblnumber = new JLabel("Number");
        lblnumber.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblnumber.setBounds(40,230,150,25);
        add(lblnumber);

        labelnumber = new JLabel();
        labelnumber.setBounds(250,230,150,25);
        add(labelnumber);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblphone.setBounds(40,270,200,25);
        add(lblphone);

        labelphone = new JLabel();
        labelphone.setBounds(250,270,200,25);
        add(labelphone);

        JLabel lbltotalprice = new JLabel("Total Price");
        lbltotalprice.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbltotalprice.setBounds(40,310,150,25);
        add(lbltotalprice);

        labelprice = new JLabel();
        labelprice.setBounds(250,310,150,25);
        add(labelprice);

        try {
            Conn conn = new Conn();
            String sql = "Select * From customer Where Username= '"+username+"';"; 
           ResultSet rs = conn.s.executeQuery(sql);
           while (rs.next()) {
                labelusername.setText(rs.getString("Username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phone"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        checkprice = new JButton("Check Price");
        checkprice.setBackground(Color.black);
        checkprice.setForeground(Color.WHITE);
        checkprice.setBounds(60,380,120,25);
        checkprice.addActionListener(this);
        add(checkprice);

        bookpackage = new JButton("Book Package");
        bookpackage.setBackground(Color.black);
        bookpackage.setForeground(Color.WHITE);
        bookpackage.setBounds(200,380,120,25);
        bookpackage.addActionListener(this);
        add(bookpackage);

        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.setBounds(340,380,120,25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon("icons/bookpackage.jpg");
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(550, 50,500,300);
        add(image);

        setVisible(true);
    }
    public static void main(String[] args) {
        new BookPackage("");
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==checkprice) {
            String selected_package = cpackage.getSelectedItem();
            int cost=0;
            if (selected_package.equals("Goa, India")) {
                cost+=12000;
            } else if(selected_package.equals("Ladakh, India")){
                cost+=22500;
            }
            else if (selected_package.equals("Kerala, India")) {
                cost+=51000;
            }

            int Persons = Integer.parseInt(tfpersons.getText());
            cost *=Persons;
            labelprice.setText("Rs "+cost);

        } else if(ae.getSource()==bookpackage) {
            try {
                Conn c = new Conn();
                c.s.executeUpdate("Insert into bookpackage values('"+labelusername.getText()+"','"+cpackage.getSelectedItem()+"','"+tfpersons.getText()+"','"+labelid.getText()+"','"+labelnumber.getText()+"','"+labelphone.getText()+"','"+labelprice.getText()+"');");

                JOptionPane.showMessageDialog(null,"Package Booked Successfully");
                setVisible(false);

            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        } else if (ae.getSource()==back) {
            setVisible(false);
        }
    }
}
