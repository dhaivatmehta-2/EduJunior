package com.example.edu_app;


import android.content.Context;
import android.view.View;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.core.content.ContextCompat;

public class TouchScreen extends View {
    Paint myPaint;
    Path myPath;

    public TouchScreen(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        myPaint = new Paint();
        myPath = new Path();

        myPaint.setColor(Color.RED);
        myPaint.setStyle(Paint.Style.STROKE);

        myPaint.setStrokeJoin(Paint.Join.ROUND);
        myPaint.setStrokeWidth(6f);
    }

    protected void onDraw(Canvas canvas)
    {
        canvas.drawPath(myPath, myPaint);
    }

    public boolean onTouchEvent(MotionEvent event)
    {
        float eventx = event.getX();
        float eventy = event.getY();

        switch(event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                myPath.moveTo(eventx,eventy);
                break;

            case MotionEvent.ACTION_MOVE:
                myPath.lineTo(eventx,eventy);
                break;

            case MotionEvent.ACTION_UP:
                break;

            default:
                return false;
        }
        invalidate();
        return true;
    }

    public void clearCanvas()
    {
        myPath.reset();
        invalidate();
    }

    public void changeColor(String choice) {
        int color=Color.parseColor(choice);
        myPaint.setColor(color);
        invalidate();
    }
}
