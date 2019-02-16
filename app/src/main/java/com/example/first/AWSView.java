package com.example.first;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.View;

public class AWSView extends View {

    Bitmap background;
    public AWSView(Context context) {
        super(context);
        background = BitmapFactory.decodeResource(getResources(),R.drawable.back);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(background,0,0,null);
    }
}
