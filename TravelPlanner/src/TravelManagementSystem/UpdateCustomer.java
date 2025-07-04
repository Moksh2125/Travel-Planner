package TravelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateCustomer extends JFrame implements ActionListener{

    JLabel labelusername,labelname;
    JComboBox<Object> comboID;
    JTextField tfnumber,tfcountry,tfaddress,tfemail,tfphone,tfgender;
    JRadioButton male,female;
    JButton update,back;
    String UserName;

    UpdateCustomer(String UserName)
    {
        this.UserName=UserName;
        setBounds(500,200,850,550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text = new JLabel(" UPDATE CUSTOMER DETAILS ");
        text.setBounds(275,0,300,25);
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(text);

        JLabel iblusername = new JLabel("Username");
        iblusername.setBounds(30,50,150,25);
        add(iblusername);

        labelusername = new JLabel();
        labelusername.setBounds(220,50,150,25);
        add(labelusername);

        JLabel iblid = new JLabel("ID");
        iblid.setBounds(30,90,150,25);
        add(iblid);

       comboID = new JComboBox<>(new String[] {"Passport","Aadhar card","Pan card","Ration card"});
       comboID.setBounds(220, 90, 150, 25);
       comboID.setBackground(Color.WHITE);
       add(comboID);

        JLabel iblnumber = new JLabel("Number");
        iblnumber.setBounds(30, 130, 150, 25);
        add(iblnumber);

        tfnumber = new JTextField();
        tfnumber.setBounds(220, 130, 150, 25);
        add(tfnumber);

        JLabel iblname = new JLabel("Name");
        iblname.setBounds(30,170,150,25);
        add(iblname);

        labelname = new JLabel();
        labelname.setBounds(220,170,150,25);
        add(labelname);

        JLabel iblgender = new JLabel("Gender");
        iblgender.setBounds(30,210,150,25);
        add(iblgender);

        tfgender = new JTextField();
        tfgender.setBounds(220, 210, 150, 25);
        add(tfgender);

        JLabel iblcountry = new JLabel("Country");
        iblcountry.setBounds(30,250,150,25);
        add(iblcountry);

        tfcountry = new JTextField();
        tfcountry.setBounds(220,250,150,25);
        add(tfcountry);

        JLabel ibladdress = new JLabel("Address");
        ibladdress.setBounds(30,290,150,25);
        add(ibladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(220,290,150,25);
        add(tfaddress);

        JLabel iblphone = new JLabel("Phone");
        iblphone.setBounds(30,330,150,25);
        add(iblphone);

        tfphone = new JTextField();
        tfphone.setBounds(220,330,150,25);
        add(tfphone);

        JLabel iblemail = new JLabel("Email");
        iblemail.setBounds(30,370,150,25);
        add(iblemail);

        tfemail = new JTextField();
        tfemail.setBounds(220,370,150,25);
        add(tfemail);

        update = new JButton("UPDATE");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setBounds(70,430,100,25);
        update.addActionListener(this);
        add(update);

        back = new JButton("BACK");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(220,430,100,25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon("icons/update.png");
        Image i2 = i1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 100, 400, 500);
        add(image);

        /*CONNECTION*/
        try {
            labelusername.setText(UserName);
            Conn c = new Conn();
           ResultSet rs = c.s.executeQuery("Select * From customer where username ='"+UserName+"';");
            while (rs.next()) {
                labelusername.setText(rs.getString("UserName"));
                labelname.setText(rs.getString("Name"));
               // tfid.setText(rs.getString("id"));
                tfnumber.setText(rs.getString("Number"));
                tfgender.setText(rs.getString("gender"));
                tfcountry.setText(rs.getString("country"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Storing additional information in table
        setVisible(true);
    }
    public static void main(String[] args) {
        new UpdateCustomer("riya");
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==update) {
            String username = labelusername.getText();
            String id = (String)comboID.getSelectedItem();
            String number = tfnumber.getText();
            String name = labelname.getText();
            String gender = tfgender.getText();
            String country = tfcountry.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText(); 
            try {
                Conn c = new Conn();
                String sql = "Update customer set username = '"+username+"',id ='"+id+"',number = '"+number+"',name = '"+name+"',gender = '"+gender+"',country = '"+country+"',address = '"+address+"',phone = '"+phone+"',email = '"+email+"' where username = '"+UserName+"';";
                c.s.executeUpdate(sql);

                JOptionPane.showMessageDialog(null, "Customer Details Updated Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }
}
