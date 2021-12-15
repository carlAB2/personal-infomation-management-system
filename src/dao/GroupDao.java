package dao;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import util.DBHelper;

public class GroupDao {
	public static List<Map<String,String>> query(){
		String sql = "SELECT * FROM shixun.group";
		
		List<Map<String,String>> list =new ArrayList<>();
		
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
		
		return list;
	}
	
	public static void insert(String name) {
		String sql = "insert into shixun.group values(null,?)";
		
		try {
			DBHelper.update(sql,name);
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
		
	}
	public static void delete(String id) {
		String sql = "delete from shixun.group where id=?";
		try {
			DBHelper.update(sql,id);
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
}














