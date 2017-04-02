package com.smeghani.chatlib.views;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.smeghani.chatlib.R;
import com.smeghani.chatlib.model.MessageItem;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by smeghani on 3/26/2017.
 */

public abstract class MessageListBaseAdap extends RecyclerView.Adapter<MessageListBaseAdap.ViewHolder> {

    private ArrayList<MessageItem> mMsgList;
    private Context mContext;

    public MessageListBaseAdap(Context context, int resource, ArrayList<MessageItem> list) {
        mMsgList = list;
        mContext = context;
    }

    @Override
    public MessageListBaseAdap.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layout = -1;

        switch (viewType) {
            case 0:
                layout = R.layout.item_chat_text;
                break;

            case 1:
                layout = R.layout.item_chat_text_author;
                break;

            case 2:
                layout = R.layout.item_chat_image_author;
                break;

            case 3:
                layout = R.layout.item_chat_image;
                break;

            default:
                throw new IllegalArgumentException("no type specified");


        }
        View v = LayoutInflater
                .from(parent.getContext())
                .inflate(layout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MessageListBaseAdap.ViewHolder holder, int position) {
        try {
            holder.setMessage(getItem(position));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }



    @Override
    public int getItemCount() {
        return mMsgList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView mMessageView;
        ImageView ivPic, ivImage;


        public ViewHolder(View itemView) {
            super(itemView);
            mMessageView = (TextView) itemView.findViewById(R.id.message);
            ivPic = (ImageView) itemView.findViewById(R.id.iv_pic);
            ivImage = (ImageView) itemView.findViewById(R.id.iv_image);
        }

        public void setMessage(MessageItem msgItem) throws JSONException {
            JSONObject dataObj = msgItem.getData();

            if (msgItem.getMsgType().equals(MessageItem.MessageType.TEXT)) {


                String msg = dataObj.getString("msg");
                mMessageView.setText(msg);


            } else if (msgItem.getMsgType().equals(MessageItem.MessageType.IMAGE)) {


                String imageUrl = dataObj.getString("image_url");
                displayPic(ivImage, imageUrl);

            }else{
                throw new IllegalArgumentException("no type specified");
            }
            String profilePicUrl = dataObj.getString("profile_pic");
            displayProfile(ivPic, profilePicUrl);



        }
    }

    @Override
    public int getItemViewType(int position) {
        int type = -1;
        if (getItem(position).getMsgType().equals(MessageItem.MessageType.TEXT)) {
            if (isByAuthor(getItem(position).getUserId())) {
                type = 1;
            } else {
                type = 0;
            }
        } else if (getItem(position).getMsgType().equals(MessageItem.MessageType.IMAGE)) {
            if (isByAuthor(getItem(position).getUserId())) {
                type = 2;
            } else {
                type = 3;
            }
        }

        return type;
    }

    public abstract void displayPic(ImageView iv, String url);

    public abstract void displayProfile(ImageView iv, String url);

    public abstract boolean isByAuthor(String userId);



    public MessageItem getItem(int position){
        return mMsgList.get(position);
    }

}
