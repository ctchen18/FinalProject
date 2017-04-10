package com.example.user.finalproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChangeBackGroundActivity extends AppCompatActivity {
    private int clickedID;
    private int dialogID = 123456;

    @BindView(R.id.radio_btn_group)
    RadioGroup radioGroup;

    @BindView(R.id.radio_btn1)
    RadioButton btn1;
    @BindView(R.id.radio_btn2)
    RadioButton btn2;
    @BindView(R.id.radio_btn3)
    RadioButton btn3;
    @BindView(R.id.radio_btn4)
    RadioButton btn4;

    @OnClick(R.id.radio_ok_button)
    public void okButtonClicked(){
        Bundle bundle = new Bundle();
        Intent intent=getIntent();

        switch(clickedID){
            case(R.id.radio_btn1):

                bundle.putString("BackgroundColor",btn1.getText().toString());
                break;
            case(R.id.radio_btn2):
                bundle.putString("BackgroundColor",btn2.getText().toString());
                break;
            case(R.id.radio_btn3):
                bundle.putString("BackgroundColor",btn3.getText().toString());
                break;
            case(R.id.radio_btn4):
                bundle.putString("BackgroundColor",btn4.getText().toString());
                break;
            default:
                bundle.putString("BackgroundColor","0");
                break;
        }
        intent.putExtras(bundle);
        setResult(Activity.RESULT_OK,intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_change_back_ground);
        ButterKnife.bind(this);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                clickedID=checkedId;
            }
        });


    }

}
