package TravelManagementSystem;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;;
//import java.util.jar.JarEntry;
public class SignUp extends JFrame implements ActionListener{

  JButton create, back;
  JTextField tfanswer,tfusername,tfname,tfpassword;
  Choice security;
  private static String sql="";

  public SignUp()
    {
      setBounds(350,200,900,360);
      getContentPane().setBackground(Color.WHITE);
      setLayout(null);

      JPanel p1 = new JPanel();
      p1.setBackground(new Color(133,193,233));
      p1.setBounds(0,0,500,400);
      p1.setLayout(null);
      add(p1);

      JLabel iblusername = new JLabel("Username");
      iblusername.setFont(new Font("Tahoma",Font.BOLD,14));
      iblusername.setBounds(50,20,125,25);
      p1.add(iblusername);

      tfusername = new JTextField();
      tfusername.setBounds(190,20,180,25);
      tfusername.setBorder(BorderFactory.createEmptyBorder());
      p1.add(tfusername);

      JLabel iblname = new JLabel("Name");
      iblname.setFont(new Font("Tahoma",Font.BOLD,14));
      iblname.setBounds(50,55,125,25);
      p1.add(iblname);

      tfname = new JTextField();
      tfname.setBounds(190,55,180,25);
      tfname.setBorder(BorderFactory.createEmptyBorder());
      p1.add(tfname);

      JLabel iblpassword = new JLabel("Password");
      iblpassword.setFont(new Font("Tahoma",Font.BOLD,14));
      iblpassword.setBounds(50,90,125,25);
      p1.add(iblpassword);

      tfpassword = new JTextField();
      tfpassword.setBounds(190,90,180,25);
      tfpassword.setBorder(BorderFactory.createEmptyBorder());
      p1.add(tfpassword);

      JLabel iblsecurityqus = new JLabel("Security Question");
      iblsecurityqus.setFont(new Font("Tahoma",Font.BOLD,14));
      iblsecurityqus.setBounds(50,125,125,25);
      p1.add(iblsecurityqus); 

      security = new Choice();
      security.add("Fav Character from The Boys.");
      security.add("Fav character from Marvel.");
      security.add("Fav Charactor from DC.");
      security.setBounds(190,125,180,25);
      p1.add(security);
   
      JLabel iblanswer = new JLabel("Answer");
      iblanswer.setFont(new Font("Tahoma",Font.BOLD,14));
      iblanswer.setBounds(50,160,125,25);
      p1.add(iblanswer);

      tfanswer = new JTextField();
      tfanswer.setBounds(190,160,180,25);
      tfanswer.setBorder(BorderFactory.createEmptyBorder());
      p1.add(tfanswer);

      create = new JButton("Create");
      create.setBounds(80,220,110,25);
      create.setFont(new Font("SEN_SERIF",Font.PLAIN,20));
      create.setForeground(new Color(133, 193, 233));
      create.setBackground(Color.white);
      create.setBorder(BorderFactory.createEmptyBorder());
      create.addActionListener(this);
      p1.add(create);

      back = new JButton("Back");
      back.setBounds(280,220,110,25);
      back.setFont(new Font("SEN_SERIF",Font.PLAIN,20));
      back.setForeground(new Color(133, 193, 233));
      back.setBackground(Color.white);
      back.setBorder(BorderFactory.createEmptyBorder());
      back.addActionListener(this);
      p1.add(back);

      ImageIcon i1 = new ImageIcon("icons/signup.png");
        //if (i1.getImageLoadStatus() == MediaTracker.COMPLETE) { // Check if the image is loaded
            Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel image = new JLabel(i3);
            image.setBounds(600, 70, 200, 200);
            add(image); 
        //}
      setVisible(true);
    }
 public static void main(String[] args) {
    new SignUp();
 }
@Override
  public void actionPerformed(ActionEvent ae) {
    // Create Button used to create an account but will ask the user if he is a Admin or not.
    if(ae.getSource() == create)
     {  
        String username = tfusername.getText();
        String name = tfname.getText();
        String password = tfpassword.getText();
        String answer = tfanswer.getText();
        String question = security.getSelectedItem();
        

        sql = "Insert into account values('"+username+"','"+name+"','"+password+"','"+question+"','"+answer+"','Customer');";
        
       try {
        Conn c = new Conn();
        c.s.executeUpdate(sql);
        JOptionPane.showMessageDialog(null, "Account Created Successfully ");
        setVisible(false);
        new Login(); 
      } catch (Exception e) {
        e.printStackTrace();
      } 
      }  
     else if (ae.getSource() == back) {
       setVisible(false);
       new Login();
     }
  }
}
