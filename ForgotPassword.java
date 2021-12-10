import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class ForgotPassword extends JFrame implements ActionListener{
    JPanel loginPanel;
    JTextField userField, nameField, answerField ,passField;
    JLabel userLabel, nameLabel, quesLabel, answerLabel, passLabel;
    JButton search, retrieve, back; 
    JTextField quesBox;
    
    ForgotPassword(){
        setLayout(null);
        setResizable(false);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setTitle("LIBRARY MANAGEMENT SYSTEM");

        ImageIcon iconImg = new ImageIcon(getClass().getResource("Assets/icon.png")); 
        setIconImage(iconImg.getImage());

        ImageIcon image = new ImageIcon(getClass().getResource("Assets/Lib.jpg"));
        JLabel img= new JLabel();
        img.setIcon(image);
        img.setHorizontalAlignment(JLabel.CENTER);
        img.setVerticalAlignment(JLabel.CENTER);

     
        userLabel = new JLabel("USERNAME: ");
        userLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        userLabel.setForeground(Color.BLACK);
        userLabel.setBounds(500, 240, 125, 40);

        userField = new JTextField();
        userField.setFont(new Font("Serif", Font.BOLD, 18));
        userField.setBounds(730, 250, 190, 25);

        nameLabel = new JLabel("NAME: ");
        nameLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        nameLabel.setForeground(Color.BLACK);
        nameLabel.setBounds(500, 290, 125, 40);

        nameField = new JTextField();
        nameField.setFont(new Font("Serif", Font.BOLD, 18));
        nameField.setEditable(false);
        nameField.setBounds(730, 300, 190, 25);

        quesLabel = new JLabel("SECURITY QUESTION: ");
        quesLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        quesLabel.setForeground(Color.BLACK);
        quesLabel.setBounds(500, 340, 240, 40);
        

        quesBox = new JTextField();
        quesBox.setFont(new Font("Serif", Font.BOLD, 18));
        quesBox.setEditable(false);
        quesBox.setBounds(730, 350, 300, 25);
        
        answerLabel = new JLabel("ANSWER: ");
        answerLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        answerLabel.setForeground(Color.BLACK);
        answerLabel.setBounds(500, 390, 215, 40);
        
        answerField = new JTextField();
        answerField.setBounds(730, 400, 190, 25);
        answerField.setFont(new Font("Serif", Font.BOLD, 18));
        
        passLabel = new JLabel("PASSWORD: ");
        passLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        passLabel.setForeground(Color.BLACK);
        passLabel.setBounds(500, 440, 185, 40);
        
         
        passField = new JTextField();
        passField.setEditable(false);
        passField.setFont(new Font("Serif", Font.PLAIN, 18));
        passField.setBounds(730, 450, 190, 25);



        search = new JButton("Search");
        search.setFont(new Font("Tahoma", Font.BOLD, 15));
        search.setForeground(Color.white);
        search.setBackground(Color.black);
        search.setBounds(930, 250, 90,25);
        search.addActionListener(this);

        retrieve = new JButton("Retrieve");
        retrieve.setFont(new Font("Tahoma", Font.BOLD, 15));
        retrieve.setForeground(Color.white);
        retrieve.setBackground(Color.black);
        retrieve.setBounds(930, 450, 100,25);
        retrieve.addActionListener(this);

        back = new JButton("Back");
        back.setFont(new Font("Tahoma", Font.BOLD, 16));
        back.setForeground(Color.white);
        back.setBackground(Color.black);
        back.setBounds(750, 500, 90, 35);
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
        img.add(answerField );
        img.add(search);
        img.add(retrieve);
        img.add(back);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(new Color(150, 75, 0), 3), "Forgot-Password",
                TitledBorder.LEADING, TitledBorder.TOP, null, new Color(150, 75, 0)));
        panel.setBounds(455, 210, 605, 355);
        panel.setBackground(new Color(255, 229, 180));
        img.add(panel);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent ae){
        try{
            connect conn = new connect();
            if(ae.getSource()==search){
                String sql = "select * from db.user where Username=?";
		        PreparedStatement st = conn.c.prepareStatement(sql);

		        st.setString(1, userField.getText());
		        ResultSet rs = st.executeQuery();

		        while (rs.next()) {
                    nameField.setText(rs.getString("Name"));
                    quesBox.setText(rs.getString("Security_Question"));
                    rs.close();
                    st.close();
                    conn.c.close();
		        }
            }  
            if(ae.getSource()==retrieve){
                String sql = "select * from db.user where Answer=?";
                PreparedStatement st = conn.c.prepareStatement(sql);

                st.setString(1, answerField.getText());
                ResultSet rs = st.executeQuery();

                while (rs.next()) {
                    passField.setText(rs.getString("Password"));
                }
                rs.close();
                st.close();
            }  
            if(ae.getSource()==back){
                new Login().setVisible(true);;
                this.setVisible(false);
            }   
           
        }        
        catch (Exception e) {
            System.out.println("Error occured");
        }
    }

    public static void main(String args[]){
        
       new ForgotPassword();
    }
}
