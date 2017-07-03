package com.example.etao.main.main;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.etao.R;
import com.example.etao.main.UnLoginFragment;
import com.example.etao.main.me.MeFragment;
import com.example.etao.main.shop.ShopFragment;

import org.w3c.dom.Text;

import butterknife.BindColor;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity{

    long existTime = 0;//判断按两次返回退出程序
    @BindView(R.id.main_title)
    TextView title;
    @BindView(R.id.main_toobar)
    Toolbar mainToobar;
    @BindView(R.id.viewpager)
    ViewPager vp;
    @BindViews({R.id.tv_shop,R.id.tv_message,R.id.tv_mail_list,R.id.tv_me})
    TextView[] tvs;
    @BindView(R.id.linearlayout)
    LinearLayout linearlayout;
    @BindView(R.id.activity_main)
    RelativeLayout activityMain;
    @BindColor(R.color.colorPrimary)
    int colorPrimary;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        init();
    }

    private void init() {
        vp.setAdapter(unLoginAdapter);
        vp.addOnPageChangeListener(vpChangeListener);
        tvs[0].setSelected(true);
        tvs[0].setTextColor(colorPrimary);
    }

    ViewPager.OnPageChangeListener vpChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            for(TextView tv: tvs){
                tv.setSelected(false);
                tv.setTextColor(Color.BLACK);
            }
            title.setText(tvs[position].getText());
            tvs[position].setSelected(true);
            tvs[position].setTextColor(colorPrimary);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    @OnClick({R.id.tv_shop, R.id.tv_message, R.id.tv_mail_list, R.id.tv_me})
    public void onViewClicked(TextView tv) {
        for (int i = 0; i <tvs.length ; i++) {
            tvs[i].setTextColor(colorPrimary);
            tvs[i].setSelected(false);
            tvs[i].setTag(i);
        }

        title.setText(tv.getText());
        tv.setSelected(true);
        tv.setTextColor(colorPrimary);
        vp.setCurrentItem((Integer) tv.getTag(),false);
    }

    private FragmentStatePagerAdapter unLoginAdapter = new FragmentStatePagerAdapter(getSupportFragmentManager()) {
        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new ShopFragment();

                case 1:
                    return new UnLoginFragment();

                case 2:
                    return new UnLoginFragment();

                case 3:
                    return new MeFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 4;
        }
    };

    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() - existTime > 2000) {
            Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show();
            existTime = System.currentTimeMillis();
        } else finish();
    }
}
