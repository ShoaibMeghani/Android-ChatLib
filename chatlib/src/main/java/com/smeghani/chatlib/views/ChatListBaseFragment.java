package com.smeghani.chatlib.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.smeghani.chatlib.model.ChatItem;

import java.util.ArrayList;

/**
 * Created by smeghani on 3/21/2017.
 */

public abstract class ChatListBaseFragment extends Fragment implements AdapterView.OnItemClickListener, ChatListListener {

    private ListView mChatListView;
    private ArrayList<ChatItem> mChatList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(getChatLayoutResource(), container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initObj(savedInstanceState);
        initView();

        fetchChatList();
    }


    public void initView() {
        mChatListView = (ListView) getView().findViewById(getListviewId());
        mChatListView.setAdapter(getChatAdapter());
        mChatListView.setOnItemClickListener(this);
    }

    public void initObj(Bundle savedInstanceState) {
        mChatList = new ArrayList<>();
    }

    /*
    * Provide chat fragment layout resource. It should have a listview to show user list.
    * */
    public abstract int getChatLayoutResource();


    /*
    * Provide listview id. This listview will be used to show chat list.
    * */
    public abstract int getListviewId();

    /*
   * Implement this method to provide the list
   * */
    public abstract void fetchChatList();

    /*
    * Override this method to provide custom adapter.
    * */
    public ChatListBaseAdap getChatAdapter() {
        ChatListBaseAdap adap = new ChatListBaseAdap(getActivity(), 0, mChatList);
        return adap;
    }

    public ArrayList<ChatItem> getChatList() {
        return mChatList;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        onChatListItemClick((ChatItem) mChatListView.getAdapter().getItem(position), position);
    }

    @Override
    public void onChatListFetched(ArrayList<ChatItem> list) {
        ((ChatListBaseAdap) mChatListView.getAdapter()).setChatList(list);
        ((ChatListBaseAdap) mChatListView.getAdapter()).notifyDataSetChanged();
    }

    public void filterChatList(String constraint) {
        ((ChatListBaseAdap) mChatListView.getAdapter()).getFilter().filter(constraint);
    }
}
