package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import biz.GroupBiz;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;

public class GroupManage extends JDialog {

	private final JPanel contentPanel = new JPanel();
	MyJComboBox comboBox;
	public MyJComboBox getComboBox() {
		return comboBox;
	}

	public void setComboBox(MyJComboBox comboBox) {
		this.comboBox = comboBox;
	}

	private static test2 jf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GroupManage dialog = new GroupManage(jf);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GroupManage(test2 jf) {
		setModal(true);
		setResizable(false);
		this.jf = jf;
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 305, 240);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 299, 211);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			comboBox = new MyJComboBox();
			comboBox.setBounds(88, 22, 96, 22);
			
			comboBox.setItems(GroupBiz.query(), "gname", "id");			
			contentPanel.add(comboBox);
		}
		{
			JButton addBtn = new JButton("add");
			addBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					AddGroupDialog addGroupDialog = new AddGroupDialog(GroupManage.this.jf,GroupManage.this);
				}
			});
			addBtn.setBounds(10, 22, 68, 23);
			contentPanel.add(addBtn);
		}
		{
			JButton deleteBtn = new JButton("delete");
			deleteBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String str = GroupManage.this.comboBox.getText();
					List<Map<String,String>> list;
					
					if(str != null && !str.trim().isEmpty()) {
						GroupBiz.delete(str);
						list = GroupBiz.query();
						GroupManage.this.jf.selectGroup.setList(list);
						GroupManage.this.jf.selectGroup.refresh("gname","id" );
						GroupManage.this.comboBox.setList(list);
						GroupManage.this.comboBox.refresh("gname","id" );
					}
				}
			});
			deleteBtn.setBounds(194, 22, 79, 23);
			contentPanel.add(deleteBtn);
		}
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

}
