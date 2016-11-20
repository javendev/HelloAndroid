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
public class FragmentTwo extends BaseFragment {
    public FragmentTwo() {
    }

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        Logger.i("FragmentTwo onCreateView");
        return view;
    }

    @Override
    public void loadData() {
        Logger.i("FragmentTwo loadData");
        Toast.makeText(getActivity().getApplication(),"FragmentTwo",Toast.LENGTH_LONG).show();
//        DialogUtils.progressDialog(mActivity,"FragmentTwo loading...");

    }

}
