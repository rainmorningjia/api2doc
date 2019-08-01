package com.alibaba.api2doc.util;

import java.util.UUID;

public class ThreadNumberUtil {

    private static Long number;
    private static ThreadLocal<String> threadLocal=new ThreadLocal<String >(){
        public synchronized String initialValue(){
            return UUID.randomUUID().toString();
        }
    };
}
