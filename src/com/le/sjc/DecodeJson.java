package com.le.sjc;
import org.json.*;
/**
 * Created by sunjianchun on 17/1/20.
 */
public class DecodeJson {
    public static void main(String[] args) {
        String json = "{\"pageInfo\": {\"pageName\": \"abc\",\"pagePic\": \"http://example.com/content.jpg\"}, " +
                "\"posts\": [" +
                "{\"post_id\": \"123456789012_123456789012\",\"actor_id\": \"1234567890\",\"picOfPersonWhoPosted\": \"http://example.com/photo.jpg\",\"nameOfPersonWhoPosted\": \"Jane Doe\",\"message\": \"Sounds cool. Can't wait to see it!\",\"likesCount\": \"2\",\"comments\": [],\"timeOfPost\": \"1234567890\"},{\"post_id\": \"123456789012_123456789012\",\"actor_id\": \"1234567890\",\"picOfPersonWhoPosted\": \"http://example.com/photo.jpg\",\"nameOfPersonWhoPosted\": \"Jane Doe\",\"message\": \"Sounds cool. Can't wait to see it!\",\"likesCount\": \"2\",\"comments\": [],\"timeOfPost\": \"1234567890\"}]}";

        JSONObject jsonObject = new JSONObject(json);
        String pagename = jsonObject.getJSONObject("pageInfo").getString("pageName");
        String pagepic = jsonObject.getJSONObject("pageInfo").getString("pagePic");

        System.out.println("pagename : " + pagename);
        System.out.println("pagePic : " + pagepic);

        JSONArray jsonArray = jsonObject.getJSONArray("posts");

        for(int i = 0; i < jsonArray.length(); i++) {

            JSONObject j = jsonArray.getJSONObject(i);
            String post_id = j.getString("post_id");
            String actor_id = j.getString("actor_id");
            String picOfPersonWhoPosted = j.getString("picOfPersonWhoPosted");
            String nameOfPersonWhoPosted = j.getString("nameOfPersonWhoPosted");
            String message = j.getString("message");
            String likesCount = j.getString("likesCount");
            JSONArray comments = j.getJSONArray("comments");
            String timeOfPost = j.getString("timeOfPost");

            System.out.println("ID : " + i);
            System.out.println("post_id : " + post_id);
            System.out.println("actor_id : " + actor_id);
            System.out.println("picOfPersonWhoPosted : " + picOfPersonWhoPosted);
            System.out.println("nameOfPersonWhoPosted : " + nameOfPersonWhoPosted);
            System.out.println("message : " + message);
            System.out.println("likesCount : " + likesCount);
            System.out.println("comments : " + comments);
            System.out.println("timeOfPost : " + timeOfPost);



        }

    }
}