package com.javen205.demo.ui.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.javen205.demo.R;
import com.orhanobut.logger.Logger;

public class FragmentFour extends BaseFragment {


    public FragmentFour() {
    }

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_four, container, false);
        Logger.i("FragmentFour onCreateView");
        return view;
    }

    @Override
    public void loadData() {
        Logger.i("FragmentFour loadData");
//        DialogUtils.progressDialog(mActivity,"FragmentFour loading ...");
        Toast.makeText(getActivity().getApplication(),"FragmentFour",Toast.LENGTH_LONG).show();
    }

}
