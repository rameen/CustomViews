package com.example.com_learning.playground;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class DottedLineView extends View {


    private Paint _verticalLinePaint;
    private Paint _horizontalLinePaint;

    private static final int LINE_WIDTH = 15;  //approx 3dp in xxhdpi

    public DottedLineView(Context context) {
        super(context);
        init();
    }

    public DottedLineView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DottedLineView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {


        _verticalLinePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        _verticalLinePaint.setStyle(Paint.Style.STROKE);
        _verticalLinePaint.setStrokeWidth(LINE_WIDTH-12);

        _verticalLinePaint.setColor(getResources().getColor(android.R.color.holo_red_dark));
        _horizontalLinePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        _horizontalLinePaint.setStyle(Paint.Style.STROKE);
        _horizontalLinePaint.setColor(getResources().getColor(android.R.color.holo_blue_dark));
        _horizontalLinePaint.setStrokeWidth(LINE_WIDTH);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int w = getWidth();
        int h = getHeight();
        Log.d("cv", "width " + w + " height " + h);

        for (int dx = 0; dx <= h; dx += 20) {
            canvas.drawLine(w / 2, dx, w / 2, dx + 10, _verticalLinePaint);
        }
        canvas.drawLine(0, h / 2, w, h / 2, _horizontalLinePaint);


    }
}
