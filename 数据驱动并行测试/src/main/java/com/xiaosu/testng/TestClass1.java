package com.xiaosu.testng;

import org.testng.annotations.Test;

public class TestClass1 {
	@Test(dataProvider = "data", dataProviderClass = DataProviderSource.class)
	public void f1(String s1, String s2, String s3) throws InterruptedException {
		System.out.println(Thread.currentThread().getId() + "线程执行数据" + s1 + "\t" + s2 + "\t" + s3);
		Thread.sleep(3000);
	}
}
