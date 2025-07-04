 package TravelManagementSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




    public class GalleryApp extends JFrame implements ActionListener {
        private JLabel label;
        private JButton prevButton, nextButton;
        private int currentImageIndex = 0;
        private String[] imagePaths = {
            "icons/dest1.jpg",
            "icons/dest3.jpg",
            "icons/dest4.jpg",
            "icons/dest10.jpg"
        };
    
        public GalleryApp() {
            setTitle("Gallery App");
            setSize(800, 600);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(new BorderLayout());
    
            label = new JLabel();
            label.setHorizontalAlignment(JLabel.CENTER);
            label.setIcon(new ImageIcon(imagePaths[currentImageIndex]));
            add(label, BorderLayout.CENTER);
    
            JPanel panel = new JPanel();
            prevButton = new JButton("Previous");
            nextButton = new JButton("Next");
            prevButton.addActionListener(this);
            nextButton.addActionListener(this);
            panel.add(prevButton);
            panel.add(nextButton);
            add(panel, BorderLayout.SOUTH);
        }
    
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == prevButton) {
                currentImageIndex = (currentImageIndex - 1 + imagePaths.length) % imagePaths.length;
            } else if (e.getSource() == nextButton) {
                currentImageIndex = (currentImageIndex + 1) % imagePaths.length;
            }
            label.setIcon(new ImageIcon(imagePaths[currentImageIndex]));
        }
    
        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> {
                new GalleryApp().setVisible(true);
            });
        }
    }
    
