package com.qihoo.study;

import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by luoyong on 17-1-4.
 */
public class Main {
    static Set<UUID> uuids = new HashSet<>(2000000);

    public static void main(String[] args) {

        boolean is = Files.isWritable(Paths.get("/opt/opt/json"));
        if(!is){
            System.out.println("not writable");
            return;
        }
        Integer i = 0;
        Main m = new Main();
        m.addOne(i);
        System.out.println(i);
        System.out.println(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
//        for(int i=0; i<20000000; i++) {
//            if (!uuids.contains(UUID.randomUUID())) {
//                uuids.add(UUID.randomUUID());
//            }
//        }
//        System.out.println(DateFormatUtils.format(new Date(), "yyyy-MM-dd'T'HH:mm:ss"));
//        List<String> lists = new ArrayList<>();
//        for (String s : lists) {
//            System.out.println(s);
//        }
//        if (lists.size() == 0) {
//            return;
//        }
//
//        ExecutorService executorService = new ThreadPoolExecutor(1, 30, 60L, TimeUnit.SECONDS, new LinkedBlockingDeque(1000), new ThreadPoolExecutor.CallerRunsPolicy());
//        for(int i=0; i<100; i++) {
//            executorService.execute(new T());
//        }
//
//        executorService.shutdown();
//        long start = System.currentTimeMillis();
//        try {
//            executorService.awaitTermination(1000L, TimeUnit.SECONDS);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        long period = System.currentTimeMillis() - start;
//        System.out.println("++++++++++++++++++++=" + period);
    }

    public void append(String str){
        str = str + "1";
    }

    public void addOne(Integer i){
        i++;
    }
    static class T implements Runnable{

        @Override
        public void run() {
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
