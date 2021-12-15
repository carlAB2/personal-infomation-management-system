package biz;

import java.util.List;
import java.util.Map;

import dao.GroupDao;

public class GroupBiz {
	public static List<Map<String,String>> query(){
		return GroupDao.query();
	}
	public static void insert(String name) {
		GroupDao.insert(name);
	}
	public static void delete(String id) {
		GroupDao.delete(id);
	}
	
}
