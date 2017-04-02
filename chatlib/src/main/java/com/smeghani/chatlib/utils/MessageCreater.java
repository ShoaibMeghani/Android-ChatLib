package com.smeghani.chatlib.utils;

import com.smeghani.chatlib.model.MessageItem;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by smeghani on 4/1/2017.
 */

public class MessageCreater {

    public static MessageItem createTextMsg(String userId,String text,String profilePic){
        MessageItem msg = new MessageItem();
        msg.setUserId(userId);
        msg.setMsgType(MessageItem.MessageType.TEXT);
        msg.setData(getTextMsgObj(text,profilePic));
        return msg;
    }

    public static MessageItem createImageMsg(String userId,String imgUrl){
        MessageItem msg = new MessageItem();
        msg.setUserId(userId);
        msg.setMsgType(MessageItem.MessageType.IMAGE);
        msg.setData(getImageMsgObj(imgUrl));
        return msg;
    }

    private static JSONObject getTextMsgObj(String text,String profilePic) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("msg", text);
            jsonObject.put("profile_pic",profilePic);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    private static JSONObject getImageMsgObj(String text) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("img_url", text);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
}
