package com.wanq.wechat.mp.config;

import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "wechat.mp")
public class WechatMpProperties {

    /**
     * 设置微信公众号的 appID
     */
    private String appId;

    /**
     * 设置微信公众号的 app secret
     */
    private String secret;

    /**
     * 设置微信公众号的 token
     */
    private String token;

    /**
     * 设置微信公众号的 EncodingAESkey
     */
    private String aesKey;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAesKey() {
        return aesKey;
    }

    public void setAesKey(String aesKey) {
        this.aesKey = aesKey;
    }

    @Override
    public String toString() {
        return "WechatMpProperties{" +
                "appId='" + appId + '\'' +
                ", secret='" + secret + '\'' +
                ", token='" + token + '\'' +
                ", aesKey='" + aesKey + '\'' +
                '}';
    }
}
