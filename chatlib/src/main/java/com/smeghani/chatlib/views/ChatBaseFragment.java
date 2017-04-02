package com.smeghani.chatlib.views;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smeghani.chatlib.model.MessageItem;
import com.smeghani.chatlib.utils.MessageCreater;

import java.util.ArrayList;

/**
 * Created by smeghani on 3/26/2017.
 */

public abstract class ChatBaseFragment extends Fragment implements ChatListener {

    private RecyclerView mChatListView;
    private ArrayList<MessageItem> mMsgList;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getChatLayoutResource(), null);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initObj(savedInstanceState);
        initView();

        fetchChatMessages();
    }

    public void initView() {
        mChatListView = (RecyclerView) getView().findViewById(getRecyclerViewId());
        mChatListView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mChatListView.setAdapter(getChatMessageAdapter());
    }

    public void initObj(Bundle savedInstanceState) {
        mMsgList = new ArrayList<>();
    }

    /*
   * Provide chat fragment layout resource. It should have a listview to show user list.
   * */
    public abstract int getChatLayoutResource();


    /*
    * Provide recyclerview id. This recyclerview will be used to show chat messages.
    * */
    public abstract int getRecyclerViewId();

    /*
    * Implement this method to fetch the list of messages
    * */
    public abstract void fetchChatMessages();

    /*
   * Override this method to provide custom adapter.
   * */
    public abstract MessageListBaseAdap getChatMessageAdapter();

    public ArrayList<MessageItem> getMessageList() {
        return mMsgList;
    }


    @Override
    public void onChatMessagesFetched(ArrayList<MessageItem> list) {
        mMsgList.clear();
        mMsgList.addAll(list);

        (mChatListView.getAdapter()).notifyDataSetChanged();
    }

    @Override
    public void onChatLoadMoreComplete(ArrayList<MessageItem> list) {
        if (list != null) {
            mMsgList.addAll(0, list);
            (mChatListView.getAdapter()).notifyDataSetChanged();
        }
    }

    public void addTextMessage(String userId, String msg) {

        MessageItem item = MessageCreater.createTextMsg(userId, msg,"abc");
        mMsgList.add(item);

        (mChatListView.getAdapter()).notifyDataSetChanged();
    }

    public void addImgMessage(String userId, String imgUrl) {

        MessageItem item = MessageCreater.createImageMsg(userId, imgUrl);
        mMsgList.add(item);

        (mChatListView.getAdapter()).notifyDataSetChanged();
    }


}
