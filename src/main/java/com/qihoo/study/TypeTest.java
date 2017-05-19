package com.qihoo.study;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by luoyong on 16-12-22.
 */
public class TypeTest {
    public static void main(String[] args) {
        ExecutorService executor = new ThreadPoolExecutor(5, 30, 60L, TimeUnit.SECONDS, new LinkedBlockingDeque(1000), new ThreadPoolExecutor.CallerRunsPolicy());
        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("++++++++++++++++++++");
            }
        });

//        executor.shutdown();

    }
}
