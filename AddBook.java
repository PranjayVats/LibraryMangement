import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.util.*;

public class AddBook extends JFrame implements ActionListener {
    private JTextField t1, t2, t3, t4, t6, t7;
    private JButton b1, b2;
    JComboBox<String> comboBox;

    public static void main(String[] args) {
        new AddBook().setVisible(true);
    }

    public void random() {
        Random rd = new Random();
        t1.setText("" + rd.nextInt(1000 + 1));
    }

    public AddBook() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("LIBRARY MANAGEMENT SYSTEM");
        ImageIcon iconImg = new ImageIcon(getClass().getResource("Assets/icon.png"));
        setIconImage(iconImg.getImage());

        ImageIcon image = new ImageIcon(getClass().getResource("Assets/Lib.jpg"));
        JLabel contentPane = new JLabel();
        contentPane.setHorizontalAlignment(JLabel.CENTER);
        contentPane.setVerticalAlignment(JLabel.CENTER);
        contentPane.setIcon(image);
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setVisible(true);
        JLabel l1 = new JLabel("Book_Id");
        l1.setForeground(new Color(0, 0, 0));
        l1.setFont(new Font("Tahoma", Font.BOLD, 16));
        l1.setBounds(550, 266, 90, 22);
        contentPane.add(l1);

        JLabel l2 = new JLabel("Name");
        l2.setForeground(new Color(0, 0, 0));
        l2.setFont(new Font("Tahoma", Font.BOLD, 16));
        l2.setBounds(550, 300, 90, 22);
        contentPane.add(l2);

        JLabel l3 = new JLabel("ISBN");
        l3.setForeground(new Color(0, 0, 0));
        l3.setFont(new Font("Tahoma", Font.BOLD, 16));
        l3.setBounds(550, 334, 90, 22);
        contentPane.add(l3);

        JLabel l4 = new JLabel("Publisher");
        l4.setForeground(new Color(0, 0, 0));
        l4.setFont(new Font("Tahoma", Font.BOLD, 16));
        l4.setBounds(550, 368, 90, 22);
        contentPane.add(l4);

        JLabel l5 = new JLabel("Edition");
        l5.setForeground(new Color(0, 0, 0));
        l5.setFont(new Font("Tahoma", Font.BOLD, 16));
        l5.setBounds(550, 402, 90, 22);
        contentPane.add(l5);

        JLabel l6 = new JLabel("Price");
        l6.setForeground(new Color(0, 0, 0));
        l6.setFont(new Font("Tahoma", Font.BOLD, 16));
        l6.setBounds(550, 436, 90, 22);
        contentPane.add(l6);

        JLabel l7 = new JLabel("Pages");
        l7.setForeground(new Color(0, 0, 0));
        l7.setFont(new Font("Tahoma", Font.BOLD, 16));
        l7.setBounds(550, 470, 90, 22);
        contentPane.add(l7);


        t1 = new JTextField();
        t1.setEditable(false);
        t1.setForeground(new Color(0, 0, 0));
        t1.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        t1.setBounds(700, 268, 198, 24);
        contentPane.add(t1);
        t1.setColumns(10);

        t2 = new JTextField();
        t2.setForeground(new Color(0, 0, 0));
        t2.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        t2.setColumns(10);
        t2.setBounds(700, 302, 198, 24);
        contentPane.add(t2);

        t3 = new JTextField();
        t3.setForeground(new Color(0, 0, 0));
        t3.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        t3.setColumns(10);
        t3.setBounds(700, 336, 198, 24);
        contentPane.add(t3);

        t4 = new JTextField();
        t4.setForeground(new Color(0, 0, 0));
        t4.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        t4.setColumns(10);
        t4.setBounds(700, 370, 198, 24);
        contentPane.add(t4);

        comboBox = new JComboBox<String>();
        comboBox.setModel(new DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        comboBox.setBounds(700, 404, 198, 24);
        contentPane.add(comboBox);

        t6 = new JTextField();
        t6.setForeground(new Color(0, 0, 0));
        t6.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        t6.setColumns(10);
        t6.setBounds(700, 438, 198, 24);
        contentPane.add(t6);

        t7 = new JTextField();
        t7.setForeground(new Color(0, 0, 0));
        t7.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        t7.setColumns(10);
        t7.setBounds(700, 472, 198, 24);
        contentPane.add(t7);

        b1 = new JButton("Add");
        b1.addActionListener(this);
        b1.setBorder(new CompoundBorder(new LineBorder(new Color(128, 128, 128)), null));
        b1.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        b1.setBounds(600, 516, 110, 33);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        contentPane.add(b1);

        b2 = new JButton("Back");
        b2.addActionListener(this);
        b2.setBorder(new CompoundBorder(new LineBorder(new Color(105, 105, 105)), null));
        b2.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        b2.setBounds(760, 516, 110, 33);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        contentPane.add(b2);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(new Color(150, 75, 0), 2), "Add Books", TitledBorder.LEADING,
                TitledBorder.TOP, null, new Color(150, 75, 0)));
        panel.setBounds(450, 216, 600, 400);
        panel.setBackground(new Color(255, 229, 180));
        contentPane.add(panel);

        random();

    }

    public void actionPerformed(ActionEvent ae) {

        try {
            connect conn = new connect();
            if (ae.getSource() == b1) {
                String sql = "Insert into db.book(Book_Id, Name, ISBN, Publisher, Edition, Price, Pages) values(?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement st = conn.c.prepareStatement(sql);
                st.setString(1, t1.getText());
                st.setString(2, t2.getText());
                st.setString(3, t3.getText());
                st.setString(4, t4.getText());
                st.setString(5, (String) comboBox.getSelectedItem());
                st.setString(6, t6.getText());
                st.setString(7, t7.getText());

                int rs = st.executeUpdate();
                if (rs > 0){
                    JOptionPane.showMessageDialog(null, "Successfully Added");
                    new AddBook().setVisible(true);
                    this.setVisible(false);
                }
                    
                else{
                    JOptionPane.showMessageDialog(null, "Error");
                }    
                st.close();
            }
            if (ae.getSource() == b2) {
                
                new Home().setVisible(true);
                this.setVisible(false);
            }

            conn.c.close();
        } catch (Exception e) {

        }

    }
}