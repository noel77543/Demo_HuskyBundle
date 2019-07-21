package tw.noel.sung.com.demo_huskybundle.fragment_demo.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import tw.noel.sung.com.demo_huskybundle.R;
import tw.noel.sung.com.demo_huskybundle.TestModel;
import tw.noel.sung.com.huskybundle.GetValue;
import tw.noel.sung.com.huskybundle.HuskyBundle;


public class SecondFragment extends Fragment {

    @GetValue
    private ArrayList<TestModel> testModels;
    private View view;

    //-----------


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_second, container, false);
            HuskyBundle.getInstance().inject(this);
            Log.e("TTT", testModels.get(0).getName());

        } else {
            ViewGroup parent = (ViewGroup) view.getParent();
            if (parent != null) {
                parent.removeView(view);
            }
        }
        return view;
    }
}
