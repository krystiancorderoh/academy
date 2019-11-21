package com.softtek.academy.jpa.util.serializer;

public final class DataViews {

    /**
     * Entity properties marked as @JsonView(DataViews.Basic.class) means Jackson will only serialized/deserialized them
     * if Basic information of such Entity is required
     */
    public interface Basic {
    }

    /**
     * Entity properties marked as @JsonView(DataViews.Basic.class) means Jackson will only serialized/deserialized them
     * if Full information of such Entity is required, Basic one is included
     */
    public interface Full extends Basic {
    }

}
