package com.king.doubleicon.control;

/*
 * @创建者     Administrator
 * @创建时间   2017/1/23 19:25
 */

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.king.doubleicon.R;

public class ADControl {

    private Context mContext;
    private View mRootView;

    private TextView adOne, adTwo;

    public ADControl(Context context) {
        mContext = context;
        mRootView = View.inflate(mContext, R.layout.ad_layout, null);
        adOne = (TextView) mRootView.findViewById(R.id.ad_text1);
        adTwo = (TextView) mRootView.findViewById(R.id.ad_text2);
    }

    public View getRootView() {
        return mRootView;
    }

    public void setAD(String str1, String str2) {
        adOne.setText(str1);
        adTwo.setText(str2);
    }

}
