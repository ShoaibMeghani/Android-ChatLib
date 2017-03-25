package com.smeghani.chatlibexample.views;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;

import com.smeghani.chatlib.model.ChatItem;
import com.smeghani.chatlib.views.ChatListBaseAdap;

import java.util.List;

/**
 * Created by smeghani on 3/25/2017.
 */

public class ChatListAdap extends ChatListBaseAdap {

    public ChatListAdap(@NonNull Context context, @LayoutRes int resource, @NonNull List<ChatItem> objects) {
        super(context, resource, objects);
    }

    @Override
    public String getColorPrimaryHex() {
        return "#000000";
    }
}
