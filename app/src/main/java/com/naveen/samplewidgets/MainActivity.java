package com.naveen.samplewidgets;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private ToggleButton toggleButton;
    private Switch aSwitch;
    private SwitchCompat switchCompat;

    private LinearLayout checkLayout,radioLayout;
    private CheckBox cri,foot,volley;
    private RadioGroup radioGroup;
    private Button bn_radio,bn_check;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Connecting Backend to View by using findViewByID

        toggleButton = (ToggleButton)findViewById(R.id.toggleButton);
        aSwitch =(Switch)findViewById(R.id.switch_wifi);
        switchCompat = (SwitchCompat)findViewById(R.id.cswitch);

        checkLayout = (LinearLayout)findViewById(R.id.checkLayout);
        radioLayout = (LinearLayout)findViewById(R.id.radioLayout);

        cri = (CheckBox)findViewById(R.id.check__cri);
        foot = (CheckBox)findViewById(R.id.check__foot);
        volley = (CheckBox)findViewById(R.id.check__volley);

        bn_check = (Button)findViewById(R.id.bn_check_trigger);
        bn_radio = (Button)findViewById(R.id.bn_radio_trigger);

        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);


        //By Default Switch & Switch Compat should be disabled & Non Clickable

        aSwitch.setClickable(false);
        switchCompat.setClickable(false);

        aSwitch.setEnabled(false);
        switchCompat.setEnabled(false);



        //Event on Widgets
        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Actions

                if (toggleButton.isChecked()){ //true
                    //Changing color if ToggleButton state is True to Yellow
                    //toggleButton.setBackgroundColor(Color.YELLOW);

                    //User should be able to click on
                    // switch & switchcompat after turning ON toggleButton

                    aSwitch.setEnabled(true);
                    aSwitch.setClickable(true);

                    switchCompat.setEnabled(true);
                    switchCompat.setClickable(true);

                    //Actions to be performed after widgets are active.

                    aSwitch.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if (aSwitch.isChecked()){

                                //Visible the checkLayout which contains sports.
                                checkLayout.setVisibility(View.VISIBLE);
                                //Remove visibility of switchCompat.
                                switchCompat.setVisibility(View.GONE);
                                //Remove visibility of radioLayout.
                                radioLayout.setVisibility(View.GONE);


                                //After check layout is visible performing
                                // action on the button and taking inputs from the user.
                                bn_check.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {

                                        StringBuilder stringBuilder = new StringBuilder();
                                        stringBuilder.append("Selected Sports: ").append("\n");

                                        if (cri.isChecked()){//true
                                            stringBuilder.append(cri.getText().toString()).append("\n");
                                        }

                                        if (foot.isChecked()){//true
                                            stringBuilder.append(foot.getText().toString()).append("\n");
                                        }

                                        if (volley.isChecked()){//true
                                            stringBuilder.append(volley.getText().toString()).append("\n");
                                        }

                                        //Using Toast we are displaying data.
                                        Toast.makeText(MainActivity.this, stringBuilder.toString(), Toast.LENGTH_SHORT).show();

                                        checkLayout.setVisibility(View.GONE);

                                        switchCompat.setVisibility(View.VISIBLE);

                                        aSwitch.setChecked(false);


                                    }
                                });




                            }else{

                                //InVisible the checkLayout which contains sports.
                                checkLayout.setVisibility(View.INVISIBLE);
                                //visibility of switchCompat.
                                switchCompat.setVisibility(View.VISIBLE);
                                aSwitch.setChecked(false);

                            }

                        }
                    });


                    switchCompat.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {


                            if (switchCompat.isChecked()){

                                //Visible the checkLayout which contains sports.
                                radioLayout.setVisibility(View.VISIBLE);
                                //Remove visibility of switchCompat.
                                aSwitch.setVisibility(View.GONE);
                                //Remove visibility of radioLayout.
                                checkLayout.setVisibility(View.GONE);


                                bn_radio.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {

                                        //Parsing selected RadioButton ID into integer Selected.

                                        int selected = radioGroup.getCheckedRadioButtonId();

                                        RadioButton radioButton = (RadioButton)findViewById(selected);

                                        Toast.makeText(MainActivity.this, "Selected Gender: " +radioButton.getText().toString(), Toast.LENGTH_SHORT).show();


                                        radioLayout.setVisibility(View.GONE);
                                        aSwitch.setVisibility(View.VISIBLE);
                                        switchCompat.setChecked(false);
                                    }
                                });


                            }else{

                                //InVisible the checkLayout which contains sports.
                                radioLayout.setVisibility(View.INVISIBLE);
                                //visibility of switchCompat.
                                aSwitch.setVisibility(View.VISIBLE);
                                switchCompat.setChecked(false);

                            }


                        }
                    });


                }else{//false
                    //Changing color if ToggleButton state is False to RED
                    /*toggleButton.setBackgroundColor(Color.RED);*/

                    aSwitch.setChecked(false);
                    switchCompat.setChecked(false);

                    aSwitch.setEnabled(false);
                    switchCompat.setEnabled(false);

                    checkLayout.setVisibility(View.GONE);
                    radioLayout.setVisibility(View.GONE);

                    aSwitch.setVisibility(View.VISIBLE);
                    switchCompat.setVisibility(View.VISIBLE);

                }

            }
        });
/*
        aSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Actions

                if (aSwitch.isChecked()){ //true
                    //Changing TEXT if it turned ON
                    aSwitch.setText("WIFI ON");
                }else {//false
                    //Changing TEXT if it turned OFF
                    aSwitch.setText("WIFI OFF");
                }


            }
        });*/


      /*  switchCompat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (switchCompat.isChecked()){ //true
                    //Changing TEXT if it turned ON
                    switchCompat.setText("WIFI ON");
                }else {//false
                    //Changing TEXT if it turned OFF
                    switchCompat.setText("WIFI OFF");
                }
            }
        });*/




    }
}
