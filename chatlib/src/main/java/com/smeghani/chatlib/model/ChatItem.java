package com.smeghani.chatlib.model;

import com.smeghani.chatlib.utils.DateTimeUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by smeghani on 3/21/2017.
 */

public class ChatItem {

    private String mId;
    private String mTitle;
    private String mLabel;
    private String mTime;
    private String profilePic;
    private int mUnreadCount;

    public String getId() {
        return mId;
    }

    public void setId(String mId) {
        this.mId = mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getLabel() {
        return mLabel;
    }

    public void setLabel(String mLabel) {
        this.mLabel = mLabel;
    }

    public String getTime() {
        return mTime;
    }

    public void setTime(String mTime) {
        this.mTime = mTime;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getFormattedTime(String orignalDateFormat) {
        String finalTime = "";
        try {
            Date dateTime = DateTimeUtil.convertDateFromString(this.mTime, orignalDateFormat);
            SimpleDateFormat dateFormatter;
            if(DateTimeUtil.isSameDay(dateTime, Calendar.getInstance().getTime())){
                dateFormatter = new SimpleDateFormat(getSameDayFormat(), Locale.ENGLISH);
            }else{
                dateFormatter = new SimpleDateFormat(getDateFormat(), Locale.ENGLISH);
            }

           finalTime =  dateFormatter.format(dateTime);

        } catch (ParseException e) {
            e.printStackTrace();
            finalTime = "--";
        }
        return finalTime;
    }

    public int getUnreadCount() {
        return mUnreadCount;
    }

    public void setUnreadCount(int mUnreadCount) {
        this.mUnreadCount = mUnreadCount;
    }

    public String getSameDayFormat(){
        return "hh:mm";
    }

    public String getDateFormat(){
        return "yy-MM-dd";
    }


}
