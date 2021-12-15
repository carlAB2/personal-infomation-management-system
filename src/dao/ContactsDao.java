package dao;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import util.DBHelper;

public class ContactsDao {
	public static List<Map<String,String>> query(){
		String sql = "select c.id,c.name,g.gname gname,c.phone,c.mail, c.birth,c.city,c.work_place,c.remark"
				+ "  from contacts c left join shixun.group g on (c.group_id=g.id)";
		List<Map<String,String>> list = new ArrayList<>();//c.id,c.name,g.name gname,c.phone,c.mail, c.birth,c.city,c.work_place,c.remark
		
		String str;
		try {
			List<Map<String,Object>> tmp = DBHelper.select(sql);
			Map<String,String> map;
			
			for(Map<String,Object> tmp_map : tmp) {
				map = new LinkedHashMap<>();
				
				for(String str_tmp:tmp_map.keySet()) {
					
					str = String.valueOf(tmp_map.get(str_tmp));		
					if(str.contentEquals("null") || str.trim().isEmpty())
						str="";
					
					map.put(str_tmp, str);
				}
				
				list.add(map);
			}
			
		}catch(Exception e) {
			System.err.println( e.getMessage());
		}
		
		
//		System.out.println("\n\n\n\n\n");
//		System.out.println(list+"");
//		System.out.println("\n\n\n\n\n");
		
		return list;
	}
	
	public static void delete(int id) {
		String sql = "delete from contacts where id=?";
		try {
			DBHelper.update(sql, id);
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public static List<Map<String,String>> queryBykeyword(Map<String,String> map){
		List<Map<String,String>> list = new ArrayList<>();
		List<String> a_list = new ArrayList<>();
		
		String sql = "select c.id,c.name,g.gname,c.phone,c.mail, c.birth,c.city,c.work_place,c.remark"
				+ "  from contacts c left join shixun.group g on c.group_id=g.id where 1=1";
		String str2 = map.get("keyword");
		if(str2!=null && !str2.trim().isEmpty()) {
			sql +="  and (name like ? or phone like ?"
				    +"  or mail like ? or birth like ? or city like ? or "
				    +"  work_place like ? or remark like ?)";
			a_list.add(str2);
			a_list.add(str2);
			a_list.add(str2);
			a_list.add(str2);
			a_list.add(str2);
			a_list.add(str2);
			a_list.add(str2);
		}
		str2 = map.get("group");
		if(str2 != null && !str2.trim().isEmpty()) {
			sql += "  and group_id=?";
			a_list.add(str2);
		}
		
		String str;
		try {
			List<Map<String,Object>> tmp = DBHelper.select(sql,a_list.toArray());
			Map<String,String> map2;
			
			for(Map<String,Object> tmp_map : tmp) {
				map2 = new LinkedHashMap<>();
				
				for(String str_tmp:tmp_map.keySet()) {
					
					str = String.valueOf(tmp_map.get(str_tmp));		
					if(str.contentEquals("null") || str.trim().isEmpty())
						str="";
					
					map2.put(str_tmp, str);
				}
				
				list.add(map2);
			}
			
		}catch(Exception e) {
			System.err.println( e.getMessage());
		}
		
		return list;
	}
}

























