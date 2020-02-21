package com.premanandrhea.three;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView uno, dos, tres, quatro;
    int c1, c2, c3, c4;
    SeekBar seek;
    SharedPreferences.Editor editor;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uno=findViewById(R.id.one);
        dos=findViewById(R.id.two);
        tres=findViewById(R.id.three);
        quatro=findViewById(R.id.four);
        seek=findViewById(R.id.seekBar1);

        sharedPreferences = getSharedPreferences("Settings", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.apply();

        c1 = sharedPreferences.getInt("1", 0);
        c2 = sharedPreferences.getInt("2", 0);
        c3 = sharedPreferences.getInt("3", 0);
        c4 = sharedPreferences.getInt("4", 0);
        uno.setText(c1+" ");
        dos.setText(c2+" ");
        tres.setText(c3+" ");
        quatro.setText(c4+" ");


        uno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c1+=1;
                uno.setText(c1+" ");
                editor.putInt("1", c1);
                editor.apply();
                Context context = getApplicationContext();
                CharSequence text = "The bottom right corner has been clicked!";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });
        dos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c2+=1;
                dos.setText(c2+" ");
                editor.putInt("2", c2);
                editor.apply();
                Context context = getApplicationContext();
                CharSequence text = "The bottom right corner has been clicked!";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });
        tres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c3+=1;
                tres.setText(c3+" ");
                editor.putInt("3", c3);
                editor.apply();
                Context context = getApplicationContext();
                CharSequence text = "The top left corner has been clicked!";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });
        quatro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c4+=1;
                quatro.setText(c4+" ");
                editor.putInt("4", c4);
                editor.apply();
                Context context = getApplicationContext();
                CharSequence text = "The top right corner has been clicked!";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });


        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
                int progess = progresValue + 12;
                uno.setTextSize(progess);
                dos.setTextSize(progess);
                tres.setTextSize(progess);
                quatro.setTextSize(progess);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}

