import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JPanel;

public class Statistics extends JFrame implements ActionListener {
    JPanel p1, p2;
    JButton back = new JButton("Back");
    JTable issueBook, returnBook;

    public Statistics() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(false);
        setLocationRelativeTo(null);
        back.setBounds(700, 750, 100, 40);
        add(back);
        back.addActionListener(this);
        setTitle("LIBRARY MANGEMENT SYSTEM");

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

        DefaultTableModel tb1 = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tb1.addColumn("Book_id");
        tb1.addColumn("Student_id");
        tb1.addColumn("DateOfIssue");
        tb1.addColumn("Book Name");
        tb1.addColumn("Student Name");
        tb1.addColumn("Course");
        tb1.addColumn("Branch");

        DefaultTableModel tb2 = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                // all cells false
                return false;
            }
        };
        tb2.addColumn("Book_id");
        tb2.addColumn("Student_id");
        tb2.addColumn("DateOfIssue");
        tb2.addColumn("DateOfReturn");
        tb2.addColumn("Book Name");
        tb2.addColumn("Student Name");
        tb2.addColumn("Course");
        tb2.addColumn("Branch");

        back = new JButton("Back");
        back.setFont(new Font("Tahoma", Font.BOLD, 18));
        back.setBounds(730, 790, 80, 40);
        back.addActionListener(this);
        img.add(back);
        try {
            connect con = new connect();
            String sql = "select * from db.issuebook";
            PreparedStatement st = con.c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String book_id = (rs.getString("Book_Id"));
                String student_id = (rs.getString("Student_Id"));
                String issuedate = (rs.getString("DateOfIssue"));
                String bookname = (rs.getString("BookName"));
                String studentname = (rs.getString("StudentName"));
                String course = (rs.getString("Course"));
                String branch = (rs.getString("Branch"));

                tb1.addRow(new Object[] {
                        book_id, student_id, issuedate, bookname, studentname, course, branch
                });

            }
            issueBook = new JTable(tb1);
            issueBook.setBounds(220, 70, 980, 385);
            issueBook.setPreferredSize(new Dimension(800, 380));
            p1 = new JPanel();
            p1.setBounds(250, 30, 1000, 360);
            p1.setBorder(new TitledBorder(new LineBorder(new Color(150, 75, 0), 2, true), "Issue-Details",
                    TitledBorder.LEADING, TitledBorder.TOP, null, new Color(150, 75, 0)));
            p1.setBackground(new Color(255, 229, 180));
            p1.add(issueBook);
            JScrollPane sp1 = new JScrollPane(issueBook);
            sp1.setPreferredSize(new Dimension(980, 320));
            p1.add(sp1);
            img.add(p1);

            sql = "select * from db.returnbook";
            st = con.c.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                String book_id = (rs.getString("Book_Id"));
                String student_id = (rs.getString("Student_Id"));
                String issuedate = (rs.getString("DateOfIssue"));
                String returndate = (rs.getString("DateOfReturn"));
                String bookname = (rs.getString("BookName"));
                String studentname = (rs.getString("StudentName"));
                String course = (rs.getString("Course"));
                String branch = (rs.getString("Branch"));

                tb2.addRow(new Object[] {
                        book_id, student_id, issuedate, returndate, bookname, studentname, course, branch
                });

            }
            returnBook = new JTable(tb2);
            returnBook.setPreferredSize(new Dimension(380, 380));

            p2 = new JPanel();
            p2.setBounds(250, 420, 1000, 360);
            p2.setBorder(new TitledBorder(new LineBorder(new Color(150, 75, 0), 2, true), "Return-Details",
                    TitledBorder.LEADING, TitledBorder.TOP, null, new Color(150, 75, 0)));
            p2.setBackground(new Color(255, 229, 180));
            p2.add(returnBook);

            JScrollPane sp2 = new JScrollPane(returnBook);
            sp2.setPreferredSize(new Dimension(980, 320));
            p2.add(sp2);
            img.add(p2);

            st.close();
            rs.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == back) {
            new Home().setVisible(true);
            this.setVisible(false);
        }

    }

    public static void main(String[] args) {
        new Statistics().setVisible(true);
    }

}