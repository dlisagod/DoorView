package com.example.myapplication;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.MovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.databinding.ActivityMain2Binding;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity2 extends AppCompatActivity {
    String text = "测试文本测试文本测试文本测试文本。\n测试文本测试文本测试文本。\n测试文本测试文本测试文本测试文本测试文本测试文本测试文本测试文本测试文本。";
    private ActivityMain2Binding binding;
    private float downY = 0;
    private float upY = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        MovementMethod m = ScrollingMovementMethod.getInstance();
        binding.tv04.setText(text);
        binding.tv05.setText(text);
        binding.tv04.setMovementMethod(m);
        SpannableString sb = new SpannableString(text);
        MovementMethod m2 = ScrollingMovementMethod.getInstance();
//        binding.tv05.setMovementMethod(m2);
        binding.tv04.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                m2.onTouchEvent(binding.tv05, sb, motionEvent);
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:

                        downY = motionEvent.getY();
                        Log.d("MainActivity2", "downY " + downY);
                        break;
                    case MotionEvent.ACTION_UP:
                        upY = motionEvent.getY();

//                        scrollCompare(binding.tv04.getWidth(), binding.tv04.getTextSize(), (int) (upY - downY));
                        Log.d("MainActivity2", "upY " + upY);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        float y = motionEvent.getY();
//                        binding.tv05.scrollTo(0, -(int) y);
                        break;
                }
                return false;
            }
        });

        binding.tv04.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                Log.d("MainActivity2", "onPreDraw tv04 " + TextViewUtil.getTextViewLines(binding.tv04, binding.tv04.getWidth()));
                return true;
            }
        });
        binding.tv05.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                Log.d("MainActivity2", "onPreDraw tv05 " + TextViewUtil.getTextViewLines(binding.tv05, binding.tv05.getWidth()));
                return true;
            }
        });
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Log.d("MainActivity2", "" + TextViewUtil.getTextViewLines(binding.tv04, binding.tv04.getWidth()));
                Log.d("MainActivity2", "" + TextViewUtil.getTextViewLines(binding.tv05, binding.tv05.getWidth()));
            }
        }, 1000);
    }

    void scrollCompare(int compareWidth, float compareTextSize, int compareScrollHeight) {
        float compareWidthF = (float) compareWidth;
        float ratioCompare = compareWidthF / compareTextSize;
        float widthF = (float) binding.tv05.getWidth();
        float ratio = widthF / binding.tv05.getTextSize();
        float scale = ratio / ratioCompare;
        int height = (int) (scale * compareScrollHeight);
        Log.d(MainActivity2.class.getSimpleName(), compareScrollHeight + " " + height);
        binding.tv05.scrollBy(0, -height);
    }

}