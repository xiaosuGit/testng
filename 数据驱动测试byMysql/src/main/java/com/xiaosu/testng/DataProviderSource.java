package com.xiaosu.testng;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.testng.annotations.DataProvider;
import com.xiaosu.utils.DBCPUtil;

public class DataProviderSource {
	@DataProvider(name = "datafromMysql", parallel = true)
	public static Object[][] getData() {
		// ��ȡ����
		Connection conn = DBCPUtil.getConnection();
		// �����¼����
		List<Object[]> records = null;
		Object[][] results = null;
		try {
			// ִ�в�ѯ�����������ArrayListHandler
			QueryRunner qr = new QueryRunner();
			records = qr.query(conn, "select login_name,mobile,identitynum from cb_user", new ArrayListHandler());
			DbUtils.close(conn);
			results = new Object[records.size()][];
			for (int i = 0; i < records.size(); i++) {
				results[i] = records.get(i);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getId() + "�̻߳�ȡ����");
		return results;
	}
}
