
package TravelManagementSystem;
import javax.swing.*;
import java.awt.*;
public class Splash extends JFrame implements Runnable
{       
    /* Using constructor to genrate the image on the dialog box.*/
    Thread thread; 
    Splash()
    {
        //setSize(1200,600);
        //setLocation(750, 400);
        setVisible(true); 
        // giving refrance to a particular image.
        ImageIcon i1 = new ImageIcon("icons/splash.jpg");
        // using Image class of awt package to set its dimantion. 
        Image i2 = i1.getImage().getScaledInstance(1200, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2); // cant give a direct input of Image icon to JLable.
        JLabel image = new JLabel(i3);
        add(image);
        for(int i=1;i<=600;i++)
        {
            //frame.
            setLocation(750-i, 400-(i/2));    // Use to define the location of the frame.
            //frame.
            setSize(i*2, i); // Use to define the size of the frame.
            try {
            Thread.sleep(5);
            } catch (InterruptedException e) {
            e.printStackTrace();
            }    
        }
        thread = new Thread(this);
        thread.start();
    }

    public void run()
    {
        try 
        {
            Thread.sleep(3000);      
            new Login();
            setVisible(false);
        }
         catch (InterruptedException e) {
                 e.printStackTrace();
        }
    }

    public static void main(String[] args) {
         new Splash();    
        // To make the frame gone after 3 sec,using setVisible
    }
}