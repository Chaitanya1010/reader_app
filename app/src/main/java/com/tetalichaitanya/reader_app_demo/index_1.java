package com.tetalichaitanya.reader_app_demo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by tetalichaitanya on 22/7/16.
 */
public class index_1 extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.home_1);
        LinearLayout ll_1 = (LinearLayout)findViewById(R.id.ll_1);
        String [] collection = {
                "0askj ncakjsdkajskjns kjnkaskjncakjs dkajskjnskjnk askjncakj sdkajskjnskjn sdkajskjnskjn sdkajskjnskjn sdkajskjnskjn sdkajskjnskjn sdkajskjnskjn sdkajskjnskjn sdkajskjnskjn sdkajskjnskjn sdkajskjnskjn sdkajskjnskjn sdkajskjnskjn sdkajskjnskjn sdkajskjnskjn sdkajskjnskjn sdkajskjnskjn kaskjncakjs dkajskjnskjn kaskj ncakjsdkajskjns kjnkaskjncakjs dkajskjnskjnk askjncakj sdkajskjnskjn kaskjncakjs dkajskjnskjn kaskj ncakjsdkajskjns kjnkaskjncakjs dkajskjnskjnk askjncakj sdkajskjnskjn kaskjncakjs dkajskjnskjn kaskj ncakjsdkajskjns kjnkaskjncakjs dkajskjnskjnk askjncakj sdkajskjnskjn kaskjncakjs dkajskjnskjn kaskj ncakjsdkajskjns kjnkaskjncakjs dkajskjnskjnk askjncakj sdkajskjnskjn kaskjncakjs dkajskjnskjn kaskj ncakjsdkajskjns kjnkaskjncakjs dkajskjnskjnk askjncakj sdkajskjnskjn kaskjncakjs dkajskjnskjn kaskj ncakjsdkajsk0",
                "1askjncak jsdkajskjn skjnkaskjn cakjsdkaj skjnskjnk1",
                "2askjnc akjsdkajskjnsk jnkaskjncakj sdkajskjn skjnkaskjncakj sdkajskjnskjn kaskjncakj sdkajskjns kjnkaskjnc akjsdkajskjn skjnkaskjnca kjsdkajskjnskjnk2",
                "3askjncakj sdkajskjnskjnka skjncaksd sdsjsdkajskjnskjnkaskjncakjsdkajskjnk3",
                "4as    kjnca4",
                "5askjncakjsdkajjnskjnkaskjncakjsdkajskjnskjnkaskjncakjsdkajskjnskjnkaskjncakjsdkajskjnskjnkaskjncakjsdkajskjnskjnk5",
                "6askjncakjsdkajskjnskjnkaskjncakjsdkajskjnskjnk6",
                "7askj ncakj sdkaj skjns kjnk kjsd kjasnda jsdnkas jksadnkas kjsndkasd kjasndkas kjasndas7"
        };
        String [] tags = {"0","1","2","3","4","5","6","7"};
        populateLinks(ll_1,collection,"heading",tags);
    }

    private void populateLinks(LinearLayout ll, String [] collection, String header,String[] tag)
    {
        WindowManager wm = (WindowManager)getApplicationContext().getSystemService(getApplicationContext().WINDOW_SERVICE);

        Display disp = wm.getDefaultDisplay();

        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        int height=dm.heightPixels;

        Log.d("text and screen", "" + height + " screen");

        Display display = getWindowManager().getDefaultDisplay();
        int maxHeight = display.getHeight();

        Log.d("text and screen", "" + maxHeight + " screen_2");


        final Context mContext = getApplicationContext();

        if (collection.length > 0)
        {
            LinearLayout llAlso = new LinearLayout(this);
            llAlso.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
            llAlso.setOrientation(LinearLayout.VERTICAL);

            int HeightSoFar = 0;

            int estimated_height = HeightSoFar;

            Log.d("text and screen", "" + HeightSoFar +" in text immediately after header "+HeightSoFar);
            for (int i=0; i<collection.length;i++)
            {
                TextView txtSamItem = new TextView(this, null,
                        android.R.attr.textColorLink);
                txtSamItem.setText(collection[i]);
                txtSamItem.setPadding(10, 0, 0, 0);
                txtSamItem.setTag(tag[i]);
                txtSamItem.setTextSize(22);
                txtSamItem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        TextView self = (TextView) v;
                        String ds = self.getTag().toString();

                        Toast.makeText(mContext, "" + ds, Toast.LENGTH_SHORT).show();
                    }
                });

                int widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(dm.widthPixels, View.MeasureSpec.AT_MOST);
                int heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
                txtSamItem.measure(widthMeasureSpec, heightMeasureSpec);
                estimated_height += txtSamItem.getMeasuredHeight();
                Log.d("text and screen","height after addding "+(i)+" is est "+estimated_height +" above if else "+txtSamItem.getMeasuredHeight()+" w_inst "+HeightSoFar);

                if (estimated_height <= maxHeight)
                {
                    HeightSoFar = estimated_height;
                    llAlso = new LinearLayout(this);
                    llAlso.setLayoutParams(new ViewGroup.LayoutParams(
                            ViewGroup.LayoutParams.WRAP_CONTENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT));
                    llAlso.setOrientation(LinearLayout.VERTICAL);

                    llAlso.addView(txtSamItem);

                    ll.addView(llAlso);

                    Log.d("text and screen",HeightSoFar+" "+txtSamItem.getMeasuredHeight() +" text in if "+i);
                }
                else
                {
                    llAlso = new LinearLayout(this);
                    llAlso.setLayoutParams(new ViewGroup.LayoutParams(
                            ViewGroup.LayoutParams.WRAP_CONTENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT));
                    llAlso.setOrientation(LinearLayout.VERTICAL);

                    Log.d("text and screen", HeightSoFar + " " + txtSamItem.getMeasuredHeight() + " text in else " + i + " " + estimated_height + " " + maxHeight + " " +HeightSoFar);
                    addremaining_text(collection[i], HeightSoFar, maxHeight, ll, llAlso);
                    break;
                }
            }

            //ll.addView(llAlso);
        }
    }
    public void addremaining_text(String passage,int HeightSoFar, int maxHeight, LinearLayout ll, LinearLayout llAlso)
    {
        int estimated_height = HeightSoFar;
        int height_so_far_txt = 0;
        int i=0;

        WindowManager wm = (WindowManager)getApplicationContext().getSystemService(getApplicationContext().WINDOW_SERVICE);

        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);

        String[] words = passage.split("\\s");

        TextView txtSamItem = new TextView(this, null,
                android.R.attr.textColorLink);
        txtSamItem.setTag("7");
        txtSamItem.setTextSize(22);
        txtSamItem.setText("");


        txtSamItem.setPadding(10, 0, 0, 0);
        txtSamItem.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        txtSamItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView self = (TextView) v;
                String ds = self.getTag().toString();

                Toast.makeText(getApplicationContext(), "" + ds, Toast.LENGTH_SHORT).show();
            }
        });

        for (i=0; i<words.length;i++)
        {
            String content = txtSamItem.getText().toString();
            txtSamItem.setText(content + " " + words[i]);


            int widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(dm.widthPixels, View.MeasureSpec.AT_MOST);
            int heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
            txtSamItem.measure(widthMeasureSpec, heightMeasureSpec);

            height_so_far_txt = txtSamItem.getMeasuredHeight();

            Log.d("text and screen", "" + estimated_height + " in extra above if else " + i + " " + txtSamItem.getMeasuredHeight() + " len is " + words.length + " word is " + i);


            if (HeightSoFar+height_so_far_txt <= maxHeight)
            {
                HeightSoFar = estimated_height;

                if(txtSamItem.getParent()!=null)
                    ((ViewGroup)txtSamItem.getParent()).removeView(txtSamItem);

                llAlso.addView(txtSamItem);
                if(llAlso.getParent()!=null)
                    ((ViewGroup)llAlso.getParent()).removeView(llAlso);

                ll.addView(llAlso);

                Log.d("text and screen",HeightSoFar+" "+txtSamItem.getMeasuredHeight() +" text in if "+i+" "+maxHeight);
            }
            else
            {
                Log.d("text and screen",HeightSoFar+" "+txtSamItem.getMeasuredHeight() +" text in else "+i+" "+maxHeight);
                txtSamItem.setText(content);
                break;
            }
        }
        Log.d("text and screen"," text counter value "+i+" "+HeightSoFar);

        //call add remaining words till i=words.length
        if(i<=words.length)
        {

        }

        //call populateLinks
        else if(i==words.length)
        {

        }
    }
}

