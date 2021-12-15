package biz;

import java.util.List;
import java.util.Map;

import dao.ContactsDao;

public class ContactsBiz {
	public static List<Map<String,String>> query() {
		List<Map<String,String>> list = ContactsDao.query();
		sort(list);
		return list;
	}
	
	public static void delete(String id) {
		ContactsDao.delete(Integer.parseInt(id));
	}
	
	public static List<Map<String,String>> queryByKeyword(Map<String,String> map){
		List<Map<String,String>> list = ContactsDao.queryBykeyword(map);
		sort(list);
		return list;
	}
	
	private static void sort(List<Map<String,String>> list) {
		list.sort((m1,m2)->m1.get("name").compareTo(m2.get("name")));
	}
}
