package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Point;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class MainWin extends JFrame {

	private JPanel contentPane;
	static Point origin = new Point();
	JButton testButton=null;
	JButton testButton2=null;
	JPanel ready;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWin frame = new MainWin();
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
	public MainWin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 938, 798);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(34, 94, 250, 514);//panel.setBounds(34, 94, 220, 514);
		JScrollPane jsp = new JScrollPane(panel);//给panel添加滚动条
		jsp.setBounds(35,95,245,514);
		JScrollBar jsb = jsp.getVerticalScrollBar();
		jsb.setUnitIncrement(20);//滚轮灵敏度设置
		contentPane.add(jsp);
		
		
		
		JPanel ready = new JPanel();
		
		ready.setLayout(null);
		ready.setBorder(new LineBorder(new Color(0, 0, 0)));
		//ready.setBounds(35, 173, 229, 439);
		
		
		JScrollPane js_ready = new JScrollPane(ready,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		js_ready.setBounds(35, 173, 229, 430);
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
		
		
		GroupLayout gl_panel = new GroupLayout(panel);
		
		
		/*
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(455, Short.MAX_VALUE))
		);
		*/
		
		
		
		
		
		/*
			testButton = new JButton("test");
			testButton2 = new JButton("test2");
			gl_panel.setHorizontalGroup(
				gl_panel.createSequentialGroup()
				.addContainerGap()
				.addGroup(gl_panel.createParallelGroup(Alignment.CENTER)
						
						.addComponent(testButton, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
						.addComponent(testButton2, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
			));
			gl_panel.setVerticalGroup(
				gl_panel.createSequentialGroup()
						.addContainerGap()
						.addComponent(testButton, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()
						.addComponent(testButton2, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)						
						.addContainerGap(455, Short.MAX_VALUE)
			);
		*/	
		
		ParallelGroup pg = gl_panel.createParallelGroup(Alignment.CENTER);
		SequentialGroup sg = gl_panel.createSequentialGroup();
		
		
		for(int i=0;i<100;++i) {
			testButton = new JButton("test"+(i+1));
			pg.addComponent(testButton, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE);
			sg = sg.addContainerGap();
			sg.addComponent(testButton, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE);
		}
		
		gl_panel.setHorizontalGroup(
				gl_panel.createSequentialGroup()
				.addContainerGap()
				.addGroup(pg)
			);
		gl_panel.setVerticalGroup(
			gl_panel.createSequentialGroup()
			.addGroup(sg)
		);
			/*
			// 自动创建组件之间的间隙
			gl_panel.setAutoCreateGaps(true);
	        // 自动创建容器与触到容器边框的组件之间的间隙
			gl_panel.setAutoCreateContainerGaps(true);
			
			//Dimension preferredSize = new Dimension(63,26);
			for(int i=0;i<3;++i) {
				testButton = new JButton("test"+(i+1));
				//testButton.setSize(63,26);
				if(i==0)
					testButton2  = testButton;
				//testButton.setPreferredSize(preferredSize );
				//testButton.setSize();63,26
				pg.addComponent(testButton, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE);
				sg.addComponent(testButton, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE);
			}
			
			gl_panel.setHorizontalGroup(
					gl_panel.createSequentialGroup()
					//.addContainerGap()
					.addGroup(pg)
				);
			gl_panel.setVerticalGroup(sg);

			testButton.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					//MainWin.this.add(testButton);
					origin.x = e.getX();
					origin.y = e.getY();
				}
			});
			testButton.addMouseMotionListener(new MouseMotionAdapter() {
				public void mouseDragged(MouseEvent e) {
					//btnNewButton.repaint();
					Point p = testButton.getLocation();
					testButton.setLocation(p.x+e.getX()-origin.x,p.y+e.getY()-origin.y);
					panel.repaint();
				}
			});
			*/
			/*
			testButton = new JButton("test4");
			pg.addComponent(testButton, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE);
			sg.addComponent(testButton, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE);
			
			 
			gl_panel.setVerticalGroup(sg);
			gl_panel.setHorizontalGroup(
					gl_panel.createSequentialGroup()
					//.addContainerGap()
					.addGroup(pg)
				);
			*/
			//gl_panel.removeLayoutComponent(testButton2);
			//this.add(testButton2);
			
			
		//System.out.println(gl_panel.toString());
		
		panel.setLayout(gl_panel);
		//gl_panel.replace(testButton2,testButton);
//		testButton.setPreferredSize(new Dimension(100,100));
//		System.out.println(testButton.getPreferredSize()+"");
		//panel.remove(testButton2);
		//testButton2.setBounds(0, 0, 100, 100);
		//panel.repaint();
		//panel.revalidate();
	}
}

























