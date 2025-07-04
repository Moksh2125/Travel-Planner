package TravelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class AddCustomer extends JFrame implements ActionListener{

    JLabel labelusername,labelname;
    JComboBox<Object> comboID;
    JTextField tfnumber,tfcountry,tfaddress,tfemail,tfphone;
    JRadioButton male,female;
    JButton add,back;
    String UserName;

    AddCustomer(String UserName)
    {
        this.UserName=UserName;
        setBounds(450,200,850,550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel iblusername = new JLabel("Username");
        iblusername.setBounds(30,50,150,25);
        add(iblusername);

        labelusername = new JLabel();
        labelusername.setBounds(220,50,150,25);
        add(labelusername);

        JLabel iblid = new JLabel("ID");
        iblid.setBounds(30,90,150,25);
        add(iblid);

        comboID = new JComboBox<>(new String[] {"Passport","Aadhar Card","Pan Card","Ration Card"});
        comboID.setBackground(Color.WHITE);
        comboID.setBounds(220,90,150,25);
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

        male = new JRadioButton("Male");
        male.setBounds(220,210,70,25);
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(300,210,70,25);
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup bg = new ButtonGroup();
        bg.add(female);
        bg.add(male);

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

        add = new JButton("ADD");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(70,430,100,25);
        add.addActionListener(this);
        add(add);

        back = new JButton("BACK");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(220,430,100,25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon("icons/newcustomer.jpg");
        Image i2 = i1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 40, 450, 420);
        add(image);

        /*CONNECTION*/
        try {
            labelusername.setText(UserName);
            Conn c = new Conn();
           ResultSet rs = c.s.executeQuery("Select * From account where username ='"+UserName+"';");
            while (rs.next()) {
                labelusername.setText(rs.getString("UserName"));
                labelname.setText(rs.getString("Name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Storing additional information in table
        setVisible(true);
    }
    // public static void main(String[] args) {
    //     new AddCustomer("");
    // }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==add) {
            String username = labelusername.getText();
            String id = (String)comboID.getSelectedItem();
            String number = tfnumber.getText();
            String name = labelname.getText();
            String gender = null;
            if (male.isSelected()) {
                gender = "Male";
            }       
            else
            {
                gender = "Female";
            }     
            String country = tfcountry.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String mail = tfemail.getText();
            try {
                Conn c = new Conn();
                String sql = "insert into customer values('"+username+"','"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+address+"','"+phone+"','"+mail+"');";
                c.s.executeUpdate(sql);

                JOptionPane.showMessageDialog(null, "Customer Details added Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }
}
