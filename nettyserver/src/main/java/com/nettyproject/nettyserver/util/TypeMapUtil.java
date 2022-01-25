package com.nettyproject.nettyserver.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/1/26
 */


public class TypeMapUtil {

    private static final Map<Integer,Class<?>> TYPE_MAP = new HashMap<>();

    public static void put(Integer type,Class<?> c){
        TYPE_MAP.put(type,c);
    }

    public static Class<?> get(Integer type){
        return TYPE_MAP.get(type);
    }

}
