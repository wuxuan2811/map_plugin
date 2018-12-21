package com.spaceon.spaceonmapplugin;

import android.content.Context;
import android.view.View;
import com.spaceon.widget.MapViewWrapper;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.platform.PlatformView;

public class MapView implements PlatformView, MethodChannel.MethodCallHandler
{
    //private final TextView textView;
    private MapViewWrapper mMapView;
    private final MethodChannel methodChannel;

    MapView(Context context, BinaryMessenger messenger)
    {
        mMapView = new MapViewWrapper(context);
        methodChannel = new MethodChannel(messenger, "plugins.spaceon/mapview");
        methodChannel.setMethodCallHandler(this);
    }

    @Override
    public View getView()
    {
        return mMapView;
    }

    @Override
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result)
    {
        switch (methodCall.method)
        {
            default:
                result.notImplemented();
        }

    }

    @Override
    public void dispose()
    {
    }
}
