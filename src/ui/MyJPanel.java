package ui;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JPanel;

public class MyJPanel extends JPanel{
	List<MyJButton> listButton;
	private List<Map<String,String>> list;
	public List<Map<String, String>> getList() {
		return list;
	}

	public void setList(List<Map<String, String>> list) {
		this.list = list;
	}

	MyJPanel [] mjpGroup;
	private final int pageNo;
	
	private int count;
	private int buttonWidth;
	private int buttonHeight;
	private int d1,d2;
	Point startPos;
	
	public MyJPanel() {
		super();
		this.count=0;
		this.listButton = new ArrayList<>();
		this.d1=10;
		this.d2=11;
		this.buttonWidth = 209;
		this.buttonHeight = 47;
		this.startPos = new Point(d1,d2);
		this.pageNo = 1;
		this.list=null;
	}
	
	public MyJPanel(int pageNo,List<Map<String,String>> list) {
		super();
		this.count=0;
		this.listButton = new ArrayList<>();
		this.d1=10;
		this.d2=11;
		this.buttonWidth = 209;
		this.buttonHeight = 47;
		this.startPos = new Point(d1,d2);
		this.pageNo = pageNo;
		this.list = list;
//		makeButtonList();
		
	}
	
	public void addButton(MyJButton mjb) {
		mjb.setindex(count);
		int x = d1;
		int y = d2+buttonHeight*count;
		Point p = new Point(x,y);
		
		mjb.setorigin(p);
		mjb.setBounds(x,y,buttonWidth,buttonHeight);
		
		this.add(mjb);
		listButton.add(mjb);
		mjb.setPanelNo(this.pageNo);
		
		mjb.setisInPanel(true);
		mjb.setMap(list.get(count));
		++count;
		
		//System.out.println(this.getPreferredSize());
		if(this.count*this.buttonHeight+11>this.getPreferredSize().height) {
			this.setPreferredSize(new Dimension(229,this.getPreferredSize().height+this.buttonHeight));
		}
		
		
	}
	
	public void buttonBack(MyJButton mjb) {
		mjb.setisInPanel(true);
		mjb.setLocation(mjb.getorigin());
		this.add(mjb);
		this.getParent().revalidate();
		this.getParent().repaint();
	}
	
	public Map<String,String> buttonRemove(int index) {
		MyJButton tmp;
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
	
	public MyJPanel[] getMjpGroup() {
		return mjpGroup;
	}

	public void setMjpGroup(MyJPanel[] mjpGroup) {
		this.mjpGroup = mjpGroup;
	}

	public void makeButtonList() {
		MyJButton mjb;
		String str_1;
		for(Map<String,String> tmp : list) {
			str_1="";
			
			//Date date = new Date();
			str_1 += " "+tmp.get("title");
			str_1 += " "+tmp.get("place");
			str_1 +=" "+ tmp.get("event");
			//str_1 +=" " + tmp.get("");
			
			for(int i=0;i<70;++i)
				str_1 += " ";
			
			mjb = new MyJButton();
			mjb.setText(str_1.substring(0,25));
			mjb.setMjpGroup(this.mjpGroup);
			mjb.setToolTipText("<html><b>"+"create time:"+tmp.get("create_date").substring(0,10)+" "
								+tmp.get("create_date").substring(11,19)+"</b><br>"
								+"<b>SFT:"+tmp.get("should_complete_time").replace('T', ' ')+"</b><br>"
								+str_1.substring(0,30));
			mjb.setFocusPainted(false);
			this.addButton(mjb);
		}
	}
	
}































