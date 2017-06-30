package com.gayedesign.alagiesaine.audiomanager;

import android.media.AudioManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button modeButton,normalButton,silentButton,vibrateButton;
    AudioManager audioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        modeButton = (Button)findViewById(R.id.modeButton);
        normalButton = (Button)findViewById(R.id.normalButton);
        silentButton = (Button)findViewById(R.id.silentButton);
        vibrateButton = (Button)findViewById(R.id.vibrateButton);
        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);

        modeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              int currentMode = audioManager.getRingerMode();
                if (currentMode == AudioManager.RINGER_MODE_NORMAL)
                    Toast.makeText(MainActivity.this,"Normal Mode",Toast.LENGTH_SHORT).show();
                else if (currentMode == AudioManager.RINGER_MODE_SILENT)
                    Toast.makeText(MainActivity.this,"Silent Mode",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this,"Vibrate Mode",Toast.LENGTH_SHORT).show();
            }
        });

        normalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                Toast.makeText(MainActivity.this,"Mode changed to Normal",Toast.LENGTH_SHORT).show();
            }
        });
        vibrateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
                Toast.makeText(MainActivity.this,"Mode changed to Vibrate",Toast.LENGTH_SHORT).show();
            }
        });
        silentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
                Toast.makeText(MainActivity.this,"Mode changed to Silent",Toast.LENGTH_SHORT).show();
            }
        });

    }


}
