package com.qihoo.study.thread;

public class SleepTest {

	public static void main(String[] args) throws InterruptedException {
		Thread aThread = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println(Thread.currentThread().isInterrupted());
				System.out.println("first sleep");
				try {
					Thread.currentThread().sleep(4000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().isInterrupted());
				System.out.println("second sleep");
				try {
					Thread.currentThread().sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().isInterrupted());
				System.out.println("do something");
			}
		});
		
		aThread.start();
		aThread.interrupt();
		Thread.currentThread().sleep(1500);
		aThread.interrupt();
		System.out.println("outer done");
	}
}
