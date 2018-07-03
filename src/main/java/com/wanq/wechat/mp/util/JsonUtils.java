package com.wanq.wechat.mp.util;

import me.chanjar.weixin.mp.util.json.WxMpGsonBuilder;

public class JsonUtils {
    public static String toJson(Object object) {
        return WxMpGsonBuilder.create().toJson(object);
    }
}
