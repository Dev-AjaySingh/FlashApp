package com.example.flashapp;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.widget.CompoundButton;

import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    ToggleButton toggleButton;
    CameraManager cameraManager;
    private String cameraId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleButton=findViewById(R.id.tog);
        cameraManager= (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        try
        {
            cameraId=cameraManager.getCameraIdList()[0];
        }
        catch (CameraAccessException e)
        {
            e.printStackTrace();
        }

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    turnonflash();
                }
                else
                {
                    turnoffflash();
                }
            }
        });

    }
    private void turnonflash()
    {
        try{
            cameraManager.setTorchMode(cameraId,true);
        }
        catch (CameraAccessException e)
        {
            e.printStackTrace();
        }
    }
    private  void turnoffflash()
    {
        try {
            cameraManager.setTorchMode(cameraId,false);
        }
        catch (CameraAccessException e)
        {
            e.printStackTrace();
        }
    }
}