package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class TodoInfoDlg extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textTitle;
	private JTextField textPlace;
	//private test2 jf;
	JTextArea textEvent;
	private Map<String,String> map;
	JLabel labelCreateDate;
	MyJButton myBtn;
	JTextField SFT;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		try {
			TodoInfoDlg dialog = new TodoInfoDlg();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/
	 * Create the dialog.
	 */
	public TodoInfoDlg(MyJButton myBtn) {//
		super((JFrame)myBtn.getParent().getParent().getParent().getParent().getParent().getParent().getParent().getParent().getParent());
		this.myBtn = myBtn;
		this.map = myBtn.getMap(); 
		
		this.setVisible(true);
		setResizable(false);
		setBounds(100, 100, 730, 509);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 714, 470);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Create Date:");
		lblNewLabel.setBounds(50, 38, 85, 14);
		contentPanel.add(lblNewLabel);
		
		labelCreateDate = new JLabel("");
		labelCreateDate.setBounds(123, 38, 174, 14);
		contentPanel.add(labelCreateDate);
		
		JLabel lblNewLabel_1 = new JLabel("Title:");
		lblNewLabel_1.setBounds(89, 94, 46, 14);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Place:");
		lblNewLabel_2.setBounds(82, 132, 36, 14);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Event:");
		lblNewLabel_3.setBounds(82, 174, 46, 14);
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
		
		JButton updateBtn = new JButton("update");
		updateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Map<String,String> tmp;
				String id = map.get("id");
				map.put("title", TodoInfoDlg.this.textTitle.getText());
				map.put("place", TodoInfoDlg.this.textPlace.getText());
				map.put("event", TodoInfoDlg.this.textEvent.getText());
				TodoBiz.update(id,map);
				(TodoInfoDlg.this.myBtn.getMjpGroup())[TodoInfoDlg.this.myBtn.getPanelNo()-1].setList(TodoBiz.queryByStatus(TodoInfoDlg.this.myBtn.getPanelNo()));
				(TodoInfoDlg.this.myBtn.getMjpGroup())[TodoInfoDlg.this.myBtn.getPanelNo()-1].refresh();
				JOptionPane.showMessageDialog(TodoInfoDlg.this, "Update sucessful !");
			}
		});
		updateBtn.setBounds(123, 370, 89, 23);
		contentPanel.add(updateBtn);
		
		JButton cancelBtn = new JButton("cancel");
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TodoInfoDlg.this.dispose();
			}
		});
		cancelBtn.setBounds(222, 370, 89, 23);
		contentPanel.add(cancelBtn);
	
		this.labelCreateDate.setText(map.get("create_date"));
		this.textTitle.setText(map.get("title"));
		this.textPlace.setText(map.get("place"));
		this.textEvent.setText(map.get("event"));
		this.SFT.setText(map.get("should_complete_time"));
		
		JLabel lblNewLabel_4 = new JLabel("should finish time:");
		lblNewLabel_4.setBounds(10, 63, 107, 14);
		contentPanel.add(lblNewLabel_4);
		this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		
	}
}






















