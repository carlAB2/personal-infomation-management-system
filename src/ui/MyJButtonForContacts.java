package ui;

//public class MyJButtonForContactsForContacts {
//
//}


import java.awt.Container;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import biz.ContactsBiz;

public class MyJButtonForContacts extends JButton implements MouseListener {

	private int index;
	private boolean isInPanel;
	private Point origin;
	private Point tmp;
	private MyJPanelForContacts parent;
	
	private void f() {
		this.addMouseListener(this);
		this.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				if(MyJButtonForContacts.this.isInPanel) {
					MyJButtonForContacts.this.isInPanel=false;
					
					Container jp = MyJButtonForContacts.this.getParent().getParent().getParent().getParent();
					//JFrame jp = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, MyJButtonForContacts.this.getParent().getParent().getParent().getParent());
					MyJButtonForContacts.this.getParent().remove(MyJButtonForContacts.this);
					
					//jp.add(MyJButtonForContacts.this);
					
					jp.add(MyJButtonForContacts.this);
				}
				Point p = MyJButtonForContacts.this.getLocation();
				MyJButtonForContacts.this.setLocation(p.x+e.getX()-tmp.x,p.y+e.getY()-tmp.y);
				MyJButtonForContacts.this.getParent().getParent().getParent().getParent().revalidate();
				MyJButtonForContacts.this.getParent().getParent().getParent().getParent().repaint();
				/*
				if(MyJButtonForContacts.this.getParent()==(Container)MyJButtonForContacts.this.jp)					
					System.out.println("dragging");
				*/
			}
		});
		
	}
	public MyJButtonForContacts(int index, Point origin,String text) {
		super(text);
		this.index = index;
		this.isInPanel = isInPanel;
		this.origin = origin;
		tmp = new Point();

		f();
	}

	public MyJButtonForContacts(){
		super();
		index = -1;
		isInPanel = true;
		tmp = new Point();

		f();
	}
	
	public MyJButtonForContacts(String text,MyJPanelForContacts parent){
		super(text);
		index = -1;
		isInPanel = true;
		tmp = new Point();
		this.parent = parent;

		f();
	}
	
	public MyJButtonForContacts(MyJPanelForContacts parent){

		index = -1;
		isInPanel = true;
		tmp = new Point();
		this.parent = parent;

		f();
	}
	
	public MyJButtonForContacts(int index, boolean isInPanel) {
		super();
		this.index = index;
		this.isInPanel = isInPanel;
		tmp = new Point();
		
		f();
	}

	public MyJButtonForContacts(String text,int index,boolean isInPanel){
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
				String str = this.parent.buttonRemove(this.index).get("id");
				ContactsBiz.delete(str);
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

