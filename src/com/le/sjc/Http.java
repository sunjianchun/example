package com.le.sjc;

import org.apache.http.HttpResponse;
import org.json.JSONObject;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;

import java.io.*;


/**
 * Created by sunjianchun on 17/1/21.
 */
class Http {
    public static JSONObject httpPost(String url, JSONObject jsonObject) {
        return httpPost(url, jsonObject, false);
    }

    public static JSONObject httpPost(String url, JSONObject jsonObject, boolean noNeedResponse) {

        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
        HttpPost method = new HttpPost(url);
        JSONObject jsonResult = null;

        try {
            if (null != jsonObject) {

                StringEntity stringEntity = new StringEntity(jsonObject.toString(), "utf-8");
                stringEntity.setContentEncoding("UTF-8");
                stringEntity.setContentType("application/json");
                method.setEntity(stringEntity);
            }
            HttpResponse result = defaultHttpClient.execute(method);

            if (result.getStatusLine().getStatusCode() == 200) {
                String str = "";
                str = EntityUtils.toString(result.getEntity());
                if (noNeedResponse) {
                    return null;
                } else {
                    jsonResult = new JSONObject(str);

                }
            }

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        return jsonResult;
    }
}

class Test {
        public static  void main(String [] args) {
             String str = "{\"query\": { \"match_all\": {} },\"sort\": { \"timestamp\": { \"order\": \"asc\" } },\"size\": 1}";
             String url = "http://192:9200/logs/_search?pretty";

             JSONObject jsonObject = new Http().httpPost(url,new JSONObject(str));
             System.out.println(jsonObject.toString());
        }
}
