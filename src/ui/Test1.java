package ui;

import java.awt.EventQueue;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Test1 extends JFrame {

	private JPanel contentPane;
	static Point origin = new Point();
	private JTextField txtSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test1 frame = new Test1();
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
	public Test1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1026, 663);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(78, 157, 230, 400);
		contentPane.add(panel);
		panel.setLayout(null);
		
		MyJButton btnNewButton_1 = new MyJButton("New button_1");
		
		btnNewButton_1.setBounds(10, 11, 210, 45);
		panel.add(btnNewButton_1);
		/*
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				origin.x = e.getX();
				origin.y = e.getY();
			}
		});
		btnNewButton_1.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				//btnNewButton.repaint();
				Point p = btnNewButton.getLocation();
				btnNewButton_1.setLocation(p.x+e.getX()-origin.x,p.y+e.getY()-origin.y);
			}
		});
		
		btnNewButton_1.addMouseListener(new MyMouseListener() {
			public void mouseReleased(MouseEvent e) {
				System.out.println("mosue released: "+e.getPoint()+"");
			}
		});
		btnNewButton_1.addMouseListener(new MyMouseListener() {
			public void mousePressed(MouseEvent e) {
				System.out.println("mosue pressed: "+e.getPoint()+"");
			}
		});
		btnNewButton_1.addMouseListener(new MyMouseListener() {
			public void mouseClicked(MouseEvent e) {
				System.out.println("mosue clicked: "+e.getPoint()+"");
			}
		});
		*/
		//System.out.println(panel.getParent()+"");
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(353, 157, 230, 400);
		contentPane.add(panel_1);
		
		MyJButton btnNewButton_1_1 = new MyJButton("New button_1");
		btnNewButton_1_1.setBounds(10, 11, 210, 45);
		panel_1.add(btnNewButton_1_1);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(78, 123, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(177, 123, 89, 23);
		contentPane.add(btnNewButton_2);
		
		txtSearch = new JTextField();
		txtSearch.setToolTipText("search key world");
		txtSearch.setBounds(78, 26, 239, 33);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.setIcon(new ImageIcon("D:\\a\\java\\Shixun\\test\\Test\\resource\\search.png"));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBounds(317, 26, 33, 33);
		contentPane.add(btnNewButton_3);
	}
	
	class MyMouseListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
