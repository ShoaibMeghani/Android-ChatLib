package com.smeghani.chatlibexample.views;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.smeghani.chatlib.views.ChatAnimButton;
import com.smeghani.chatlib.views.ChatBaseFragment;
import com.smeghani.chatlib.views.MessageListBaseAdap;
import com.smeghani.chatlibexample.R;
import com.smeghani.chatlibexample.data.ChatDataHelper;

/**
 * Created by smeghani on 4/1/2017.
 */

public class MessageListFragment extends ChatBaseFragment {

    private ChatAnimButton mBtnSend;
    private EditText mTextBox;
    private SwipeRefreshLayout mSwipView;


    @Override
    public int getChatLayoutResource() {
        return R.layout.fragment_messages;
    }

    @Override
    public int getRecyclerViewId() {
        return R.id.lv_conversation;
    }

    @Override
    public void fetchChatMessages() {
        onChatMessagesFetched(ChatDataHelper.getMessageList());
    }

    @Override
    public MessageListBaseAdap getChatMessageAdapter() {
        return new MessageListAdap(getActivity(),0,getMessageList());
    }

    @Override
    public void initView() {
        super.initView();
        mBtnSend = (ChatAnimButton) getView().findViewById(R.id.btn_send_record);
        mTextBox = (EditText)getView().findViewById(R.id.et_input);
        mSwipView = (SwipeRefreshLayout)getView().findViewById(R.id.swipeRefreshLayout);

        mSwipView.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mSwipView.setRefreshing(false);
                onChatLoadMoreComplete(null);
            }
        });

        mBtnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTextMessage(ChatDataHelper.USERID,mTextBox.getText().toString());
                mTextBox.setText("");
            }
        });
    }
}
