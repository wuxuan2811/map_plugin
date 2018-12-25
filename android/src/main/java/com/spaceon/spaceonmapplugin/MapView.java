package com.spaceon.spaceonmapplugin;

import android.content.Context;
import android.view.View;
import com.spaceon.map.util.SpaceonTileSource;
import com.spaceon.map.util.TileType;
import com.spaceon.widget.MapViewWrapper;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.platform.PlatformView;
import org.osmdroid.api.IMapController;
import org.osmdroid.views.overlay.ScaleBarOverlay;

public class MapView implements PlatformView, MethodChannel.MethodCallHandler
{
    private IMapController mMapController;
    private MapViewWrapper mMapView;
    private final MethodChannel methodChannel;

    MapView(Context context, BinaryMessenger messenger)
    {
        mMapView = new MapViewWrapper(context);
        init();
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
            case "zoomIn":
                onZoomIn();
                break;
            case "zoomOut":
                onZoomOut();
                break;
            default:
                result.notImplemented();
        }

    }

    @Override
    public void dispose()
    {
    }

    private void init()
    {
        mMapView.setTileSource(SpaceonTileSource.newTileSource(TileType.CHART, true));
        mMapController = mMapView.getController();

        //scales tiles to the current screen's DPI, helps with readability of labels
        mMapView.setTilesScaledToDpi(true);
        //我们的海图瓦片图只提供了4-17级, 17级下船舶按真实比例画出来很小, 所以最大zoom设为19
        mMapView.setMaxZoomLevel(19.0d);
        mMapView.setMinZoomLevel(4.0d);
        //隐藏内置的放大缩小建
        mMapView.setBuiltInZoomControls(false);
        mMapView.setMultiTouchControls(true);

        //map scale 显示比例尺
        ScaleBarOverlay scaleBarOverlay = new ScaleBarOverlay(mMapView);
        scaleBarOverlay.setEnableAdjustLength(true);
        //海里单位
        scaleBarOverlay.setUnitsOfMeasure(ScaleBarOverlay.UnitsOfMeasure.nautical);
        mMapView.getOverlays().add(scaleBarOverlay);
    }

    public void onZoomIn()
    {
        mMapController.zoomIn();
    }

    public void onZoomOut()
    {
        mMapController.zoomOut();
    }
}
