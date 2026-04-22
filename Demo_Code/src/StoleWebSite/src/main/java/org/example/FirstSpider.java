package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;

public class FirstSpider {

    // 忽略SSL证书
    static {
        try {
            HttpsURLConnection.setDefaultHostnameVerifier((hostname, session) -> true);
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, new X509TrustManager[]{
                    new X509TrustManager() {
                        @Override public void checkClientTrusted(X509Certificate[] chain, String authType) {}
                        @Override public void checkServerTrusted(X509Certificate[] chain, String authType) {}
                        @Override public X509Certificate[] getAcceptedIssuers() {return new X509Certificate[0];}
                    }
            }, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    void test(String url) throws IOException {
        //直接伪装成微信/QQ
        Map<String, String> headers = new HashMap<>();
        headers.put("User-Agent", "Mozilla/5.0 (Linux; Android 14; SM-G988B) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/124.0.6367.180 Mobile Safari/537.36 XWEB/1478 MMWEBSDK/20250401 MMWEBID/9999 MicroMessenger/8.0.56.2580(0x28003839) WeChat/arm64 Weixin NetType/WIFI Language/zh_CN ABI/arm64");
        headers.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
        headers.put("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
        headers.put("Accept-Encoding", "gzip, deflate, br");
        headers.put("Connection", "keep-alive");
        headers.put("Upgrade-Insecure-Requests", "1");
        headers.put("Referer", "https://wx.qq.com/");

        Document doc = Jsoup.connect(url)
                .headers(headers)
                .timeout(9500)
                .ignoreHttpErrors(true)
                .followRedirects(true)
                .get();

        System.out.println("=== 真实网页内容 ===");
        System.out.println("标题：" + doc.title());
        System.out.println("正文：" + doc.text());
    }
    public static void main(String[] args) throws Exception {
        FirstSpider f=new FirstSpider();
        f.test("https://baidu.com");
    }
}