package biz;

import java.util.List;
import java.util.Map;

import dao.DiaryDao;

public class DiaryBiz {
	public static List<Map<String,String>> query(){
		List<Map<String,String>> list = DiaryDao.query();
		sort(list);
		return list;
	}
	
	public static void sort(List<Map<String,String>> list) {
		list.sort((m1,m2)->m2.get("date").compareTo(m1.get("date")));
	}
	
	public static List<Map<String,String>> queryByKeyword(Map<String,String> map){
		
		List<Map<String,String>> list = DiaryDao.queryByKeyword(map);
		sort(list);
		
		return list;
	}
	
	public static void delete(String id) {
		DiaryDao.delete(id);
	}
	
	public static void insert(Map<String,String> map) {
		DiaryDao.insert(map);
	}
}
