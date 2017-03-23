package com.mook.dubbo.core.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.junit.Test;

import com.alibaba.fastjson.JSONObject;

/**
 * 
 * Description: 文件上传、下载
 *
 * @author dehai.wang@changhong.com
 * @date 2017-03-02 18:09:38
 * @version 1.0
 *
 */
@SuppressWarnings("deprecation")
public class HttpClientDemo {
    static class Struct {
        private String imagedata;
        private String orderno;

        public String getImagedata() {
            return imagedata;
        }

        public void setImagedata(String imagedata) {
            this.imagedata = imagedata;
        }

        public String getOrderno() {
            return orderno;
        }

        public void setOrderno(String orderno) {
            this.orderno = orderno;
        }
    }

    @Test
    public void postImgTest() {

        HttpPost httppost = new HttpPost("http://10.7.73.77:9999");

        String data = null;
        String id = null;
        try {
            Struct s = new Struct();
            s.setImagedata(wrapImgToStr());
            id = System.currentTimeMillis() + "";
            s.setOrderno(id);
            System.err.println(id);
            data = new ObjectMapper().writeValueAsString(s);
        } catch (IOException e) {
            e.printStackTrace();
        }

        CloseableHttpClient httpclient = HttpClients.createDefault();

        StringEntity se = new StringEntity(data, "UTF-8");
        se.setContentType("application/json");
        httppost.setEntity(se);

        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(httppost);
        } catch (IOException e) {
            e.printStackTrace();
        }

        StatusLine statusLine = response.getStatusLine();
        if (200 == statusLine.getStatusCode()) {
            HttpEntity entity = response.getEntity();
            String result = null;
            try {
                result = EntityUtils.toString(entity, "UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
            JSONObject resultObj = JSONObject.parseObject(result);
            int errCode = resultObj.getIntValue("errocode");
            System.err.println(errCode);
//            System.err.println(resultObj);
            System.err.println(id);
        }

    }

    private String wrapImgToStr() {
        InputStream is = null;
        try {
            is = new FileInputStream(new File("d:/test2.jpg"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String imgStr = null;
        try {
            imgStr = Base64.encodeBase64String(IOUtils.toByteArray(is));
            System.err.println(imgStr);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return imgStr;
    }

    @SuppressWarnings({ "resource" })
    @Test
    public void getDataTest() {

        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpGet get = new HttpGet("http://112.74.49.93:10086/api");
            HttpResponse response = httpclient.execute(get);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String result = EntityUtils.toString(response.getEntity(), "UTF-8");
                JSONObject resultObj = JSONObject.parseObject(result);
                String xml = resultObj.getString("xml");
                String imgData = resultObj.getString("imgdata");
                String orderNo = resultObj.getString("orderno");
                System.err.println(orderNo);
                System.err.println(xml);
                Document doc = DocumentHelper.parseText(xml.trim());
                System.err.println(doc);
                System.err.println(imgData);
                System.err.println("END");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
