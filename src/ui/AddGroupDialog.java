package ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import biz.GroupBiz;

public class AddGroupDialog extends JDialog{
	private final JPanel contentPanel = new JPanel();
	private JTextField textGroupName;
	private test2 jf;
	private GroupManage gm;
	
	public AddGroupDialog(test2 jf,GroupManage gm) {
		super(gm);
		this.jf = jf;
		this.gm = gm;
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
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = textGroupName.getText();
				List<Map<String,String>> list;
				if(str != null && !str.trim().isEmpty()) {
					GroupBiz.insert(str);
					list = GroupBiz.query();
					AddGroupDialog.this.jf.selectGroup.setList(list);
					AddGroupDialog.this.jf.selectGroup.refresh("gname","id" );
					AddGroupDialog.this.gm.comboBox.setList(list);
					AddGroupDialog.this.gm.comboBox.refresh("gname","id" );
					AddGroupDialog.this.dispose();
				}
				else {
					JOptionPane.showMessageDialog(AddGroupDialog.this, "Group name can't be empty!!!");//.showConfirmDialog(AddGroupDialog.this,"Group name can't be empty!!!", "Error",JOptionPane.YES_NO_OPTION);
				}
			}
		});
		btn.setBounds(112, 76, 55, 23);
		getContentPane().add(btn);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		
	}
}








