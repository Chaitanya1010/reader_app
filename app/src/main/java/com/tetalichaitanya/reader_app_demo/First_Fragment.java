package com.tetalichaitanya.reader_app_demo;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by tetalichaitanya on 30/7/16.
 */
public class First_Fragment extends Fragment
{
    String [] collection;
    String [] tags;
    int passage_id_1;
    int word_count_1;
    int HeightSoFar_1;
    int maxHeight;
    LinearLayout ll,llAlso;
    MyPagerAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        Log.d("Frag cycle","in Oncreate stat");

        getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        View v = inflater.inflate(R.layout.home_1, container, false);
        ll = (LinearLayout)v.findViewById(R.id.ll_1);

        llAlso = new LinearLayout(getContext());
        llAlso.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        llAlso.setOrientation(LinearLayout.VERTICAL);

        if(word_count_1==0)
        {
            //LinearLayout ,llAlso_1, collection, tag, pas_id, HeightSoFar, maxHeight
            populateLinks(passage_id_1, HeightSoFar_1);

        }

        else
        {
            // collection, HeightSoFar, maxHeight, LinearLayout ll, LinearLayout llAlso, pass_id,word_count
            addremaining_text(HeightSoFar_1, passage_id_1,word_count_1);
        }
        return v;
    }


    // collection, tags, pass_id, word_count, heightsofar,maxheight
    public static First_Fragment newInstance(MyPagerAdapter adapter, String[] collection_1,String[] tag_ids_1,int passage_id_1,int word_count_1,int HeightSoFar,int maxHeight)
    {
        First_Fragment f = new First_Fragment();

        f.collection = collection_1;
        f.tags = tag_ids_1;
        f.passage_id_1 = passage_id_1;
        f.word_count_1 = word_count_1;
        f.HeightSoFar_1 = HeightSoFar;
        f.maxHeight = maxHeight;
        f.adapter = adapter;

        Log.d("text and screen", "" + collection_1.toString() + " "+ tag_ids_1.toString()+" "+passage_id_1+" "+word_count_1+" "+HeightSoFar+" "+maxHeight);

        return f;
    }

    public First_Fragment() //for new fragment initialization
    {

    }

    //LinearLayout ll,llAlso_1, collection, tag, pas_id, HeightSoFar, maxHeight
    private void populateLinks(int pas_id ,int HeightSoFar)
    {
        WindowManager wm = (WindowManager) getActivity().getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);

        final Context mContext = getContext();

        if (collection.length > 0)
        {
            //int HeightSoFar = 0;

            int estimated_height = HeightSoFar;

            Log.d("text and screen", "" + HeightSoFar +" in text immediately after header "+HeightSoFar);
            for (int i=pas_id; i<collection.length;i++)
            {
                TextView txtSamItem = new TextView(getContext(), null,android.R.attr.textColorLink);
                txtSamItem.setText(collection[i]);
                txtSamItem.setPadding(10, 0, 0, 0);
                txtSamItem.setTag(tags[i]);
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
                    llAlso = new LinearLayout(getContext());
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
                    llAlso = new LinearLayout(getContext());
                    llAlso.setLayoutParams(new ViewGroup.LayoutParams(
                            ViewGroup.LayoutParams.WRAP_CONTENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT));
                    llAlso.setOrientation(LinearLayout.VERTICAL);

                    Log.d("text and screen", HeightSoFar + " " + txtSamItem.getMeasuredHeight() + " text in else " + i + " " + estimated_height + " " + maxHeight + " " + HeightSoFar);
                    addremaining_text(HeightSoFar,i,0);
                    break;
                }
            }

            if(pas_id==collection.length)
            {
                Log.d("text and screen", "this is the end line THE LAST LINE");
            }

            //ll.addView(llAlso);
        }
    }

    // collection, HeightSoFar, maxHeight, LinearLayout ll, LinearLayout llAlso, pass_id,word_count
    public void addremaining_text(int HeightSoFar,int pass_id,int word_count_1)
    {
        int height_so_far_txt = 0;
        int estimated_txt = height_so_far_txt;

        int i=0;

        String passage = collection[pass_id];
        WindowManager wm = (WindowManager)getContext().getSystemService(getContext().WINDOW_SERVICE);

        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);

        String[] words = passage.split("\\s");
        //Toast.makeText(getContext(),words.length+" ",Toast.LENGTH_SHORT).show();

        TextView txtSamItem = new TextView(getContext(), null,android.R.attr.textColorLink);
        txtSamItem.setTag(pass_id);
        txtSamItem.setTextSize(21);
        txtSamItem.setText("");


        txtSamItem.setPadding(10, 0, 0, 0);
        txtSamItem.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        txtSamItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView self = (TextView) v;
                String ds = self.getTag().toString();

                Toast.makeText(getContext(), ""+ds, Toast.LENGTH_SHORT).show();
            }
        });

        for (i=word_count_1; i<words.length;i++)
        {
            String content = txtSamItem.getText().toString();
            if(i==word_count_1)
            {
                txtSamItem.setText(words[i]);
            }
            else
                txtSamItem.setText(content + " " + words[i]);


            int widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(dm.widthPixels, View.MeasureSpec.AT_MOST);
            int heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
            txtSamItem.measure(widthMeasureSpec, heightMeasureSpec);

            height_so_far_txt = txtSamItem.getMeasuredHeight();

            Log.d("text and screen", "" + (HeightSoFar+height_so_far_txt) + " in extra above if else " + i + " " + txtSamItem.getMeasuredHeight() + " len is " + words.length + " word is " + i);


            if (HeightSoFar+height_so_far_txt <= maxHeight)
            {
                estimated_txt = height_so_far_txt;

                if(txtSamItem.getParent()!=null)
                    ((ViewGroup)txtSamItem.getParent()).removeView(txtSamItem);

                llAlso.addView(txtSamItem);
                if(llAlso.getParent()!=null)
                    ((ViewGroup)llAlso.getParent()).removeView(llAlso);

                ll.addView(llAlso);
                Log.d("text and screen",(HeightSoFar+height_so_far_txt)+" "+txtSamItem.getMeasuredHeight() +" text in if "+i+" "+maxHeight);
            }

            //no more space is left
            else
            {
                Log.d("text and screen", (HeightSoFar + height_so_far_txt) + " " + txtSamItem.getMeasuredHeight() + " text in else " + i + " " + maxHeight);

                HeightSoFar += estimated_txt;
                txtSamItem.setText(content);
                break;
            }
        }

        //still space is remaining
        if(i==words.length)
            HeightSoFar +=estimated_txt;

        Log.d("text and screen"," text counter value "+i+" "+(HeightSoFar)+" "+estimated_txt+" "+height_so_far_txt+" "+maxHeight);

        //call add remaining words till i=words.length
        if(i<words.length-1)
        {
            // collection, tags, pass_id, word_count, heightsofar,maxheight
            adapter.first_fragments.add(First_Fragment.newInstance(adapter,collection,tags,pass_id,i,0,maxHeight));
            adapter.notifyDataSetChanged();
        }

        //call populateLinks
        else if(i==words.length)
        {

            //started in new page and height isn't initialized yet
            if(HeightSoFar ==0)
                HeightSoFar += estimated_txt;

            if(pass_id == collection.length-1)
            {
                Log.d("text and screen", "this is the end line THE LAST LINE");
            }
            else if(HeightSoFar<maxHeight)
            {
                Log.d("text and screen", "CALLING FUNC "+pass_id+" "+HeightSoFar);
                //LinearLayout ll, llAlso_1, collection, tag, pas_id, HeightSoFar, maxHeight
                populateLinks(pass_id+1, HeightSoFar);
            }
        }
    }
}

