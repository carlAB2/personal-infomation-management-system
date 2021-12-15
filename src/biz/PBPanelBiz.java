package biz;

import java.util.List;
import java.util.Map;

import dao.IncomeDao;
import dao.PBPanelDao;

public class PBPanelBiz {
	public static List<Map<String,String>> query() {
		List<Map<String,String>> list = PBPanelDao.query();
		sort(list);
		
		return list;
	}
	
	public static List<Map<String,String>> queryMulCd(Map<String,String> map){
		List<Map<String,String>> list = PBPanelDao.queryMulCd(map);
		sort(list);
		
		return list;
	}
	
	public static void delete(String id){
		PBPanelDao.delete(id);
	}
	
	private static void sort(List<Map<String,String>> list) {
		list.sort((m1,m2)->m1.get("date").compareTo(m2.get("date")));
	}
}
