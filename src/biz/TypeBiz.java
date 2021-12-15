package biz;

import java.util.List;
import java.util.Map;

import dao.TypeDao;

public class TypeBiz {
	public static List<Map<String,String>> query(){
		
		return TypeDao.query();
	}
}
