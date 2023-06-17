package Student;

import java.awt.EventQueue;

import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class user {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					user window = new user();
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
	public user() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 756, 740);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("USER:");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(240, 230, 140));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblNewLabel.setBounds(10, 10, 173, 78);
		getFrame().getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("MailId");
		lblNewLabel_1.setForeground(new Color(165, 42, 42));
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBackground(new Color(152, 251, 152));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_1.setBounds(10, 98, 144, 53);
		getFrame().getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(10, 161, 285, 34);
		getFrame().getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("userid");
		lblNewLabel_2.setForeground(new Color(165, 42, 42));
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setBackground(new Color(152, 251, 152));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_2.setBounds(10, 219, 117, 53);
		getFrame().getContentPane().add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 282, 285, 34);
		getFrame().getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("password");
		lblNewLabel_3.setForeground(new Color(165, 42, 42));
		lblNewLabel_3.setOpaque(true);
		lblNewLabel_3.setBackground(new Color(152, 251, 152));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_3.setBounds(10, 346, 144, 42);
		getFrame().getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("conform password");
		lblNewLabel_4.setForeground(new Color(165, 42, 42));
		lblNewLabel_4.setOpaque(true);
		lblNewLabel_4.setBackground(new Color(152, 251, 152));
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_4.setBounds(10, 471, 252, 34);
		getFrame().getContentPane().add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("create");
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setBackground(new Color(211, 211, 211));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String mailid  = textField.getText();
				   String userid = textField_1.getText();
				   @SuppressWarnings("deprecation")
				String password = passwordField.getText();
				   @SuppressWarnings("deprecation")
				String cpassword = passwordField_1.getText();
				   try
				   {
					   Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/world","root","1234");
					   String query = "insert into nadmin values('"+mailid+"','"+userid+"','"+password+"','"+cpassword+"')";
					   Statement sta = connection.createStatement();
					   int x = sta.executeUpdate(query);
					   if(x==0) {
						   JOptionPane.showMessageDialog(btnNewButton,"This is already exist");
					   }
						   else {
							   JOptionPane.showMessageDialog(btnNewButton,"welcome,"+userid+"Your account is successfully created");
						   }
				   connection.close();
				   }catch(Exception exception) {
			    exception.printStackTrace();
				   }
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 30));
		btnNewButton.setBounds(10, 651, 117, 42);
		getFrame().getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setForeground(new Color(255, 0, 0));
		btnNewButton_1.setBackground(new Color(211, 211, 211));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login window = new login();
				window.getFrame().setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		btnNewButton_1.setBounds(178, 651, 117, 42);
		frame.getContentPane().add(btnNewButton_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(10, 406, 285, 34);
		frame.getContentPane().add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(10, 525, 285, 34);
		frame.getContentPane().add(passwordField_1);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
		frame.getContentPane().setBackground(new Color(221, 160, 221));
	}
}
