package Student;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;

public class profile {

	private JFrame frame;
	private JTable table;
	private JTextField textField;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					profile window = new profile();
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
	public profile() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 1206, 738);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("profile");
		btnNewButton.setForeground(new Color(0, 100, 0));
		btnNewButton.setBackground(new Color(240, 255, 240));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String rollno = textField.getText();
				try
				{
					Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/world","root","1234");
					Statement st = con.createStatement();
					String q= "select * from student where rollno = '"+rollno+"'";
					ResultSet rs = st.executeQuery(q);
					while(rs.next()) {
						 rollno = rs.getString("Rollno");
						 String name = rs.getString("name");
						 String DOB = rs.getString("DOB");
						 String gender = rs.getString("sex");
						 String email = rs.getString("mailid");
						 String db[]= {rollno,name,DOB,gender,email};
						 DefaultTableModel tb1Model=(DefaultTableModel)table.getModel();
						 tb1Model.addRow(db);
					}
				}catch(Exception e1) {
					System.out.println(e1);
				}
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 50));
		btnNewButton.setBounds(663, 84, 227, 79);
		getFrame().getContentPane().add(btnNewButton);
		
		table = new JTable();
		table.setBackground(new Color(255, 222, 173));
		table.setForeground(new Color(255, 0, 0));
		table.setFont(new Font("Times New Roman", Font.BOLD, 20));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Rollno", "Name", "DOB", "gender", "mail"
			}
		));
		table.setBounds(10, 211, 1156, 447);
		getFrame().getContentPane().add(table);
		
		JLabel lblNewLabel = new JLabel("Rollno");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(250, 240, 230));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblNewLabel.setBounds(109, 100, 149, 52);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(306, 108, 274, 56);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setForeground(new Color(0, 100, 0));
		btnNewButton_1.setBackground(new Color(240, 255, 240));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userside window = new userside();
				window.getFrame().setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		btnNewButton_1.setBounds(968, 84, 179, 79);
		frame.getContentPane().add(btnNewButton_1);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
		frame.getContentPane().setBackground(new Color(238, 130, 238));
	}
}
