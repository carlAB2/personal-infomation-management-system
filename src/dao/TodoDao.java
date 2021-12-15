package dao;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import util.DBHelper;

public class TodoDao {
	public static List<Map<String,String>> queryByStatus(int status){
		String sql = "select * from todo where status=?";
		List<Map<String,String>> list = new ArrayList<>();
		String str;
		
		try {
			List<Map<String,Object>> tmp = DBHelper.select(sql,status);
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
	
	public static void updateById(int id,int status) {
		String sql = "update todo set status=? where id=?";
		try {
			DBHelper.update(sql, status,id);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public static void delete(int id) {
		String sql = "delete from todo where id=?";
		try {
			DBHelper.update(sql, id);
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public static List<Map<String,String>> query(Map<String,String> map,int status) {
		
		String sql = "select * from todo where status=?";
		List<Map<String,String>> list = new ArrayList<>();
		List<String> tmpList = new ArrayList<>();
		String str;		
		
		String textKeyWord = map.get("textKeyWord");
		String CTStart= map.get("CTStart");
		String CTEnd= map.get("CTEnd");
		String SFTStart= map.get("SFTStart");
		String SFTEnd= map.get("SFTEnd");
		
		tmpList.add(String.valueOf(status));
		
		if(textKeyWord != null && !textKeyWord.trim().isEmpty()) {
			sql += "  and (title like ? or place like ? or event like ?)";
			tmpList.add("%"+textKeyWord+"%");
			tmpList.add("%"+textKeyWord+"%");
			tmpList.add("%"+textKeyWord+"%");
		}
		
		if(CTStart != null && !CTStart.trim().isEmpty()) {
			sql += "  and create_date>=?";
			tmpList.add(CTStart);
		}
		if(CTEnd != null && !CTEnd.trim().isEmpty()) {
			sql += "  and create_date<=?";
			tmpList.add(CTEnd);
		}
		if(SFTStart != null && !SFTStart.trim().isEmpty()) {
			sql += "  and should_complete_time>=?";
			tmpList.add(SFTStart);
		}
		if(SFTEnd != null && !SFTEnd.trim().isEmpty()) {
			sql += "  and should_complete_time<=?";
			tmpList.add(SFTEnd);
		}
		
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
	
	public static void update(String id,Map<String,String> map) {
		String sql = "update todo set title=?,place=?,event=? where id=?";
		try {
			DBHelper.update(sql, map.get("title"),map.get("place"),map.get("event"),id);
		}catch(Exception e) {
			System.err.println( e.getMessage());
		}
	}
	
	public static void insert(Map<String,String> map) {
		String sql = "insert into todo(id,create_date,title,place,event,should_complete_time,status) "
				+ "values(null,now(),?,?,?,?,1)";
		try {
			DBHelper.update(sql, map.get("title"),map.get("place"),map.get("event"),map.get("SFT"));
		}catch(Exception e) {
			System.err.println( e.getMessage());
		}
	}
}






















