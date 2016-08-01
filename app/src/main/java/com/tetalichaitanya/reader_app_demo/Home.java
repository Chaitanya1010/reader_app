package com.tetalichaitanya.reader_app_demo;

import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.text.SpannableString;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.TextView;

/**
 * Created by tetalichaitanya on 14/7/16.
 */
public class Home extends AppCompatActivity
{

    final String name = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

    String new_page="";
    String last_page ="";

    int lastVisibleLineNumber_out;

    String name_1;
    int count =0;
    int count_1;
    Boolean var=true;
    TextView myTextView;

    public void home()
    {
        count=0;
        count_1=0;
        var=true;
        new_page="";
    }

    public void change_it(int val)
    {
        count_1=val;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        /*
        WindowManager wm = (WindowManager)getApplicationContext().getSystemService(getApplicationContext().WINDOW_SERVICE);

        final String name = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

        final String name_1;



        final TextView myTextView = (TextView)findViewById(R.id.textView);
        myTextView.setText(name);

        //Listener to see on which line did the text stop
        ViewTreeObserver vto = myTextView.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                ViewTreeObserver obs = myTextView.getViewTreeObserver();
                obs.removeOnGlobalLayoutListener(this);
                int height = myTextView.getHeight();
                int scrollY = myTextView.getScrollY();
                Layout layout = myTextView.getLayout();

                int firstVisibleLineNumber = layout.getLineForVertical(scrollY);
                int lastVisibleLineNumber = layout.getLineForVertical(height + scrollY);

                Log.d("width is", "lets see " + " " + name.length() + " " + myTextView.length() +" "+firstVisibleLineNumber);
                Log.d("height is", "lets see " + height + " "+lastVisibleLineNumber);

            }
        });*/

        /*

        while(home_1.var)
        {
            ViewTreeObserver vto = myTextView.getViewTreeObserver();

            home_1.new_page=home_1.new_page+""+(name.charAt(home_1.count_1));

            myTextView.setText(home_1.new_page);

            vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
            {
                @Override
                public void onGlobalLayout()
                {
                    ViewTreeObserver obs = myTextView.getViewTreeObserver();
                    obs.removeOnGlobalLayoutListener(this);
                    int height = myTextView.getHeight();
                    int scrollY = myTextView.getScrollY();
                    Layout layout = myTextView.getLayout();

                    int firstVisibleLineNumber = layout.getLineForVertical(scrollY);
                    int lastVisibleLineNumber = layout.getLineForVertical(height + scrollY);

                    home_1.count_1=lastVisibleLineNumber;
                    home_1.count++;

                    if(home_1.count>home_1.count_1)
                    {
                        home_1.break_it();
                    }
                }
            });


        }
        */

        int size=18;


        WindowManager wm = (WindowManager)getApplicationContext().getSystemService(getApplicationContext().WINDOW_SERVICE);

        Display disp = wm.getDefaultDisplay();

        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        int width=dm.widthPixels;
        int height=dm.heightPixels;

        myTextView = (TextView)findViewById(R.id.textView);
        myTextView.setTextSize(size);

        /*layout margin
        height-=20;
        width-=20;*/



        float chars_in_line = width/size;
        float num_of_lines = height/size;

        final Home home_1=new Home();

        for(int i=0;i<name.length();i++)
        {

            myTextView.setText(myTextView.getText().toString()+""+name.charAt(count));
            count++;

            check_val(home_1);

            if(count/chars_in_line>home_1.count_1+1)
            break;
        }


        Log.d("width is","lets see "+width+" "+chars_in_line);
        Log.d("height is","lets see "+height+" "+name.length()+" "+myTextView.getText().length()+" "+count+" "+home_1.count_1+" "+count/chars_in_line+" ");
    }

    public void check_val(Home obj)
    {
        ViewTreeObserver vto = myTextView.getViewTreeObserver();

        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
        {
            @Override
            public void onGlobalLayout()
            {
                ViewTreeObserver obs = myTextView.getViewTreeObserver();
                obs.removeOnGlobalLayoutListener(this);
                int height = myTextView.getHeight();
                int scrollY = myTextView.getScrollY();
                Layout layout = myTextView.getLayout();

                int firstVisibleLineNumber = layout.getLineForVertical(scrollY);
                int lastVisibleLineNumber = layout.getLineForVertical(height + scrollY);

                change_it(lastVisibleLineNumber);
            }
        });
    }
}