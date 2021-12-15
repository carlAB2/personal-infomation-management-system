package util;

import java.awt.Point;

import ui.PanelLengthInfo;

public class CalPos {
	final static int doing = 2;
	final static int done = 3;
	
	
	public static boolean isInOtherPanel(Point origin,int panel) {
		boolean isIn=false;
		Point left_down;
		Point right_down;
		Point tmp = new Point();
		tmp.x=origin.x;
		tmp.y=origin.y;
		if(panel==doing) {
			//tmp.setLocation(tmp.x+35,tmp.y+173);
			left_down = new Point(tmp.x,tmp.y+PanelLengthInfo.l2);
			right_down = new Point(tmp.x+PanelLengthInfo.l1,tmp.y+PanelLengthInfo.l2);
			if(left_down.x>308 && left_down.x < 537 && left_down.y>173 && left_down.y<598) {
				isIn=true;
			}
			else if(right_down.x>=308 && right_down.x <= 537 && right_down.y>173 && right_down.y<598) {
				isIn=true;
			}
			
		}
		else if(panel==done){
			//tmp.setLocation(tmp.x+308,tmp.y+173);
			left_down = new Point(tmp.x,tmp.y+PanelLengthInfo.l2);
			right_down = new Point(tmp.x+PanelLengthInfo.l1,tmp.y+PanelLengthInfo.l2);
			if(left_down.x>578 && left_down.x < 807 && left_down.y>173 && left_down.y<598) {
				isIn=true;
			}
			else if(right_down.x>578 && right_down.x < 807 && right_down.y>173 && right_down.y<598) {
				isIn=true;
			}
		}
		
		return isIn;
	}
}
