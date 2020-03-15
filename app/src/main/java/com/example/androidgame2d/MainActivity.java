package com.example.androidgame2d;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private boolean isMute;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);



        findViewById(R.id.play).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(MainActivity.this,GameActivity.class));
            }
        });
        TextView highScore = findViewById(R.id.highScore);
        final SharedPreferences prefs = getSharedPreferences("game", MODE_PRIVATE);
        highScore.setText("HighScore: "+prefs.getInt("highscore", 0));
        isMute = prefs.getBoolean("isMute",false);

        final ImageView volume = findViewById(R.id.volume);

        if(isMute)
            volume.setImageResource(R.drawable.ic_volume_off_black_24dp);
        else
            volume.setImageResource(R.drawable.ic_volume_up_black_24dp);

        volume.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                isMute = !isMute;
                if(isMute)
                    volume.setImageResource(R.drawable.ic_volume_off_black_24dp);
                else
                    volume.setImageResource(R.drawable.ic_volume_up_black_24dp);

                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean("isMute", isMute);
                editor.apply();

            }
        });

    }
}
