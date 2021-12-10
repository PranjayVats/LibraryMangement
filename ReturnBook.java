// package library.management.system;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.PreparedStatement;

public class ReturnBook extends JFrame implements ActionListener {

	private JLabel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField dt;
	private Date thisDate;
	JButton b1, b2, b3;

	public static void main(String[] args) {
		new ReturnBook().setVisible(true);
	}

	public void delete() {
		try {
			connect con = new connect();
			String sql = "delete from db.issueBook where Book_Id=?";
			PreparedStatement st = con.c.prepareStatement(sql);
			st.setString(1, textField.getText());
			int i = st.executeUpdate();
			if (i > 0)
				JOptionPane.showMessageDialog(null, "All status cleared");
			else
				JOptionPane.showMessageDialog(null, "Error in Deleting");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
			e.printStackTrace();
		}
	}

	public ReturnBook() {
		thisDate = new Date();
		SimpleDateFormat dateForm = new SimpleDateFormat("dd/MM/Y");
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLocationRelativeTo(null);
		setResizable(false);

		setTitle("LIBRARY MANAGEMENT SYSTEM");
		ImageIcon iconImg = new ImageIcon(getClass().getResource("Assets/icon.png"));
		setIconImage(iconImg.getImage());

		ImageIcon image = new ImageIcon(getClass().getResource("Assets/Lib.jpg"));

		contentPane = new JLabel();
		contentPane.setHorizontalAlignment(JLabel.CENTER);
		contentPane.setVerticalAlignment(JLabel.CENTER);
		contentPane.setIcon(image);
		contentPane.setLayout(null);
		contentPane.setVisible(true);
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("Book_id");
		lblNewLabel.setForeground(new Color(47, 79, 79));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(462, 242, 87, 24);// done
		contentPane.add(lblNewLabel);

		JLabel lblStudentid = new JLabel("Student_id");
		lblStudentid.setForeground(new Color(47, 79, 79));
		lblStudentid.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblStudentid.setBounds(690, 242, 87, 24);// done
		contentPane.add(lblStudentid);

		JLabel lblBook = new JLabel("Book");
		lblBook.setForeground(new Color(47, 79, 79));
		lblBook.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBook.setBounds(462, 302, 71, 24);
		contentPane.add(lblBook);

		JLabel lblName = new JLabel("Name");
		lblName.setForeground(new Color(47, 79, 79));
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(770, 302, 71, 24);
		contentPane.add(lblName);

		JLabel lblCourse = new JLabel("Course");
		lblCourse.setForeground(new Color(47, 79, 79));
		lblCourse.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCourse.setBounds(462, 360, 87, 24);
		contentPane.add(lblCourse);

		JLabel lblBranch = new JLabel("Branch");
		lblBranch.setForeground(new Color(47, 79, 79));
		lblBranch.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBranch.setBounds(770, 360, 68, 24);
		contentPane.add(lblBranch);

		JLabel lblDateOfIssue = new JLabel("Date of Issue");
		lblDateOfIssue.setForeground(new Color(47, 79, 79));
		lblDateOfIssue.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDateOfIssue.setBounds(462, 430, 105, 29);
		contentPane.add(lblDateOfIssue);

		JLabel lblDateOfReturn = new JLabel("Date of Return");
		lblDateOfReturn.setForeground(new Color(47, 79, 79));
		lblDateOfReturn.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDateOfReturn.setBounds(462, 500, 118, 29);
		contentPane.add(lblDateOfReturn);
		dt = new JTextField();
		dt.setBounds(600, 500, 118, 29);// return date
		String currDate = dateForm.format(thisDate);
		dt.setText(currDate);
		dt.setEditable(false);
		contentPane.add(dt);

		textField = new JTextField();
		textField.setForeground(new Color(105, 105, 105));
		textField.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		textField.setBounds(550, 242, 87, 24);// book
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setForeground(new Color(105, 105, 105));
		textField_1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		textField_1.setBounds(790, 242, 87, 24);// done
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		b1 = new JButton("Search");
		b1.addActionListener(this);
		b1.setBounds(900, 242, 105, 29);// done
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		contentPane.add(b1);

		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setForeground(new Color(0, 100, 0));
		textField_2.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		textField_2.setBounds(550, 305, 168, 29);// book
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setForeground(new Color(0, 100, 0));
		textField_3.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		textField_3.setColumns(10);
		textField_3.setBounds(550, 360, 168, 29);// course
		contentPane.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setForeground(new Color(0, 100, 0));
		textField_4.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		textField_4.setColumns(10);
		textField_4.setBounds(840, 365, 158, 29);// name
		contentPane.add(textField_4);

		textField_5 = new JTextField();
		textField_5.setForeground(new Color(0, 100, 0));
		textField_5.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(600, 435, 118, 29);// Issue date
		contentPane.add(textField_5);

		textField_6 = new JTextField();
		textField_6.setForeground(new Color(0, 100, 0));
		textField_6.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(840, 305, 158, 29); // stud id
		contentPane.add(textField_6);

		b2 = new JButton("Return");
		b2.addActionListener(this);
		b2.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		b2.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
		b2.setBounds(820, 450, 149, 28);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);

		contentPane.add(b2);

		b3 = new JButton("Back");
		b3.addActionListener(this);
		b3.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		b3.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
		b3.setBounds(820, 500, 149, 30);
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		contentPane.add(b3);

		JPanel panel = new JPanel();
		panel.setBounds(440, 220, 605, 355);
		contentPane.add(panel);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(150, 75, 0), 2, true), "Return-Panel",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(150, 75, 0)));
		panel.setBackground(new Color(255, 229, 180));
	}	

	public void actionPerformed(ActionEvent ae) {
		try {
			connect con = new connect();
			if (ae.getSource() == b1) {
				String sql = "select * from db.issuebook where Student_Id = ? and Book_Id =?";
				PreparedStatement st = con.c.prepareStatement(sql);
				st.setString(1, textField_1.getText());
				st.setString(2, textField.getText());
				ResultSet rs = st.executeQuery();

				while (rs.next()) {
					textField_2.setText(rs.getString("BookName"));
					textField_6.setText(rs.getString("StudentName"));
					textField_3.setText(rs.getString("Course"));
					textField_4.setText(rs.getString("Branch"));
					textField_5.setText(rs.getString("DateOfIssue"));
				}
				st.close();
				rs.close();
			}
			if (ae.getSource() == b2) {
				try {
					String sql = "insert into db.returnbook(Book_id, Student_id, DateOfIssue, DateOfReturn, BookName,StudentName,Course, Branch) values(?, ?, ?, ?, ?, ?, ?,?)";
					PreparedStatement st = con.c.prepareStatement(sql);
					st.setString(1, textField.getText());
					st.setString(2, textField_1.getText());
					st.setString(3, textField_5.getText());
					st.setString(4, dt.getText());
					st.setString(5, textField_2.getText());
					st.setString(6, textField_6.getText());
					st.setString(7, textField_3.getText());
					st.setString(8, textField_4.getText());
					
					int i = st.executeUpdate();
					if (i > 0) {
						JOptionPane.showMessageDialog(null, "Book Returned Successfully...");
						delete();
					} else {
						JOptionPane.showMessageDialog(null, "error");
					}
				} catch (Exception e) {
					System.out.println(e);
				}

			}
			if (ae.getSource() == b3) {
				new Home().setVisible(true);
				this.setVisible(false);
			}
		} catch (Exception e) {

		}
	}
}