package Student;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class login {

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
					login window = new login();
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
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 583, 427);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("loginId:");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBounds(10, 106, 103, 44);
		lblNewLabel.setBackground(new Color(233, 150, 122));
		lblNewLabel.setForeground(new Color(128, 128, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		getFrame().getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(156, 115, 261, 36);
		getFrame().getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("password:");
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBounds(10, 186, 133, 44);
		lblNewLabel_1.setBackground(new Color(233, 150, 122));
		lblNewLabel_1.setForeground(new Color(128, 128, 255));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 24));
		getFrame().getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("login");
		btnNewButton.setBackground(new Color(255, 192, 203));
		btnNewButton.setForeground(new Color(255, 69, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world","root","1234");
					Statement st = con.createStatement();
					@SuppressWarnings("deprecation")
					String query = "select userid,password from nadmin where userid ='"+textField.getText()+"' and password ='"+passwordField.getText()+"'";
					
					ResultSet rs = st.executeQuery(query);
					
					if(rs.next()) {
						JOptionPane.showMessageDialog(btnNewButton, "successfully login");
						Administration window = new Administration();
						window.getFrame().setVisible(true);
						frame.dispose();
					}else {
						JOptionPane.showMessageDialog(btnNewButton, "invalid id or password");
					}
				}catch(Exception e1) {
					System.out.println(e1);
				}
				
			}
		});
		btnNewButton.setBounds(156, 295, 103, 44);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 24));
		getFrame().getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("signup");
		btnNewButton_1.setBackground(new Color(255, 192, 203));
		btnNewButton_1.setForeground(new Color(255, 69, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user b= new user();
				b.getFrame().setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(308, 295, 109, 44);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 24));
		getFrame().getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Admin");
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setBounds(10, 10, 161, 44);
		lblNewLabel_2.setForeground(new Color(0, 0, 139));
		lblNewLabel_2.setBackground(Color.MAGENTA);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 28));
		getFrame().getContentPane().add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(156, 195, 261, 36);
		frame.getContentPane().add(passwordField);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.setBackground(new Color(255, 192, 203));
		btnNewButton_2.setForeground(new Color(255, 69, 0));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frontpage window = new frontpage();
				window.getFrame().setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnNewButton_2.setBounds(10, 295, 103, 44);
		frame.getContentPane().add(btnNewButton_2);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
		frame.getContentPane().setBackground(new Color(255, 0, 0));
	}
}
