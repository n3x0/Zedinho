package com.estudioskelon.zedinho;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import java.util.ArrayList;

class ZedinhoView extends SurfaceView implements SurfaceHolder.Callback, View.OnTouchListener {

    private ZedinhoThread mThread;
    private ArrayList<ZedinhoSprite> mSprites;
    private int mSelectedSprite;
    private boolean mDragging;
    private ZedhinoBar mZedinhoBar;

    public ZedinhoView(Context context) {
        super(context);
        getHolder().addCallback(this);

        mThread = new ZedinhoThread(getHolder(), this);
        setFocusable(true);
        setOnTouchListener(this);
        mSelectedSprite = -1;
    }


    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        addDemoSprites();
        addDemoBar();
        mThread.setRunning(true);
        mThread.start();
    }

    private void addDemoBar() {
        mZedinhoBar = new ZedhinoBar(getResources());
    }

    private void addDemoSprites() {
        mSprites = new ArrayList();
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        boolean retry = true;
        while (retry) {
            try {
                mThread.setRunning(false);
                mThread.join();
            } catch (Exception e) {
                e.printStackTrace();
            }
            retry = false;
        }
    }

    public void update() {
        for (ZedinhoSprite sprite : mSprites) {
            sprite.update();
        }
        mZedinhoBar.update();
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (canvas != null) {
            for (ZedinhoSprite sprite : mSprites) {
                sprite.draw(canvas);
            }
            mZedinhoBar.draw(canvas);
        }
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_UP:
                //thread.carryOn();
                mSelectedSprite = -1;
                mDragging = false;
                break;
            case MotionEvent.ACTION_DOWN:
                boolean found = false;
                for (int i = 0; i < mSprites.size(); i++) {
                    ZedinhoSprite sprite = mSprites.get(i);
                    if (sprite.contains(new Point((int) motionEvent.getX(), (int) motionEvent.getY()))) {
                        this.mSelectedSprite = i;
                        found = true;
                    }
                    if (!found) {
                        this.mSelectedSprite = -1;
                    }

                }
                checkBarClick(motionEvent);
                break;
            case MotionEvent.ACTION_MOVE:
                mDragging = true;
                if (mSelectedSprite >= 0 && mSelectedSprite < mSprites.size()) {
                    mSprites.get(mSelectedSprite).setPos((int) motionEvent.getX(), (int) motionEvent.getY());
                }
                break;
        }
        return true;
    }

    private void checkBarClick(MotionEvent motionEvent) {
        ZedinhoSprite sprite = mZedinhoBar.checkClick(motionEvent);
        if (sprite!=null){
            ZedinhoSpriteFactory factory = new ZedinhoSpriteFactory(getResources());
            mSprites.add(factory.getSprite(sprite.getTag(), 500, 500));
        }
    }
}

