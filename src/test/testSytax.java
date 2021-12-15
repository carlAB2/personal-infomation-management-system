package test;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class testSytax extends JFrame {

	private JPanel contentPane;
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
					testSytax frame = new testSytax();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public testSytax() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 886, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIncome = new JLabel("testSytax");
		lblIncome.setBounds(378, 15, 81, 21);
		contentPane.add(lblIncome);
		
		JLabel lblId = new JLabel("id：");
		lblId.setBounds(159, 78, 81, 21);
		contentPane.add(lblId);
		
		JLabel lblDate = new JLabel("date：");
		lblDate.setBounds(143, 114, 81, 21);
		contentPane.add(lblDate);
		
		textField = new JTextField();
		textField.setBounds(225, 75, 222, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(225, 114, 222, 27);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("amount：");
		lblNewLabel.setBounds(122, 164, 81, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("type_id：");
		lblNewLabel_1.setBounds(122, 211, 81, 21);
		contentPane.add(lblNewLabel_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(225, 208, 222, 27);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(225, 161, 222, 27);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblInfo = new JLabel("info：");
		lblInfo.setBounds(143, 250, 81, 21);
		contentPane.add(lblInfo);
		
		textField_4 = new JTextField();
		textField_4.setBounds(225, 250, 222, 69);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(823, 15, 26, 415);
		contentPane.add(scrollBar);
		
		JButton btnNewButton = new JButton("add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(15, 375, 123, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("update");
		btnNewButton_1.setBounds(159, 375, 123, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("delete");
		btnNewButton_2.setBounds(297, 375, 123, 29);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("exit");
		btnNewButton_3.setBounds(443, 375, 123, 29);
		contentPane.add(btnNewButton_3);
	}
}

