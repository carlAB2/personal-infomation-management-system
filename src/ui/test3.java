package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class test3 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test3 frame = new test3();
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
	public test3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
JPanel ready = new JPanel();
		
		ready.setLayout(null);
		ready.setBorder(new LineBorder(new Color(0, 0, 0)));
		//ready.setBounds(35, 173, 229, 439);
		
		
		JScrollPane js_ready = new JScrollPane(ready,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		js_ready.setBounds(35, 173, 229, 1000);
		ready.setPreferredSize(new Dimension(229,439));
		JScrollBar js_ready_b = js_ready.getVerticalScrollBar();
		js_ready_b.setUnitIncrement(20);//滚轮灵敏度设置		
		
		contentPane.add(js_ready);
		
		JButton test;
		for(int i=0;i<100;++i) {
			test = new JButton("test"+(i+1));
			test.setBounds(6,i*20,20,20);
			ready.add(test);
		}
	}

}
