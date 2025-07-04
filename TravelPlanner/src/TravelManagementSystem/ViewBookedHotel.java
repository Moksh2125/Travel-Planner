package TravelManagementSystem;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewBookedHotel extends JFrame {
   

    public ViewBookedHotel(String username) {
        setBounds(580, 220, 850, 600);
        setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon icon = new ImageIcon("icons/bookedDetails.jpg");
        Image scaledImage = icon.getImage().getScaledInstance(500, 350, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel imageLabel = new JLabel(scaledIcon);
        imageLabel.setBounds(450, 50, 350, 350);
        add(imageLabel);

        JLabel headingLabel = new JLabel("VIEW BOOKED HOTEL DETAILS");
        headingLabel.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
        headingLabel.setBounds(88, 11, 350, 53);
        add(headingLabel);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(35, 70, 200, 14);
        add(usernameLabel);

        JLabel usernameValueLabel = new JLabel();
        usernameValueLabel.setBounds(271, 70, 200, 14);
        add(usernameValueLabel);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(35, 110, 200, 14);
        add(nameLabel);

        JLabel nameValueLabel = new JLabel();
        nameValueLabel.setBounds(271, 110, 200, 14);
        add(nameValueLabel);

        JLabel personsLabel = new JLabel("Number of Persons:");
        personsLabel.setBounds(35, 150, 200, 14);
        add(personsLabel);

        JLabel personsValueLabel = new JLabel();
        personsValueLabel.setBounds(271, 150, 200, 14);
        add(personsValueLabel);

        JLabel daysLabel = new JLabel("Number of Days:");
        daysLabel.setBounds(35, 190, 200, 14);
        add(daysLabel);

        JLabel daysValueLabel = new JLabel();
        daysValueLabel.setBounds(271, 190, 200, 14);
        add(daysValueLabel);

        JLabel acLabel = new JLabel("AC / Non-AC:");
        acLabel.setBounds(35, 230, 200, 14);
        add(acLabel);

        JLabel acValueLabel = new JLabel();
        acValueLabel.setBounds(271, 230, 200, 14);
        add(acValueLabel);

        JLabel foodLabel = new JLabel("Food Included (Yes/No):");
        foodLabel.setBounds(35, 270, 200, 14);
        add(foodLabel);

        JLabel foodValueLabel = new JLabel();
        foodValueLabel.setBounds(271, 270, 200, 14);
        add(foodValueLabel);

        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(35, 310, 200, 14);
        add(idLabel);

        JLabel idValueLabel = new JLabel();
        idValueLabel.setBounds(271, 310, 200, 14);
        add(idValueLabel);

        JLabel numberLabel = new JLabel("Number:");
        numberLabel.setBounds(35, 350, 200, 14);
        add(numberLabel);

        JLabel numberValueLabel = new JLabel();
        numberValueLabel.setBounds(271, 350, 200, 14);
        add(numberValueLabel);

        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setBounds(35, 390, 200, 14);
        add(phoneLabel);

        JLabel phoneValueLabel = new JLabel();
        phoneValueLabel.setBounds(271, 390, 200, 14);
        add(phoneValueLabel);

        JLabel costLabel = new JLabel("Cost:");
        costLabel.setBounds(35, 430, 200, 14);
        add(costLabel);

        JLabel costValueLabel = new JLabel();
        costValueLabel.setBounds(271, 430, 200, 14);
        add(costValueLabel);

        Conn conn = new Conn();
        try {
            ResultSet rs = conn.s.executeQuery("select * from bookHotel where username = '" + username + "'");
            while (rs.next()) {
                usernameValueLabel.setText(rs.getString(1));
                nameValueLabel.setText(rs.getString(2));
                personsValueLabel.setText(rs.getString(3));
                daysValueLabel.setText(rs.getString(4));
                acValueLabel.setText(rs.getString(5));
                foodValueLabel.setText(rs.getString(6));
                idValueLabel.setText(rs.getString(7));
                numberValueLabel.setText(rs.getString(8));
                phoneValueLabel.setText(rs.getString(9));
                costValueLabel.setText(rs.getString(10));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        backButton.setBounds(160, 470, 120, 30);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        add(backButton);

        setVisible(true);
    }
}
