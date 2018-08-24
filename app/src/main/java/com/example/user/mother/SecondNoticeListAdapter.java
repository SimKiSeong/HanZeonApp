package com.example.user.mother;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by user on 2018-01-14.
 */

public class SecondNoticeListAdapter extends BaseAdapter {

    public SecondNoticeListAdapter(Context context, List<Notice> noticeList) {
        this.context = context;
        this.noticeList = noticeList;
    }

    private Context context;
    private List<Notice>  noticeList;

    @Override
    public int getCount() {
        return noticeList.size();
    }

    @Override
    public Object getItem(int i) {
        return noticeList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {

        View v = View.inflate(context, R.layout.secondnotice, null);
        TextView noticeText = (TextView) v.findViewById(R.id.noticeText);
        TextView workText = (TextView) v.findViewById(R.id.workText);
        TextView startdateText = (TextView) v.findViewById(R.id.dateText);
        //TextView seconddateText = (TextView) v.findViewById(R.id.dateText);

        noticeText.setText(noticeList.get(i).getNotice());
        workText.setText(noticeList.get(i).getWork());
        startdateText.setText(noticeList.get(i).getStudydate());


        v.setTag(noticeList.get(i).getNotice());
        return v;
    }

    @Nullable
    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }



}
