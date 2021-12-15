package biz;

import java.util.List;
import java.util.Map;

import dao.TodoDao;

public class TodoBiz {
	public static List<Map<String,String>> queryByStatus(int status){
		
			return TodoDao.queryByStatus(status);
	}
	
	public static void updateById(String id,int status) {
		TodoDao.updateById(Integer.parseInt(id), status);
	}
	
	public static void delete(String id) {
		TodoDao.delete(Integer.parseInt(id));
	}
	
	public static void sortByCT(List<Map<String,String>> list,boolean isAsc) {
		if(isAsc) {
			list.sort((m1,m2)->Integer.parseInt(m1.get("id"))-Integer.parseInt(m2.get("id")));
		}
		else {
			//System.out.println(list+"");
			list.sort((m1,m2)->Integer.parseInt(m2.get("id"))-Integer.parseInt(m1.get("id")));
			//System.out.println("After sort:");
			//System.out.println(list+"");
		}
		
	}
	public static void sortBySFT(List<Map<String,String>> list,boolean isAsc) {
		if(isAsc) {
			list.sort((l1,l2)->l1.get("should_complete_time").compareTo(l2.get("should_complete_time")));
		}
		else {
			list.sort((l1,l2)->l2.get("should_complete_time").compareTo(l1.get("should_complete_time")));
		}
	}
	
	public static List<Map<String,String>> query(Map<String,String> map,int status){
		
		return TodoDao.query(map,status);
	}
	public static void update(String id,Map<String,String> map) {
		TodoDao.update(id, map);
	}
	
	public static void insert(Map<String,String> map) {
		TodoDao.insert(map);
	}
}















