package TravelManagementSystem;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BookHotel extends JFrame implements ActionListener {
    private JTextField textFieldPersons, textFieldDays;
    private Choice choiceHotel, choiceAC, choiceFood;
    private JButton buttonBack,buttonCheckPrice,buttonBookHotel;
    private JLabel labelDisplayTotalPrice,labelDisplayUsername,labelDisplayID,labelDisplayNumber,labelDisplayPhone;
    
    public BookHotel(String username) {
        setBounds(420, 220, 1100, 600);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
                
        ImageIcon iconHotel = new ImageIcon("icons/book.jpg");
        Image imgHotel = iconHotel.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon iconScaledHotel = new ImageIcon(imgHotel);
        JLabel labelHotelImage = new JLabel(iconScaledHotel);
        labelHotelImage.setBounds(450, 100, 700, 300);
        add(labelHotelImage);
		
        JLabel labelTitle = new JLabel("BOOK HOTEL");
        labelTitle.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
        labelTitle.setBounds(118, 11, 300, 53);
        add(labelTitle);
                
        JLabel labelUsername = new JLabel("Username:");
        labelUsername.setBounds(35, 70, 200, 14);
        add(labelUsername);
                
        labelDisplayUsername = new JLabel(username);
        labelDisplayUsername.setBounds(271, 70, 200, 14);
        add(labelDisplayUsername);
                
        JLabel labelSelectHotel = new JLabel("Select Hotel:");
        labelSelectHotel.setBounds(35, 110, 200, 14);
        add(labelSelectHotel);
                
        choiceHotel = new Choice();
        Conn conn = new Conn();
        try {
            ResultSet rs = conn.s.executeQuery("select * from hotels");
            while (rs.next()) {
                choiceHotel.add(rs.getString("name"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        choiceHotel.setBounds(271, 110, 150, 30);
        add(choiceHotel);
                
        JLabel labelTotalPersons = new JLabel("Total Persons:");
        labelTotalPersons.setBounds(35, 150, 200, 14);
        add(labelTotalPersons);
                
        textFieldPersons = new JTextField("0");
        textFieldPersons.setBounds(271, 150, 150, 20);
        add(textFieldPersons);
        textFieldPersons.setColumns(10);
                
        JLabel labelNumberOfDays = new JLabel("Number of Days:");
        labelNumberOfDays.setBounds(35, 190, 200, 14);
        add(labelNumberOfDays);
		
        textFieldDays = new JTextField("0");
        textFieldDays.setBounds(271, 190, 150, 20);
        add(textFieldDays);
        textFieldDays.setColumns(10);
		
        JLabel labelAC = new JLabel("AC / Non-AC:");
        labelAC.setBounds(35, 230, 200, 14);
        add(labelAC);
                
        choiceAC = new Choice();
        choiceAC.add("AC");
        choiceAC.add("Non-AC");
        choiceAC.setBounds(271, 230, 150, 30);
        add(choiceAC);
                
        JLabel labelFoodIncluded = new JLabel("Food Included:");
        labelFoodIncluded.setBounds(35, 270, 200, 14);
        add(labelFoodIncluded);
                
        choiceFood = new Choice();
        choiceFood.add("Yes");
        choiceFood.add("No");
        choiceFood.setBounds(271, 270, 150, 30);
        add(choiceFood);
                
        JLabel labelID = new JLabel("ID:");
        labelID.setBounds(35, 310, 200, 14);
        add(labelID);
                
        labelDisplayID = new JLabel();
        labelDisplayID.setBounds(271, 310, 200, 14);
        add(labelDisplayID);
		
        JLabel labelNumber = new JLabel("Number:");
        labelNumber.setBounds(35, 350, 200, 14);
        add(labelNumber);
                
        labelDisplayNumber = new JLabel();
        labelDisplayNumber.setBounds(271, 350, 200, 14);
        add(labelDisplayNumber);
           	
        JLabel labelPhone = new JLabel("Phone:");
        labelPhone.setBounds(35, 390, 200, 14);
        add(labelPhone);
                
        labelDisplayPhone = new JLabel();
        labelDisplayPhone.setBounds(271, 390, 200, 14);
        add(labelDisplayPhone);

		
        JLabel labelTotalPrice = new JLabel("Total Price:");
        labelTotalPrice.setBounds(35, 430, 200, 14);
        add(labelTotalPrice);
		
        labelDisplayTotalPrice = new JLabel();
        labelDisplayTotalPrice.setBounds(271, 430, 200, 14);
        labelDisplayTotalPrice.setForeground(Color.RED);
        add(labelDisplayTotalPrice);
                
        try {
            ResultSet rs = conn.s.executeQuery("select * from customer where username = '" + username + "'");
            while (rs.next()) {
                labelDisplayID.setText(rs.getString("id"));
                labelDisplayNumber.setText(rs.getString("number"));
                labelDisplayPhone.setText(rs.getString("phone"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
                
        buttonCheckPrice = new JButton("Check Price");        
        buttonCheckPrice.setBounds(50, 470, 120, 30);
        buttonCheckPrice.setBackground(Color.BLACK);
        buttonCheckPrice.setForeground(Color.WHITE);
        buttonCheckPrice.addActionListener(this);
        add(buttonCheckPrice);
		

        buttonBookHotel = new JButton("Book");
        buttonBookHotel.addActionListener(this);
                
        
        buttonBookHotel.setBounds(200, 470, 120, 30);
        buttonBookHotel.setBackground(Color.BLACK);
        buttonBookHotel.setForeground(Color.WHITE);
        add(buttonBookHotel);
		
        buttonBack = new JButton("Back");
        buttonBack.addActionListener(this);
            
         
        buttonBack.setBounds(350, 470, 120, 30);
        buttonBack.setBackground(Color.BLACK);
        buttonBack.setForeground(Color.WHITE);
        add(buttonBack);
                
        setVisible(true);
    }

    // public static void main(String[] args) {
    //     EventQueue.invokeLater(new Runnable() {
    //         public void run() {
    //             try {
    //                 BookHotel frame = new BookHotel("riya");
    //                 frame.setVisible(true);
    //             } catch (Exception e) {
    //                 e.printStackTrace();
    //             }
    //         }
    //     });
    // }
    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource()==buttonBack) {
            setVisible(false);
        } else if(ae.getSource()==buttonCheckPrice){
            Conn conn = new Conn();
                try {
                    String selectedHotel = choiceHotel.getSelectedItem();
                    String query = "select * from hotels where name = '" + selectedHotel + "'";
                    ResultSet rs = conn.s.executeQuery(query);
                    if (rs.next()) {
                        int costPerDay = Integer.parseInt(rs.getString("cost_per_day"));
                        int foodCharges = Integer.parseInt(rs.getString("food_charges"));
                        int acCharges = Integer.parseInt(rs.getString("ac_charges"));
                        
                        int persons = Integer.parseInt(textFieldPersons.getText());
                        int days = Integer.parseInt(textFieldDays.getText());
                        
                        String acOption = choiceAC.getSelectedItem();
                        String foodOption = choiceFood.getSelectedItem();
                        
                        if (persons * days > 0) {
                            int total = 0;
                            total += acOption.equals("AC") ? acCharges : 1;
                            total += foodOption.equals("Yes") ? foodCharges : 1;
                            total += costPerDay;
                            total = total * persons * days;
                            labelDisplayTotalPrice.setText("Rs " + total);
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            else if (ae.getSource()==buttonBookHotel) {
                Conn conn = new Conn();
                try {
                    String selectedHotel = choiceHotel.getSelectedItem();
                    String query = "insert into bookHotel values('"+ labelDisplayUsername.getText() +"', '"+ selectedHotel +"', '"+ textFieldPersons.getText() +"', '"+ textFieldDays.getText() +"', '"+ choiceAC.getSelectedItem() +"', '"+ choiceFood.getSelectedItem() +"', '"+ labelDisplayID.getText() +"', '"+ labelDisplayNumber.getText() +"', '"+ labelDisplayPhone.getText() +"', '"+ labelDisplayTotalPrice.getText() +"')";
                    conn.s.executeUpdate(query);
                    
                    JOptionPane.showMessageDialog(null, "Hotel Booked Successfully");
                    setVisible(false);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                }
            }
        
        }
    
    