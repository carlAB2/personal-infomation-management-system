package dao;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import util.DBHelper;

public class DiaryDao {
	public static List<Map<String,String>> query(){
		String sql = "select * from diary";
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
	
	public static List<Map<String,String>> queryByKeyword(Map<String,String> map){
		
		String sql = "select * from diary where 1=1";
		List<String> tmpList = new ArrayList<>();
		
		if(map.get("diaryKeyword") != null && !map.get("diaryKeyword").trim().isEmpty()) {
			sql += "  and (weather like ? or about_place like ? or"
					+"  about_people like ? or happening like ?)";
			
			tmpList.add(map.get("diaryKeyword"));
			tmpList.add(map.get("diaryKeyword"));
			tmpList.add(map.get("diaryKeyword"));
			tmpList.add(map.get("diaryKeyword"));		
		}
		
		if(map.get("startDate") != null && !map.get("startDate").trim().isEmpty()) {
			sql += "  and date >= ?";
			tmpList.add(map.get("startDate"));
		}
		
		if(map.get("endDate") != null && !map.get("endDate").trim().isEmpty()) {
			sql += "  and date <= ?";
			tmpList.add(map.get("endDate"));
		}
		
		List<Map<String,String>> list =new ArrayList<>();
		
		String str;	
		try {
			List<Map<String,Object>> tmp = DBHelper.select(sql, tmpList.toArray());;
			Map<String,String> map1;
			
			for(Map<String,Object> tmp_map : tmp) {
				map1 = new LinkedHashMap<>();
				
				for(String str_tmp:tmp_map.keySet()) {
					
					str = String.valueOf(tmp_map.get(str_tmp));		
					if(str.contentEquals("null") || str.trim().isEmpty())
						str="";
					
					map1.put(str_tmp, str);
				}
				
				list.add(map1);
			}
			
		}catch(Exception e) {
			System.err.println( e.getMessage());
		}
		
		
		return list;
	}
	
	public static void delete(String id) {
		
		String sql = "delete from diary where id=?";
		try {
			DBHelper.update(sql, Integer.parseInt(id));
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public static void insert(Map<String,String> map) {
		
		String sql = "insert into diary values(null,?,now(),?,?,?)";
		
		try {
			DBHelper.update(sql, map.get("weather"),map.get("place"),map.get("people"),map.get("happening"));
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
		
	}
}






















