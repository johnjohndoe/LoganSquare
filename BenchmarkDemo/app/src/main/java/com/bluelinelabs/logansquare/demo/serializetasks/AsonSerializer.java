package com.bluelinelabs.logansquare.demo.serializetasks;

import com.afollestad.ason.Ason;
import com.bluelinelabs.logansquare.demo.model.Response;
import com.squareup.moshi.Moshi;

public class AsonSerializer extends Serializer {

    public AsonSerializer(SerializeListener parseListener, Response response) {
        super(parseListener, response);
    }

    @Override
    protected String serialize(Response response) {
        try {
            return Ason.serialize(response).toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
           System.gc();
        }
    }

}
