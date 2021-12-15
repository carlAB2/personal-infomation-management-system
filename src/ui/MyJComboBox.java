package ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JComboBox;

public class MyJComboBox extends JComboBox{
	private List<Map<String,String>> list;
	public List<Map<String, String>> getList() {
		return list;
	}

	public void setList(List<Map<String, String>> list) {
		this.list = list;
	}

	private String valueColumn;
	
	MyJComboBox(){
		super();	
	}
	
	public void setItems(List<Map<String,String>> list,String showColumn,String valueColumn){
		this.removeAllItems();
		this.addItem("");
		List<String> items = new ArrayList();
		for(int i=0;i<list.size();++i){
			items.add(list.get(i).get(showColumn)+"");
		}
		//super.setItems(items.toArray(new String[0]));
		for(String tmp:items) {
			this.addItem(tmp);
		}
		
		this.list = list;
		this.valueColumn = valueColumn;
	}
	
	public String getSelected(){
		int index = this.getSelectedIndex();
		if(index>0){
			Map<String,String>row = list.get(index-1);
			return row.get(valueColumn);
		}else{
			return "";
		}
	}
	
	public String getText(){
		return this.getSelected()+"";
	}
	
	public void refresh(String showColumn,String valueColumn) {
		this.setItems(list, showColumn, valueColumn);
	}
	
//	@Override
//	protected void checkSubclass(){
//		//继承swt控件必须覆盖该方法，并且只要清空代码即可
//		//super.checkSubclass();
//	}
}
