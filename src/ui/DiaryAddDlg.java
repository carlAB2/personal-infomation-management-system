package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import biz.DiaryBiz;

public class DiaryAddDlg extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textWeather;
	private JTextField textPlace;
	private JTextField textPeople;
	JTextArea textHappening;
	MyJPanelForDiary mdp;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			DiaryAddDlg dialog = new DiaryAddDlg();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public DiaryAddDlg(MyJPanelForDiary mdp) {
		this.mdp = mdp;
		
		this.setVisible(true);
		setResizable(false);
		setBounds(100, 100, 908, 583);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 902, 543);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Weather:");
		lblNewLabel_1.setBounds(10, 11, 57, 14);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Place:");
		lblNewLabel_2.setBounds(187, 11, 46, 14);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("People:");
		lblNewLabel_3.setBounds(404, 11, 46, 14);
		contentPanel.add(lblNewLabel_3);
		
		textHappening = new JTextArea();
		textHappening.setBounds(10, 46, 864, 486);
		textHappening.setLineWrap(true);        //激活自动换行功能 
		textHappening.setWrapStyleWord(true);
		JScrollPane jsp = new JScrollPane(textHappening);
		jsp.setBounds(10, 46, 864, 486);
		contentPanel.add(jsp);
		
		textWeather = new JTextField();
		textWeather.setBounds(59, 8, 118, 20);
		contentPanel.add(textWeather);
		textWeather.setColumns(10);
		
		textPlace = new JTextField();
		textPlace.setBounds(224, 8, 170, 20);
		contentPanel.add(textPlace);
		textPlace.setColumns(10);
		
		textPeople = new JTextField();
		textPeople.setBounds(452, 8, 170, 20);
		contentPanel.add(textPeople);
		textPeople.setColumns(10);
		
		JButton btnNewButton = new JButton("save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Map<String,String> map = new LinkedHashMap<>();
				map.put("weather", DiaryAddDlg.this.textWeather.getText());
				map.put("place", DiaryAddDlg.this.textPlace.getText());
				map.put("people", DiaryAddDlg.this.textPeople.getText());
				map.put("happening", DiaryAddDlg.this.textHappening.getText());
				DiaryBiz.insert(map);
				
				mdp.setList(DiaryBiz.query());
				mdp.refresh();
			}
		});
		btnNewButton.setBounds(632, 7, 89, 23);
		contentPanel.add(btnNewButton);
		
		JButton cancelBtn = new JButton("cancel");
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DiaryAddDlg.this.dispose();
			}
		});
		cancelBtn.setBounds(731, 7, 89, 23);
		contentPanel.add(cancelBtn);
	}
}
