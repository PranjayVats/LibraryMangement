import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Home extends JFrame implements ActionListener{
    JButton addStudent, addBook, aboutUs, issueBook, returnBook, statistic;
    JButton iconButton1, iconButton2, iconButton3, iconButton4, iconButton5, iconButton6;
    JMenuBar MainMenu = new JMenuBar();
    JMenu menu = new JMenu("Menu");
    JMenu exit = new JMenu("Exit");

    JMenuItem menu1 = new JMenuItem("Book Details");
    JMenuItem menu2 = new JMenuItem("Student Details");
    JMenuItem exit1 = new JMenuItem("Sign out");
    JMenuItem exit2 = new JMenuItem("Close window");
    Home() {
        setLayout(null);
        setResizable(false);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setTitle("LIBRARY MANAGEMENT SYSTEM");

        ImageIcon iconImg = new ImageIcon(getClass().getResource("Assets/icon.png"));
        setIconImage(iconImg.getImage());

        ImageIcon image = new ImageIcon(getClass().getResource("Assets/Lib.jpg"));
        JLabel img = new JLabel();
        img.setHorizontalAlignment(JLabel.CENTER);
        img.setVerticalAlignment(JLabel.CENTER);
        img.setIcon(image);
        setContentPane(img);
        img.setLayout(null);
        img.setVisible(true);
        
        setJMenuBar(MainMenu);
        MainMenu.add(menu);
        MainMenu.add(exit);

        
        menu.add(menu1);
        menu1.addActionListener(this);
        menu.add(menu2);
        menu2.addActionListener(this);
        exit.add(exit1);
        exit1.addActionListener(this);
        exit.add(exit2);
        exit2.addActionListener(this);
        
        
        JPanel panel = new JPanel();
        panel.setForeground(new Color(150, 75, 0));
        panel.setBorder(new TitledBorder(new LineBorder(new Color(150, 75, 0), 3), "Home-Page",
                TitledBorder.LEADING, TitledBorder.TOP, null, new Color(150, 75, 0)));
        panel.setBounds(160, 30, 1200, 755);
        panel.setBackground(new Color(255, 229, 180));

        ImageIcon arrowIcon1 = new ImageIcon("assets/addbook.jpg");
        ImageIcon arrowIcon2 = new ImageIcon("assets/addstudent.jpg");
        ImageIcon arrowIcon3 = new ImageIcon("assets/information.png");
        ImageIcon arrowIcon4 = new ImageIcon("assets/issuebooks.jpg");
        ImageIcon arrowIcon5 = new ImageIcon("assets/return.png");
        ImageIcon arrowIcon6 = new ImageIcon("assets/statistics.png");

        iconButton1 = new JButton(arrowIcon1);
        iconButton1.addActionListener(this);
        iconButton2 = new JButton(arrowIcon2);
        iconButton2.addActionListener(this);
        iconButton3 = new JButton(arrowIcon3);
        iconButton3.addActionListener(this);
        iconButton4 = new JButton(arrowIcon4);
        iconButton4.addActionListener(this);
        iconButton5 = new JButton(arrowIcon5);
        iconButton5.addActionListener(this);
        iconButton6 = new JButton(arrowIcon6);
        iconButton6.addActionListener(this);

        iconButton1.setText("ADD BOOK");
        iconButton2.setText("ADD STUDENT");
        iconButton3.setText("ABOUT US");
        iconButton4.setText("ISSUE BOOK");
        iconButton5.setText("RETURN BOOK");
        iconButton6.setText("STATISTICS");

        iconButton1.setPreferredSize(new Dimension(380, 350));
        iconButton2.setPreferredSize(new Dimension(380, 350));
        iconButton3.setPreferredSize(new Dimension(380, 350));
        iconButton4.setPreferredSize(new Dimension(380, 350));
        iconButton5.setPreferredSize(new Dimension(380, 350));
        iconButton6.setPreferredSize(new Dimension(380, 350));

        iconButton1.setBackground(Color.WHITE);
        iconButton2.setBackground(Color.WHITE);
        iconButton3.setBackground(Color.WHITE);
        iconButton4.setBackground(Color.WHITE);
        iconButton5.setBackground(Color.WHITE);
        iconButton6.setBackground(Color.WHITE);
        panel.add(iconButton1);
        panel.add(iconButton2);
        panel.add(iconButton3);
        panel.add(iconButton4);
        panel.add(iconButton5);
        panel.add(iconButton6);
        img.add(panel, BorderLayout.CENTER);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == iconButton1) {
            new AddBook().setVisible(true);
            this.setVisible(false);
        }

        if (ae.getSource() == iconButton2) {
            new AddStudent().setVisible(true);
            this.setVisible(false);
        }
        if (ae.getSource() == iconButton3) {
            new AboutUs().setVisible(true);
            this.setVisible(false);
        }
        if (ae.getSource() == iconButton4) {
            new IssueBook().setVisible(true);
            this.setVisible(false);
        }
        if (ae.getSource() == iconButton5) {
            new ReturnBook().setVisible(true);
            this.setVisible(false);
        }
        if (ae.getSource() == iconButton6) {
            new Statistics().setVisible(true);
            this.setVisible(false);
        }
        if (ae.getSource() == menu1) {
            new BookDetails().setVisible(true);
            this.setVisible(false);
        }
        if (ae.getSource() == menu2) {
            new StudentDetails().setVisible(true);
            this.setVisible(false);
        }
        if (ae.getSource() == exit1) {
            new Login().setVisible(true);
            this.setVisible(false);
        }
        if (ae.getSource() == exit2) {
            this.setVisible(false);
        }
    }
    public static void main(String args[]) {
        new Home().setVisible(true);
    }
}
