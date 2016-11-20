package com.javen205.demo.ui.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.javen205.demo.R;
import com.orhanobut.logger.Logger;


/**
 * Created by Javen on 16/8/25.
 */
public class FragmentThree extends BaseFragment {
    public FragmentThree() {
    }

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_three, container, false);
        Logger.i("FragmentThree onCreateView");
        return view;
    }

    @Override
    public void loadData() {
        Logger.i("FragmentThree loadData");
//        DialogUtils.progressDialog(mActivity,"FragmentThree loading...");
        Toast.makeText(getActivity().getApplication(),"FragmentThree",Toast.LENGTH_LONG).show();

    }
}
