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
public class FragmentOne extends BaseFragment {
    public FragmentOne() {
    }

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        Logger.i("FragmentOne onCreateView");
        return view;
    }

    @Override
    public void loadData() {
        Logger.i("FragmentOne loadData");
        Toast.makeText(getActivity().getApplication(),"FragmentOne",Toast.LENGTH_LONG).show();
//        DialogUtils.progressDialog(mActivity,"FragmentOne loading...");
    }

}
