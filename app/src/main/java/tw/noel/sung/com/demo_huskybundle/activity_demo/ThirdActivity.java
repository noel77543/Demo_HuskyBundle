package tw.noel.sung.com.demo_huskybundle.activity_demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;

import tw.noel.sung.com.demo_huskybundle.TestModel;
import tw.noel.sung.com.huskybundle.GetValue;
import tw.noel.sung.com.huskybundle.HuskyBundle;


public class ThirdActivity extends AppCompatActivity {


    //加入Annotation
    //須注意接收端變數名稱需與傳送端key值相符
    @GetValue
    private ArrayList<TestModel> testModels;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HuskyBundle.getInstance().inject(this);

        Log.e("T1", testModels.get(0).getName());
    }
}