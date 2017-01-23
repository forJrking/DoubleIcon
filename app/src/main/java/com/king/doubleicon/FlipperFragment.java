package com.king.doubleicon;


import android.widget.ViewFlipper;

import com.king.doubleicon.control.ADControl;

public class FlipperFragment extends LazyLoadFragment {

    String[] strs = {"ViVO R18,高通骁龙360+8GB运行", "小米4s,高通骁龙360+8GB运行", "小米5s,高通骁龙360+8GB运行", "红米6s,高通骁龙360+8GB运行", "华为荣耀,高通骁龙360+8GB运行"};
    private ViewFlipper vf;

    @Override
    public void lazyLoad() {
        initView();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.flipper_fragment;
    }

    private void initView() {
        vf = (ViewFlipper) findViewById(R.id.viewflipper);
        for (int i = 0; i < 4; i++) {
            ADControl adControl = new ADControl(mActivity);
            adControl.setAD(strs[i], strs[i + 1]);
            vf.addView(adControl.getRootView());
        }
    }

}
