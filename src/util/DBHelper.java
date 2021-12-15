package util;

import java.sql.*;
import java.util.*;

public class DBHelper {

	static {
		// 加载驱动( 只要加载一次  )
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("数据库加载驱动失败!", e);
		}
	}

	/**
	 * 用于执行增删改(insert,delete,update)语句的方法
	 * @param sql	 语句
	 * @param params 参数数组(可变参数数组)
	 * @return	更新的数据库记录数
	 */
	public static int update(String sql, Object... params) {
		//System.out.println("SQL: " + sql);
		//System.out.println("参数: " + Arrays.toString(params));
		String url = "jdbc:mysql://127.0.0.1:3306/shixun";
		String user = "root";
		String password = "123456";
		// 获取连接 
		// 关闭连接  try ( ... ) 会在try执行之后自动管理
		try (Connection conn = DriverManager.getConnection(url, user, password);) {
			// 创建语句
			PreparedStatement ps = conn.prepareStatement(sql);
			// 添加参数
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i + 1, params[i]);
			}
			// 执行语句
			System.out.println(ps.toString().substring(42));
			return ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("執行SQL語句失败!", e);
		}
	}

	/**
	 * 用于执行查询(select)语句的方法
	 * @param sql
	 * @param params
	 * @return
	 */
	public static List<Map<String, Object>> select(String sql, Object... params) {
		//System.out.println("SQL: " + sql);
		//System.out.println("参数: " + Arrays.toString(params));
		String url = "jdbc:mysql://127.0.0.1:3306/shixun";
		String user = "root";
		String password = "123456";
		// 获取连接 
		// 关闭连接  try ( ... ) 会在try执行之后自动管理
		try (Connection conn = DriverManager.getConnection(url, user, password);) {
			// 创建语句
			PreparedStatement ps = conn.prepareStatement(sql);
			// 添加参数
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i + 1, params[i]);
			}
			// 执行语句
			System.out.println(ps.toString().substring(42));
			ResultSet rs = ps.executeQuery();
			// 获取结果集元数据对象
			ResultSetMetaData rsmd = rs.getMetaData();
			List<Map<String, Object>> ret = new ArrayList<>();
			while (rs.next()) {
				Map<String, Object> row = new LinkedHashMap<>();
				for (int i = 0; i < rsmd.getColumnCount(); i++) {
					String columnName = rsmd.getColumnName(i + 1);
					Object value = rs.getObject(columnName);
					row.put(columnName, value);
				}
				ret.add(row);
			}
			return ret;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException("執行SQL語句失败!", e);
		}
	}

	public static void main(String[] args) {
		
		System.out.println(select("select * from todo where status=1"));
		System.out.println("------------------------");
//		System.out.println(select("select * from hall where id=?", 1));
//		System.out.println("------------------------");
//		System.out.println(select("select * from hall where name like '%2%'"));
//		System.out.println("------------------------");

	}

}
