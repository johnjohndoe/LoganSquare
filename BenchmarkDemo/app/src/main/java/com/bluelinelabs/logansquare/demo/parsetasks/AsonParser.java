package com.bluelinelabs.logansquare.demo.parsetasks;

import com.afollestad.ason.Ason;
import com.bluelinelabs.logansquare.demo.model.Response;

public class AsonParser extends Parser {

	public AsonParser(Parser.ParseListener parseListener, String jsonString) {
		super(parseListener, jsonString);
	}

	@Override
	protected int parse(String json) {
		try {
			// FIXME: Allocating a new instance is expensive
			return new Ason(json).deserialize(Response.class).users.size();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			System.gc();
		}
	}

}
