package ui;

import java.awt.Container;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import biz.DiaryBiz;
import biz.IncomeBiz;
import biz.PBPanelBiz;

public class MyJButtonForPI extends JButton implements MouseListener {

	private int index;
	private boolean isInPanel;
	private Point origin;
	private Point tmp;
	private MyJPanelForPI parent;
	
	private void f() {
		this.addMouseListener(this);
		this.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				if(MyJButtonForPI.this.isInPanel) {
					MyJButtonForPI.this.isInPanel=false;
					
					Container jp = MyJButtonForPI.this.getParent().getParent().getParent().getParent();
					//JFrame jp = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, MyJButtonForPI.this.getParent().getParent().getParent().getParent());
					MyJButtonForPI.this.getParent().remove(MyJButtonForPI.this);
					
					//jp.add(MyJButtonForPI.this);
					
					jp.add(MyJButtonForPI.this);
				}
				Point p = MyJButtonForPI.this.getLocation();
				MyJButtonForPI.this.setLocation(p.x+e.getX()-tmp.x,p.y+e.getY()-tmp.y);
				MyJButtonForPI.this.getParent().getParent().getParent().getParent().revalidate();
				MyJButtonForPI.this.getParent().getParent().getParent().getParent().repaint();
				/*
				if(MyJButtonForPI.this.getParent()==(Container)MyJButtonForPI.this.jp)					
					System.out.println("dragging");
				*/
			}
		});
		
	}
	public MyJButtonForPI(int index, Point origin,String text) {
		super(text);
		this.index = index;
		this.isInPanel = isInPanel;
		this.origin = origin;
		tmp = new Point();

		f();
	}

	public MyJButtonForPI(){
		super();
		index = -1;
		isInPanel = true;
		tmp = new Point();

		f();
	}
	
	public MyJButtonForPI(String text,MyJPanelForPI parent){
		super(text);
		index = -1;
		isInPanel = true;
		tmp = new Point();
		this.parent = parent;

		f();
	}
	
	public MyJButtonForPI(MyJPanelForPI parent){

		index = -1;
		isInPanel = true;
		tmp = new Point();
		this.parent = parent;

		f();
	}
	
	public MyJButtonForPI(int index, boolean isInPanel) {
		super();
		this.index = index;
		this.isInPanel = isInPanel;
		tmp = new Point();
		
		f();
	}

	public MyJButtonForPI(String text,int index,boolean isInPanel){
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
				//e.getSource()
				if(this.parent.getLabel() == 1) {
					PBPanelBiz.delete(id);
				}
				else if(this.parent.getLabel() == 2) {
					IncomeBiz.delete(id);
				}
				this.parent.refresh();
			
			}

		}
		else if(e.getButton() == MouseEvent.BUTTON1) {
			
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




