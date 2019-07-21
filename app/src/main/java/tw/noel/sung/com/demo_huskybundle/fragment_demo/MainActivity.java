package tw.noel.sung.com.demo_huskybundle.fragment_demo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import java.util.ArrayList;

import tw.noel.sung.com.demo_huskybundle.R;
import tw.noel.sung.com.demo_huskybundle.TestModel;
import tw.noel.sung.com.demo_huskybundle.fragment_demo.fragment.FirstFragment;
import tw.noel.sung.com.demo_huskybundle.fragment_demo.fragment.SecondFragment;
import tw.noel.sung.com.huskybundle.HuskyBundle;
import tw.noel.sung.com.huskybundle.PutValue;

public class MainActivity extends FragmentActivity {


    //指定目標
    @PutValue(target = "FirstFragment")
    private String test1;
    //指定多個目標
    @PutValue(target = {"FirstFragment", "SecondFragment"})
    private ArrayList<TestModel> testModels;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_2);



        test1 = "ttt";
        TestModel testModel = new TestModel();
        testModel.setName("Noel");
        testModels = new ArrayList<>();
        testModels.add(testModel);



        findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = HuskyBundle.getInstance().take(MainActivity.this, new FirstFragment());
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,fragment).commit();

            }
        });


        findViewById(R.id.button_second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment fragment = HuskyBundle.getInstance().take(MainActivity.this, new SecondFragment());
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,fragment).commit();

            }
        });



    }


}

