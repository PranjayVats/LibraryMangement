import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JPanel loginPanel;
    JTextField userField;
    JPasswordField passField;
    JLabel userLabel, passLabel, forgotPassLabel;
    JButton login, signUp, forgotPassword;

    Login() {
        // Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        // int width = (int)size.getWidth();
        // int height = (int)size.getHeight();
        // System.out.println(width+" " +height);

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
        

        userLabel = new JLabel("Username: ");
        userLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        userLabel.setForeground(Color.BLACK);
        userLabel.setBounds(550, 330, 115, 40);

        userField = new JTextField();
        userField.setFont(new Font("Serif", Font.BOLD, 20));
        userField.setBounds(750, 335, 190, 30);

        passLabel = new JLabel("Password: ");
        passLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        passLabel.setForeground(Color.BLACK);
        passLabel.setBounds(550, 380, 115, 30);

        passField = new JPasswordField();
        passField.setBounds(750, 385, 190, 30);
        passField.setFont(new Font("Serif", Font.PLAIN, 20));

        login = new JButton("LOGIN");
        login.setFont(new Font("Tahoma", Font.BOLD, 16));
        login.setForeground(new Color(	2, 75, 48));
        login.setBounds(735, 445, 100, 30);
        login.addActionListener(this);

        signUp = new JButton("SIGN UP");
        signUp.setFont(new Font("Tahoma", Font.BOLD, 16));
        signUp.setForeground(new Color(	2, 75, 48));
        signUp.setBounds(850, 445, 105, 30);
        signUp.addActionListener(this);

        forgotPassword = new JButton("Forgot Password");
        forgotPassword.setFont(new Font("Tahoma", Font.PLAIN, 17));
        forgotPassword.setForeground(Color.red);
        forgotPassword.setBounds(755, 495, 180, 30);
        forgotPassword.addActionListener(this);

        img.add(userLabel);
        img.add(userField);
        img.add(passLabel);
        img.add(passField);
        img.add(login);
        img.add(signUp);
        img.add(forgotPassword);
        
        JPanel panel = new JPanel();
        panel.setForeground(new Color(150, 75, 0));
        panel.setBorder(new TitledBorder(new LineBorder(new Color(150, 75, 0), 3), "Login-Account",
                TitledBorder.LEADING, TitledBorder.TOP, null, new Color(150, 75, 0)));
        panel.setBounds(500, 265, 532, 315);
        panel.setBackground(new Color(255, 229, 180));
        img.add(panel);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            try {
                connect conn = new connect();
                String sql = "select * from db.user where Username=? and Password=?";
                PreparedStatement st = conn.c.prepareStatement(sql);
                st.setString(1, userField.getText());
                st.setString(2, String.valueOf(passField.getPassword()));
                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                    new Home().setVisible(true);
                    this.setVisible(false);
                } 
                else {
                    JOptionPane.showMessageDialog(null, "Invalid Login");
                    new Login().setVisible(true);
                    this.setVisible(false);
                }
                rs.close();
                conn.c.close();
                st.close();
            } 
            catch (Exception e) {
            }
        }
        if (ae.getSource() == signUp) {
            this.setVisible(false);
            new SignUp();
        }
        if (ae.getSource() == forgotPassword) {
            this.setVisible(false);
            new ForgotPassword();
        }

    }

    public static void main(String args[]) {
        new Login();
    }
}
