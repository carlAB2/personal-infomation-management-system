package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;

public class PIInfoDlg extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PIInfoDlg frame = new PIInfoDlg();
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
	public PIInfoDlg() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 603, 381);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 309, 577, -309);
		contentPane.add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("PIInfoDlg");
		lblNewLabel.setBounds(217, 0, 152, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("id：");
		lblNewLabel_1.setBounds(146, 55, 108, 29);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(260, 52, 255, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("date：");
		lblNewLabel_1_1.setBounds(146, 97, 108, 29);
		contentPane.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(260, 92, 255, 35);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("total：");
		lblNewLabel_1_2.setBounds(146, 135, 108, 29);
		contentPane.add(lblNewLabel_1_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(260, 132, 255, 35);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("info：");
		lblNewLabel_1_3.setBounds(146, 185, 108, 29);
		contentPane.add(lblNewLabel_1_3);
		
		JButton btnNewButton = new JButton("add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(21, 262, 108, 37);
		contentPane.add(btnNewButton);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(260, 184, 255, 68);
		contentPane.add(textArea);
		
		JButton btnNewButton_1 = new JButton("update");
		btnNewButton_1.setBounds(136, 262, 125, 37);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("delete");
		btnNewButton_1_1.setBounds(270, 262, 125, 37);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("exit");
		btnNewButton_1_2.setBounds(406, 262, 119, 37);
		contentPane.add(btnNewButton_1_2);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(546, 0, 31, 310);
		contentPane.add(scrollBar);
	}
}

