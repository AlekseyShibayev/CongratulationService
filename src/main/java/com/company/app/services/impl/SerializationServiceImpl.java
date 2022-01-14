package com.company.app.services.impl;

import com.company.app.services.api.SerializationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.*;

@Component
public class SerializationServiceImpl<T> implements SerializationService<T> {

	@Override
	public boolean save(List<T> list, String fileName) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(new File(fileName), list.toArray());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<T> load(String fileName, Class<T[]> type) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			T[] array = mapper.readValue(new File(fileName), type);
			return Arrays.asList(array);
		} catch (Exception e) {
			return new ArrayList<>();
		}
	}
}
