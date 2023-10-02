package dabney;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;

/**
 * 
 * @author Devon Dabney
 * @version 1.0
 */
public class MyMain {

	private JFrame frame;
	private JTextField myPassword;
	private JButton testBtn;
	private JTextPane outputTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyMain window = new MyMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MyMain() {
		initialize();
		
		// CREATE ACTIONLISTENER FOR TEST BUTTON
		testBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Password password = new Password(myPassword.getText());
				outputTxt.setText(password.isValid() ? password.strengthCheck()
						: password.invalidPass());
			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel appTitle = new JLabel("Password Checker");
		appTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		appTitle.setBounds(147, 0, 161, 42);
		frame.getContentPane().add(appTitle);
		
		JTextArea appDescription = new JTextArea();
		appDescription.setText("Please enter a password you want to test! Make sure it is between 8 to 12 \r\ncharacters long and contains no spaces.");
		appDescription.setBounds(10, 42, 416, 56);
		frame.getContentPane().add(appDescription);
		
		JLabel passwordLbl = new JLabel("Password");
		passwordLbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordLbl.setBounds(10, 135, 75, 28);
		frame.getContentPane().add(passwordLbl);
		
		myPassword = new JTextField();
		myPassword.setBounds(95, 135, 309, 26);
		frame.getContentPane().add(myPassword);
		myPassword.setColumns(10);
		
		testBtn = new JButton("Check Strength");
		testBtn.setBounds(223, 171, 103, 21);
		frame.getContentPane().add(testBtn);
		
		outputTxt = new JTextPane();
		outputTxt.setBounds(36, 208, 368, 45);
		frame.getContentPane().add(outputTxt);
	}
}
