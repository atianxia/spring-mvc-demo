package com.qihoo.study.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.LocatedFileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.RemoteIterator;
import org.apache.hadoop.io.IOUtils;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * HDFS工具类
 * Author: 菩提树下的杨过(http://yjmyzz.cnblogs.com)
 * Since: 2015-05-21
 */
public class HDFSUtilTest {

    @Test
    public void test() throws IOException {
        Configuration conf = new Configuration();
        String newDir = "/test";
        //01.检测路径是否存在 测试
        if (HDFSUtil.exits(conf, newDir)) {
            System.out.println(newDir + " 已存在!");
        } else {
            //02.创建目录测试
            boolean result = HDFSUtil.createDirectory(conf, newDir);
            if (result) {
                System.out.println(newDir + " 创建成功!");
            } else {
                System.out.println(newDir + " 创建失败!");
            }
        }
        String fileContent = "Hi,hadoop. I love you";
        String newFileName = newDir + "/myfile.txt";

        //03.创建文件测试
        HDFSUtil.createFile(conf, newFileName, fileContent);
        System.out.println(newFileName + " 创建成功");

        //04.读取文件内容 测试
        System.out.println(newFileName + " 的内容为:\n" + HDFSUtil.readFile(conf, newFileName));

        //05. 测试获取所有目录信息
        FileStatus[] dirs = HDFSUtil.listStatus(conf, "/");
        System.out.println("--根目录下的所有子目录---");
        for (FileStatus s : dirs) {
            System.out.println(s);
        }

        //06. 测试获取所有文件
        FileSystem fs = FileSystem.get(conf);
        RemoteIterator<LocatedFileStatus> files = HDFSUtil.listFiles(fs, "/", true);
        System.out.println("--根目录下的所有文件---");
        while (files.hasNext()) {
            System.out.println(files.next());
        }
        fs.close();

        //删除文件测试
        boolean isDeleted = HDFSUtil.deleteFile(conf, newDir);
        System.out.println(newDir + " 已被删除");

    }
}