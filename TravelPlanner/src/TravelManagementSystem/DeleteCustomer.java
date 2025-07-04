package TravelManagementSystem;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeleteCustomer extends JFrame implements ActionListener {
    private JPanel contentPane;
    private JLabel customer;
    String username;
    JButton deleteButton,backButton;

    public static void main(String[] args)  {
        new DeleteCustomer("Keval321");
    }

    public DeleteCustomer(String UserName)  {
        this.username=UserName;
        setBounds(580, 220, 850, 550);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon icon = new ImageIcon("icons/delete.png");
        Image scaledImage = icon.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        JLabel imageLabel = new JLabel(new ImageIcon(scaledImage));
        imageLabel.setBounds(500, 100, 300, 300);
        add(imageLabel);

        JLabel titleLabel = new JLabel("DELETE CUSTOMER DETAILS");
        titleLabel.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
        titleLabel.setBounds(118, 11, 300, 53);
        contentPane.add(titleLabel);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(35, 70, 200, 14);
        contentPane.add(usernameLabel);

        customer = new JLabel();
        customer.setBounds(271, 70, 150, 30);
        add(customer);

        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(35, 110, 200, 14);
        contentPane.add(idLabel);

        JLabel idValueLabel = new JLabel();
        idValueLabel.setBounds(271, 110, 200, 14);
        contentPane.add(idValueLabel);

        JLabel numberLabel = new JLabel("Number:");
        numberLabel.setBounds(35, 150, 200, 14);
        contentPane.add(numberLabel);

        JLabel numberValueLabel = new JLabel();
        numberValueLabel.setBounds(271, 150, 200, 14);
        contentPane.add(numberValueLabel);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(35, 190, 200, 14);
        contentPane.add(nameLabel);

        JLabel nameValueLabel = new JLabel();
        nameValueLabel.setBounds(271, 190, 200, 14);
        contentPane.add(nameValueLabel);

        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(35, 230, 200, 14);
        contentPane.add(genderLabel);

        JLabel genderValueLabel = new JLabel();
        genderValueLabel.setBounds(271, 230, 200, 14);
        contentPane.add(genderValueLabel);

        JLabel countryLabel = new JLabel("Country:");
        countryLabel.setBounds(35, 270, 200, 14);
        contentPane.add(countryLabel);

        JLabel countryValueLabel = new JLabel();
        countryValueLabel.setBounds(271, 270, 200, 14);
        contentPane.add(countryValueLabel);

        JLabel addressLabel = new JLabel("Permanent Address:");
        addressLabel.setBounds(35, 310, 200, 14);
        contentPane.add(addressLabel);

        JLabel addressValueLabel = new JLabel();
        addressValueLabel.setBounds(271, 310, 200, 14);
        contentPane.add(addressValueLabel);

        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setBounds(35, 350, 200, 14);
        contentPane.add(phoneLabel);

        JLabel phoneValueLabel = new JLabel();
        phoneValueLabel.setBounds(271, 350, 200, 14);
        contentPane.add(phoneValueLabel);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(35, 390, 200, 14);
        contentPane.add(emailLabel);

        JLabel emailValueLabel = new JLabel();
        emailValueLabel.setBounds(271, 390, 200, 14);
        contentPane.add(emailValueLabel);

        try  {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("SELECT * FROM customer where username = '"+UserName+"';");
            while (rs.next()) {
                customer.setText(rs.getString("username"));
                idValueLabel.setText(rs.getString("id"));
                numberValueLabel.setText(rs.getString("number"));
                nameValueLabel.setText(rs.getString("name"));
                genderValueLabel.setText(rs.getString("gender"));
                countryValueLabel.setText(rs.getString("country"));
                addressValueLabel.setText(rs.getString("address"));
                phoneValueLabel.setText(rs.getString("phone"));
                emailValueLabel.setText(rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(this);
        deleteButton.setBounds(100, 430, 120, 30);
        deleteButton.setBackground(Color.BLACK);
        deleteButton.setForeground(Color.WHITE);
        contentPane.add(deleteButton);

        backButton = new JButton("Back");
        backButton.addActionListener(this);
        backButton.setBounds(260, 430, 120, 30);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(this);
        contentPane.add(backButton);

        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == deleteButton ) {
            int result = JOptionPane.showConfirmDialog(null,"Are You Sure You Want to Delete","", JOptionPane.YES_NO_OPTION);
            if (result==JOptionPane.YES_OPTION) {
                try  {
                    Conn conn = new Conn();
                    String query = "DELETE FROM customer WHERE username = '" + username + "';";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Customer Detail Deleted Successfully");
                    setVisible(false);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        
            }
        } else if(ae.getSource()==backButton){
            setVisible(false);
        }
    }
}
