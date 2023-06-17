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

public class Administration {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Administration window = new Administration();
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
	public Administration() {
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
		btnNewButton.setBackground(new Color(238, 232, 170));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				studentlist window = new studentlist();
				window.getFrame().setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		btnNewButton.setBounds(10, 90, 271, 52);
		getFrame().getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("AdminList");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(0, 255, 255));
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel.setBounds(10, 10, 180, 43);
		getFrame().getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("New Register");
		btnNewButton_1.setForeground(new Color(255, 0, 0));
		btnNewButton_1.setBackground(new Color(238, 232, 170));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newregister window = new newregister();
				window.getFrame().setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		btnNewButton_1.setBounds(10, 178, 271, 58);
		getFrame().getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("RemoveStudent");
		btnNewButton_2.setForeground(new Color(255, 0, 0));
		btnNewButton_2.setBackground(new Color(238, 232, 170));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removestd window = new removestd();
				window.getFrame().setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		btnNewButton_2.setBounds(10, 273, 271, 63);
		getFrame().getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("About");
		btnNewButton_3.setForeground(new Color(255, 0, 0));
		btnNewButton_3.setBackground(new Color(238, 232, 170));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				About window = new About();
				window.getFrame().setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_3.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		btnNewButton_3.setBounds(10, 370, 271, 58);
		getFrame().getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("logout");
		btnNewButton_4.setForeground(new Color(255, 0, 0));
		btnNewButton_4.setBackground(new Color(238, 232, 170));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = 1;
				if(a==1) {
					JOptionPane.showMessageDialog(btnNewButton_4, "successfully logout");
					login window = new login();
					window.getFrame().setVisible(true);
					frame.dispose();
				}else {
					JOptionPane.showMessageDialog(btnNewButton_4,"already logout");
				}
			}
		});
		btnNewButton_4.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		btnNewButton_4.setBounds(10, 463, 271, 58);
		getFrame().getContentPane().add(btnNewButton_4);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
		frame.getContentPane().setBackground(new Color(255, 0, 128));
	}
}
