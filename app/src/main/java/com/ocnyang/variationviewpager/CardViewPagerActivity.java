package com.ocnyang.variationviewpager;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.ocnyang.pagetransformerhelp.cardtransformer.AlphaAndScalePageTransformer;
import com.ocnyang.pagetransformerhelp.cardtransformer.AlphaPageTransformer;
import com.ocnyang.pagetransformerhelp.cardtransformer.CascadingPageTransformer;
import com.ocnyang.pagetransformerhelp.cardtransformer.RotateDownPageTransformer;

import java.util.ArrayList;
import java.util.List;

public class CardViewPagerActivity extends AppCompatActivity {

    private final int[] mData = {R.drawable.img0, R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4};
    private ViewPager mViewPager;
    public  AlertDialog.Builder builder;
    private Dialog dialog;
    TextView okay_text, cancel_text;
    Button positiveDialog;
    Button negativeDialog;
    public static AlertDialog.Builder dialogBuilder;
    public static AlertDialog alertDialog;





    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view_pager);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        builder = new AlertDialog.Builder(this);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

            }
        },2000);
        mViewPager = ((ViewPager) findViewById(R.id.cardViewPager));
        mViewPager.setOffscreenPageLimit(3);
        mViewPager.setPageMargin(40);
        mViewPager.setPageTransformer(true,new AlphaPageTransformer());
        mViewPager.setAdapter(new MyPagerAdapter(getViewPagerData(),this));

       /* mViewPager.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent i = new Intent(MainActivity.this, SingleItemView.class);
                i.putExtra("flag", flag);
                i.putExtra("position", position);
                startActivity(i);
            }

        });*/
    }

/*
    public void dialog(Context context)
    {
        dialogBuilder = new AlertDialog.Builder(context);
        View layoutView = getLayoutInflater().inflate(R.layout.dialog_layout, null);
        TextView dialogButton = layoutView.findViewById(R.id.okay_text);
        dialogBuilder.setView(layoutView);
        alertDialog = dialogBuilder.create();
        alertDialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.show();
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });
    }
*/
    private List<ViewPagerItemBean> getViewPagerData() {
        List<ViewPagerItemBean> pagerItemBeanList = new ArrayList<>(mData.length);
        for (int i = 0; i < mData.length; i++) {
            pagerItemBeanList.add(new ViewPagerItemBean(mData[i], "OCN.Yang - "+i));
        }
        return pagerItemBeanList;
    }

/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.cardviewpagermenu,menu);
        return super.onCreateOptionsMenu(menu);
    }
*/

/*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
                finish();
                break;
            case R.id.AlphaPageTransformer:
                getSupportActionBar().setTitle("AlphaPageTransformer");
                mViewPager.setPageMargin(40);
                mViewPager.setPageTransformer(true,new AlphaPageTransformer());
                break;
            case R.id.CascadingPageTransformer:
                getSupportActionBar().setTitle("CascadingPageTransformer");
                mViewPager.setPageTransformer(true,new CascadingPageTransformer());
                break;
            case R.id.RotateDownPageTransformer:
                getSupportActionBar().setTitle("RotateDownPageTransformer");
                mViewPager.setPageMargin(40);
                mViewPager.setPageTransformer(true,new RotateDownPageTransformer());
                break;
            case R.id.AlphaAndScalePageTransformer:
                getSupportActionBar().setTitle("AlphaAndScalePageTransformer");
                mViewPager.setPageMargin(40);
                mViewPager.setPageTransformer(true,new AlphaAndScalePageTransformer());
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
*/
}
