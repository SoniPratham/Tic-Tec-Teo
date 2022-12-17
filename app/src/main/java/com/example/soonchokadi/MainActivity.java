package com.example.soonchokadi;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int flg=0;
    int grid[] ={2,2,2,2,2,2,2,2,2};
    boolean start=true;

    public void Tap(View view){
        ImageView img = (ImageView) view;
        TextView w =findViewById(R.id.win);
        TextView t =findViewById(R.id.state);

        int num=(Integer.parseInt(img.getTag().toString()))-1;

        if(grid[num]==2 && start)
        {
            grid[num]=flg;
            img.setTranslationY(-1000f);
            if(flg==1)
            {
                final MediaPlayer o = MediaPlayer.create(this,R.raw.xx);
                o.start();
                while(o.isPlaying()==false)
                {
                    final MediaPlayer p = MediaPlayer.create(this,R.raw.xx);
                    p.start();
                }

                img.setImageResource(R.drawable.x);
                t.setText("0's Turn");
                flg=0;
            }
            else
            {


                img.setImageResource(R.drawable.o);
                t.setText("X's Turn");
                flg=1;
            }

            img.animate().translationYBy(1000f).setDuration(600);

            int win=-1;
            for (int i=0;i<7;i+=3) {
                //Horizontally check
                if (grid[i] == grid[i + 1] && grid[i] == grid[i + 2] && grid[i]!=2) {
                    win = grid[i];
                    break;
                }
                //vertically check
                int j=i/3;
                if (grid[j] == grid[j + 1*3] && grid[j] == grid[j + 2*3] && grid[j]!=2) {
                    win = grid[j];
                    break;
                }
            }
            if(grid[0]==grid[4] && grid[0]==grid[8] && grid[0]!=2)
                win=grid[0];
            if(grid[2]==grid[4] && grid[2]==grid[6] && grid[2]!=2)
                win=grid[2];

            if(win==1)
            {
                t.setText("X Win");
                w.setText("X Win");
                final MediaPlayer o = MediaPlayer.create(this,R.raw.win);
                o.start();
                while (o.isPlaying()==false)
                {
                    final MediaPlayer p = MediaPlayer.create(this,R.raw.win);
                    p.start();
                }
                LinearLayout vl=findViewById(R.id.box);
                vl.setVisibility(View.VISIBLE);
                start=false;
            }
            else if(win==0) {
                t.setText("0 Win");
                w.setText("0 Win");
                final MediaPlayer o = MediaPlayer.create(this,R.raw.win);
                o.start();
                while (o.isPlaying()==false)
                {
                    final MediaPlayer p = MediaPlayer.create(this,R.raw.win);
                    p.start();
                }

                LinearLayout vl=findViewById(R.id.box);
                start=false;
                vl.setVisibility(View.VISIBLE);
            }
            boolean e=true;
            for(int i=0;i<9;i++)
                if(grid[i]==2)
                    e=false;
            if(e && win==-1)
            {
                t.setText("Tie");
                w.setText("Tie");
                final MediaPlayer o = MediaPlayer.create(this,R.raw.win);
                o.start();
                while(o.isPlaying()==false)
                {
                final MediaPlayer p = MediaPlayer.create(this,R.raw.win);
                p.start();
                }

                LinearLayout vl=findViewById(R.id.box);
                vl.setVisibility(View.VISIBLE);
                start=false;

            }
        }
    }

    public void Reset(View view){
        RadioButton rg = (RadioButton) view;

        if(rg.isChecked())
        {
            flg=0;
            for (int i=0;i<9;i++)
                grid[i]=2;
            ((ImageView) findViewById (R. id. imageView1)).setImageResource (0) ;
            ((ImageView) findViewById (R. id. imageView8)).setImageResource (0) ;
            ((ImageView) findViewById (R. id. imageView2)).setImageResource (0) ;
            ((ImageView) findViewById (R. id. imageView9)).setImageResource (0) ;
            ((ImageView) findViewById (R. id. imageView3)).setImageResource (0) ;
            ((ImageView) findViewById (R. id. imageView4)).setImageResource (0) ;
            ((ImageView) findViewById (R. id. imageView5)).setImageResource (0) ;
            ((ImageView) findViewById (R. id. imageView6)).setImageResource (0) ;
            ((ImageView) findViewById (R. id. imageView7)).setImageResource (0) ;
            LinearLayout vl=findViewById(R.id.box);
            vl.setVisibility(View.INVISIBLE);
            TextView t =findViewById(R.id.state);
            t.setText("0's Turn");
            start=true;
        }
    }
    public void Ext(View view){
        finish();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}