package Student;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


import java.awt.Font;


import javax.swing.JButton;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import java.awt.Color;

public class userside {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userside window = new userside();
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
	public userside() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 567, 622);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Student List");
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setBackground(new Color(169, 169, 169));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				studentlistuser window = new studentlistuser();
				window.getFrame().setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		btnNewButton.setBounds(10, 90, 271, 52);
		getFrame().getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Userside");
		lblNewLabel.setBackground(new Color(100, 149, 237));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setForeground(new Color(154, 205, 50));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel.setBounds(10, 10, 180, 43);
		getFrame().getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Profile");
		btnNewButton_1.setForeground(new Color(255, 0, 0));
		btnNewButton_1.setBackground(new Color(169, 169, 169));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				profile window = new profile();
				window.getFrame().setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		btnNewButton_1.setBounds(10, 178, 271, 58);
		getFrame().getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("About");
		btnNewButton_3.setForeground(new Color(255, 0, 0));
		btnNewButton_3.setBackground(new Color(169, 169, 169));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userabout window = new userabout();
				window.getFrame().setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_3.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		btnNewButton_3.setBounds(10, 275, 271, 58);
		getFrame().getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("logout");
		btnNewButton_4.setForeground(new Color(255, 0, 0));
		btnNewButton_4.setBackground(new Color(169, 169, 169));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = 1;
				if(a==1) {
					JOptionPane.showMessageDialog(btnNewButton_4, "successfully logout");
					userlogin window = new userlogin();
					window.getFrame().setVisible(true);
					frame.dispose();
				}else {
					JOptionPane.showMessageDialog(btnNewButton_4,"already logout");
				}
			}
		});
		btnNewButton_4.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		btnNewButton_4.setBounds(10, 361, 271, 58);
		getFrame().getContentPane().add(btnNewButton_4);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
		frame.getContentPane().setBackground(new Color(245, 245, 220));
	}
}
