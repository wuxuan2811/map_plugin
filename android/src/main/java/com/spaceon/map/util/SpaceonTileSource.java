package com.spaceon.map.util;

import android.util.Log;
import org.osmdroid.tileprovider.tilesource.OnlineTileSourceBase;
import org.osmdroid.util.MapTileIndex;

/**
 * Created by lengxr on 2018/04/10 11:47.
 */
public class SpaceonTileSource extends OnlineTileSourceBase
{
    private static final String TAG = "SpaceonTileSource";
    public static final String KEY = "Uho0laGeZDliWNcVMG9sR9NU75m1djITaTDfhFIEJKo=";
    private TileType tileType;

    private SpaceonTileSource(TileType tileType, String[] urls)
    {
        this("Spaceon-" + tileType.name(), 0, 18, 256, "",
                urls);
        this.tileType = tileType;
        Log.d(TAG, "constructor  " + tileType);
    }

    /**
     * Constructor
     *
     * @param aName                a human-friendly name for this tile source
     * @param aZoomMinLevel        the minimum zoom level this tile source can provide
     * @param aZoomMaxLevel        the maximum zoom level this tile source can provide
     * @param aTileSizePixels      the tile size in pixels this tile source provides
     * @param aImageFilenameEnding the file name extension used when constructing the filename
     * @param aBaseUrl             the base url(s) of the tile server used when constructing the url to download the tiles
     */
    private SpaceonTileSource(String aName, int aZoomMinLevel, int aZoomMaxLevel, int aTileSizePixels, String aImageFilenameEnding, String[] aBaseUrl)
    {
        super(aName, aZoomMinLevel, aZoomMaxLevel, aTileSizePixels, aImageFilenameEnding, aBaseUrl, "USGS");
    }

    @Override
    public String getTileURLString(final long pMapTileIndex)
    {
        int x = MapTileIndex.getX(pMapTileIndex);
        int y = MapTileIndex.getY(pMapTileIndex);
        int z = MapTileIndex.getZoom(pMapTileIndex);
        StringBuilder builder = new StringBuilder(getBaseUrl());
        if(tileType == TileType.CHART)
        {
            builder.append("Charts/")
                    .append(z).append("/")
                    .append(x).append("/")
                    .append(y);
        }
        else
        {
            builder.append(tileType.getMap()).append("/")
                    .append(tileType.getType()).append("/")
                    .append(z).append("/")
                    .append(x).append("/")
                    .append(y).append("/")
                    .append(KEY);
        }
        String url = builder.toString();
        return url;
    }

    public static SpaceonTileSource newTileSource(final TileType tileType, boolean isCn)
    {
        Log.d(TAG, "newTileSource  tileType=" + tileType + " ,isCn = " + isCn);
        int port = isCn ? 19000 : 19001;
        return new SpaceonTileSource(tileType, new String[]{"http://47.74.180.47:" + port + "/"});
    }
}
