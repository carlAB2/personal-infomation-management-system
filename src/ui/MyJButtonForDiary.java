package ui;

import java.awt.Container;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import biz.DiaryBiz;

public class MyJButtonForDiary extends JButton implements MouseListener {

	private int index;
	private boolean isInPanel;
	private Point origin;
	private Point tmp;
	private MyJPanelForDiary parent;
	Map<String,String> map;
	
	public Map<String, String> getMap() {
		return map;
	}
	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	private void f() {
		this.addMouseListener(this);
		this.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				if(MyJButtonForDiary.this.isInPanel) {
					MyJButtonForDiary.this.isInPanel=false;
					
					Container jp = MyJButtonForDiary.this.getParent().getParent().getParent().getParent();
					//JFrame jp = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, MyJButtonForDiary.this.getParent().getParent().getParent().getParent());
					MyJButtonForDiary.this.getParent().remove(MyJButtonForDiary.this);
					
					//jp.add(MyJButtonForDiary.this);
					
					jp.add(MyJButtonForDiary.this);
				}
				Point p = MyJButtonForDiary.this.getLocation();
				MyJButtonForDiary.this.setLocation(p.x+e.getX()-tmp.x,p.y+e.getY()-tmp.y);
				MyJButtonForDiary.this.getParent().getParent().getParent().getParent().revalidate();
				MyJButtonForDiary.this.getParent().getParent().getParent().getParent().repaint();
				/*
				if(MyJButtonForDiary.this.getParent()==(Container)MyJButtonForDiary.this.jp)					
					System.out.println("dragging");
				*/
			}
		});
		
	}
	public MyJButtonForDiary(int index, Point origin,String text) {
		super(text);
		this.index = index;
		this.isInPanel = isInPanel;
		this.origin = origin;
		tmp = new Point();

		f();
	}

	public MyJButtonForDiary(){
		super();
		index = -1;
		isInPanel = true;
		tmp = new Point();

		f();
	}
	
	public MyJButtonForDiary(String text,MyJPanelForDiary parent){
		super(text);
		index = -1;
		isInPanel = true;
		tmp = new Point();
		this.parent = parent;

		f();
	}
	
	public MyJButtonForDiary(MyJPanelForDiary parent){

		index = -1;
		isInPanel = true;
		tmp = new Point();
		this.parent = parent;

		f();
	}
	
	public MyJButtonForDiary(int index, boolean isInPanel) {
		super();
		this.index = index;
		this.isInPanel = isInPanel;
		tmp = new Point();
		
		f();
	}

	public MyJButtonForDiary(String text,int index,boolean isInPanel){
		super(text);
		this.index=index;
		this.isInPanel=isInPanel;
		tmp = new Point();
		
		f();
	}
	
	public int getindex() {
		return index;
	}

	public void setindex(int index) {
		this.index = index;
	}

	public boolean isisInPanel() {
		return isInPanel;
	}

	public void setisInPanel(boolean isInPanel) {
		this.isInPanel = isInPanel;
	}
	

	public Point getorigin() {
		return origin;
	}

	public void setorigin(Point origin) {
		this.origin = origin;
	}
	
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON3) {
			int opt = JOptionPane.showConfirmDialog(this.getParent().getParent().getParent(),"Are you sure delete this todo item?", "Confirm Infomation",JOptionPane.YES_NO_OPTION);
			if (opt == JOptionPane.YES_OPTION) {
				//确认继续操作
				//System.out.println("YES");
				String id = this.parent.buttonRemove(this.index).get("id");
				DiaryBiz.delete(id);
				this.parent.refresh();
			
			}

		}
		else if(e.getButton() == MouseEvent.BUTTON1) {
			new DiaryInfoDlg(this);
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		tmp.x = e.getX();
		tmp.y = e.getY();
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		if(!this.isInPanel) {
			parent.buttonBack(this);
		}
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


