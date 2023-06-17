package Student;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class userabout {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userabout window = new userabout();
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
	public userabout() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 1240, 731);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("About");
		lblNewLabel.setForeground(new Color(255, 218, 185));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(0, 0, 139));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 50));
		lblNewLabel.setBounds(10, 29, 181, 40);
		getFrame().getContentPane().add(lblNewLabel);
		
		JTextPane txtpnTheAimOf = new JTextPane();
		txtpnTheAimOf.setBackground(new Color(144, 238, 144));
		txtpnTheAimOf.setForeground(new Color(139, 69, 19));
		txtpnTheAimOf.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		txtpnTheAimOf.setText("The aim of this Student Registration System project is to build a student registration system that will completely automate the process of new student registration in a university. The system will handle the document submission, testing process and registration of new students. The system will be web based and will have two implementations i.e. client side (student) and server side (university). The server side implementation can only be accessed over the university intranet while the client side can be accessed over the internet.");
		txtpnTheAimOf.setBounds(10, 120, 1049, 537);
		getFrame().getContentPane().add(txtpnTheAimOf);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setBackground(new Color(128, 0, 128));
		btnNewButton.setForeground(new Color(250, 250, 210));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userside window = new userside();
				window.getFrame().setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 30));
		btnNewButton.setBounds(1073, 332, 132, 60);
		frame.getContentPane().add(btnNewButton);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
		frame.getContentPane().setBackground(new Color(50, 205, 50));
	}
}
