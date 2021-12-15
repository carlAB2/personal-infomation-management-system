package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import biz.TodoBiz;

public class TodoAddDlg extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textTitle;
	private JTextField textPlace;
	//private test2 jf;
	JTextArea textEvent;
	private Map<String,String> map;
	test2 jf;
	private JTextField SFT;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			TodoAddDlg dialog = new TodoAddDlg();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/*
	 * Create the dialog.
	 */
	public TodoAddDlg(test2 jf) {//
		super(jf);
		this.jf = jf;
		
		this.setVisible(true);
		setResizable(false);
		setBounds(100, 100, 730, 509);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 714, 470);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Title:");
		lblNewLabel_1.setBounds(89, 94, 46, 14);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Place:");
		lblNewLabel_2.setBounds(82, 132, 36, 14);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Event:");
		lblNewLabel_3.setBounds(82, 175, 46, 14);
		contentPanel.add(lblNewLabel_3);
		
		textTitle = new JTextField();
		textTitle.setBounds(123, 91, 174, 20);
		contentPanel.add(textTitle);
		textTitle.setColumns(10);
		
		textPlace = new JTextField();
		textPlace.setBounds(123, 129, 174, 20);
		contentPanel.add(textPlace);
		textPlace.setColumns(10);
		
		textEvent = new JTextArea();
		textEvent.setBounds(123, 169, 271, 138);
		JScrollPane jsp = new JScrollPane(textEvent);
		jsp.setBounds(123, 169, 271, 138);
		contentPanel.add(jsp);
		
		SFT = new JTextField();
		SFT.setBounds(123, 63, 174, 20);
		contentPanel.add(SFT);
		SFT.setColumns(10);
		
		JButton addBtn = new JButton("Add");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Map<String,String> tmp;
				map = new LinkedHashMap<>();
				
				map.put("title", TodoAddDlg.this.textTitle.getText());
				map.put("place", TodoAddDlg.this.textPlace.getText());
				map.put("event", TodoAddDlg.this.textEvent.getText());
				map.put("SFT",TodoAddDlg.this.SFT.getText());
				TodoBiz.insert(map);
				TodoAddDlg.this.jf.getMjpGroup()[0].setList(TodoBiz.queryByStatus(1));
				TodoAddDlg.this.jf.getMjpGroup()[0].refresh();
				
				JOptionPane.showMessageDialog(TodoAddDlg.this, "Add sucessful !");	
//				TodoAddDlg.this.jf.revalidate();
//				TodoAddDlg.this.jf.repaint();
				//TodoAddDlg.this.dispose();
			}
		});
		addBtn.setBounds(123, 386, 89, 23);
		contentPanel.add(addBtn);
		
		JButton cancelBtn = new JButton("cancel");
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TodoAddDlg.this.dispose();
			}
		});
		cancelBtn.setBounds(223, 386, 89, 23);
		contentPanel.add(cancelBtn);
		
		JLabel lblNewLabel_4 = new JLabel("should finish time:");
		lblNewLabel_4.setBounds(10, 66, 106, 14);
		contentPanel.add(lblNewLabel_4);
		
		
		
	}
}

























