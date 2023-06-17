package Student;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;

public class userlogin {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userlogin window = new userlogin();
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
	public userlogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 969, 707);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Userlogin");
		lblNewLabel.setBackground(new Color(250, 235, 215));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setForeground(new Color(128, 0, 128));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setBounds(23, 22, 155, 39);
		getFrame().getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("loginid");
		lblNewLabel_1.setForeground(new Color(205, 133, 63));
		lblNewLabel_1.setBackground(new Color(245, 245, 220));
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_1.setBounds(66, 126, 112, 50);
		getFrame().getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(236, 137, 274, 41);
		getFrame().getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("password");
		lblNewLabel_2.setForeground(new Color(205, 133, 63));
		lblNewLabel_2.setBackground(new Color(245, 245, 220));
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_2.setBounds(66, 220, 133, 39);
		getFrame().getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("login");
		btnNewButton.setBackground(new Color(255, 0, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/world","root","1234");
					Statement st = con.createStatement();
					@SuppressWarnings("deprecation")
					String query = "select userid,password from user where userid ='"+textField.getText()+"'and password ='"+passwordField.getText()+"'";
					ResultSet rs = st.executeQuery(query);
					if(rs.next())
					{
						JOptionPane.showMessageDialog(btnNewButton, "successfully login");
						userside window = new userside();
						window.getFrame().setVisible(true);
						frame.dispose();
					}else {
						JOptionPane.showMessageDialog(btnNewButton,"invalid id or password");
					}
				}catch(Exception e1) {
					System.out.println(e1);
				}
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 30));
		btnNewButton.setBounds(236, 332, 112, 61);
		getFrame().getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("signup");
		btnNewButton_1.setBackground(new Color(255, 0, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newuser window = new newuser();
				window.getFrame().setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		btnNewButton_1.setBounds(391, 332, 119, 61);
		getFrame().getContentPane().add(btnNewButton_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(236, 220, 274, 35);
		frame.getContentPane().add(passwordField);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.setBackground(new Color(255, 0, 255));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frontpage window = new frontpage();
				window.getFrame().setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 30));
		btnNewButton_2.setBounds(51, 332, 119, 61);
		frame.getContentPane().add(btnNewButton_2);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
		frame.getContentPane().setBackground(new Color(224, 255, 255));
	}

}
