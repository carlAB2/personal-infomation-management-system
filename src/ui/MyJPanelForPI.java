package ui;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MyJPanelForPI extends JPanel{
	private final int label;
	public int getLabel() {
		return label;
	}



	List<MyJButtonForPI> listButton;
	private List<Map<String,String>> list;
	public List<Map<String, String>> getList() {
		return list;
	}

	public void setList(List<Map<String, String>> list) {
		this.list = list;
	}

	
	
	private int count;
	private int buttonWidth;
	private int buttonHeight;
	private int d1,d2;
	Point startPos;
	
	public MyJPanelForPI(int label) {
		super();
		this.count=0;
		this.listButton = new ArrayList<>();
		this.d1=10;
		this.d2=11;
		this.buttonWidth = 209;
		this.buttonHeight = 47;
		this.startPos = new Point(d1,d2);
		this.label = label;
		this.list=null;
	}
	
	public MyJPanelForPI(List<Map<String,String>> list,int label) {
		super();
		this.count=0;
		this.listButton = new ArrayList<>();
		this.d1=10;
		this.d2=11;
		this.buttonWidth = 209;
		this.buttonHeight = 47;
		this.startPos = new Point(d1,d2);
		this.label = label;
		this.list = list;
//		makeButtonList();
		
	}
	
	public void addButton(MyJButtonForPI mjb) {
		mjb.setindex(count);
		int x = d1;
		int y = d2+buttonHeight*count;
		Point p = new Point(x,y);
		
		mjb.setorigin(p);
		mjb.setBounds(x,y,buttonWidth,buttonHeight);
		
		this.add(mjb);
		listButton.add(mjb);

		
		mjb.setisInPanel(true);
		++count;
		
		//System.out.println(this.getPreferredSize());
		if(this.count*this.buttonHeight+11>this.getPreferredSize().height) {
			this.setPreferredSize(new Dimension(229,this.getPreferredSize().height+this.buttonHeight));
		}
		
		
	}
	
	public void buttonBack(MyJButtonForPI mjb) {
		mjb.setisInPanel(true);
		mjb.setLocation(mjb.getorigin());
		this.add(mjb);
		this.getParent().revalidate();
		this.getParent().repaint();
	}
	
	public Map<String,String> buttonRemove(int index) {
		MyJButtonForPI tmp;
		Point p;
		this.remove(listButton.remove(index));
		Map<String,String> map = list.remove(index);
		--count;
		int x;
		int y;
		for(int i=index;i<listButton.size();++i) {
			tmp = listButton.get(i);
			tmp.setindex(tmp.getindex()-1);
			x=d1;
			y=d2+this.buttonHeight*i;
			p = new Point(x,y);
			tmp.setLocation(p);
		}
		this.setPreferredSize(new Dimension(229,this.getPreferredSize().height-this.buttonHeight));
		
		this.getParent().revalidate();
		this.getParent().repaint();
		
		return map;
	}
	
	public void refresh() {
		this.removeAll();
		this.count=0;
		this.setPreferredSize(new Dimension(229, 425));
		this.listButton.clear();
		this.makeButtonList();
		this.getParent().revalidate();
		this.getParent().repaint();
	}
	/*
	public MyJPanelForPI[] getMjpGroup() {
		return mjpGroup;
	}

	public void setMjpGroup(MyJPanelForPI[] mjpGroup) {
		this.mjpGroup = mjpGroup;
	}
*/
	public void makeButtonList() {
		MyJButtonForPI mjb;
		String str_1="",str;
		float x1;
		int x2;
		
		for(Map<String,String> tmp : list) {
			//str_1="";
			
//			//Date date = new Date();
//			str_1 += " "+tmp.get("title");
//			str_1 += " "+tmp.get("place");
//			str_1 +=" "+ tmp.get("event");
			//str_1 +=" " + tmp.get("");
			
			
			x1=Float.parseFloat(tmp.get("amount"));
			x2=(int)x1;
			str=String.valueOf(x1);
			if(x1==x2)
				str=String.valueOf(x2);
			//System.out.println("x1:"+x1+"\nx2:"+x2);
			
			mjb = new MyJButtonForPI(this);
			mjb.setText("<html><b>"
						+str
					+ "</b>");
			mjb.setToolTipText("<html>date: "+tmp.get("date").substring(0,10)+"<br>type: "+tmp.get("type")+"<br>info: "
								+tmp.get("info"));
			//mjb.setHorizontalAlignment(SwingConstants.LEFT);
			mjb.setFocusPainted(false);
			this.addButton(mjb);
		}
	}
	
}


































