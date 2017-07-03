package com.example.etao.base;

import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.widget.Toast;

/**
 * Created by xmy on 2017/7/3.
 */

public class BaseFragment extends Fragment {

    public void startActivity(Class<?> mClass) {
        Intent intent = new Intent(getActivity(), mClass);
        startActivity(intent);
    }

    public void showToast(CharSequence msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }
}
