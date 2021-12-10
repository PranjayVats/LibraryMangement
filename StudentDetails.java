import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.JTable;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentDetails extends JFrame implements ActionListener {

    private JTable table;
    private JTextField search;
    private JButton b1, b2, b3;
    private DefaultTableModel tablemodel;
    private JLabel contentPane;
    private JScrollPane scrollPane;
    private JPanel p1, p2;

    public static void main(String[] args) {
        new StudentDetails().setVisible(true);
    }

    public StudentDetails() {

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setTitle("LIBRARY MANAGEMENT SYSTEM");
        setResizable(false);
        ImageIcon iconImg = new ImageIcon(getClass().getResource("Assets/icon.png"));
        setIconImage(iconImg.getImage());

        ImageIcon image = new ImageIcon(getClass().getResource("Assets/Lib.jpg"));
        contentPane = new JLabel();
        contentPane.setHorizontalAlignment(JLabel.CENTER);
        contentPane.setVerticalAlignment(JLabel.CENTER);
        contentPane.setIcon(image);
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setVisible(true);
        tablemodel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                // all cells false
                return false;
            }
        };
        tablemodel.addColumn("Student_id");
        tablemodel.addColumn("Name");
        tablemodel.addColumn("Father_Name");
        tablemodel.addColumn("Course");
        tablemodel.addColumn("Branch");
        tablemodel.addColumn("Year");
        tablemodel.addColumn("Semester");
        try {
            connect conn = new connect();
            String sql = "select * from db.Student";
            PreparedStatement st = conn.c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String Student_id = (rs.getString("Student_id"));
                String Name = rs.getString("Name");
                String Father_Name = rs.getString("Father_Name");
                String Course = rs.getString("Course");
                String Branch = rs.getString("Branch");
                String Year = (rs.getString("Year"));
                String Semester = (rs.getString("Semester"));

                tablemodel.addRow(new Object[] {
                        Student_id, Name, Father_Name, Course, Branch, Year, Semester,
                });
            }

            p1 = new JPanel();
            p1.setBounds(250, 180, 1000, 70);
            p1.setBorder(new LineBorder(new Color(150, 75, 0), 2, true));
            p1.setBackground(new Color(255, 229, 180));
            p1.setLayout(null);
            p1.setVisible(true);

            table = new JTable(tablemodel);
            table.setPreferredSize(new Dimension(800, 385));
            p2 = new JPanel();
            p2.setBounds(250, 250, 1000, 360);
            p2.setBorder(new TitledBorder(new LineBorder(new Color(150, 75, 0), 2, true), "Student-Details",
                    TitledBorder.LEADING, TitledBorder.TOP, null, new Color(150, 75, 0)));
            p2.setBackground(new Color(255, 229, 180));
            p2.add(table);
            scrollPane = new JScrollPane(table);
            scrollPane.setPreferredSize(new Dimension(980, 320));
            p2.add(scrollPane);
            contentPane.add(p2);
            rs.close();
            st.close();
            conn.c.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        b1 = new JButton("Search");
        b1.addActionListener(this);
        b1.setForeground(new Color(0, 0, 0));
        b1.setBackground(new Color(133, 198, 21));
        b1.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
        b1.setBounds(820, 200, 140, 35);
        contentPane.add(b1);

        b2 = new JButton("Delete");
        b2.addActionListener(this);
        b2.setForeground(new Color(199, 21, 133));
        b2.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
        b2.setBorder(new LineBorder(new Color(255, 20, 147), 2, true));
        b2.setBounds(1010, 200, 140, 35);
        contentPane.add(b2);

        search = new JTextField();
        search.setBackground(new Color(255, 240, 245));
        search.setBorder(new LineBorder(new Color(255, 105, 180), 2, true));
        search.setForeground(new Color(47, 79, 79));
        search.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 17));
        search.setBounds(420, 200, 360, 35);
        search.setColumns(20);
        contentPane.add(search);

        b3 = new JButton("Back");
        b3.addActionListener(this);
        b3.setForeground(Color.GRAY);
        b3.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
        b3.setBounds(330, 200, 75, 35);
        contentPane.add(b3);
        contentPane.add(p1);

    }

    public void actionPerformed(ActionEvent ae) {
        try {

            connect conn = new connect();
            if (ae.getSource() == b3) {
                new Home().setVisible(true);
                setVisible(false);
            }
            if (ae.getSource() == b1) {
                if (search.getText().equals("")) {
                    new StudentDetails().setVisible(true);
                    this.setVisible(false);
                    return;
                }
                tablemodel.setRowCount(0);
                String sql = "select * from db.Student where Student_id = ?";
                PreparedStatement st = conn.c.prepareStatement(sql);
                st.setString(1, search.getText());
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    String Student_id = (rs.getString("Student_id"));
                    String Name = rs.getString("Name");
                    String Father_Name = rs.getString("Father_Name");
                    String Course = rs.getString("Course");
                    String Branch = rs.getString("Branch");
                    String Year = (rs.getString("Year"));
                    String Semester = (rs.getString("Semester"));
                    tablemodel.addRow(new Object[] {
                            Student_id, Name, Father_Name, Course, Branch, Year, Semester,
                    });
                }
                p1 = new JPanel();
                p1.setBounds(250, 180, 1000, 70);
                p1.setBorder(new LineBorder(new Color(150, 75, 0), 2, true));
                p1.setBackground(new Color(255, 229, 180));
                p1.setLayout(null);
                p1.setVisible(true);

                table = new JTable(tablemodel);
                table.setPreferredSize(new Dimension(800, 385));
                p2 = new JPanel();
                p2.setBounds(250, 250, 1000, 360);
                p2.setBorder(new TitledBorder(new LineBorder(new Color(150, 75, 0), 2, true), "Student-Details",
                        TitledBorder.LEADING, TitledBorder.TOP, null, new Color(150, 75, 0)));
                p2.setBackground(new Color(255, 229, 180));
                p2.add(table);
                scrollPane = new JScrollPane(table);
                scrollPane.setPreferredSize(new Dimension(980, 320));

                p2.add(table);
                p2.add(scrollPane);
                contentPane.add(p1);
                contentPane.add(p2);
                rs.close();
                st.close();
            }
            if (ae.getSource() == b2) {
                try {
                    connect con = new connect();
                    String sql = "delete from db.Student where Student_id = ?";

                    PreparedStatement st = con.c.prepareStatement(sql);
                    st.setString(1, search.getText());
                    int i = st.executeUpdate();
                    if (i > 0) {
                        JOptionPane.showMessageDialog(null, "All status cleared");
                        new StudentDetails().setVisible(true);
                        this.setVisible(false);
                    } else
                        JOptionPane.showMessageDialog(null, "Error in Deleting");

                    st.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            conn.c.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}