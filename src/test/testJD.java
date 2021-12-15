package test;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

public class testJD extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textGroupName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			testJD dialog = new testJD();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public testJD() {
		setModal(true);
		setBounds(100, 100, 299, 156);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 110, 434, 118);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("group name");
		lblNewLabel.setFont(new Font("Meiryo", Font.BOLD, 11));
		lblNewLabel.setBounds(105, 21, 69, 14);
		getContentPane().add(lblNewLabel);
		
		textGroupName = new JTextField();
		textGroupName.setBounds(90, 46, 102, 26);
		getContentPane().add(textGroupName);
		textGroupName.setColumns(10);
		
		JButton btn = new JButton("OK");
		btn.setBounds(112, 76, 55, 23);
		getContentPane().add(btn);
		
	}
}
