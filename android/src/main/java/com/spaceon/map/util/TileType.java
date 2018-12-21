package com.spaceon.map.util;

/**
 * Created by lengxr on 2018/04/12 11:05.
 */
public enum TileType
{
    CHART("c", "c"),
    GAODE("d", "m"),
    GAODE_SAT("d", "s"),
    GOOGLE("g", "m"),
    GOOGLE_SAT("g", "s"),;

    TileType(String map, String type)
    {
        this.map = map;
        this.type = type;
    }

    public String getMap()
    {
        return map;
    }

    public String getType()
    {
        return type;
    }

    @Override
    public String toString()
    {
        return "TileType{" +
                "map='" + map + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    //c:海图；d:高德；g:谷歌
    private String map;
    //m:街道图；s:卫星图 在map参数为g或d时才生效
    private String type;
}
