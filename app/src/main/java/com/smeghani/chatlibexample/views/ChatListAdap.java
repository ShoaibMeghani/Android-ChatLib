package com.smeghani.chatlibexample.views;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.smeghani.chatlib.model.ChatItem;
import com.smeghani.chatlib.views.ChatListBaseAdap;
import com.smeghani.chatlibexample.R;

import java.util.List;

/**
 * Created by smeghani on 3/25/2017.
 */

public class ChatListAdap extends ChatListBaseAdap {

    private Context mContext;

    public ChatListAdap(@NonNull Context context, @LayoutRes int resource, @NonNull List<ChatItem> objects) {
        super(context, resource, objects);
        mContext = context;
    }

    @Override
    public void displayProfilePic(ImageView iv) {
        iv.setBackground(mContext.getResources().getDrawable(R.mipmap.ic_launcher));
    }

    @Override
    public String getColorPrimaryHex() {
        return "#3F51B5";
    }
}
