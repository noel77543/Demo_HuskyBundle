package tw.noel.sung.com.demo_huskybundle.activity_demo;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;

import tw.noel.sung.com.demo_huskybundle.R;
import tw.noel.sung.com.demo_huskybundle.TestModel;
import tw.noel.sung.com.huskybundle.HuskyBundle;
import tw.noel.sung.com.huskybundle.PutValue;

public class MainActivity extends AppCompatActivity {


    //指定目標
    @PutValue(target = "SecondActivity")
    private String test1;
    //指定多個目標
    @PutValue(target = {"SecondActivity", "ThirdActivity"})
    private ArrayList<TestModel> testModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        test1 = "ttt";
        TestModel testModel = new TestModel();
        testModel.setName("Noel");
        testModels = new ArrayList<>();
        testModels.add(testModel);

        findViewById(R.id.button_second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HuskyBundle.getInstance().take(MainActivity.this, new SecondActivity());
            }
        });

        findViewById(R.id.button_third).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HuskyBundle.getInstance().take(MainActivity.this, new ThirdActivity());
            }
        });


    }


}
