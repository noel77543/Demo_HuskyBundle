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
import tw.noel.sung.com.huskybundle.PutValue;

public class FirstFragment extends Fragment {

    //加入Annotation
    //須注意接收端變數名稱需與傳送端key值相符
    @GetValue
    @PutValue(target = "SecondFragment")
    private ArrayList<TestModel> testModels;
    //亦可透過標註符"name" 指定為與傳遞端key值相符的名稱後即可任意更改變數名稱
    @GetValue(name = "test1")
    private String stringTest;

    private View view;

    //-----------


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_first, container, false);
            HuskyBundle.getInstance().inject(this);

            Log.e("T1", testModels.get(0).getName());
            Log.e("T2", stringTest + "");

            view.findViewById(R.id.text_view).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Fragment fragment = HuskyBundle.getInstance().take(FirstFragment.this, new SecondFragment());
                    getFragmentManager().beginTransaction()
                            .addToBackStack(null)
                            .replace(R.id.frame_layout, fragment)
                            .commit();
                }
            });

        } else {
            ViewGroup parent = (ViewGroup) view.getParent();
            if (parent != null) {
                parent.removeView(view);
            }
        }
        return view;
    }
}
