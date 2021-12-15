package dao;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import util.DBHelper;

public class IncomeDao {
	public static List<Map<String,String>> query(){
		String sql = "select i.id,i.date,i.amount,i.type_id,i.info,t.type"
				+ "  from income i left join type t on i.type_id=t.id";
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
	
	public static List<Map<String,String>> queryMulCd(Map<String,String> map){
		String sql = "select i.id,i.date,i.amount,i.type_id,i.info,t.type"
				+ "  from income i left join type t on i.type_id=t.id where 1=1";
		
		List<String> tmpList = new ArrayList<>();
		if(map.get("keyword") != null && !map.get("keyword").trim().isEmpty()) {
			sql += "  and (t.type like ? or i.info like ?)";
			tmpList.add(map.get("keyword"));
			tmpList.add(map.get("keyword"));
		}
		if(map.get("type") != null && !map.get("type").trim().isEmpty()) {
			sql += "  and t.id=?";
			tmpList.add(map.get("type"));
		}
		if(map.get("startDate") != null && !map.get("startDate").trim().isEmpty()) {
			sql += "  and i .date>=?";
			tmpList.add(map.get("startDate"));
		}
		if(map.get("endDate") != null && !map.get("endDate").trim().isEmpty()) {
			sql += "  and i.date<=?";
			tmpList.add(map.get("endDate"));
		}
		if(map.get("low") != null && !map.get("low").trim().isEmpty()) {
			sql += "  and i.amount>=?";
			tmpList.add(map.get("low"));
		}
		if(map.get("high") != null && !map.get("high").trim().isEmpty()) {
			sql += "  and i.amount<=?";
			tmpList.add(map.get("high"));
		}
		
		
		List<Map<String,String>> list =new ArrayList<>();
		
		String str;
		try {
			List<Map<String,Object>> tmp = DBHelper.select(sql,tmpList.toArray());
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
	public static void delete(String id){
		String sql = "delete from income where id=?";
		try {
			DBHelper.update(sql,id);
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
}





















