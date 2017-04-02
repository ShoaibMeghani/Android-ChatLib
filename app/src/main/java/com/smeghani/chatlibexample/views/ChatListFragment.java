package com.smeghani.chatlibexample.views;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.smeghani.chatlib.model.ChatItem;
import com.smeghani.chatlib.views.ChatListBaseAdap;
import com.smeghani.chatlib.views.ChatListBaseFragment;
import com.smeghani.chatlibexample.R;
import com.smeghani.chatlibexample.data.ChatDataHelper;

/**
 * Created by smeghani on 3/21/2017.
 */

public class ChatListFragment extends ChatListBaseFragment {

    @Override
    public int getChatLayoutResource() {
        return R.layout.fragment_chat;
    }

    @Override
    public int getListviewId() {
        return R.id.lv_chat;
    }

    @Override
    public void fetchChatList() {
        onChatListFetched(ChatDataHelper.getChatItemList());
    }

    @Override
    public void onChatListItemClick(ChatItem chatItem, int position) {
        ((MainActivity)getActivity()).switchFragment(new MessageListFragment());
    }

    @Override
    public ChatListBaseAdap getChatAdapter() {
        return new ChatListAdap(getActivity(),0,getChatList());
    }

    @Override
    public void initView() {
        super.initView();
        EditText etFilter = (EditText)getView().findViewById(R.id.et_filter);

        etFilter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filterChatList(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
