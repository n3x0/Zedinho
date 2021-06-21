package com.estudioskelon.zedinho;

import android.graphics.Canvas;
import android.util.Log;
import android.view.SurfaceHolder;

class ZedinhoThread extends Thread {
    private SurfaceHolder surfaceHolder;
    private ZedinhoView zView;
    private boolean running;
    public static Canvas canvas;
    private boolean mPaused;
    private Object mPauseLock;

    public ZedinhoThread(SurfaceHolder sHolder, ZedinhoView zView) {
        super();
        mPauseLock = new Object();
        this.surfaceHolder = sHolder;
        this.zView = zView;
        this.mPaused = false;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    @Override
    public void run() {
        while (running) {
            canvas = null;
            try {
                canvas = this.surfaceHolder.lockCanvas();
                synchronized (surfaceHolder) {
                    this.zView.update();
                    this.zView.draw(canvas);
                }
                synchronized (mPauseLock) {
                    while (mPaused) {
                        try {
                            mPauseLock.wait();
                        } catch (InterruptedException e) {
                        }
                    }
                }
            } catch (Exception e) {
            } finally {
                if (canvas != null) {
                    try {
                        surfaceHolder.unlockCanvasAndPost(canvas);

                    } catch (Exception e) {

                    }

                }
            }
        }
    }

    public void pause() {
        synchronized (mPauseLock) {
            Log.d("ZedinhoThread", "Pause");
            mPaused = true;
        }
    }

    public void carryOn() {
        synchronized (mPauseLock) {
            Log.d("ZedinhoThread", "CarryOn");
            mPaused = false;
            mPauseLock.notifyAll();
        }
    }
}


