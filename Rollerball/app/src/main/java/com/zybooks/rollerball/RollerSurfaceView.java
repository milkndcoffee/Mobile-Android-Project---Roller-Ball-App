package com.zybooks.rollerball;


import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.zybooks.rollerball.RollerThread;


/*
    RollerSurfaceView starts and stops a background thread, which displays
    the game elements on the SurfaceView. The background thread is implemented
    in the RollerThread class. RollerSurfaceView sends accelerometer values to
    the thread so the ball's position can be updated.
 */
public class RollerSurfaceView extends SurfaceView implements SurfaceHolder.Callback {

    private RollerThread mRollerThread;

    public RollerSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);

        SurfaceHolder holder = getHolder();
        holder.addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        mRollerThread = new RollerThread(holder);
        mRollerThread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        mRollerThread.stopThread();
    }

    public void changeAcceleration(float x, float y) {
        if (mRollerThread != null) {
            mRollerThread.changeAcceleration(x, y);
        }
    }

    public void shake() {
        if (mRollerThread != null) {
            mRollerThread.shake();
        }
    }
}