import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class AddStudent extends JFrame implements ActionListener {
    private JTextField t1, t2, t3;
    private JComboBox<String> comboBox, comboBox_1, comboBox_2, comboBox_3;
    JButton b1, b2;

    public static void main(String[] args) {
        new AddStudent().setVisible(true);
    }

    public void random() {
        Random rd = new Random();
        t1.setText("" + rd.nextInt(10000 + 1));
    }

    public AddStudent() {
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
        JLabel l1 = new JLabel("Student_id");
        l1.setForeground(new Color(0, 0, 0));
        l1.setFont(new Font("Tahoma", Font.BOLD, 16));
        l1.setBounds(550, 266, 90, 22);
        contentPane.add(l1);

        JLabel l2 = new JLabel("Name");
        l2.setForeground(new Color(0, 0, 0));
        l2.setFont(new Font("Tahoma", Font.BOLD, 16));
        l2.setBounds(550, 300, 90, 22);
        contentPane.add(l2);

        JLabel l3 = new JLabel("Father's Name");
        l3.setForeground(new Color(0, 0, 0));
        l3.setFont(new Font("Tahoma", Font.BOLD, 16));
        l3.setBounds(550, 334, 150, 22);
        contentPane.add(l3);

        JLabel l4 = new JLabel("Course");
        l4.setForeground(new Color(0, 0, 0));
        l4.setFont(new Font("Tahoma", Font.BOLD, 16));
        l4.setBounds(550, 368, 90, 22);
        contentPane.add(l4);

        JLabel l5 = new JLabel("Branch");
        l5.setForeground(new Color(0, 0, 0));
        l5.setFont(new Font("Tahoma", Font.BOLD, 16));
        l5.setBounds(550, 402, 90, 22);
        contentPane.add(l5);

        JLabel l6 = new JLabel("Year");
        l6.setForeground(new Color(0, 0, 0));
        l6.setFont(new Font("Tahoma", Font.BOLD, 16));
        l6.setBounds(550, 436, 90, 22);
        contentPane.add(l6);

        JLabel l7 = new JLabel("Semester");
        l7.setForeground(new Color(0, 0, 0));
        l7.setFont(new Font("Tahoma", Font.BOLD, 16));
        l7.setBounds(550, 470, 90, 22);
        contentPane.add(l7);

        t1 = new JTextField();
        t1.setEditable(false);
        t1.setForeground(new Color(47, 79, 79));
        t1.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        t1.setBounds(700, 268, 198, 24);
        contentPane.add(t1);
        t1.setColumns(10);

        t2 = new JTextField();
        t2.setForeground(new Color(47, 79, 79));
        t2.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        t2.setColumns(10);
        t2.setBounds(700, 302, 198, 24);
        contentPane.add(t2);

        t3 = new JTextField();
        t3.setForeground(new Color(47, 79, 79));
        t3.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        t3.setColumns(10);
        t3.setBounds(700, 336, 198, 24);
        contentPane.add(t3);

        comboBox = new JComboBox<String>();
        comboBox.setModel(new DefaultComboBoxModel<>(
                new String[] { "B.E", "B.Tech", "M.Tech", "MBA", "BBA", "BCA", "B.Sc", "M.Sc", "B.Com", "M.Com" }));
        comboBox.setForeground(new Color(47, 79, 79));
        comboBox.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        comboBox.setBounds(700, 370, 198, 24);
        contentPane.add(comboBox);

        comboBox_1 = new JComboBox<String>();
        comboBox_1.setModel(new DefaultComboBoxModel<>(
                new String[] { "None", "Mechanical", "CSE", "IT", "Civil", "Automobile", "EEE", "Other" }));
        comboBox_1.setForeground(new Color(47, 79, 79));
        comboBox_1.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        comboBox_1.setBounds(700, 404, 198, 24);
        contentPane.add(comboBox_1);

        comboBox_2 = new JComboBox<String>();
        comboBox_2.setModel(new DefaultComboBoxModel<>(new String[] { "First", "Second", "Third", "Four" }));
        comboBox_2.setForeground(new Color(47, 79, 79));
        comboBox_2.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        comboBox_2.setBounds(700, 438, 198, 24);
        contentPane.add(comboBox_2);

        comboBox_3 = new JComboBox<String>();
        comboBox_3.setModel(new DefaultComboBoxModel<>(new String[] {
                "1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th" }));
        comboBox_3.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        comboBox_3.setForeground(new Color(47, 79, 79));
        comboBox_3.setBounds(700, 472, 198, 24);
        contentPane.add(comboBox_3);

        b1 = new JButton("ADD");
        b1.addActionListener(this);
        b1.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        b1.setBounds(600, 516, 110, 33);
        b1.setBackground(new Color(89,39,32));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        contentPane.add(b1);

        b2 = new JButton("Back");
        b2.addActionListener(this);
        b2.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        b2.setBounds(760, 516, 110, 33);
        b2.setBackground(new Color(89,39,32));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        contentPane.add(b2);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(new Color(150, 75, 0), 2), "Add Student", TitledBorder.LEADING,
                TitledBorder.TOP, null, new Color(150, 75, 0)));
        panel.setBounds(450, 216, 600, 400);
        panel.setBackground(new Color(255, 229, 180));
        contentPane.add(panel);
        random();
    }

    public void actionPerformed(ActionEvent ae) {

        try {
            if (ae.getSource() == b1) {
                try {
                    connect conn = new connect();
                    String sql = "Insert into db.student(Student_Id, Name, Father_Name, Course, Branch, Year, Semester) values(?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement st = conn.c.prepareStatement(sql);
                    st.setString(1, t1.getText());
                    st.setString(2, t2.getText());
                    st.setString(3, t3.getText());
                    st.setString(4, (String) comboBox.getSelectedItem());
                    st.setString(5, (String) comboBox_1.getSelectedItem());
                    st.setString(6, (String) comboBox_2.getSelectedItem());
                    st.setString(7, (String) comboBox_3.getSelectedItem());

                    int i = st.executeUpdate();
                    if (i > 0) {
                        JOptionPane.showMessageDialog(null, "Successfully Added");
                        new AddStudent().setVisible(true);
                        this.setVisible(false);
                        
                    } else
                        JOptionPane.showMessageDialog(null, "error");

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if (ae.getSource() == b2) {
                new Home().setVisible(true);
                this.setVisible(false);
               
            }
        } catch (Exception e) {

        }
    }
}
