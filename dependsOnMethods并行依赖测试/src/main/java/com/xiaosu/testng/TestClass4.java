package com.xiaosu.testng;

import org.testng.annotations.Test;

public class TestClass4 {
	@Test(dependsOnMethods = { "f1" })
	public void f2() throws InterruptedException {
		System.out.println(Thread.currentThread().getId() + "�߳̿�ʼִ��" + this.getClass().getSimpleName() + "�Ĳ��Է���f2");
		Thread.sleep(3000);
	}

	@Test
	public void f1() throws InterruptedException {
		System.out.println(Thread.currentThread().getId() + "�߳̿�ʼִ��" + this.getClass().getSimpleName() + "�Ĳ��Է���f1");
		Thread.sleep(3000);
	}
}
