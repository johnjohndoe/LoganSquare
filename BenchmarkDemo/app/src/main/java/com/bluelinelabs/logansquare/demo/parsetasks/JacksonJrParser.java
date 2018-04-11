package com.bluelinelabs.logansquare.demo.parsetasks;

import com.bluelinelabs.logansquare.demo.model.User;
import com.fasterxml.jackson.jr.ob.JSON;

import java.util.List;
import java.util.Map;

public class JacksonJrParser extends Parser {

	public JacksonJrParser(ParseListener parseListener, String jsonString) {
		super(parseListener, jsonString);
	}

	@Override
	protected int parse(String json) {
		try {
			Map<String, Object> map = JSON.std.mapFrom(json);
			List<User> users = (List<User>) map.get("users");
			return users.size();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			System.gc();
		}
	}

}
