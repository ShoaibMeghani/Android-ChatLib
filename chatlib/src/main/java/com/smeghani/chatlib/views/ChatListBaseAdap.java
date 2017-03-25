package com.smeghani.chatlib.views;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.smeghani.chatlib.R;
import com.smeghani.chatlib.model.ChatItem;
import com.smeghani.chatlib.utils.DateTimeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by smeghani on 3/21/2017.
 */

public class ChatListBaseAdap extends ArrayAdapter<ChatItem> implements Filterable{

    private Context mContext;
    private ArrayList<ChatItem> mChatList;
    private ArrayList<ChatItem> mOrignalChatList;

    public ChatListBaseAdap(@NonNull Context context, @LayoutRes int resource, @NonNull List<ChatItem> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mChatList = (ArrayList<ChatItem>) objects;

    }
    /**
     * Override this method if you want to provide custome design for list item. The custom layout must have
     * all essential chat list item views with same id as provided in item_chat_list.
     * */
    public int getItemResourceId() {
        return R.layout.item_chat_list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(getItemResourceId(), parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.setItem(getItem(position));

        return convertView;
    }

    @Nullable
    @Override
    public ChatItem getItem(int position) {
        return mChatList.get(position);
    }

    @Override
    public int getCount() {
        return mChatList.size();
    }

    public class ViewHolder {
        TextView tvTitle, tvDesc, tvTime,tvBadge;
        ImageView ivProfile;

        public ViewHolder(View view) {
            tvTitle = (TextView) view.findViewById(R.id.tv_title);
            tvDesc = (TextView) view.findViewById(R.id.tv_desc);
            tvTime = (TextView) view.findViewById(R.id.tv_time);
            ivProfile = (ImageView) view.findViewById(R.id.iv_pic);
            tvBadge = (TextView)view.findViewById(R.id.tv_unread_count);
        }

        public void setItem(ChatItem item) {
            tvTitle.setText(item.getTitle());
            tvDesc.setText(item.getLabel());
            tvTime.setText(item.getFormattedTime(DateTimeUtil.DATETIME_FORMAT));

            if (item.getUnreadCount() > 0){
                tvBadge.setText(String.valueOf(item.getUnreadCount()));
                tvBadge.setVisibility(View.VISIBLE);
            }else{
                tvBadge.setText(String.valueOf(item.getUnreadCount()));
                tvBadge.setVisibility(View.INVISIBLE);
            }

            GradientDrawable gd = (GradientDrawable) tvBadge.getBackground().getCurrent();
            gd.setColor(Color.parseColor(getColorPrimaryHex()));



            displayProfilePic(ivProfile);
        }
    }

    /*
    * Override this method to show profile pic using any third party library you prefer.
    * **/
    public void displayProfilePic(ImageView iv){
        //let sub-class implement this
    }

    /**
     * User can provide custom unread badge count color.
     * */
    public String getColorPrimaryHex(){
        return "#FF0000";
    }

    @NonNull
    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults filterResults = new FilterResults();
                ArrayList<ChatItem> tempList= new ArrayList<>();
                if (constraint != null && mOrignalChatList != null){
                    if ("".equals(constraint)){
                        filterResults.values = mOrignalChatList;
                        filterResults.count = mOrignalChatList.size();
                    }else{
                        for (int i=0;i<mOrignalChatList.size();i++){
                            if (mOrignalChatList.get(i).getTitle().toLowerCase().contains(constraint.toString())){
                                tempList.add(mOrignalChatList.get(i));
                            }
                        }

                        filterResults.values = tempList;
                        filterResults.count = tempList.size();
                    }
                }

                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                mChatList = (ArrayList<ChatItem>) results.values;
                notifyDataSetChanged();
            }
        };
    }

    public void setChatList(ArrayList<ChatItem> list){
        mChatList.clear();
        mChatList.addAll(list);
        this.mOrignalChatList = new ArrayList<>(mChatList);

    }
}
