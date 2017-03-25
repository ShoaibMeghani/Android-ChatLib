package com.smeghani.chatlibexample.data;

import com.smeghani.chatlib.model.ChatItem;

import java.util.ArrayList;

/**
 * Created by smeghani on 3/22/2017.
 */

public class ChatDataHelper {

    public static ArrayList<ChatItem> getChatItemList(){
        ArrayList<ChatItem> chatItems = new ArrayList<>();

        ChatItem chatItem1 = new ChatItem();
        chatItem1.setId("1");
        chatItem1.setTime("2017-03-02T12:03:03Z");
        chatItem1.setLabel("hello");
        chatItem1.setProfilePic("");
        chatItem1.setTitle("Alex");
        chatItem1.setUnreadCount(0);

        ChatItem chatItem2 = new ChatItem();
        chatItem2.setId("2");
        chatItem2.setTime("2017-03-02T12:03:03Z");
        chatItem2.setLabel("hello");
        chatItem2.setProfilePic("");
        chatItem2.setTitle("Martin");
        chatItem2.setUnreadCount(1);

        ChatItem chatItem3 = new ChatItem();
        chatItem3.setId("3");
        chatItem3.setTime("2017-03-02T12:03:03Z");
        chatItem3.setLabel("hello");
        chatItem3.setProfilePic("");
        chatItem3.setTitle("Jason");
        chatItem3.setUnreadCount(0);


        chatItems.add(chatItem1);
        chatItems.add(chatItem2);
        chatItems.add(chatItem3);

        return chatItems;
    }
}
