package ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import biz.ContactsBiz;
import biz.DiaryBiz;
import biz.GroupBiz;
import biz.IncomeBiz;
import biz.PBPanelBiz;
import biz.TodoBiz;
import biz.TypeBiz;

public class test2 extends JFrame {

	private JPanel contentPane;
	private JTextField textKeyWord;
	private JTextField CTStart;
	private JTextField CTEnd;
	private JTextField SFTStart;
	private JTextField SFTEnd;
//	private List<Map<String,String>> readyList;
//	private List<Map<String,String>> doingList;
//	private List<Map<String,String>> doneList;
	private  MyJPanel [] mjpGroup;
	public MyJPanel[] getMjpGroup() {
		return mjpGroup;
	}

	private MyJPanel ready;
	private MyJPanel doing;
	private MyJPanel done;
	private JTextField contactsKeySearch;
	MyJPanelForContacts contatcsPanel;
	private JTextField diaryKeySearch;
	MyJPanelForDiary diaryPanel;
	private JTextField startDate;
	private JTextField endDate;
	private JTextField PISearch;
	private JTextField low;
	private JTextField high;
	private JTextField PBStartDate;
	private JTextField PBEndDate;
	JComboBox PICombo;
	MyJComboBox PITypeCombo;
	MyJPanelForPI PBPanel;
	MyJPanelForPI incomePanel;
	MyJComboBox selectGroup ;
	JComboBox<String> comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test2 frame = new test2();
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
	public test2() {
		
		//this.initList();
		//setLocationRelativeTo(null);
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 952, 691);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setBorder(new LineBorder(Color.CYAN));
		
		tabbedPane.setBounds(10, 11, 926, 630);
		contentPane.add(tabbedPane);
		
		JPanel contacts = new JPanel();
		tabbedPane.addTab("contacs", null, contacts, null);
		tabbedPane.setBackgroundAt(0, Color.WHITE);
		contacts.setLayout(null);
		
		contatcsPanel = new MyJPanelForContacts();
		contatcsPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		//contatcsPanel.setBounds(167, 139, 229, 430);
		
		JScrollPane js_contatcsPanel = new JScrollPane(contatcsPanel,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		js_contatcsPanel.setBounds(290, 139, 229, 430);
		contatcsPanel.setPreferredSize(new Dimension(229, 425));
		JScrollBar js_contatcsPanel_b = js_contatcsPanel.getVerticalScrollBar();
		js_contatcsPanel_b.setUnitIncrement(20);//滚轮灵敏度设置	
		
		
		contatcsPanel.setList(ContactsBiz.query());
		
		contatcsPanel.makeButtonList();
		
		/*
		
		*/
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(contacts, popupMenu);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("manage group");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GroupManage gm = new GroupManage(test2.this);
			}
		});
		popupMenu.add(mntmNewMenuItem_1);
		
		
		
		contacts.add(js_contatcsPanel);
		contatcsPanel.setLayout(null);
		
		contactsKeySearch = new JTextField();
		contactsKeySearch.setBounds(290, 97, 216, 31);
		contacts.add(contactsKeySearch);
		contactsKeySearch.setColumns(10);
		
		JButton contactSearchButton = new JButton("");
		contactSearchButton.setIcon(new ImageIcon(".\\resource\\search.png"));
		contactSearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Map<String,String>> list=new ArrayList<>();
				
				Map<String,String> map = new LinkedHashMap<>();
				map.put("keyword",test2.this.contactsKeySearch.getText());
				map.put("group",test2.this.selectGroup.getText());
				try {
					list = ContactsBiz.queryByKeyword(map);
				}catch(Exception m) {
					System.err.println(m.getMessage());
				}
				
				test2.this.contatcsPanel.setList(list);
				test2.this.contatcsPanel.refresh();
			}
		});
		contactSearchButton.setBackground(Color.WHITE);
		contactSearchButton.setBounds(516, 97, 33, 31);
		contacts.add(contactSearchButton);
		
		JButton contactAddBtn = new JButton("");
		contactAddBtn.setBackground(Color.WHITE);
		contactAddBtn.setBounds(526, 139, 23, 19);
		contacts.add(contactAddBtn);
		
		selectGroup = new MyJComboBox();
		selectGroup.setBounds(206, 101, 74, 22);
		selectGroup.setItems(GroupBiz.query(), "gname", "id");
		contacts.add(selectGroup);
		
		JButton btnNewButton_1_3 = new JButton("clear");
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				test2.this.selectGroup.setSelectedIndex(-1);
				test2.this.contactsKeySearch.setText(null);
			}
		});
		btnNewButton_1_3.setBackground(Color.WHITE);
		btnNewButton_1_3.setBounds(559, 101, 63, 23);
		contacts.add(btnNewButton_1_3);
		
		JPanel diary = new JPanel();
		tabbedPane.addTab("diary", null, diary, null);
		tabbedPane.setBackgroundAt(1, Color.WHITE);
		diary.setLayout(null);
		
		diaryPanel = new MyJPanelForDiary();
		diaryPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		//diaryPanel.setBounds(188, 116, 384, 450);
		
		JScrollPane js_diaryPanel = new JScrollPane(diaryPanel,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		js_diaryPanel.setBounds(188, 116, 229, 430);
		diaryPanel.setPreferredSize(new Dimension(229, 425));
		diaryPanel.setLayout(null);
		JScrollBar js_diaryPanel_b = js_diaryPanel.getVerticalScrollBar();
		js_diaryPanel_b.setUnitIncrement(20);//滚轮灵敏度设置	
		
		diaryPanel.setList(DiaryBiz.query());	
		diaryPanel.makeButtonList();
		
		/*
		
		*/
		
		
		diary.add(js_diaryPanel);
		
		diaryKeySearch = new JTextField();
		diaryKeySearch.setBounds(188, 43, 215, 31);
		diary.add(diaryKeySearch);
		diaryKeySearch.setColumns(10);
		
		JButton diarySearchBtn = new JButton("");
		diarySearchBtn.setIcon(new ImageIcon(".\\resource\\search.png"));
		diarySearchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Map<String,String> map = new LinkedHashMap<>();
				List<Map<String,String>> list = new ArrayList<>();
				
				map.put("diaryKeyword", test2.this.diaryKeySearch.getText());
				map.put("startDate", test2.this.startDate.getText());
				map.put("endDate", test2.this.endDate.getText());
				//map.put
				try {
					list = DiaryBiz.queryByKeyword(map);
				}catch(Exception m) {
					System.err.println(m.getMessage());
				}
				test2.this.diaryPanel.setList(list);
				test2.this.diaryPanel.refresh();
			}
		});
		diarySearchBtn.setBackground(Color.WHITE);
		diarySearchBtn.setBounds(413, 43, 33, 31);
		diary.add(diarySearchBtn);
		
		JButton diaryAddBtn = new JButton("");
		diaryAddBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DiaryAddDlg(test2.this.diaryPanel);
			}
		});
		diaryAddBtn.setBackground(Color.WHITE);
		diaryAddBtn.setBounds(427, 116, 23, 19);
		diary.add(diaryAddBtn);
		
		startDate = new JTextField();
		startDate.setBounds(188, 85, 80, 20);
		diary.add(startDate);
		startDate.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("-");
		lblNewLabel_8.setBounds(278, 88, 11, 14);
		diary.add(lblNewLabel_8);
		
		endDate = new JTextField();
		endDate.setBounds(292, 85, 80, 20);
		diary.add(endDate);
		endDate.setColumns(10);
		
		
		JButton btnNewButton_1_2 = new JButton("clear");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				test2.this.diaryKeySearch.setText(null);
				test2.this.startDate.setText(null);
				test2.this.endDate.setText(null);
				
			}
		});
		
		
		btnNewButton_1_2.setBackground(Color.WHITE);
		btnNewButton_1_2.setBounds(453, 47, 63, 23);
		diary.add(btnNewButton_1_2);
		
		JPanel pay_income = new JPanel();
		tabbedPane.addTab("pay&income", null, pay_income, null);
		tabbedPane.setBackgroundAt(2, Color.WHITE);
		pay_income.setLayout(null);
		
		PBPanel = new MyJPanelForPI(1);
		PBPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		//PBPanel.setBounds(155, 170, 229, 425);
		
		JScrollPane js_PBPanel = new JScrollPane(PBPanel,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		js_PBPanel.setBounds(155, 170, 229, 430);
		PBPanel.setPreferredSize(new Dimension(229, 425));
		PBPanel.setLayout(null);
		JScrollBar js_PBPanel_b = js_PBPanel.getVerticalScrollBar();
		js_PBPanel_b.setUnitIncrement(20);//滚轮灵敏度设置
		
		pay_income.add(js_PBPanel);
		PBPanel.setLayout(null);
		
		PBPanel.setList(PBPanelBiz.query());	
		PBPanel.makeButtonList();
		
		/*
		MyJButtonForPI test;
		for(int i=0;i<20;++i) {
			test = new MyJButtonForPI("test"+(i+1),PBPanel);
			//test.setBounds(6,i*20,20,20);
	
			PBPanel.addButton(test);
			
		}
		*/
		
		incomePanel = new MyJPanelForPI(2);
		incomePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		//incomePanel.setBounds(460, 170, 229, 425);
		
		JScrollPane js_incomePanel = new JScrollPane(incomePanel,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		js_incomePanel.setBounds(460, 170, 229, 430);
		incomePanel.setPreferredSize(new Dimension(229, 425));
		incomePanel.setLayout(null);
		JScrollBar js_incomePanel_b = js_incomePanel.getVerticalScrollBar();
		js_incomePanel_b.setUnitIncrement(20);//滚轮灵敏度设置
		
		pay_income.add(js_incomePanel);
		incomePanel.setLayout(null);
		
		incomePanel.setList(IncomeBiz.query());	
		incomePanel.makeButtonList();
		
		/*
		MyJButtonForPI test2;
		for(int i=0;i<20;++i) {
			test2 = new MyJButtonForPI("test"+(i+1),incomePanel);
			//test.setBounds(6,i*20,20,20);
	
			incomePanel.addButton(test2);
			
		}
		*/
		
		JLabel lblNewLabel_9 = new JLabel("Pay Bills");
		lblNewLabel_9.setBounds(245, 145, 52, 14);
		pay_income.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Income");
		lblNewLabel_10.setBounds(560, 145, 46, 14);
		pay_income.add(lblNewLabel_10);
		
		PISearch = new JTextField();
		PISearch.setColumns(10);
		PISearch.setBounds(155, 29, 215, 31);
		pay_income.add(PISearch);
		
		JButton PISearchBtn = new JButton("");
		PISearchBtn.setIcon(new ImageIcon(".\\resource\\search.png"));
		PISearchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String PI = test2.this.PICombo.getSelectedItem()+"";
				Map<String,String> map = new LinkedHashMap<>();
				map.put("keyword", test2.this.PISearch.getText());
//				map.put("PI",test2.this.PICombo.getSelectedItem()+"");
				map.put("type", test2.this.PITypeCombo.getText());
				map.put("startDate", test2.this.PBStartDate.getText());
				map.put("endDate", test2.this.PBEndDate.getText());
				map.put("low", test2.this.low.getText());
				map.put("high", test2.this.high.getText());
				try {
					if(PI.equals("pay bills")) {
						test2.this.PBPanel.setList(PBPanelBiz.queryMulCd(map));
						test2.this.PBPanel.refresh();
						//System.out.println("pay");
					}
					else if(PI.equals("income")) {
						test2.this.incomePanel.setList(IncomeBiz.queryMulCd(map));	
						test2.this.incomePanel.refresh();
						//System.out.println("income");
					}
					else {
						test2.this.PBPanel.setList(PBPanelBiz.queryMulCd(map));
						test2.this.incomePanel.setList(IncomeBiz.queryMulCd(map));
						test2.this.PBPanel.refresh();
						test2.this.incomePanel.refresh();
						//System.out.println("both");
					}
					
				}catch(Exception m){
					System.err.println(m.getMessage());
				}
			}
		});
		PISearchBtn.setBackground(Color.WHITE);
		PISearchBtn.setBounds(539, 29, 33, 31);
		pay_income.add(PISearchBtn);
		
		JButton PBAdd = new JButton("");
		PBAdd.setBackground(Color.WHITE);
		PBAdd.setBounds(394, 170, 23, 19);
		pay_income.add(PBAdd);
		
		JButton incomeAdd = new JButton("");
		incomeAdd.setBackground(Color.WHITE);
		incomeAdd.setBounds(699, 170, 23, 19);
		pay_income.add(incomeAdd);
		
		low = new JTextField();
		low.setBounds(155, 105, 46, 20);
		pay_income.add(low);
		low.setColumns(10);
		
		high = new JTextField();
		high.setColumns(10);
		high.setBounds(220, 105, 46, 20);
		pay_income.add(high);
		
		PBStartDate = new JTextField();
		PBStartDate.setColumns(10);
		PBStartDate.setBounds(155, 74, 91, 20);
		pay_income.add(PBStartDate);
		
		JLabel lblNewLabel_11 = new JLabel("-");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11.setBounds(256, 77, 10, 14);
		pay_income.add(lblNewLabel_11);
		
		PBEndDate = new JTextField();
		PBEndDate.setColumns(10);
		PBEndDate.setBounds(276, 74, 91, 20);
		pay_income.add(PBEndDate);
		
		JLabel lblNewLabel_12 = new JLabel("-");
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12.setBounds(206, 108, 10, 14);
		pay_income.add(lblNewLabel_12);
		
		JButton PIClear = new JButton("clear");
		PIClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				test2.this.PISearch.setText(null);
				test2.this.PICombo.setSelectedIndex(0);
				test2.this.PITypeCombo.setSelectedIndex(-1);
				test2.this.PBStartDate.setText(null);
				test2.this.PBEndDate.setText(null);
				test2.this.low.setText(null);
				test2.this.high.setText(null);
			}
		});
		PIClear.setBackground(Color.WHITE);
		PIClear.setBounds(582, 33, 63, 23);
		pay_income.add(PIClear);
		
		JLabel lblNewLabel_13 = new JLabel("date");
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_13.setBounds(93, 77, 52, 14);
		pay_income.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("amount");
		lblNewLabel_14.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_14.setBounds(93, 108, 52, 14);
		pay_income.add(lblNewLabel_14);
		
		PICombo = new JComboBox();
		
		PICombo.setBounds(380, 33, 69, 22);
		PICombo.addItem("");
		PICombo.addItem("pay bills");
		PICombo.addItem("income");
		pay_income.add(PICombo);
		PICombo.setSelectedIndex(0);
		
		PITypeCombo = new MyJComboBox();
		PITypeCombo.setItems(TypeBiz.query(), "type", "id");
		PITypeCombo.setSelectedIndex(-1);
		PITypeCombo.setBounds(460, 33, 69, 22);
		pay_income.add(PITypeCombo);
		
		JLabel lblNewLabel_15 = new JLabel("Total Amount:");
		lblNewLabel_15.setBounds(676, 11, 91, 14);
		pay_income.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("1200");
		lblNewLabel_16.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_16.setBounds(774, 11, 46, 14);
		pay_income.add(lblNewLabel_16);
		
		JPanel todo = new JPanel();
		tabbedPane.addTab("todo", null, todo, "todo");
		tabbedPane.setBackgroundAt(3, Color.WHITE);
		tabbedPane.setForegroundAt(3, Color.BLACK);
		tabbedPane.setEnabledAt(3, true);
		todo.setLayout(null);
		
		ready = new MyJPanel(1,this.initList(1));
		
		ready.setLayout(null);
		ready.setBorder(new LineBorder(new Color(0, 0, 0)));
		//ready.setBounds(35, 173, 229, 439);
		
		
		JScrollPane js_ready = new JScrollPane(ready,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		js_ready.setBounds(35, 173, 229, 430);
		ready.setPreferredSize(new Dimension(229, 425));
		JScrollBar js_ready_b = js_ready.getVerticalScrollBar();
		js_ready_b.setUnitIncrement(20);//滚轮灵敏度设置		
		//Container c = (Container)js_ready;
		todo.add(js_ready);
		
		
		
		
		//System.out.println(ready.getHeight());			
		
		doing = new MyJPanel(2,this.initList(2));
		doing.setLayout(null);
		doing.setBorder(new LineBorder(new Color(0, 0, 0)));
		//doing.setBounds(308, 173, 229, 430);
		
		JScrollPane js_doing = new JScrollPane(doing,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		js_doing.setBounds(308, 173, 229, 430);
		doing.setPreferredSize(new Dimension(229, 425));
		JScrollBar js_doing_b = js_doing.getVerticalScrollBar();
		js_doing_b.setUnitIncrement(20);//滚轮灵敏度设置		
		//Container c = (Container)js_ready;
		
		todo.add(js_doing);
		
		
		
		
		done = new MyJPanel(3,this.initList(3));
		done.setLayout(null);
		done.setBorder(new LineBorder(new Color(0, 0, 0)));
		//done.setBounds(578, 173, 229, 430);
		
		JScrollPane js_done = new JScrollPane(done,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		js_done.setBounds(578, 173, 229, 430);
		done.setPreferredSize(new Dimension(229, 425));
		JScrollBar js_done_b = js_done.getVerticalScrollBar();
		js_done_b.setUnitIncrement(20);//滚轮灵敏度设置	
		
		todo.add(js_done);
		
		
		textKeyWord = new JTextField();
		textKeyWord.setBounds(161, 23, 265, 31);
		todo.add(textKeyWord);
		textKeyWord.setColumns(10);
		
		JToggleButton sortByCT = new JToggleButton("");
		sortByCT.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				JToggleButton tmp = (JToggleButton)e.getSource();
				if(tmp.isSelected()) {
					TodoBiz.sortByCT(test2.this.ready.getList(),false);
				}
				else {
					TodoBiz.sortByCT(test2.this.ready.getList(),true);
				}
				test2.this.ready.refresh();
			}
		});
		sortByCT.setIcon(new ImageIcon("D:\\a\\java\\Shixun\\test\\Test\\resource\\down.jpg"));
		sortByCT.setSelectedIcon(new ImageIcon("D:\\a\\java\\Shixun\\test\\Test\\resource\\up.jpg"));
		
		sortByCT.setToolTipText("sort by create time");
		sortByCT.setBounds(35, 139, 22, 23);
		todo.add(sortByCT);
		
		JToggleButton sortBySFT = new JToggleButton("");
		sortBySFT.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				JToggleButton tmp = (JToggleButton)e.getSource();
				if(tmp.isSelected()) {
					TodoBiz.sortBySFT(test2.this.ready.getList(),false);
				}
				else {
					TodoBiz.sortBySFT(test2.this.ready.getList(),true);
				}
				test2.this.ready.refresh();
			}
		});
		sortBySFT.setIcon(new ImageIcon("D:\\a\\java\\Shixun\\test\\Test\\resource\\down.jpg"));
		sortBySFT.setSelectedIcon(new ImageIcon("D:\\a\\java\\Shixun\\test\\Test\\resource\\up.jpg"));
		sortBySFT.setToolTipText("sort by should finished time");
		sortBySFT.setBounds(64, 139, 16, 23);
		todo.add(sortBySFT);
		
		JLabel lblNewLabel_1 = new JLabel("create time");
		lblNewLabel_1.setBounds(86, 68, 77, 14);
		todo.add(lblNewLabel_1);
		
		CTStart = new JTextField();
		CTStart.setBounds(161, 65, 118, 20);
		todo.add(CTStart);
		CTStart.setColumns(10);
		
		CTEnd = new JTextField();
		CTEnd.setBounds(308, 65, 118, 20);
		todo.add(CTEnd);
		CTEnd.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("should finished time");
		lblNewLabel_3.setBounds(35, 99, 114, 14);
		todo.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("key word search");
		lblNewLabel_4.setBounds(57, 31, 99, 14);
		todo.add(lblNewLabel_4);
		
		SFTStart = new JTextField();
		SFTStart.setBounds(161, 96, 118, 20);
		todo.add(SFTStart);
		SFTStart.setColumns(10);
		
		SFTEnd = new JTextField();
		SFTEnd.setBounds(308, 96, 118, 20);
		todo.add(SFTEnd);
		SFTEnd.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("-");
		lblNewLabel_2.setBounds(289, 68, 11, 14);
		todo.add(lblNewLabel_2);
		
		JLabel lblNewLabel_5 = new JLabel("-");
		lblNewLabel_5.setBounds(289, 99, 11, 14);
		todo.add(lblNewLabel_5);
		
		this.mjpGroup = new MyJPanel[] {ready,doing,done};
		
		ready.setMjpGroup(mjpGroup);
		doing.setMjpGroup(mjpGroup);
		done.setMjpGroup(mjpGroup);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Map<String,String> map = new LinkedHashMap<>();
				map.put("textKeyWord",test2.this.textKeyWord.getText());
				map.put("CTStart",test2.this.CTStart.getText());
				map.put("CTEnd", test2.this.CTEnd.getText());
				map.put("SFTStart", test2.this.SFTStart.getText());
				map.put("SFTEnd", test2.this.SFTEnd.getText());
				
				if(test2.this.comboBox.getSelectedItem().equals("ready")) {
					test2.this.ready.setList(TodoBiz.query(map,1));
					test2.this.ready.refresh();
				}
				else if(test2.this.comboBox.getSelectedItem().equals("doing")) {
					test2.this.doing.setList(TodoBiz.query(map,2));
					test2.this.doing.refresh();
				}
				else if(test2.this.comboBox.getSelectedItem().equals("done")) {
					test2.this.done.setList(TodoBiz.query(map,3));
					test2.this.done.refresh();
				}
				else {
					test2.this.ready.setList(TodoBiz.query(map,1));
					test2.this.doing.setList(TodoBiz.query(map,2));
					test2.this.done.setList(TodoBiz.query(map,3));
					
					test2.this.ready.refresh();
					test2.this.doing.refresh();
					test2.this.done.refresh();
				}
				
				
//				System.out.println("result:");
//				System.out.println(test2.this.readyList+"");
				
			}
		});
		btnNewButton.setIcon(new ImageIcon(".\\resource\\search.png"));
		btnNewButton.setBounds(504, 23, 33, 31);
		todo.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("clear");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				test2.this.textKeyWord.setText(null);
				test2.this.CTStart.setText(null);
				test2.this.CTEnd.setText(null);
				test2.this.SFTStart.setText(null);
				test2.this.SFTEnd.setText(null);
				test2.this.comboBox.setSelectedIndex(0);
			}
		});
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(541, 27, 63, 23);
		todo.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Ready");
		lblNewLabel.setBounds(130, 148, 43, 14);
		todo.add(lblNewLabel);
		
		JLabel lblNewLabel_6 = new JLabel("Doing");
		lblNewLabel_6.setBounds(404, 148, 34, 14);
		todo.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Done");
		lblNewLabel_7.setBounds(678, 148, 33, 14);
		todo.add(lblNewLabel_7);
		
		comboBox = new JComboBox<>();

		comboBox.addItem("");
		comboBox.addItem("ready");
		comboBox.addItem("doing");
		comboBox.addItem("done");
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(434, 27, 63, 22);
		todo.add(comboBox);
		
		JButton todoAddBtn = new JButton("");
		todoAddBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TodoAddDlg tddD = new TodoAddDlg(test2.this);
			}
		});
		todoAddBtn.setBackground(Color.WHITE);
		todoAddBtn.setBounds(238, 148, 23, 19);
		todo.add(todoAddBtn);
		
		ready.makeButtonList();
		doing.makeButtonList();
		done.makeButtonList();
		
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
		tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
		tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);
		/*
		
		*/
		//this.setLocationRelativeTo(null);
		
		
	}
	private List<Map<String,String>> initList(int panelNo) {
		List<Map<String,String>> list;
		list = TodoBiz.queryByStatus(panelNo);
		return list;
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
