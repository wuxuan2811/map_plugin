package com.spaceon.widget;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import org.osmdroid.tileprovider.MapTileProviderBase;
import org.osmdroid.views.MapView;
import org.osmdroid.views.Projection;

/**
 * Created by lengxr on 2018/04/11 13:49.
 */
public class MapViewWrapper extends MapView
{
    private AnimatorListener mAnimatorListener;
    private OnTouchListener mTouchListener;
    private OnScaleChangeListener mOnScaleChangeListener;


    public MapViewWrapper(Context context, MapTileProviderBase tileProvider, Handler tileRequestCompleteHandler, AttributeSet attrs)
    {
        super(context, tileProvider, tileRequestCompleteHandler, attrs);
    }

    public MapViewWrapper(Context context, MapTileProviderBase tileProvider, Handler tileRequestCompleteHandler, AttributeSet attrs, boolean hardwareAccelerated)
    {
        super(context, tileProvider, tileRequestCompleteHandler, attrs, hardwareAccelerated);
    }

    public MapViewWrapper(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public MapViewWrapper(Context context)
    {
        super(context);
    }

    public MapViewWrapper(Context context, MapTileProviderBase aTileProvider)
    {
        super(context, aTileProvider);
    }

    public MapViewWrapper(Context context, MapTileProviderBase aTileProvider, Handler tileRequestCompleteHandler)
    {
        super(context, aTileProvider, tileRequestCompleteHandler);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev)
    {
        //可以接收
//        Log.d(TAG, "dispatchTouchEvent: " + ev.getAction() + ", x=" + ev.getX() + ",y=" + ev.getY());
        if (mTouchListener != null)
        {
            mTouchListener.onTouch(this, ev);
        }
        return super.dispatchTouchEvent(ev);
    }

    public void animationStart()
    {
        if (mAnimatorListener != null)
        {
            mAnimatorListener.onAnimationStart();
        }
    }

    public void animationEnd()
    {
        if (mAnimatorListener != null)
        {
            mAnimatorListener.onAnimationEnd();
        }
    }

    public void setMapTouchListener(OnTouchListener listener)
    {
        mTouchListener = listener;
    }


    @Override
    protected void setMultiTouchScale(float scale)
    {
        super.setMultiTouchScale(scale);
        if (mOnScaleChangeListener != null)
        {
            mOnScaleChangeListener.onScaleChanged(scale);
        }
    }


    public void setOnScaleChangeListener(OnScaleChangeListener listener)
    {
        mOnScaleChangeListener = listener;
    }

    public interface OnScaleChangeListener
    {
        void onScaleChanged(float scale);
    }

    public interface AnimatorListener
    {
        void onAnimationStart();

        void onAnimationEnd();
    }

    public void setAnimatorListener(AnimatorListener listener)
    {
        mAnimatorListener = listener;
    }


    public interface OnProjectionCreateListener
    {
        void onProjectionCreate();
    }

    public void setOnProjectionCreateListener(OnProjectionCreateListener listener)
    {
        mOnProjectionCreateListener = listener;
    }

    private OnProjectionCreateListener mOnProjectionCreateListener;

    @Override
    public Projection getProjection()
    {
        Projection projection = mProjection;
        if (projection == null)
        {
            projection = super.getProjection();
            if (mOnProjectionCreateListener != null)
            {
                mOnProjectionCreateListener.onProjectionCreate();
            }
        }
        return projection;
    }
}
