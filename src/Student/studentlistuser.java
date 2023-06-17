package Student;
import java.sql.*;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JTable;

import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class studentlistuser {

	private JFrame frame;
	private JTable table_1;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					studentlistuser window = new studentlistuser();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public studentlistuser() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 1244, 725);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		
		table_1 = new JTable();
		table_1.setBackground(new Color(250, 235, 215));
		table_1.setForeground(new Color(255, 0, 0));
		table_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"rollno", "name", "DOB", "gender", "email"
			}
		));
		table_1.setBounds(25, 130, 1129, 460);
		frame.getContentPane().add(table_1);
		
		JButton btnNewButton = new JButton("show list");
		btnNewButton.setForeground(new Color(0, 0, 205));
		btnNewButton.setBackground(new Color(255, 222, 173));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world","root","1234");
					Statement st = con.createStatement();
					String q = "select * from student";
					ResultSet rs = st.executeQuery(q);
					while(rs.next()) {
						String rollno = rs.getString("rollno");
						String name = rs.getString("name");
						String DOB = rs.getString("DOB");
						String gender = rs.getString("sex");
						String email = rs.getString("mailid");
						
						String tbData[]= {rollno, name, DOB, gender, email};
						DefaultTableModel tb1Model=(DefaultTableModel)table_1.getModel();
						
						tb1Model.addRow(tbData);
						
						
					}
					}catch(Exception e1) {
						System.out.println(e1);
					}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 42));
		btnNewButton.setBounds(386, 22, 245, 98);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setForeground(new Color(0, 0, 205));
		btnNewButton_1.setBackground(new Color(255, 222, 173));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userside window = new userside();
				window.getFrame().setVisible(true);
				frame.dispose();
				
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		btnNewButton_1.setBounds(729, 22, 175, 84);
		frame.getContentPane().add(btnNewButton_1);
		
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
		frame.getContentPane().setBackground(new Color(138, 43, 226));
	}
}
