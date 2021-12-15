package dao;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import util.DBHelper;

public class TypeDao {
	public static List<Map<String,String>> query(){
		
		String sql = "select * from type";
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
}
