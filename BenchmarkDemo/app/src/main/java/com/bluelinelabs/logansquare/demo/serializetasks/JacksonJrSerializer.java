package com.bluelinelabs.logansquare.demo.serializetasks;

import com.bluelinelabs.logansquare.demo.model.Response;
import com.fasterxml.jackson.jr.ob.JSON;

public class JacksonJrSerializer extends Serializer {

	public JacksonJrSerializer(SerializeListener parseListener, Response response) {
		super(parseListener, response);
	}

	@Override
	protected String serialize(Response response) {
		try {
			return JSON.std.asString(response);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			System.gc();
		}
	}
}
