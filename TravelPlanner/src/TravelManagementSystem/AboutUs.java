package TravelManagementSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AboutUs extends JFrame implements ActionListener {

    private JButton exitButton;
    private JLabel titleLabel;
    private Font titleFont, textFont;
    private TextArea infoTextArea;
    private String projectInfo;

    public AboutUs() {
        setLayout(null);
        setBounds(700, 220, 500, 550);
        getContentPane().setBackground(Color.WHITE);
        
        exitButton = new JButton("Exit");
        exitButton.setBounds(180, 430, 120, 20);
        exitButton.addActionListener(this);
        add(exitButton);

        titleFont = new Font("RALEWAY", Font.BOLD, 20);
        textFont = new Font("RALEWAY", Font.BOLD, 16);

        projectInfo = "                                    About Project          \n  "
                + "\nThe objective of the Travel Planner Software"
                + " project is to develop a system that automates the processes "
                + "and activities of travel. The purpose is to design a "
                + "system using which one can perform all operations related to "
                + "traveling.\n\n"
                + "This application will help in accessing the information related "
                + "to travel to a particular destination with great ease. "
                + "Users can track information related to their tours with "
                + "great ease through this application. Travel agency information "
                + "can also be obtained through this application.\n\n"
                + "Advantages of the Project:"
                + "\n Provides accurate information"
                + "\n Simplifies manual work"
                + "\n Minimizes documentation work"
                + "\n Provides up-to-date information"
                + "\n Friendly environment with warning messages"
                + "\n Provides travelers' details"
                + "\n Booking confirmation notifications";

        infoTextArea = new TextArea(projectInfo, 10, 40, Scrollbar.VERTICAL);
        infoTextArea.setEditable(false);
        infoTextArea.setBounds(20, 100, 450, 300);
        infoTextArea.setFont(textFont);
        add(infoTextArea);

        titleLabel = new JLabel("About Project");
        titleLabel.setBounds(170, 10, 180, 80);
        titleLabel.setForeground(Color.RED);
        titleLabel.setFont(titleFont);
        add(titleLabel);

        
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        dispose();
    }

    public static void main(String[] args) {
        new AboutUs();
    }
}
