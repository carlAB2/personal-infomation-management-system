package ui;

import java.util.Map;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import biz.DiaryBiz;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DiaryInfoDlg extends JDialog {

	private final JPanel contentPanel = new JPanel();
	Map<String,String> map;
	JLabel createDate;
	JLabel weather;
	JLabel labelPlace;
	JLabel labelPeople;
	JTextArea textHappening;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			DiaryInfoDlg dialog = new DiaryInfoDlg();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public DiaryInfoDlg(MyJButtonForDiary mjb) {
		this.map = mjb.getMap();
		
		this.setVisible(true);
		setResizable(false);
		setBounds(100, 100, 908, 583);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 902, 543);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Date:");
		lblNewLabel.setBounds(10, 11, 46, 14);
		contentPanel.add(lblNewLabel);
		
		createDate = new JLabel("New label");
		createDate.setBounds(49, 11, 164, 14);
		contentPanel.add(createDate);
		
		JLabel lblNewLabel_1 = new JLabel("Weather:");
		lblNewLabel_1.setBounds(223, 11, 57, 14);
		contentPanel.add(lblNewLabel_1);
		
		weather = new JLabel("New label");
		weather.setBounds(288, 11, 85, 14);
		contentPanel.add(weather);
		
		JLabel lblNewLabel_2 = new JLabel("Place:");
		lblNewLabel_2.setBounds(419, 11, 46, 14);
		contentPanel.add(lblNewLabel_2);
		
		labelPlace = new JLabel("New label");
		labelPlace.setBounds(468, 11, 99, 14);
		contentPanel.add(labelPlace);
		
		JLabel lblNewLabel_3 = new JLabel("People:");
		lblNewLabel_3.setBounds(630, 11, 46, 14);
		contentPanel.add(lblNewLabel_3);
		
		labelPeople = new JLabel("New label");
		labelPeople.setBounds(686, 11, 155, 14);
		contentPanel.add(labelPeople);
		
		textHappening = new JTextArea();
		textHappening.setBounds(10, 46, 882, 486);
		textHappening.setLineWrap(true);        //激活自动换行功能 
		textHappening.setWrapStyleWord(true);
		textHappening.setEditable(false);
		JScrollPane jsp = new JScrollPane(textHappening,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jsp.setBounds(10, 46, 864, 486);
		contentPanel.add(jsp);
		
		this.createDate.setText(map.get("date"));
		this.labelPeople.setText(map.get("about_people"));
		this.labelPlace.setText(map.get("about_place"));
		this.weather.setText(map.get("weather"));
		this.textHappening.setText(map.get("happening"));
	}
}














