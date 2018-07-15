package com.xiaosu.testng;

import org.testng.annotations.Test;

public class TestClass4 {
	@Test(dependsOnMethods = { "f1" })
	public void f2() throws InterruptedException {
		System.out.println(Thread.currentThread().getId() + "线程开始执行" + this.getClass().getSimpleName() + "的测试方法f2");
		Thread.sleep(3000);
	}

	@Test
	public void f1() throws InterruptedException {
		System.out.println(Thread.currentThread().getId() + "线程开始执行" + this.getClass().getSimpleName() + "的测试方法f1");
		Thread.sleep(3000);
	}
}
