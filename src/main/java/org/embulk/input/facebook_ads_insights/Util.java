package org.embulk.input.facebook_ads_insights;

import com.google.gson.Gson;
import org.embulk.input.facebook_ads_insights.unit.ToStringMap;

import java.util.List;
import java.util.stream.Collectors;

public class Util
{
    private Util() {}

    public static String stringifyToStringMaps(List<ToStringMap> value)
    {
        Gson gson = new Gson();
        return "[" + value.stream().map(gson::toJson).collect(Collectors.joining(",")) + "]";
    }
    public static String stringifyToStringMap(ToStringMap value)
    {
        Gson gson = new Gson();
        return gson.toJson(value);
    }
}
