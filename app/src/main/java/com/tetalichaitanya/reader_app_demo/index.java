package com.tetalichaitanya.reader_app_demo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by tetalichaitanya on 21/7/16.
 */
public class index extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_1);
        LinearLayout ll_1 = (LinearLayout)findViewById(R.id.ll_1);
        String [] collection = {
                "askjncakjsdkajskjnskjnkaskjncakjsdkajskjnskjnkaskjncakjsdkajskjnskjnkaskjncakjsdkajskjnskjnk",
                "askjncakjsdkajskjnskjnkaskjncakjsdkajskjnskjnk",
                "askjncakjsdkajskjnskjnkaskjncakjsdkajskjnskjnkaskjncakjsdkajskjnskjnkaskjncakjsdkajskjnskjnkaskjncakjsdkajskjnskjnkaskjncakjsdkajskjnskjnk",
                "askjncakjsdkajskjnskjnkaskjncakjsdkajskjnskjnkaskjncakjsdkajskjnskjnk",
                "askjnca",
                "askjncakjsdkajskjnskjnkaskjncakjsdkajskjnskjnkaskjncakjsdkajskjnskjnkaskjncakjsdkajskjnskjnkaskjncakjsdkajskjnskjnkaskjncakjsdkajskjnskjnkaskjncakjsdkajskjnskjnk",
                "askjncakjsdkajskjnskjnkaskjncakjsdkajskjnskjnk",
                "askjncakjsdkajskjnskjnk"
        };
        String [] tags = {"1","2","3","4","5","6","7","8"};
        populateLinks(ll_1,collection,"heading",tags);
    }

    private void populateLinks(LinearLayout ll, String [] collection, String header,String[] tag)
    {
        WindowManager wm = (WindowManager)getApplicationContext().getSystemService(getApplicationContext().WINDOW_SERVICE);

        Display disp = wm.getDefaultDisplay();

        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        int height=dm.heightPixels;

        Log.d("text and screen", "" + height + "screen");

        Display display = getWindowManager().getDefaultDisplay();
        int maxHeight = display.getHeight() - 10;

        Log.d("text and screen",""+maxHeight +"screen_2");


        final Context mContext = getApplicationContext();

        if (collection.length > 0)
        {
            LinearLayout llAlso = new LinearLayout(this);
            llAlso.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
            llAlso.setOrientation(LinearLayout.VERTICAL);

            TextView txtSample = new TextView(this);
            txtSample.setText(header);
            txtSample.setTextSize(22);
            llAlso.addView(txtSample);
            txtSample.measure(0, 0);

            int HeightSoFar = txtSample.getMeasuredWidth();


            for (int i=0; i<collection.length;i++)
            {
                TextView txtSamItem = new TextView(this, null,
                        android.R.attr.textColorLink);
                txtSamItem.setPadding(10, 0, 0, 0);
                txtSamItem.setTag(tag[i]);
                txtSamItem.setTextSize(22);
                txtSamItem.setText("");

                for(int j=0;j<collection[i].length();j++)
                {
                    txtSamItem.setText(txtSamItem.getText().toString() + "" + collection[i].charAt(j));
                    measure_heigth(txtSamItem,HeightSoFar,maxHeight,dm);
                }

                //txtSamItem.setText(collection[i]);


                Log.d("text and screen", "" + HeightSoFar +" in text");

                txtSamItem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        TextView self = (TextView) v;
                        String ds = self.getTag().toString();

                        Toast.makeText(mContext, "" + ds, Toast.LENGTH_LONG).show();
                    }
                });

                if (HeightSoFar <= maxHeight)
                {
                    ll.addView(llAlso);

                    llAlso = new LinearLayout(this);
                    llAlso.setLayoutParams(new ViewGroup.LayoutParams(
                            ViewGroup.LayoutParams.WRAP_CONTENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT));
                    llAlso.setOrientation(LinearLayout.VERTICAL);

                    llAlso.addView(txtSamItem);

                    Log.d("text and screen",""+txtSamItem.getMeasuredHeight() +"text");
                }
                else
                {
                    Log.d("text and screen",""+HeightSoFar +"text in else");

                }
            }

            ll.addView(llAlso);
        }
    }
    public void measure_heigth(TextView txtSamItem,int HeightSoFar,int maxHeight,DisplayMetrics dm)
    {
        int widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(dm.widthPixels, View.MeasureSpec.AT_MOST);
        int heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        txtSamItem.measure(widthMeasureSpec, heightMeasureSpec);
        HeightSoFar += txtSamItem.getMeasuredHeight();

        if(HeightSoFar>=maxHeight)
        {
            Log.d("text and screen","end of screen");
        }
    }
}

