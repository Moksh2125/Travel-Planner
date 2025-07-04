 package TravelManagementSystem; 
// Make sure the package name is correct

import java.awt.*; 
import javax.swing.*;

import java.awt.event.*;
import java.sql.ResultSet;
public class Login extends JFrame implements ActionListener {

    JButton signup,login,forgotPassword;
    JTextField tfuser,tfpass;
    Login() {
        // Set up the frame
        setSize(900, 400);
        setLocation(350, 200);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Add this line
        getContentPane().setBackground(Color.white);        
        // Create and set up the panel
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(131, 193, 233));
        p1.setBounds(0, 0, 400, 400);
        add(p1);

        // Load and scale the image
        ImageIcon i1 = new ImageIcon("icons/login.png");
        if (i1.getImageLoadStatus() == MediaTracker.COMPLETE) { // Check if the image is loaded
            Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel image = new JLabel(i3);
            image.setBounds(100, 120, 200, 200);
            p1.add(image);
        } else {
            System.out.println("Image loading failed.");
        }
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(400, 30, 450, 300);
        add(p2);
        // Revalidate and repaint the panel
        p1.revalidate();
        p1.repaint();
         JLabel lbluser = new JLabel("Username");
         lbluser.setBounds(60, 20, 100, 25);
         lbluser.setFont(new Font("SEN_SERIF",Font.PLAIN,20));
         p2.add(lbluser);

         tfuser = new JTextField();
         tfuser.setBounds(60,60,300,30);
         tfuser.setBorder(BorderFactory.createEmptyBorder());   
         p2.add(tfuser);

         JLabel lblpass = new JLabel("Password");
         lblpass.setBounds(60, 110, 100, 25);
         lblpass.setFont(new Font("SEN_SERIF",Font.PLAIN,20));
         p2.add(lblpass);

         tfpass = new JTextField();
         tfpass.setBounds(60,150,300,30);
         tfpass.setBorder(BorderFactory.createEmptyBorder());
         p2.add(tfpass);

         login = new JButton("Login");
         login.setFont(new Font("SEN_SERIF",Font.PLAIN,20));
         login.setBounds(60, 200, 130, 30);
         login.setBackground(new Color(133, 193, 233));
         login.setForeground(Color.white);
         login.setBorder(BorderFactory.createEmptyBorder());
         login.addActionListener(this);
         p2.add(login);

         signup = new JButton("Signup");
         signup.setFont(new Font("SEN_SERIF",Font.PLAIN,20));
         signup.setBounds(220, 200, 130, 30);
         signup.setBackground(new Color(133, 193, 233));
         signup.setForeground(Color.white);
         signup.setBorder(BorderFactory.createEmptyBorder());
         signup.addActionListener(this);
         p2.add(signup);

         forgotPassword = new JButton("Forgot Password");
         forgotPassword.setFont(new Font("SEN_SERIF",Font.PLAIN,20));
         forgotPassword.setBounds(125, 250, 180, 30);
         forgotPassword.setBackground(new Color(133, 193, 233));
         forgotPassword.setForeground(Color.white);
         forgotPassword.setBorder(BorderFactory.createEmptyBorder());
         forgotPassword.addActionListener(this);
         p2.add(forgotPassword);
        
        //   JLabel text = new JLabel("Trouble in login...");
        //   text.setBounds(320,250,150,20);
        //   text.setForeground(Color.RED);
        //   p2.add(text);
        
         setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        // TODO Auto-generated method stub
        if (ae.getSource() == signup) {
            setVisible(false);
            new SignUp();            
        }else if(ae.getSource() == login)
        {
            try {
                String username = tfuser.getText();
                String password = tfpass.getText();

                String sql = "Select * From account where username = '"+username+"' and password = '"+password+"';";
                // JOptionPane.showMessageDialog(null, "Connection is done");
                 Conn c = new Conn();
                 ResultSet rs = c.s.executeQuery(sql);
                 if (rs.next()){
                    setVisible(false);
                    new Loading(username);
                 } else {
                     JOptionPane.showMessageDialog(null, "Incorrect UserName or Password");
                 }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(ae.getSource()== forgotPassword)
        {
            setVisible(false);
            new ForgotPassword();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}