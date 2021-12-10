import java.awt.*;
import javax.swing.JMenuBar;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class AboutUs extends JFrame implements ActionListener {
    JFrame frame = new JFrame("LIBRARY MANAGEMENT SYSTEM");
    JMenuBar MainMenu = new JMenuBar();
    JMenu menu = new JMenu("Menu");
    JMenu help = new JMenu("Help");
    JMenu exit = new JMenu("Exit");

    JMenuItem menu1 = new JMenuItem("New User");
    JMenuItem menu2 = new JMenuItem("Sign in");
    JMenuItem menu3 = new JMenuItem("Home");

    JMenuItem help1 = new JMenuItem("About Us");
    JMenuItem help2 = new JMenuItem("Contact Us");

    JMenuItem exit1 = new JMenuItem("Sign out");
    JMenuItem exit2 = new JMenuItem("Close window");
    JButton back;
    public AboutUs() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setTitle("LIBRARY MANAGEMENT SYSTEM");

        ImageIcon iconImg = new ImageIcon(getClass().getResource("Assets/icon.png"));
        setIconImage(iconImg.getImage());

        ImageIcon image = new ImageIcon(getClass().getResource("Assets/Lib.jpg"));
        JLabel img = new JLabel();
        img.setIcon(image);
        img.setHorizontalAlignment(JLabel.CENTER);
        img.setVerticalAlignment(JLabel.CENTER);
        setContentPane(img);

        JLabel userLabel = new JLabel(
                "<html>Library management system is a project which aims in developing a computerized system to maintain all the daily work of a library. The system helps both students and library manager to keep a constant track of all the books available in the library. It allows both the admin and the student to search for the desired book.<br><br><br>The main feature of this system is that all the books available in the library can be displayed in a list so that students need not roam through the entire library to find a book. Additionally, the application effectively maintains the details of students to whom books have been issued; it also records the issued date and return date.<br><br><br>Language Used -  Core Java<br><br>Concept Used - Swing<br><br>IDE Used - VSCode<br><br> Database Used - MySQL<br><br>Made By - Aman Kumar(044) , Kamal Parashar(018) , Pranjay Vats(058) , Swapnil Manke(014)</html>");
        userLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
        userLabel.setForeground(Color.BLACK);
        userLabel.setBounds(215, 190, 1095, 500);

        back =  new JButton("Back");
        back.setForeground(Color.white);
        back.setBackground(Color.black);
        back.setBounds(1180,620,100,40);
        back.addActionListener(this);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(new Color(150, 75, 0), 3), "About-Us",
                TitledBorder.LEADING, TitledBorder.TOP, null, new Color(150, 75, 0)));
        panel.setBounds(205, 180, 1105, 505);

        panel.setBackground(new Color(255, 229, 180));
        img.add(userLabel);
        img.add(back);
        img.add(panel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {
        try{
            if (ae.getSource()==back) {
                new Home().setVisible(true);
                this.setVisible(false);
            }
        }
        catch (Exception e) {
            System.out.println("Error occured");
        }

    }

    public static void main(String args[]) {
        new AboutUs().setVisible(true);
        ;
    }
}
