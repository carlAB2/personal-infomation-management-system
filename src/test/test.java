package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Rectangle;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class test extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test frame = new test();
					frame.setVisible(true);
					JFrame jf = new JFrame("test");
					jf.setVisible(true);
					jf.setBounds(new Rectangle(0,0,300,100));
					//jf.setEnabled(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JDesktopPane desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);
		new testJD();
	}

}
