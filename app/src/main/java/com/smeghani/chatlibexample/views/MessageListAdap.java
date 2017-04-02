package com.smeghani.chatlibexample.views;

import android.content.Context;
import android.widget.ImageView;

import com.smeghani.chatlib.model.MessageItem;
import com.smeghani.chatlib.views.MessageListBaseAdap;
import com.smeghani.chatlibexample.R;
import com.smeghani.chatlibexample.data.ChatDataHelper;

import java.util.ArrayList;

/**
 * Created by smeghani on 4/1/2017.
 */

public class MessageListAdap extends MessageListBaseAdap {

    private Context mContext;

    public MessageListAdap(Context context, int resource, ArrayList<MessageItem> list) {
        super(context, resource, list);
        mContext = context;
    }

    @Override
    public void displayPic(ImageView iv, String url) {

    }

    @Override
    public void displayProfile(ImageView iv, String url) {
        iv.setBackground(mContext.getResources().getDrawable(R.mipmap.ic_launcher));
    }

    @Override
    public boolean isByAuthor(String userId) {
        return userId.equals(ChatDataHelper.USERID);
    }
}
