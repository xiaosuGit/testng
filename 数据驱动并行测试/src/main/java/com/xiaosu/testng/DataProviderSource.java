package com.xiaosu.testng;

import org.testng.annotations.DataProvider;

public class DataProviderSource {
	@DataProvider(name = "data", parallel = true)
	public static Object[][] getData() {
		System.out.println(Thread.currentThread().getId() + "�̻߳�ȡ����");
		return new Object[][] { { "1", "2", "3" }, { "11", "12", "13" }, { "21", "22", "23" }, { "31", "32", "33" } };
	}
}
