package TravelManagementSystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Dashboard extends JFrame implements ActionListener { 
    
    String UserName;
    private  int addCustomer_count=0;
    JButton addPersonalDetails,viewDetails,updatePersonDetails,deletePersonalDetails;
    JButton viewPackage,bookPackage,viewbookedPackage,viewHotel,viewBookedHotel,destination,bookHotel;
    JButton payments,calculator,notepad,aboutUs;

    public Dashboard(String UserName) {
        
        this.UserName = UserName;
        setBounds(0,0,1600,1000);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(0,0,1600,65);
        p1.setBackground(new Color(0,0,102));
        add(p1);
        
        ImageIcon i1 = new ImageIcon("icons/Dashboard.png");
        Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(5,0,70,70);
        p1.add(l1);

        JLabel l2 = new JLabel("Dashboard");
        l2.setBounds(80,10,300,40);
        l2.setForeground(Color.white);
        l2.setFont(new Font("Arial", Font.BOLD, 30));
        p1.add(l2);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0,0,102));
        p2.setBounds(0,65,300,900);
        add(p2);

         addPersonalDetails = new JButton("ADD person Details");
         addPersonalDetails.setBounds(0,0,300,50);
         addPersonalDetails.setBackground(new Color(0,0,102));
         addPersonalDetails.setForeground(Color.white);
         addPersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
         addPersonalDetails.addActionListener(this);
         p2.add(addPersonalDetails);   

         updatePersonDetails = new JButton("Update Person Details");
         updatePersonDetails.setBounds(0,50,300,50);
         updatePersonDetails.setBackground(new Color(0,0,102));
         updatePersonDetails.setForeground(Color.white);
         updatePersonDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
         updatePersonDetails.addActionListener(this);
         p2.add(updatePersonDetails);
         
         viewDetails = new JButton("View Details");
         viewDetails.setBounds(0,100,300,50);
         viewDetails.setBackground(new Color(0,0,102));
         viewDetails.setForeground(Color.white);
         viewDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
         viewDetails.addActionListener(this);
         p2.add(viewDetails); 
         
         deletePersonalDetails = new JButton("Delete person Details");
         deletePersonalDetails.setBounds(0,150,300,50);
         deletePersonalDetails.setBackground(new Color(0,0,102));
         deletePersonalDetails.setForeground(Color.white);
         deletePersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
         deletePersonalDetails.addActionListener(this);
         p2.add(deletePersonalDetails);   
        
         viewPackage = new JButton("View Package");
         viewPackage.setBounds(0,200,300,50);
         viewPackage.setBackground(new Color(0,0,102));
         viewPackage.setForeground(Color.white);
         viewPackage.setFont(new Font("Tahoma", Font.PLAIN, 20));
         viewPackage.addActionListener(this);
         p2.add(viewPackage);
         
         bookPackage = new JButton("Book Package");
         bookPackage.setBounds(0,250,300,50);
         bookPackage.setBackground(new Color(0,0,102));
         bookPackage.setForeground(Color.white);
         bookPackage.setFont(new Font("Tahoma", Font.PLAIN, 20));
         bookPackage.addActionListener(this);
         p2.add(bookPackage);

          viewbookedPackage = new JButton("View Booked package");
          viewbookedPackage.setBounds(0,300,300,50);
          viewbookedPackage.setBackground(new Color(0,0,102));
          viewbookedPackage.setForeground(Color.white);
          viewbookedPackage.setFont(new Font("Tahoma", Font.PLAIN, 20));
          viewbookedPackage.addActionListener(this);  
          p2.add( viewbookedPackage);

          viewHotel = new JButton("View Hotel");
          viewHotel.setBounds(0,350,300,50);
          viewHotel.setBackground(new Color(0,0,102));
          viewHotel.setForeground(Color.white);
          viewHotel.setFont(new Font("Tahoma", Font.PLAIN, 20));
          viewHotel.addActionListener(this);  
          p2.add( viewHotel);

          bookHotel = new JButton("Book Hotel");
          bookHotel.setBounds(0,400,300,50);
          bookHotel.setBackground(new Color(0,0,102));
          bookHotel.setForeground(Color.white);
          bookHotel.setFont(new Font("Tahoma", Font.PLAIN, 20));
          bookHotel.addActionListener(this);
         p2.add(bookHotel);

         viewBookedHotel = new JButton("View Booked Hotel");
          viewBookedHotel.setBounds(0,450,300,50);
          viewBookedHotel.setBackground(new Color(0,0,102));
          viewBookedHotel.setForeground(Color.white);
          viewBookedHotel.setFont(new Font("Tahoma", Font.PLAIN, 20));
          viewBookedHotel.addActionListener(this);
          p2.add(viewBookedHotel);

          destination = new JButton("Destinations");
          destination.setBounds(0,500,300,50);
          destination.setBackground(new Color(0,0,102));
          destination.setForeground(Color.white);
          destination.setFont(new Font("Tahoma", Font.PLAIN, 20));
          destination.addActionListener(this);  
          p2.add(destination);

         payments = new JButton("Payments");
         payments.setBounds(0,550,300,50);
         payments.setBackground(new Color(0,0,102));
         payments.setForeground(Color.white);
         payments.setFont(new Font("Tahoma", Font.PLAIN, 20));
         payments.addActionListener(this);
        p2.add(payments);

        calculator = new JButton("Calculator");
        calculator.setBounds(0,600,300,50);
        calculator.setBackground(new Color(0,0,102));
        calculator.setForeground(Color.white);
        calculator.setFont(new Font("Tahoma", Font.PLAIN, 20));
        calculator.addActionListener(this);
       p2.add(calculator);

       notepad = new JButton("NotePad");
        notepad.setBounds(0,650,300,50);
        notepad.setBackground(new Color(0,0,102));
        notepad.setForeground(Color.white);
        notepad.setFont(new Font("Tahoma", Font.PLAIN, 20));
        notepad.addActionListener(this);
       p2.add(notepad);

        aboutUs = new JButton("About Us");
        aboutUs.setBounds(0,700,300,50);
        aboutUs.setBackground(new Color(0,0,102));
        aboutUs.setForeground(Color.white);
        aboutUs.setFont(new Font("Tahoma", Font.PLAIN, 20));
        aboutUs.addActionListener(this);
       p2.add(aboutUs);

    //    JButton WishList = new JButton("Your WishList");
    //    WishList.setBounds(0,700,300,50);
    //    WishList.setBackground(new Color(0,0,102));
    //    WishList.setForeground(Color.white);
    //    WishList.setFont(new Font("Tahoma", Font.PLAIN, 20));
    //   p2.add(WishList);

        

       ImageIcon i4 = new ImageIcon("icons/Home.jpg");
        Image i5 = i4.getImage().getScaledInstance(1650, 1000, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image= new JLabel(i6); 
        image.setBounds(0,0,1650,1000);
        add(image);

        JLabel text = new JLabel("Travel Planner");
        text.setBounds(400,70,1200,70);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.PLAIN,55));
        image.add(text);

        // JScrollPane scrollPane = new JScrollPane(p2);
        // scrollPane.setBounds(0,65,300,900);
        // scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        // scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        // add(scrollPane);

       setVisible(true);
    }
    public static void main(String[] args) {
        new Dashboard("Moksh1234");
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==addPersonalDetails) {
            // Conn c = new Conn();
            // ResultSet rs;
            // try {
            //     rs = c.s.executeQuery("SELECT COUNT(*) > 0 FROM customer WHERE username = "+UserName+";");
            //     if (rs.next() && rs.getBoolean(1)) {
            //         JOptionPane.showMessageDialog(null,"The Details are added");
            //     } else {}} catch (Exception e) {
            //     e.printStackTrace();
            // }
                    if (addCustomer_count>0) {
                        JOptionPane.showMessageDialog(null,"Your Details Has Been Added Onces");
                    } else {
                        new AddCustomer(UserName);
                        addCustomer_count++;
                    }
        }
        else if (ae.getSource()==updatePersonDetails) {
            new UpdateCustomer(UserName);
        } else if (ae.getSource()==deletePersonalDetails) {
            try {
                new DeleteCustomer(UserName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (ae.getSource()==viewDetails) {
            new ViewCustomer(UserName);
        }
        else if (ae.getSource()==viewPackage) {
            new ViewPackages();
        }
        else if (ae.getSource()==bookPackage) {
            new BookPackage(UserName);
        } else if(ae.getSource()==viewbookedPackage){
            new ViewSelectedPackages(UserName);
        } else if (ae.getSource()==viewHotel) {
            new ViewHotals();
        }
        else if (ae.getSource()== destination ) {
            new Destinations();
        } else if (ae.getSource()==bookHotel) {
            new BookHotel(UserName);
        } else if (ae.getSource()==viewBookedHotel) {
            new ViewBookedHotel(UserName);
        } else if (ae.getSource()==payments) {
            new Payment();
        } else if (ae.getSource()==notepad) {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == calculator) {
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource()==aboutUs) {
            new AboutUs();
        }
    }
}
