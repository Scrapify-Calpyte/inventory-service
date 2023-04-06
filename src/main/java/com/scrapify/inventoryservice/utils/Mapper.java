package com.scrapify.inventoryservice.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Mapper {

	public static <T> T map(Object object, Class<T> clazz) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			Gson gson = new GsonBuilder().create();
			String json = mapper.writeValueAsString(object);
			return gson.fromJson(json, clazz);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
