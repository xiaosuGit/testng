package com.xiaosu.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

public class DBCPUtil {
	public static DataSource ds = null;
	static {
		Properties prop = new Properties();
		try {
			// ����DBCPUtil��classpath·�������������ļ�,classpath�������ļ�·��
			prop.load(DBCPUtil.class.getClassLoader().getResourceAsStream("dbcpconfig.properties"));
			// ��ȡ���ӳ�����Դ
			ds = BasicDataSourceFactory.createDataSource(prop);
		} catch (Exception e) {
			throw new ExceptionInInitializerError("��ʼ���������������ļ�");
		}
	}

	public static Connection getConnection() {
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException("��������æ");
		}
	}

	public static void release(Connection conn, Statement stmt, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				rs = null;
				e.printStackTrace();
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				stmt = null;
				e.printStackTrace();
			}
		}
		// ��conn�Ż����ӳ���ȥ
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				conn = null;
				e.printStackTrace();
			}
		}
	}

}
