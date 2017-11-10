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

    //Declaration of Widgets
    private ToggleButton toggleButton;
    private Switch aSwitch;
    private SwitchCompat switchCompat;

    private LinearLayout checkLayout,radioLayout;
    private CheckBox cri,foot,volley;
    private RadioGroup radioGroup;
    private Button bn_check,bn_radio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Connecting the Widgets with View by using FindViewByID

        toggleButton = (ToggleButton)findViewById(R.id.toggleButton);
        aSwitch = (Switch) findViewById(R.id.switch_wifi);
        switchCompat = (SwitchCompat)findViewById(R.id.cswitch);

        checkLayout = (LinearLayout)findViewById(R.id.checkLayout);
        radioLayout = (LinearLayout)findViewById(R.id.radioLayout);

        cri = (CheckBox)findViewById(R.id.check__cri);
        foot = (CheckBox)findViewById(R.id.check__foot);
        volley = (CheckBox)findViewById(R.id.check__volley);

        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);

        bn_check =(Button)findViewById(R.id.bn_check_trigger);
        bn_radio =(Button)findViewById(R.id.bn_radio_trigger);



        //Disabling the Widgets by there properties
            aSwitch.setClickable(false);
            aSwitch.setEnabled(false);

            switchCompat.setClickable(false);
            switchCompat.setEnabled(false);

        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                   //Controlling the ToggleButton
                if (toggleButton.isChecked()){//true

                   //Turn on the click option on widgets.

                    aSwitch.setEnabled(true);
                    aSwitch.setClickable(true);
                    switchCompat.setEnabled(true);
                    switchCompat.setClickable(true);

                    //performing click event on widgets
                    aSwitch.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            //Turned ON then visible the check layout,
                            //Remove Visibility of RadioLayout & SwitchCompat(Gender)

                            if (aSwitch.isChecked()){ //true

                                checkLayout.setVisibility(View.VISIBLE);
                                radioLayout.setVisibility(View.GONE);
                                switchCompat.setVisibility(View.GONE);

                                bn_check.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {

                                        StringBuilder stringBuilder = new StringBuilder();
                                        stringBuilder.append("Selected Sports: ").append("\n");

                                        if (cri.isChecked()){
                                            stringBuilder.append(cri.getText().toString()).append("\n");
                                        }

                                        if (foot.isChecked()){
                                            stringBuilder.append(foot.getText().toString()).append("\n");
                                        }

                                        if (volley.isChecked()){

                                            stringBuilder.append(volley.getText().toString());
                                        }


                                        //Show the selected Sports using Toasting
                                        Toast.makeText(MainActivity.this, stringBuilder.toString(), Toast.LENGTH_SHORT).show();

                                        //Remove Visibility of current layout.
                                        checkLayout.setVisibility(View.GONE);
                                        //Enable Visibility of SwitchCompat
                                        switchCompat.setVisibility(View.VISIBLE);

                                    }
                                });


                            }else {

                                checkLayout.setVisibility(View.GONE);
                                switchCompat.setVisibility(View.VISIBLE);
                                aSwitch.setChecked(false);
                            }
                        }
                    });


                    switchCompat.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (switchCompat.isChecked()){//True

                                radioLayout.setVisibility(View.VISIBLE);
                                aSwitch.setVisibility(View.GONE);
                                checkLayout.setVisibility(View.GONE);

                                bn_radio.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {

                                        int selected = radioGroup.getCheckedRadioButtonId();


                                        RadioButton radioButton = (RadioButton)findViewById(selected);

                                        Toast.makeText(MainActivity.this, "Selected Gender: \n" +radioButton.getText().toString(), Toast.LENGTH_SHORT).show();


                                        radioLayout.setVisibility(View.GONE);
                                        aSwitch.setVisibility(View.VISIBLE);

                                    }
                                });

                            }else {

                                radioLayout.setVisibility(View.GONE);
                                aSwitch.setVisibility(View.VISIBLE);
                                switchCompat.setChecked(false);
                            }
                        }
                    });

                }else { //false

                    aSwitch.setClickable(false);
                    aSwitch.setEnabled(false);
                    aSwitch.setChecked(false);
                    switchCompat.setClickable(false);
                    switchCompat.setEnabled(false);
                    switchCompat.setChecked(false);


                }
            }
        });

    }
}
