package test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DBdemo {

	static String sql = null;
	static DBHelper db1 = null;
	static ResultSet ret = null;

	public static void main(String[] args) {
//		sql = "desc goods";//SQL语句
		sql="select count(*) from goods where goods_name='搜索' and is_deleted='0'";
		db1 = new DBHelper(sql);//创建DBHelper对象

		try {
			ret = db1.pst.executeQuery();//执行语句，得到结果集
//			while (ret.next()) {
//				String uid = ret.getString(1);
//				String ufname = ret.getString(2);
//				String ulname = ret.getString(3);
//				String udate = ret.getString(4);
//				System.out.println(uid + "\t" + ufname + "\t" + ulname + "\t" + udate );
//			}//显示数据
			
			while(ret.next()){
				String result = ret.getString(1);
				System.out.println(result);
			}

			ret.close();
			db1.close();//关闭连接
		} catch (SQLException e) {
			System.out.println("===============");
			e.printStackTrace();
		}
	}

}

