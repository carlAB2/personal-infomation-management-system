package ui;

import java.awt.Container;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import biz.TodoBiz;
import util.CalPos;

public class MyJButton extends JButton implements MouseListener {

	private int index;
	private boolean isInPanel;
	private Point origin;
	private Point tmp;
	private int panelNo;
	private MyJPanel []mjpGroup;
	Map<String,String> map;
	

	public Map<String, String> getMap() {
		return map;
	}
	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	private JFrame jf;
	private JPanel jp;
	
	
	private void f() {
		this.addMouseListener(this);
		this.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				if(MyJButton.this.isInPanel) {
					MyJButton.this.isInPanel=false;
					
					Container jp = MyJButton.this.getParent().getParent().getParent().getParent();
					//JFrame jp = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, MyJButton.this.getParent().getParent().getParent().getParent());
					MyJButton.this.getParent().remove(MyJButton.this);
					
					//jp.add(MyJButton.this);
					
					jp.add(MyJButton.this);
				}
				Point p = MyJButton.this.getLocation();
				MyJButton.this.setLocation(p.x+e.getX()-tmp.x,p.y+e.getY()-tmp.y);
				MyJButton.this.getParent().getParent().getParent().getParent().revalidate();
				MyJButton.this.getParent().getParent().getParent().getParent().repaint();
				/*
				if(MyJButton.this.getParent()==(Container)MyJButton.this.jp)					
					System.out.println("dragging");
				*/
			}
		});
		
	}
	public MyJButton(int index, Point origin,int panelNo,String text) {
		super(text);
		this.index = index;
		this.isInPanel = isInPanel;
		this.origin = origin;
		tmp = new Point();
		this.panelNo = panelNo;
		f();
		
	}

	public MyJButton(){
		super();
		index = -1;
		isInPanel = true;
		tmp = new Point();
		this.panelNo = 1;
		f();
	}
	
	public MyJButton(String text){
		super(text);
		index = -1;
		isInPanel = true;
		tmp = new Point();
		this.panelNo = 1;
		f();
	}
	public MyJButton(String text,JFrame jf){
		super(text);
		index = -1;
		isInPanel = true;
		tmp = new Point();
		this.panelNo = 1;
		this.jf = jf;
		f();
	}
	
	public MyJButton(String text,JPanel jp){
		super(text);
		index = -1;
		isInPanel = true;
		tmp = new Point();
		this.panelNo = 1;
		this.jp = jp;
		f();
	}
	
	
	public MyJButton(int index, boolean isInPanel) {
		super();
		this.index = index;
		this.isInPanel = isInPanel;
		tmp = new Point();
		this.panelNo = 1;
		f();
	}

	public MyJButton(String text,int index,boolean isInPanel){
		super(text);
		this.index=index;
		this.isInPanel=isInPanel;
		tmp = new Point();
		this.panelNo = 1;
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
	
	public int getPanelNo() {
		return panelNo;
	}
	public void setPanelNo(int panelNo) {
		this.panelNo = panelNo;
	}
	
	public MyJPanel[] getMjpGroup() {
		return mjpGroup;
	}
	public void setMjpGroup(MyJPanel[] mjpGroup) {
		this.mjpGroup = mjpGroup;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON3) {
			int opt = JOptionPane.showConfirmDialog(this.getParent().getParent().getParent(),"Are you sure delete this todo item?", "Confirm Infomation",JOptionPane.YES_NO_OPTION);
			if (opt == JOptionPane.YES_OPTION) {
				//确认继续操作
				//System.out.println("YES");
				
				 String id = this.mjpGroup[panelNo-1].buttonRemove(this.index).get("id");
				 TodoBiz.delete(id);
			}

		}
		else if(e.getButton() == MouseEvent.BUTTON1) {
			TodoInfoDlg tdDlg = new TodoInfoDlg(this);
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		tmp.x = e.getX();
		tmp.y = e.getY();
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		Point p1 = MyJButton.this.getLocation();
		Point p2 = new Point(p1.x,p1.y);
		Map<String,String> map;
		if(!this.isInPanel) {
			if(CalPos.isInOtherPanel(p2, panelNo+1)) {
	
				map = this.mjpGroup[panelNo-1].buttonRemove(this.index);
				map.put("status",String.valueOf(panelNo+1));
				TodoBiz.updateById(map.get("id"),panelNo+1);
				
				this.mjpGroup[panelNo].getList().add(map);
				this.mjpGroup[panelNo].addButton(this);
				
				
				this.mjpGroup[panelNo-1].getParent().revalidate();
				this.mjpGroup[panelNo-1].getParent().repaint();
//				this.getParent().revalidate();
//				this.getParent().repaint();
			}
			else {
				this.mjpGroup[panelNo-1].buttonBack(this);
			}
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
