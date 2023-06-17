package Student;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class newregister {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newregister window = new newregister();
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
	public newregister() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 1318, 765);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.setForeground(new Color(165, 42, 42));
		btnNewButton.setBackground(new Color(255, 192, 203));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String rollno = textField.getText();
				String name = textField_1.getText();
				String DOB = textField_2.getText();
				String gender = textField_3.getText();
				String email = textField_4.getText();
				try
				{
					Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/world","root","1234");
					Statement st = con.createStatement();
					String query= "insert into student values('"+rollno+"','"+name+"','"+DOB+"','"+gender+"','"+email+"')";
					int x = st.executeUpdate(query);
					if(x==0) {
						JOptionPane.showMessageDialog(btnNewButton,"not inserted");
					}else {
						JOptionPane.showMessageDialog(btnNewButton,"successfully registered");
					}
				}catch(Exception e1) {
					System.out.println(e1);
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 45));
		btnNewButton.setBounds(487, 578, 242, 83);
		getFrame().getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("NewAdmin");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setBackground(new Color(199, 21, 133));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 50));
		lblNewLabel.setBounds(471, 30, 274, 83);
		getFrame().getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Rollno");
		lblNewLabel_1.setForeground(new Color(47, 79, 79));
		lblNewLabel_1.setBackground(new Color(211, 211, 211));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_1.setBounds(67, 147, 166, 55);
		getFrame().getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setForeground(new Color(47, 79, 79));
		lblNewLabel_2.setBackground(new Color(211, 211, 211));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_2.setBounds(67, 271, 171, 68);
		getFrame().getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("DOB");
		lblNewLabel_3.setForeground(new Color(47, 79, 79));
		lblNewLabel_3.setBackground(new Color(211, 211, 211));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_3.setBounds(67, 393, 166, 55);
		getFrame().getContentPane().add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(241, 160, 274, 36);
		getFrame().getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(241, 280, 274, 36);
		getFrame().getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(243, 397, 280, 36);
		getFrame().getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Gender");
		lblNewLabel_4.setForeground(new Color(47, 79, 79));
		lblNewLabel_4.setBackground(new Color(211, 211, 211));
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_4.setBounds(684, 160, 142, 44);
		getFrame().getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("email");
		lblNewLabel_5.setForeground(new Color(47, 79, 79));
		lblNewLabel_5.setBackground(new Color(211, 211, 211));
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_5.setBounds(684, 271, 147, 55);
		getFrame().getContentPane().add(lblNewLabel_5);
		
		textField_3 = new JTextField();
		textField_3.setBounds(854, 171, 287, 44);
		getFrame().getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(854, 271, 287, 44);
		getFrame().getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setForeground(new Color(165, 42, 42));
		btnNewButton_1.setBackground(new Color(255, 192, 203));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Administration window = new Administration();
				window.getFrame().setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		btnNewButton_1.setBounds(782, 578, 182, 76);
		frame.getContentPane().add(btnNewButton_1);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
		frame.getContentPane().setBackground(new Color(240, 230, 140));
	}
}
