package com.github.supermoonie.example;

import com.alibaba.fastjson.JSON;
import com.github.supermoonie.auto.AutoChrome;
import com.github.supermoonie.type.network.Cookie;
import com.github.supermoonie.type.storage.StorageType;
import org.junit.Test;

import javax.swing.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
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
        autoChrome.clearBrowserCache();
        autoChrome.clearBrowserCookies();
        autoChrome.getStorage().clearDataForOrigin("www.hermes.com", StorageType.all.value);
        List<Cookie> allCookie = autoChrome.getAllCookies();
        for (Cookie cookie : allCookie) {
            System.out.println(JSON.toJSONString(cookie));
        }
//        CustomHttpClient httpClient = new CustomHttpClient(new HttpHost("127.0.0.1", 8888));
//        RequestBuilder requestBuilder = RequestBuilder.create("post").setUri("https://bck.hermes.com/add-to-cart");
//        List<String> cookies = new ArrayList<>();
//        cookies.add("ECOM_SESS");
//        cookies.add("_cs_mk");
//        cookies.add("_gid");
//        cookies.add("_ga");
//        cookies.add("_ga_Y862HCHCQ7");
//        cookies.add("datadome");
//        for (Cookie cookie : allCookie) {
//            if (cookies.contains(cookie.getName()) && cookie.getDomain().contains("hermes")) {
//                requestBuilder.addHeader("cookie", cookie.getName() + ":" + cookie.getValue());
//            }
//        }
//        requestBuilder.setHeader("sec-fetch-site", "same-site");
//        requestBuilder.setHeader("sec-fetch-mode", "cors");
//        requestBuilder.setHeader("sec-fetch-dest", "empty");
//        requestBuilder.setHeader(":authority", "bck.hermes.com");
//        requestBuilder.setHeader(":method", "POST");
//        requestBuilder.setHeader(":path", "/add-to-cart");
//        requestBuilder.setHeader(":scheme", "https");
//        requestBuilder.setHeader("origin", "https://www.hermes.com");
//        requestBuilder.setHeader("referer", "https://www.hermes.com/hk/en/product/mosaique-au-24-mini-bag-H079054CKP9/");
//        requestBuilder.setHeader("Content-Type", "application/json");
//        requestBuilder.setEntity(new StringEntity("{\"locale\":\"hk_en\",\"items\":[{\"category\":\"direct\",\"sku\":\"H079054CKP9\"}]}"));
//        httpClient.execute(requestBuilder.build(), new ResponseHandler<Void>() {
//            @Override
//            public Void handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
//                System.out.println(EntityUtils.toString(response.getEntity()));
//                return null;
//            }
//        });
    }

    @Test
    public void captcha() throws Exception {
        AutoChrome autoChrome = new AutoChrome(9222, "You have been blocked", 5_000);
//        autoChrome.navigate("https://geo.captcha-delivery.com/captcha/?initialCid=AHrlqAAAAAMAfqGQflgv2cQA36YggA%3D%3D&hash=2211F522B61E269B869FA6EAFFB5E1&cid=ItJHcWb~2WaHwqh~kW54tm3S1qy8fDQ6ciwgn2fY2najY_tIlvTk.PTvTz5MIwovGbhzCT_ujC2ws5hPnrFTE9kA7YbjWXy.~qE4~CWO7_&t=fe&referer=https%3A%2F%2Fwww.hermes.com%2Fhk%2Fen%2Fproduct%2Fmosaique-au-24-mini-bag-H079054CKP9%2F&s=13461");
//        FrameTree frameTree = autoChrome.getPage().getFrameTree();
//        System.out.println(JSON.toJSONString(frameTree));
        autoChrome.click(".geetest_btn");
    }

    @Test
    public void test() {
        try {
            HttpClient client = HttpClient.newBuilder()
                    .version(HttpClient.Version.HTTP_1_1)
                    .followRedirects(HttpClient.Redirect.ALWAYS)
                    .build();
            String proxyUrl = "http://list.sky-ip.net/user_get_ip_list?token=SbnzU8qJ7CLyoIVs1623746522101&qty=1&country=&time=1&format=txt&protocol=http";
            HttpResponse<String> proxyRes = client.send(HttpRequest.newBuilder().uri(URI.create(proxyUrl)).build(), HttpResponse.BodyHandlers.ofString());
            String proxy = proxyRes.body();
            System.out.println("proxy: " + proxy);
            String[] proxyArr = proxy.split(":");
            String proxyHost = proxyArr[0];
            int proxyPort = Integer.parseInt(proxyArr[1]);
            try (AutoChrome autoChrome = new AutoChrome.Builder().setProxy(proxy).build()) {
                autoChrome.navigateUntilDomReady("https://www.hermes.com/fr/fr/product/portefeuille-silk-in-classique-H075188CKAH/");
                autoChrome.waitCondition(autoChrome1 -> (boolean) autoChrome1.eval("!!document.getElementById('add-to-cart-button-in-stock')"), 5_000);
                TimeUnit.SECONDS.sleep(2);
                autoChrome.eval("document.getElementById('add-to-cart-button-in-stock').click()");
            } catch (Exception e) {
                e.printStackTrace();
            }

//            HttpClient proxyClient = HttpClient.newBuilder()
//                    .version(HttpClient.Version.HTTP_2)
//                    .followRedirects(HttpClient.Redirect.ALWAYS)
//                    .proxy(ProxySelector.of(new InetSocketAddress(proxyHost, proxyPort)))
//                    .build();
//            HttpRequest.Builder builder = HttpRequest.newBuilder()
//                    .uri(URI.create("https://bck.hermes.com/add-to-cart"))
//                    .timeout(Duration.ofMinutes(1))
//                    .POST(HttpRequest.BodyPublishers.ofString("{\"locale\":\"fr_fr\",\"items\":[{\"category\":\"direct\",\"sku\":\"H1H0622D92F34\"}]}"));
//            Map<String, String> headerMap = new HashMap<>();
//
//            for (String key : headerMap.keySet()) {
//                if (key.equalsIgnoreCase("datadome")) {
//                    continue;
//                }
//                if (key.equalsIgnoreCase("cookie")) {
//                    String value = headerMap.get(key);
//                    String[] arr = value.split(";");
//                    for (String cookie : arr) {
//                        builder.header("cookie", cookie.replaceAll("\\s", ""));
//                    }
//                } else {
//                    builder.setHeader(key, headerMap.get(key));
//                }
//            }
//            builder.setHeader("sec-fetch-site", "same-site");
//            builder.setHeader("sec-fetch-mode", "cors");
//            builder.setHeader("sec-fetch-dest", "empty");
//            builder.setHeader("referer", "https://www.hermes.com/fr/fr/product/blouse-manches-courtes-imprime-brides-de-gala-en-desordre-H1H0622D92F34/");
//            builder.setHeader("accept-encoding", "gzip, deflate, br");
//            builder.setHeader("accept-language", "en-US,en;q=0.9");
//            HttpResponse<byte[]> resp = proxyClient.send(builder.build(), HttpResponse.BodyHandlers.ofByteArray());
//            String s = GZIPUtils.uncompressToString(resp.body(), "UTF-8");
//            log.info("res: {}", s);
//            TimeUnit.SECONDS.sleep(10);
//        } catch (Exception e) {
//            log.error(e.getMessage(), e);
//            App.getInstance().getMainBrowser().loadURL("about:blank");
//            try {
//                AutoChrome autoChrome = new AutoChrome(9222, "about:blank", 5_000);
//                autoChrome.clearBrowserCache();
//                autoChrome.clearBrowserCookies();
//                autoChrome.getStorage().clearDataForOrigin("www.hermes.com", StorageType.all.value);
//                autoChrome.navigate("https://www.hermes.com/fr/fr/product/blouse-manches-courtes-imprime-brides-de-gala-en-desordre-H1H0622D92F34/");
//            } catch (Exception exception) {
//                log.error(exception.getMessage(), exception);
//            }
//            break;
//        }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
