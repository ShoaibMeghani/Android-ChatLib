package com.smeghani.chatlib.model;

import org.json.JSONObject;

/**
 * Created by smeghani on 3/26/2017.
 */

public class MessageItem {

    private String mId;
    private String mUserId;
    private JSONObject mData;
    private MessageType mMsgType;



    public enum MessageType{
        TEXT(0),IMAGE(1);

        private final int value;
        private MessageType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public String getId() {
        return mId;
    }

    public void setId(String mId) {
        this.mId = mId;
    }

    public JSONObject getData() {
        return mData;
    }

    public void setData(JSONObject mData) {
        this.mData = mData;
    }

    public MessageType getMsgType() {
        return mMsgType;
    }

    public void setMsgType(MessageType mMsgType) {
        this.mMsgType = mMsgType;
    }

    public String getUserId() {
        return mUserId;
    }

    public void setUserId(String mUserId) {
        this.mUserId = mUserId;
    }
}
