package com.xiaosu.testng;

import org.testng.annotations.Test;

public class TestClass2 {
	@Test(groups={"g2"})
	public void f2() throws InterruptedException {
		System.out.println(Thread.currentThread().getId() + "�߳̿�ʼִ��" + this.getClass().getSimpleName() + "�Ĳ��Է���f2");
		Thread.sleep(3000);
	}
}
