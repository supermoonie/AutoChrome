package com.github.supermoonie.example;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.supermoonie.auto.AutoChrome;
import com.github.supermoonie.httpclient.CustomHttpClient;
import com.github.supermoonie.type.network.Cookie;
import com.github.supermoonie.type.page.FrameTree;
import com.github.supermoonie.type.storage.StorageType;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author supermoonie
 * @since 2021/8/23
 */
public class NativeCef {

    @Test
    public void nc() throws Exception {
        AutoChrome autoChrome = new AutoChrome(9222, "about:blank", 5_000);
        for (int i = 0; i < 1; i++) {
            autoChrome.navigate("https://www.hermes.com/hk/en/product/mosaique-au-24-mini-bag-H079054CKP9/");
            autoChrome.waitCondition(autoChrome1 -> (boolean) autoChrome1.eval("!!document.getElementById('add-to-cart-button-in-stock')"), 5_000);
            TimeUnit.SECONDS.sleep(6);
//            autoChrome.eval("document.getElementById('add-to-cart-button-in-stock').click()");
//            TimeUnit.SECONDS.sleep(10);
        }
        JOptionPane.showMessageDialog(null, "...");
    }

    @Test
    public void cookie() throws Exception {
        AutoChrome autoChrome = new AutoChrome(9222, "Mosaique au 24 mini bag | Hermès Hong Kong SAR", 5_000);
//        autoChrome.clearBrowserCache();
//        autoChrome.clearBrowserCookies();
//        autoChrome.getStorage().clearDataForOrigin("www.hermes.com", StorageType.all.value);
        List<Cookie> allCookie = autoChrome.getAllCookies();
        for (Cookie cookie : allCookie) {
            System.out.println(JSON.toJSONString(cookie));
        }
        CustomHttpClient httpClient = new CustomHttpClient(new HttpHost("127.0.0.1", 8888));
        RequestBuilder requestBuilder = RequestBuilder.create("post").setUri("https://bck.hermes.com/add-to-cart");
        List<String> cookies = new ArrayList<>();
        cookies.add("ECOM_SESS");
        cookies.add("_cs_mk");
        cookies.add("_gid");
        cookies.add("_ga");
        cookies.add("_ga_Y862HCHCQ7");
        cookies.add("datadome");
        for (Cookie cookie : allCookie) {
            if (cookies.contains(cookie.getName()) && cookie.getDomain().contains("hermes")) {
                requestBuilder.addHeader("cookie", cookie.getName() + ":" + cookie.getValue());
            }
        }
//        requestBuilder.setHeader("sec-fetch-site", "same-site");
//        requestBuilder.setHeader("sec-fetch-mode", "cors");
//        requestBuilder.setHeader("sec-fetch-dest", "empty");
//        requestBuilder.setHeader(":authority", "bck.hermes.com");
//        requestBuilder.setHeader(":method", "POST");
//        requestBuilder.setHeader(":path", "/add-to-cart");
//        requestBuilder.setHeader(":scheme", "https");
        requestBuilder.setHeader("origin", "https://www.hermes.com");
        requestBuilder.setHeader("referer", "https://www.hermes.com/hk/en/product/mosaique-au-24-mini-bag-H079054CKP9/");
        requestBuilder.setHeader("Content-Type", "application/json");
        requestBuilder.setEntity(new StringEntity("{\"locale\":\"hk_en\",\"items\":[{\"category\":\"direct\",\"sku\":\"H079054CKP9\"}]}"));
        httpClient.execute(requestBuilder.build(), new ResponseHandler<Void>() {
            @Override
            public Void handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
                System.out.println(EntityUtils.toString(response.getEntity()));
                return null;
            }
        });
    }

    @Test
    public void captcha() throws Exception {
        AutoChrome autoChrome = new AutoChrome(9222, "You have been blocked", 5_000);
//        autoChrome.navigate("https://geo.captcha-delivery.com/captcha/?initialCid=AHrlqAAAAAMAfqGQflgv2cQA36YggA%3D%3D&hash=2211F522B61E269B869FA6EAFFB5E1&cid=ItJHcWb~2WaHwqh~kW54tm3S1qy8fDQ6ciwgn2fY2najY_tIlvTk.PTvTz5MIwovGbhzCT_ujC2ws5hPnrFTE9kA7YbjWXy.~qE4~CWO7_&t=fe&referer=https%3A%2F%2Fwww.hermes.com%2Fhk%2Fen%2Fproduct%2Fmosaique-au-24-mini-bag-H079054CKP9%2F&s=13461");
//        FrameTree frameTree = autoChrome.getPage().getFrameTree();
//        System.out.println(JSON.toJSONString(frameTree));
        autoChrome.click(".geetest_btn");
    }
}
