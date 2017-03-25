package com.smeghani.chatlib.views;

import com.smeghani.chatlib.model.ChatItem;

import java.util.ArrayList;

/**
 * Created by smeghani on 3/21/2017.
 */

public interface ChatListListener {

    void onChatListItemClick(ChatItem chatItem, int position);
    void onChatListFetched(ArrayList<ChatItem> list);

}
