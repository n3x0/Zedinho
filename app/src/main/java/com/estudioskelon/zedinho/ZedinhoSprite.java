package com.estudioskelon.zedinho;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

import java.util.Random;

public class ZedinhoSprite {
    private String tag;
    private Paint mPaint;
    private Bitmap mBitmap;
    private int mColor;
    int x, y;

    public ZedinhoSprite(Bitmap bmp) {
        this.mBitmap = Bitmap.createScaledBitmap(bmp, 120, 120, false);
        x = new Random().nextInt(501);
        y = new Random().nextInt(501) + 200;
        mColor = Color.rgb(new Random().nextInt(128) + 128, new Random().nextInt(128) + 128, new Random().nextInt(128) + 128);
        mPaint = new Paint();
        mPaint.setColor(mColor);
        mPaint.setStrokeWidth(10);
    }

    public ZedinhoSprite(Bitmap bmp, int x, int y) {
        this.mBitmap = Bitmap.createScaledBitmap(bmp, 120, 120, false);
        this.x = x;
        this.y = y;
        mColor = Color.rgb(new Random().nextInt(128) + 128, new Random().nextInt(128) + 128, new Random().nextInt(128) + 128);
        mPaint = new Paint();
        mPaint.setColor(mColor);
        mPaint.setStrokeWidth(10);
    }

    public ZedinhoSprite(Resources r, int image, String tag, int x, int y) {
        Bitmap bitmap = BitmapFactory.decodeResource(r, image);
        this.mBitmap = Bitmap.createScaledBitmap(bitmap, 120, 120, false);
        this.tag = tag;
        this.x = x;
        this.y = y;
        mColor = Color.rgb(new Random().nextInt(128) + 128, new Random().nextInt(128) + 128, new Random().nextInt(128) + 128);
        mPaint = new Paint();
        mPaint.setColor(mColor);
        mPaint.setStrokeWidth(10);
    }

    public ZedinhoSprite(Bitmap bmp, Point point) {
        new ZedinhoSprite(bmp, point.x, point.y);
    }


    public void draw(Canvas canvas) {
        canvas.drawRect(getRect(), mPaint);
        canvas.drawBitmap(mBitmap, x, y, null);
    }

    public void update() {
        //y++;
    }

    public void setPos(int x, int y) {
        this.x = x - 60;
        this.y = y - 60;
    }

    public boolean contains(Point point) {
        return getRect().contains(point.x, point.y);
    }

    private Rect getRect() {
        return new Rect(x, y, x + 120, y + 120);
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}


