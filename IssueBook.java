import java.awt.*;
import java.sql.PreparedStatement;
import java.util.Date;
import javax.swing.*;
import java.text.SimpleDateFormat;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
public class IssueBook extends JFrame implements ActionListener {

    private JLabel contentPane;
    private JTextField t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, dt;
    private JButton b1, b2, b3, b4;
    Date thisDate;

    public static void main(String[] args) {
        new IssueBook().setVisible(true);
    }

    public IssueBook() {
        thisDate = new Date();
        SimpleDateFormat dateForm = new SimpleDateFormat("dd/MM/Y");
        // setBounds(300, 200, 900, 500);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("LIBRARY MANAGEMENT SYSTEM");
        ImageIcon iconImg = new ImageIcon(getClass().getResource("Assets/icon.png"));
        setIconImage(iconImg.getImage());

        contentPane = new JLabel();
        ImageIcon image = new ImageIcon(getClass().getResource("Assets/Lib.jpg"));
        contentPane.setHorizontalAlignment(JLabel.CENTER);
        contentPane.setVerticalAlignment(JLabel.CENTER);
        contentPane.setIcon(image);
        setContentPane(contentPane);
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(null);

        JLabel l1 = new JLabel("Book_id");
        l1.setFont(new Font("Tahoma", Font.BOLD, 14));
        l1.setForeground(new Color(47, 79, 79));
        l1.setBounds(400, 263, 100, 23);
        contentPane.add(l1);

        JLabel l2 = new JLabel("Name");
        l2.setForeground(new Color(47, 79, 79));
        l2.setFont(new Font("Tahoma", Font.BOLD, 14));
        l2.setBounds(397, 297, 100, 23);
        contentPane.add(l2);

        JLabel l3 = new JLabel("ISBN");
        l3.setForeground(new Color(47, 79, 79));
        l3.setFont(new Font("Tahoma", Font.BOLD, 14));
        l3.setBounds(397, 331, 100, 23);
        contentPane.add(l3);

        JLabel l4 = new JLabel("Publisher");
        l4.setForeground(new Color(47, 79, 79));
        l4.setFont(new Font("Tahoma", Font.BOLD, 14));
        l4.setBounds(397, 365, 100, 23);
        contentPane.add(l4);

        JLabel l5 = new JLabel("Edition");
        l5.setForeground(new Color(47, 79, 79));
        l5.setFont(new Font("Tahoma", Font.BOLD, 14));
        l5.setBounds(397, 399, 100, 23);
        contentPane.add(l5);

        JLabel l6 = new JLabel("Price");
        l6.setForeground(new Color(47, 79, 79));
        l6.setFont(new Font("Tahoma", Font.BOLD, 14));
        l6.setBounds(397, 433, 100, 23);
        contentPane.add(l6);

        JLabel l7 = new JLabel("Pages");
        l7.setForeground(new Color(47, 79, 79));
        l7.setFont(new Font("Tahoma", Font.BOLD, 14));
        l7.setBounds(397, 467, 100, 23);
        contentPane.add(l7);

        t1 = new JTextField();
        t1.setForeground(new Color(47, 79, 79));
        t1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t1.setBounds(480, 263, 86, 20);
        contentPane.add(t1);

        b1 = new JButton("Search");
        b1.addActionListener(this);
        b1.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        b1.setBounds(580, 263, 100, 30);

        contentPane.add(b1);

        t2 = new JTextField();
        t2.setEditable(false);
        t2.setForeground(new Color(47, 79, 79));
        t2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t2.setBounds(480, 300, 208, 20);
        contentPane.add(t2);
        t2.setColumns(10);

        t3 = new JTextField();
        t3.setEditable(false);
        t3.setForeground(new Color(47, 79, 79));
        t3.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t3.setColumns(10);
        t3.setBounds(480, 331, 208, 20);
        contentPane.add(t3);

        t4 = new JTextField();
        t4.setEditable(false);
        t4.setForeground(new Color(47, 79, 79));
        t4.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t4.setColumns(10);
        t4.setBounds(480, 368, 208, 20);
        contentPane.add(t4);

        t5 = new JTextField();
        t5.setEditable(false);
        t5.setForeground(new Color(47, 79, 79));
        t5.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t5.setColumns(10);
        t5.setBounds(480, 402, 208, 20);
        contentPane.add(t5);

        t6 = new JTextField();
        t6.setEditable(false);
        t6.setForeground(new Color(47, 79, 79));
        t6.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t6.setColumns(10);
        t6.setBounds(480, 436, 208, 20);
        contentPane.add(t6);

        t7 = new JTextField();
        t7.setEditable(false);
        t7.setForeground(new Color(47, 79, 79));
        t7.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t7.setColumns(10);
        t7.setBounds(480, 470, 208, 20);
        contentPane.add(t7);

        JLabel l15 = new JLabel(" Date of Issue :");
        l15.setForeground(new Color(105, 105, 105));
        l15.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        l15.setBounds(400, 510, 118, 26);
        contentPane.add(l15);
        dt = new JTextField();
        dt.setBounds(520, 510, 118, 26);
        String currDate = dateForm.format(thisDate);
        dt.setText(currDate);
        dt.setEditable(false);
        contentPane.add(dt);

        // dateChooser = new JDateChooser();
        // dateChooser.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        // dateChooser.setForeground(new Color(105, 105, 105));
        // dateChooser.setBounds(137, 337, 200, 29);
        // contentPane.add(dateChooser);

        b3 = new JButton("Issue");
        b3.addActionListener(this);
        b3.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        b3.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
        b3.setBounds(407, 547, 118, 33);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        contentPane.add(b3);

        b4 = new JButton("Back");
        b4.addActionListener(this);
        b4.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        b4.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
        b4.setBounds(549, 547, 100, 33);
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        contentPane.add(b4);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(new Color(150, 75, 0), 2, true), "Issue-Book",
                TitledBorder.LEADING, TitledBorder.TOP, null, new Color(150, 75, 0)));
        panel.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.setBounds(350, 220, 400, 380);
        panel.setBackground(new Color(255, 229, 180));
        contentPane.add(panel);

        JLabel l8 = new JLabel("Student_id");
        l8.setForeground(new Color(47, 79, 79));
        l8.setFont(new Font("Tahoma", Font.BOLD, 14));
        l8.setBounds(830, 260, 100, 23);
        contentPane.add(l8);

        JLabel l9 = new JLabel("Name");
        l9.setForeground(new Color(47, 79, 79));
        l9.setFont(new Font("Tahoma", Font.BOLD, 14));
        l9.setBounds(830, 300, 100, 23);
        contentPane.add(l9);

        JLabel l10 = new JLabel("Father's Name");
        l10.setForeground(new Color(47, 79, 79));
        l10.setFont(new Font("Tahoma", Font.BOLD, 14));
        l10.setBounds(830, 340, 140, 23);
        contentPane.add(l10);

        JLabel l11 = new JLabel("Course");
        l11.setForeground(new Color(47, 79, 79));
        l11.setFont(new Font("Tahoma", Font.BOLD, 14));
        l11.setBounds(830, 380, 100, 23);
        contentPane.add(l11);

        JLabel l12 = new JLabel("Branch");
        l12.setForeground(new Color(47, 79, 79));
        l12.setFont(new Font("Tahoma", Font.BOLD, 14));
        l12.setBounds(830, 420, 100, 23);
        contentPane.add(l12);

        JLabel l13 = new JLabel("Year");
        l13.setForeground(new Color(47, 79, 79));
        l13.setFont(new Font("Tahoma", Font.BOLD, 14));
        l13.setBounds(830, 460, 100, 23);
        contentPane.add(l13);

        JLabel l14 = new JLabel("Semester");
        l14.setForeground(new Color(47, 79, 79));
        l14.setFont(new Font("Tahoma", Font.BOLD, 14));
        l14.setBounds(830, 500, 100, 23);
        contentPane.add(l14);

        t8 = new JTextField();
        t8.setForeground(new Color(47, 79, 79));
        t8.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t8.setColumns(10);
        t8.setBounds(945, 265, 86, 20);
        contentPane.add(t8);

        b2 = new JButton("Search");
        b2.addActionListener(this);
        b2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        b2.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
        b2.setBounds(1045, 260, 100, 28);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        contentPane.add(b2);

        t9 = new JTextField();
        t9.setForeground(new Color(47, 79, 79));
        t9.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t9.setEditable(false);
        t9.setColumns(10);
        t9.setBounds(945, 305, 208, 20);
        contentPane.add(t9);

        t10 = new JTextField();
        t10.setForeground(new Color(47, 79, 79));
        t10.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t10.setEditable(false);
        t10.setColumns(10);
        t10.setBounds(945, 345, 208, 20);
        contentPane.add(t10);

        t11 = new JTextField();
        t11.setForeground(new Color(47, 79, 79));
        t11.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t11.setEditable(false);
        t11.setColumns(10);
        t11.setBounds(945, 385, 208, 20);
        contentPane.add(t11);

        t12 = new JTextField();
        t12.setForeground(new Color(47, 79, 79));
        t12.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t12.setEditable(false);
        t12.setColumns(10);
        t12.setBounds(945, 425, 208, 20);
        contentPane.add(t12);

        t13 = new JTextField();
        t13.setForeground(new Color(47, 79, 79));
        t13.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t13.setEditable(false);
        t13.setColumns(10);
        t13.setBounds(945, 465, 208, 20);
        contentPane.add(t13);

        t14 = new JTextField();
        t14.setForeground(new Color(47, 79, 79));
        t14.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t14.setEditable(false);
        t14.setColumns(10);
        t14.setBounds(945, 505, 208, 20);
        contentPane.add(t14);

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new TitledBorder(new LineBorder(new Color(150, 75, 0), 2, true), "Student-Details",
                TitledBorder.LEADING, TitledBorder.TOP, null, new Color(150, 75, 0)));
        panel_1.setForeground(new Color(0, 100, 0));
        panel_1.setBounds(780, 220, 420, 380);
        panel_1.setBackground(new Color(255, 229, 180));
        contentPane.add(panel_1);

    }

    public void actionPerformed(ActionEvent ae) {
        try {
            connect con = new connect();
            if (ae.getSource() == b1) {
                String sql = "select * from db.book where Book_Id = ?";
                PreparedStatement st = con.c.prepareStatement(sql);
                st.setString(1, t1.getText());
                ResultSet rs = st.executeQuery();

                while (rs.next()) {
                    t2.setText(rs.getString("name"));
                    t3.setText(rs.getString("isbn"));
                    t4.setText(rs.getString("publisher"));
                    t5.setText(rs.getString("edition"));
                    t6.setText(rs.getString("price"));
                    t7.setText(rs.getString("pages"));
                }
                st.close();
                rs.close();

            }
            if (ae.getSource() == b2) {
                String sql = "select * from db.student where Student_Id = ?";
                PreparedStatement st = con.c.prepareStatement(sql);
                st.setString(1, t8.getText());
                ResultSet rs = st.executeQuery();

                while (rs.next()) {
                    t9.setText(rs.getString("name"));
                    t10.setText(rs.getString("father_name"));
                    t11.setText(rs.getString("course"));
                    t12.setText(rs.getString("branch"));
                    t13.setText(rs.getString("year"));
                    t14.setText(rs.getString("semester"));
                }
                st.close();
                rs.close();

            }
            if (ae.getSource() == b3) {
                try {
                    String sql = "insert into db.issuebook(Book_Id, Student_Id, BookName, StudentName, Course, Branch, DateOfIssue) values(?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement st = con.c.prepareStatement(sql);
                    st.setString(1, t1.getText());
                    st.setString(2, t8.getText());
                    st.setString(3, t2.getText());
                    st.setString(4, t9.getText());
                    st.setString(5, t11.getText());
                    st.setString(6, t12.getText());
                    st.setString(7, dt.getText());
                    int i = st.executeUpdate();
                    if (i > 0){
                        JOptionPane.showMessageDialog(null, "Successfully Book Issued..!");
                        new Home().setVisible(true);
                        this.setVisible(false);
                    }else{
                        JOptionPane.showMessageDialog(null, "error");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Book already issued or unavailable!");
                }
            }
            if (ae.getSource() == b4) {
                new Home().setVisible(true);
                this.setVisible(false);
            }

            con.c.close();
        } catch (Exception e) {

        }
    }
}