package com.spring.service;

import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.json.JsonSanitizer;
import com.spring.entity.DataRecord;

@Service
public class JsonProcessingService {
	
	private static final Logger log = LoggerFactory.getLogger(JsonProcessingService.class);

	private final ObjectMapper mapper;

	public JsonProcessingService(ObjectMapper mapper) {
		super();
		this.mapper = mapper;
	}
	
	public DataRecord processDirtyJson(String dirtyJson) throws Exception{
		//String cleanJson = JsonSanitizer.sanitize(dirtyJson);
		
		//log.info(String.format("After cleaning json object %s", cleanJson));
		
		//return mapper.readValue(cleanJson, DataRecord.class);
		
		DataRecord record = mapper.readValue(dirtyJson, DataRecord.class);
		record.sanitizeId();
		return record;
		
		
	}
}
