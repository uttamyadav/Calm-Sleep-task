package com.ocnyang.variationviewpager;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AlertDialog;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.Calendar;
import java.util.List;

import io.feeeei.circleseekbar.CircleSeekBar;

/*******************************************************************
 *    * * * *   * * * *   *     *       Created by OCN.Yang
 *    *     *   *         * *   *       Time:2017/12/6 10:47.
 *    *     *   *         *   * *       Email address:ocnyang@gmail.com
 *    * * * *   * * * *   *     *.Yang  Web site:www.ocnyang.com
 *******************************************************************/


public class MyPagerAdapter extends PagerAdapter {

    private List<ViewPagerItemBean> mData;
    private Context mContext;
    public static AlertDialog.Builder dialogBuilder;
    public static AlertDialog alertDialog;

    public MyPagerAdapter(List<ViewPagerItemBean> data, Context context) {
        mData = data;
        mContext = context;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View inflate = LayoutInflater.from(container.getContext()).inflate(R.layout.cardviewpager_item, container, false);
        ImageView imageView1 = (ImageView) inflate.findViewById(R.id.img_card_item);
        TextView textView = (TextView) inflate.findViewById(R.id.title_card_item);
        CardView main = (CardView) inflate.findViewById(R.id.main);

        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogBuilder = new AlertDialog.Builder(mContext);
                View layoutView = LayoutInflater.from(container.getContext()).inflate(R.layout.dialog_layout, null);
                TextView buy = layoutView.findViewById(R.id.buy);
                RelativeLayout rel_date_had = layoutView.findViewById(R.id.rel_date_had);
                RelativeLayout rel1 = layoutView.findViewById(R.id.rel1);
                RelativeLayout rel2 = layoutView.findViewById(R.id.rel2);
                RelativeLayout rel_prize = layoutView.findViewById(R.id.rel_prize);
                CalendarView calendar = layoutView.findViewById(R.id.calendar);
                CircleSeekBar seekbar = layoutView.findViewById(R.id.seekbar);
                TextView date_view = (TextView) layoutView.findViewById(R.id.date_view);
                TextView prize_view = (TextView) layoutView.findViewById(R.id.prize_view);
                TextView tv_prize = (TextView) layoutView.findViewById(R.id.tv_prize);
                TextView Submit = (TextView) layoutView.findViewById(R.id.Submit);
                TextView PrizeDone = (TextView) layoutView.findViewById(R.id.PrizeDone);
                PrizeDone.setVisibility(View.GONE);
                Submit.setVisibility(View.GONE);
                prize_view.setVisibility(View.GONE);
                date_view.setVisibility(View.GONE);
                tv_prize.setVisibility(View.GONE);
                rel_prize.setVisibility(View.GONE);
                calendar.setMinDate(System.currentTimeMillis());
                System.out.println("date==>>>"+System.currentTimeMillis());
                seekbar.setOnSeekBarChangeListener(new CircleSeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onChanged(CircleSeekBar seekbar, int curValue) {
                        tv_prize.setText("Prize :" + curValue + " Rs.");
                        PrizeDone.setVisibility(View.VISIBLE);
                    }
                });

                seekbar.setCurProcess(10000);
                rel_date_had.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        calendar.setVisibility(View.VISIBLE);
                    }
                });
                Submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }
                });
                PrizeDone.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        seekbar.setVisibility(View.GONE);
                        PrizeDone.setVisibility(View.GONE);
                        Submit.setVisibility(View.VISIBLE);
                    }
                });
                rel_prize.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        rel_prize.setVisibility(View.VISIBLE);
                        tv_prize.setVisibility(View.VISIBLE);
                        seekbar.setVisibility(View.VISIBLE);
                    }
                });

                // Add Listener in calendar
                calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
                            @Override

                            // In this Listener have one method
                            // and in this method we will
                            // get the value of DAYS, MONTH, YEARS
                            public void onSelectedDayChange(
                                    @NonNull CalendarView view,
                                    int year,
                                    int month,
                                    int dayOfMonth) {

                                // Store the value of date with
                                // format in String type Variable
                                // Add 1 in month because month
                                // index is start with 0
                                String Date
                                        = dayOfMonth + "-"
                                        + (month + 1) + "-" + year;

                                // set this date in TextView for Display
                                Animation animZoomOut = AnimationUtils.loadAnimation(mContext, R.anim.zoom_out);
                                calendar.startAnimation(animZoomOut);

                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        calendar.setVisibility(View.GONE);
                                        rel_date_had.setVisibility(View.VISIBLE);
                                        rel_prize.setVisibility(View.VISIBLE);
                                        date_view.setVisibility(View.VISIBLE);
                                        date_view.setText("Selected Date : " + Date);
                                    }
                                }, 1000);
                            }
                        });
                dialogBuilder.setView(layoutView);
                alertDialog = dialogBuilder.create();
                alertDialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
                alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                alertDialog.show();
                buy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
//                        alertDialog.dismiss();

                        Animation animZoomOut = AnimationUtils.loadAnimation(mContext, R.anim.zoom_out);
                        rel1.startAnimation(animZoomOut);
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                rel1.setVisibility(View.GONE);

                                Animation animZoomIn = AnimationUtils.loadAnimation(mContext, R.anim.zoom_in);
                                rel2.startAnimation(animZoomIn);

                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        rel2.setVisibility(View.VISIBLE);
                                        calendar.setVisibility(View.GONE);
                                        seekbar.setVisibility(View.GONE);
                                        PrizeDone.setVisibility(View.GONE);
                                        Submit.setVisibility(View.GONE);

                                    }
                                }, 300);
                            }
                        }, 300);


                    }
                });

            }
        });
        Glide.with(mContext).load(mData.get(position).getImg_url()).into(imageView1);
        textView.setText(mData.get(position).getTilte_text() + "");
        container.addView(inflate);
        return inflate;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(((View) object));
    }

}
