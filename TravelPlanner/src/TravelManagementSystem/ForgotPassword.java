package TravelManagementSystem;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.sql.*;
import java.awt.event.*;

public class ForgotPassword extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JTextField usernameField, nameField, securityQuestionField, answerField, passwordField;
    private JButton searchButton, retrieveButton, backButton;

    // public static void main(String[] args) {
    //     new ForgotPassword().setVisible(true);
    // }

    public ForgotPassword() {

        setBounds(500, 200, 850, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(null);

        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        usernameLabel.setBounds(109, 83, 87, 29);
        contentPane.add(usernameLabel);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        nameLabel.setBounds(109, 122, 75, 21);
        contentPane.add(nameLabel);

        JLabel securityQuestionLabel = new JLabel("Your Security Question");
        securityQuestionLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        securityQuestionLabel.setBounds(109, 154, 156, 27);
        contentPane.add(securityQuestionLabel);

        JLabel answerLabel = new JLabel("Answer");
        answerLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        answerLabel.setBounds(109, 192, 104, 21);
        contentPane.add(answerLabel);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        passwordLabel.setBounds(109, 224, 104, 21);
        contentPane.add(passwordLabel);

        usernameField = new JTextField();
        usernameField.setFont(new Font("Tahoma", Font.BOLD, 13));
        usernameField.setForeground(new Color(105, 105, 105));
        usernameField.setBounds(277, 88, 139, 20);
        contentPane.add(usernameField);
        usernameField.setColumns(10);

        nameField = new JTextField();
        nameField.setEditable(false);
        nameField.setFont(new Font("Tahoma", Font.BOLD, 13));
        nameField.setForeground(new Color(165, 42, 42));
        nameField.setColumns(10);
        nameField.setBounds(277, 123, 139, 20);
        contentPane.add(nameField);

        securityQuestionField = new JTextField();
        securityQuestionField.setEditable(false);
        securityQuestionField.setFont(new Font("Tahoma", Font.BOLD, 12));
        securityQuestionField.setForeground(new Color(72, 61, 139));
        securityQuestionField.setColumns(10);
        securityQuestionField.setBounds(277, 161, 221, 20);
        contentPane.add(securityQuestionField);

        answerField = new JTextField();
        answerField.setFont(new Font("Tahoma", Font.BOLD, 13));
        answerField.setForeground(new Color(205, 92, 92));
        answerField.setColumns(10);
        answerField.setBounds(277, 193, 139, 20);
        contentPane.add(answerField);

        passwordField = new JTextField();
        passwordField.setEditable(false);
        passwordField.setFont(new Font("Tahoma", Font.BOLD, 13));
        passwordField.setForeground(new Color(50, 205, 50));
        passwordField.setColumns(10);
        passwordField.setBounds(277, 225, 139, 20);
        contentPane.add(passwordField);

        ImageIcon icon = new ImageIcon("icons/forgotpassword.jpg");
        Image image = icon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(image);
        JLabel imageLabel = new JLabel(scaledIcon);
        imageLabel.setBounds(560, 70, 200, 200);
        add(imageLabel);

        searchButton = new JButton("Search");
        searchButton.addActionListener(this);
        searchButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        searchButton.setBounds(428, 83, 80, 29);
        searchButton.setBackground(Color.BLACK);
        searchButton.setForeground(Color.WHITE);
        contentPane.add(searchButton);

        retrieveButton = new JButton("Retrieve");
        retrieveButton.addActionListener(this);
        retrieveButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        retrieveButton.setBounds(426, 188, 85, 29);
        retrieveButton.setBackground(Color.BLACK);
        retrieveButton.setForeground(Color.WHITE);
        contentPane.add(retrieveButton);

        backButton = new JButton("Back");
        backButton.addActionListener(this);
        backButton.setFont(new Font("Tahoma", Font.BOLD, 13));
        backButton.setBounds(233, 270, 101, 29);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        contentPane.add(backButton);

        JPanel panel = new JPanel();
        panel.setBounds(47, 45, 508, 281);
        panel.setBackground(Color.PINK);
        contentPane.add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            Conn connection = new Conn();
            if (ae.getSource() == searchButton) {
                String query = "select * from account where username=?";
                PreparedStatement statement = connection.c.prepareStatement(query);

                statement.setString(1, usernameField.getText());
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    nameField.setText(resultSet.getString("name"));
                    securityQuestionField.setText(resultSet.getString("security"));
                }

            }
            if (ae.getSource() == retrieveButton) {
                String query = "select * from account where answer=?";
                PreparedStatement statement = connection.c.prepareStatement(query);

                statement.setString(1, answerField.getText());
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    passwordField.setText(resultSet.getString("password"));
                }

            }
            if (ae.getSource() == backButton) {
                this.setVisible(false);
                new Login().setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
