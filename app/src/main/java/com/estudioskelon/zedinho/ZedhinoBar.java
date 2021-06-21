package com.estudioskelon.zedinho;

import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;

import java.util.ArrayList;
import java.util.Random;

public class ZedhinoBar {
    private final Paint mPaint;
    private int x, y;
    private ArrayList<ZedinhoSprite> mPallete;
    private ZedinhoSpriteFactory mFactory;

    public ZedhinoBar(Resources r) {
        int color = Color.rgb(new Random().nextInt(128) + 128, new Random().nextInt(128) + 128, new Random().nextInt(128) + 128);

        mPaint = new Paint();
        mPaint.setColor(color);
        mPaint.setStrokeWidth(10);

        mFactory = new ZedinhoSpriteFactory(r);

        mPallete = new ArrayList();
        mPallete.add(mFactory.getSprite(ZedinhoSpriteFactory.PELOTA, 10, 10));
        mPallete.add(mFactory.getSprite(ZedinhoSpriteFactory.CONO, 130, 10));
        mPallete.add(mFactory.getSprite(ZedinhoSpriteFactory.VALLA, 260, 10));
        mPallete.add(mFactory.getSprite(ZedinhoSpriteFactory.T1, 390, 10));
        mPallete.add(mFactory.getSprite(ZedinhoSpriteFactory.T2, 520, 10));
    }

    public void draw(Canvas canvas) {
        canvas.drawRect(getRect(canvas), mPaint);
        for (ZedinhoSprite sprite : mPallete) {
            sprite.draw(canvas);
        }
    }

    private Rect getRect(Canvas canvas) {
        return new Rect(0, 0, canvas.getWidth(), 200);
    }

    public void update() {

    }

    public ZedinhoSprite checkClick(MotionEvent motionEvent) {
        for (ZedinhoSprite sprite : mPallete) {
            if (sprite.contains(new Point((int) motionEvent.getX(), (int) motionEvent.getY()))) {
                Log.d("ZedhinoBar", "Selected: " + sprite);
                return sprite;
            }
        }
        return null;
    }
}
