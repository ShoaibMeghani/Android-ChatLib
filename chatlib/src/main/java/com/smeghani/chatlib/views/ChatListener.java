package com.smeghani.chatlib.views;

import com.smeghani.chatlib.model.ChatItem;
import com.smeghani.chatlib.model.MessageItem;

import java.util.ArrayList;

/**
 * Created by smeghani on 3/21/2017.
 */

public interface ChatListener {


    void onChatMessagesFetched(ArrayList<MessageItem> list);
    void onChatLoadMoreComplete(ArrayList<MessageItem> list);

}
