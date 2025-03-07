package org.embulk.input.facebook_ads_insights.unit;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.google.common.base.Function;
import com.google.common.collect.Maps;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

// https://github.com/embulk/embulk/blob/v0.9.17/embulk-core/src/main/java/org/embulk/spi/unit/ToStringMap.java
public class ToStringMap extends HashMap<String, String> {
    @JsonCreator
    public ToStringMap(Map<String, ToString> map) {
        super(Maps.transformValues(map, new Function<ToString, String>() {
            public String apply(ToString value) {
                if (value == null) {
                    return "null";
                } else {
                    return value.toString();
                }
            }
        }));
    }

    public Properties toProperties() {
        Properties props = new Properties();
        props.putAll(this);
        return props;
    }
}