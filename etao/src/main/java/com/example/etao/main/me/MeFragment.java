package com.example.etao.main.me;

import android.os.Binder;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.etao.R;
import com.example.etao.base.BaseFragment;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by xmy on 2017/7/2.
 */

public class MeFragment extends BaseFragment {
    private Unbinder butterKnife;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_me, container, false);
        butterKnife = ButterKnife.bind(this, view);
        return view;
    }



    @OnClick({R.id.tv_login, R.id.tv_person_info, R.id.tv_person_goods, R.id.tv_goods_upload})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_login:
                startActivity(PersonActivity.class);
                break;
            case R.id.tv_person_info:
                showToast("个人信息");
                break;
            case R.id.tv_person_goods:
                showToast("商品界面");
                break;
            case R.id.tv_goods_upload:
                showToast("上传商品");
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        butterKnife.unbind();
    }
}
