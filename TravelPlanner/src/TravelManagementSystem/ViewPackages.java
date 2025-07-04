package TravelManagementSystem;

import java.awt.*;
import javax.swing.*;

public class ViewPackages extends JFrame {

    private SinglyLinkedList packageList1 = new SinglyLinkedList();
    private SinglyLinkedList packageList2 = new SinglyLinkedList();
    private SinglyLinkedList packageList3 = new SinglyLinkedList();
    
    public ViewPackages() {   
        setBounds(450, 200, 900, 600);
        setBackground(Color.WHITE);
        setLayout(null);
        
        // Define packages
        Package pkg1 = new Package("Goa, India","PACKAGE 1", "5 days and 4 nights", "Airport Assistance", "Half Day city tour", 
                                   "Sightseeing", "Soft Drink Free", "Breakfast included", "English speaking guide", 
                                   "BOOK PACKAGE", "SUMMER SPECIAL", "Rs 12000/-", "package1.jpg");
        Package pkg2 = new Package("Ladakh, India","PACKAGE 2", "6 days 5 nights", "Full day city tour", "Breakfast and dinner included", 
                                   "Airport pickup", "Welcome Drinks on Arrival", "Mountain Biking", "White water rafting", 
                                   "BOOK NOW", "WINTER SPECIAL", "Rs 22500/-", "Package2.jpg");
        Package pkg3 = new Package("Kerala, India","PACKAGE 3", "7 days and 6 nights", "Return Airfare", "Free tickets for gardens", 
                                   "River Rafting", "Free horse riding", "Daily Buffet", "BBQ Dinner", 
                                   "BOOK NOW", "WINTER SPECIAL", "Rs 51000/-", "Package3.jpg");
        
        // Add packages to linked lists
        packageList1.addPackage(pkg1);
        packageList2.addPackage(pkg2);
        packageList3.addPackage(pkg3);

        JTabbedPane tab = new JTabbedPane();
        tab.setBounds(0, 0, 900, 600);

        // Create panels for each package
        JPanel p1 = createPackagePanel(packageList1, 0);
        tab.addTab("Package 1", null, p1);

        JPanel p2 = createPackagePanel(packageList2, 0);
        tab.addTab("Package 2", null, p2);

        JPanel p3 = createPackagePanel(packageList3, 0);
        tab.addTab("Package 3", null, p3);
        
        add(tab);
        setVisible(true);
    }

    // Method to create a panel for each package
    private JPanel createPackagePanel(SinglyLinkedList packageList, int index) {
        Package selectedPackage = packageList.fetchPackage(index);
        if (selectedPackage == null) return new JPanel(); // Return empty panel if no package found

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);

        JLabel destination = new JLabel("Destination : "+selectedPackage.getDestination());
        destination.setBounds(30, 5, 300,30);
        destination.setForeground(Color.DARK_GRAY);
        destination.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(destination); 

        JLabel name = new JLabel(selectedPackage.getName());
        name.setBounds(50, 40, 300, 30);
        name.setForeground(Color.BLACK);
        name.setFont(new Font("Tahoma", Font.BOLD, 30));
        panel.add(name);

        JLabel duration = new JLabel(selectedPackage.getDuration());
        duration.setBounds(30, 85, 300, 30);
        duration.setForeground(Color.RED);
        duration.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(duration);

        JLabel benefit1 = new JLabel(selectedPackage.getbenefit1());
        benefit1.setBounds(30, 135, 300, 30);
        benefit1.setForeground(Color.BLUE);
        benefit1.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(benefit1);

        JLabel benefit2 = new JLabel(selectedPackage.getbenefit2());
        benefit2.setBounds(30, 185, 300, 30);
        benefit2.setForeground(Color.RED);
        benefit2.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(benefit2);

        JLabel benefit3 = new JLabel(selectedPackage.getbenefit3());
        benefit3.setBounds(30, 235, 300, 30);
        benefit3.setForeground(Color.BLUE);
        benefit3.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(benefit3);

        JLabel benefit4 = new JLabel(selectedPackage.getbenefit4());
        benefit4.setBounds(30, 285, 300, 30);
        benefit4.setForeground(Color.RED);
        benefit4.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(benefit4);

        JLabel benefit5 = new JLabel(selectedPackage.getbenefit5());
        benefit5.setBounds(30, 335, 300, 30);
        benefit5.setForeground(Color.BLUE);
        benefit5.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(benefit5);

        JLabel benefit6 = new JLabel(selectedPackage.getbenefit6());
        benefit6.setBounds(30, 385, 300, 30);
        benefit6.setForeground(Color.RED);
        benefit6.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(benefit6);

        JLabel booking = new JLabel(selectedPackage.getBooking());
        booking.setBounds(60, 430, 300, 30);
        booking.setForeground(Color.BLACK);
        booking.setFont(new Font("Tahoma", Font.BOLD, 25));
        panel.add(booking);

        JLabel seasonalOffer = new JLabel(selectedPackage.getSeasonalOffer());
        seasonalOffer.setBounds(80, 480, 300, 30);
        seasonalOffer.setForeground(Color.MAGENTA);
        seasonalOffer.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(seasonalOffer);

        JLabel price = new JLabel(selectedPackage.getPrice());
        price.setBounds(500, 480, 300, 30);
        price.setForeground(Color.cyan);
        price.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(price);

        ImageIcon icon = new ImageIcon("icons/" + selectedPackage.getImagePath());
        Image image = icon.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(image);
        JLabel imageLabel = new JLabel(scaledIcon);
        imageLabel.setBounds(350, 20, 500, 300);
        panel.add(imageLabel);

        return panel;
    }

    public static void main(String[] args) {    
        new ViewPackages();
    }
}
