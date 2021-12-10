import java.sql.PreparedStatement;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class SignUp extends JFrame implements ActionListener {
    JPanel loginPanel;
    JTextField userField, nameField, answerField;
    JPasswordField passField;
    JLabel userLabel, nameLabel, quesLabel, answerLabel, passLabel;
    JButton create, back;
    JComboBox<String> quesBox;

    SignUp() {
        setLayout(null);
        setResizable(false);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setTitle("LIBRARY MANAGEMENT SYSTEM");

        ImageIcon iconImg = new ImageIcon(getClass().getResource("Assets/icon.png")); 
        setIconImage(iconImg.getImage());

        ImageIcon image = new ImageIcon(getClass().getResource("Assets/Lib.jpg"));
        JLabel img = new JLabel();
        img.setIcon(image);
        img.setHorizontalAlignment(JLabel.CENTER);
        img.setVerticalAlignment(JLabel.CENTER);

        userLabel = new JLabel("USERNAME: ");
        userLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        userLabel.setForeground(Color.BLACK);
        userLabel.setBounds(520, 240, 125, 40);

        userField = new JTextField();
        userField.setFont(new Font("Serif", Font.BOLD, 18));
        userField.setBounds(790, 250, 190, 25);

        nameLabel = new JLabel("NAME: ");
        nameLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        nameLabel.setForeground(Color.BLACK);
        nameLabel.setBounds(520, 290, 125, 40);

        nameField = new JTextField();
        nameField.setFont(new Font("Serif", Font.BOLD, 18));
        nameField.setBounds(790, 300, 190, 25);

        passLabel = new JLabel("PASSWORD: ");
        passLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        passLabel.setForeground(Color.BLACK);
        passLabel.setBounds(520, 340, 125, 40);

        passField = new JPasswordField();
        passField.setBounds(790, 350, 190, 25);
        passField.setFont(new Font("Serif", Font.PLAIN, 18));

        quesLabel = new JLabel("SECURITY QUESTION: ");
        quesLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        quesLabel.setForeground(Color.BLACK);
        quesLabel.setBounds(520, 390, 215, 40);

        quesBox = new JComboBox<String>();
        quesBox.setModel(new DefaultComboBoxModel<>(
                new String[] { "Your Nickname ?", "Your Lucky Number ?", "Your Fovourite Superhero ?",
                        "Your Fovourite Book ?", "Your Fovourite Destination ?", "Name Of Your Best Friend ?" }));
        quesBox.setBounds(790, 400, 190, 25);

        answerLabel = new JLabel("ANSWER: ");
        answerLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        answerLabel.setForeground(Color.BLACK);
        answerLabel.setBounds(520, 440, 185, 40);

        answerField = new JTextField();
        answerField.setFont(new Font("Serif", Font.BOLD, 18));
        answerField.setBounds(790, 450, 190, 25);

        create = new JButton("Create");
        create.setFont(new Font("Tahoma", Font.BOLD, 16));
        create.setForeground(Color.white);
        create.setBackground(Color.black);
        create.setBounds(780, 490, 90, 40);
        create.addActionListener(this);

        back = new JButton("Back");
        back.setFont(new Font("Tahoma", Font.BOLD, 16));
        back.setForeground(Color.white);
        back.setBackground(Color.black);
        back.setBounds(900, 490, 90, 40);
        back.addActionListener(this);
        setContentPane(img);
        img.add(userLabel);
        img.add(userField);
        img.add(nameLabel);
        img.add(nameField);
        img.add(passLabel);
        img.add(passField);
        img.add(quesLabel);
        img.add(quesBox);
        img.add(answerLabel);
        img.add(answerField);
        img.add(create);
        img.add(back);

        JPanel panel = new JPanel();
        panel.setForeground(new Color(150, 75, 0));
        panel.setBorder(new TitledBorder(new LineBorder(new Color(150, 75, 0), 3), "Create-Account",
                TitledBorder.LEADING, TitledBorder.TOP, null, new Color(150, 75, 0)));
        panel.setBounds(475, 220, 565, 345);
        panel.setBackground(new Color(255, 229, 180));
        img.add(panel);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        try {
            connect conn = new connect();
            if (ae.getSource() == create) {
                String sql = "insert into user(Username, Name, Password, Security_Question, Answer) values(?, ?, ?, ?, ?)";
                PreparedStatement st = conn.c.prepareStatement(sql);
        
                st.setString(1, userField.getText());
                st.setString(2, nameField.getText());
                st.setString(3, String.valueOf(passField.getPassword()));
                st.setString(4, (String) quesBox.getSelectedItem());
                st.setString(5, answerField.getText());
        
                int i = st.executeUpdate();
                if (i > 0){
                    JOptionPane.showMessageDialog(null, "successfully Created. You will be switched to Login Page.");
                    setVisible(false);
                    new Login();
                }
                st.close();
                conn.c.close();
            }
            if (ae.getSource() == back) {
                setVisible(false);
                new Login();
            }
        } catch (Exception e) {
            System.out.println("Error occured");
        }
    }

    public static void main(String args[]) {

        new SignUp();
    }
}
