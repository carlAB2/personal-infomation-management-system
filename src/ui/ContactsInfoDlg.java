package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

public class ContactsInfoDlg extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField name;
	private JTextField phone;
	private JTextField mail;
	private JTextField birth;
	private JTextField city;
	private JTextField place;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ContactsInfoDlg dialog = new ContactsInfoDlg();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ContactsInfoDlg() {
		setBounds(100, 100, 549, 545);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 523, 506);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("name");
			lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel.setBounds(51, 30, 46, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("phone");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_1.setBounds(51, 58, 46, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("mail");
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_2.setBounds(51, 83, 46, 14);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("birth");
			lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_3.setBounds(51, 117, 46, 14);
			contentPanel.add(lblNewLabel_3);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("city");
			lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_4.setBounds(51, 142, 46, 14);
			contentPanel.add(lblNewLabel_4);
		}
		{
			JLabel lblNewLabel_5 = new JLabel("work place");
			lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_5.setBounds(34, 179, 63, 14);
			contentPanel.add(lblNewLabel_5);
		}
		{
			JLabel lblNewLabel_6 = new JLabel("remark");
			lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_6.setBounds(51, 249, 46, 44);
			contentPanel.add(lblNewLabel_6);
		}
		
		name = new JTextField();
		name.setBounds(107, 27, 141, 20);
		contentPanel.add(name);
		name.setColumns(10);
		
		phone = new JTextField();
		phone.setBounds(107, 55, 141, 20);
		contentPanel.add(phone);
		phone.setColumns(10);
		
		mail = new JTextField();
		mail.setBounds(107, 80, 141, 20);
		contentPanel.add(mail);
		mail.setColumns(10);
		
		birth = new JTextField();
		birth.setBounds(107, 114, 141, 20);
		contentPanel.add(birth);
		birth.setColumns(10);
		
		city = new JTextField();
		city.setBounds(107, 145, 141, 20);
		contentPanel.add(city);
		city.setColumns(10);
		
		place = new JTextField();
		place.setBounds(107, 176, 141, 20);
		contentPanel.add(place);
		place.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(107, 259, 216, 167);
		contentPanel.add(textArea);
		
		JButton saveBtn = new JButton("save");
		saveBtn.setBounds(107, 451, 89, 23);
		contentPanel.add(saveBtn);
		
		JButton cancelBtn = new JButton("cancel");
		cancelBtn.setBounds(206, 451, 89, 23);
		contentPanel.add(cancelBtn);
		
		JComboBox group = new JComboBox();
		group.setBounds(107, 209, 30, 22);
		contentPanel.add(group);
		
		JLabel lable = new JLabel("group");
		lable.setBounds(61, 213, 46, 14);
		contentPanel.add(lable);
	}
}
