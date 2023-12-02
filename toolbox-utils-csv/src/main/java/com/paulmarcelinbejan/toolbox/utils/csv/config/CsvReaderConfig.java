package com.paulmarcelinbejan.toolbox.utils.csv.config;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.dataformat.csv.CsvFactory;
import com.fasterxml.jackson.dataformat.csv.CsvFactoryBuilder;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvParser;
import com.paulmarcelinbejan.toolbox.utils.jackson.ObjectMapperUtils;

import lombok.Getter;

public class CsvReaderConfig {

	public CsvReaderConfig(
			List<CsvParser.Feature> enableCsvParserFeatures,
			List<CsvParser.Feature> disableCsvParserFeatures,
			List<DeserializationFeature> enableDeserializationFeatures,
			List<DeserializationFeature> disableDeserializationFeatures,
			List<Module> modules, 
			Map<Class<?>, JsonDeserializer<?>> deserializers) {
		
		boolean createCsvFactory = createCsvFactory(enableCsvParserFeatures, disableCsvParserFeatures);
		
		if(createCsvFactory) {
			CsvFactory csvFactory = buildCsvFactory(enableCsvParserFeatures, disableCsvParserFeatures);
			this.csvMapper = buildCsvMapper(csvFactory, enableDeserializationFeatures, disableDeserializationFeatures, modules, deserializers);
		} else {
			this.csvMapper = buildCsvMapper(enableDeserializationFeatures, disableDeserializationFeatures, modules, deserializers);
		}
		
	}
	
	public static final CsvReaderConfig DEFAULT = new CsvReaderConfig(
			Collections.emptyList(), 
			Collections.emptyList(), 
			Collections.emptyList(), 
			Collections.emptyList(), 
			Collections.emptyList(), 
			Collections.emptyMap());
	
	@Getter
	private final CsvMapper csvMapper;
	
	private static CsvMapper buildCsvMapper(
			List<DeserializationFeature> enableDeserializationFeatures,
			List<DeserializationFeature> disableDeserializationFeatures,
			List<Module> modules, 
			Map<Class<?>, JsonDeserializer<?>> deserializers) {
		CsvMapper mapper = new CsvMapper();
		
		configureCsvMapper(mapper, enableDeserializationFeatures, disableDeserializationFeatures, modules, deserializers);
		
		return mapper;
	}
	
	private static CsvMapper buildCsvMapper(
			CsvFactory csvFactory,
			List<DeserializationFeature> enableDeserializationFeatures,
			List<DeserializationFeature> disableDeserializationFeatures,
			List<Module> modules, 
			Map<Class<?>, JsonDeserializer<?>> deserializers) {
		CsvMapper mapper = new CsvMapper(csvFactory);
		
		configureCsvMapper(mapper, enableDeserializationFeatures, disableDeserializationFeatures, modules, deserializers);
		
		return mapper;
	}

	private static void configureCsvMapper(CsvMapper mapper, 
			List<DeserializationFeature> enableDeserializationFeatures,
			List<DeserializationFeature> disableDeserializationFeatures,
			List<Module> modules, 
			Map<Class<?>, JsonDeserializer<?>> deserializers) {
		
		if(enableDeserializationFeatures != null && !enableDeserializationFeatures.isEmpty()) {
			ObjectMapperUtils.enableDeserializationFeatures(mapper, enableDeserializationFeatures);
		}
		
		if(disableDeserializationFeatures != null && !disableDeserializationFeatures.isEmpty()) {
			ObjectMapperUtils.disableDeserializationFeatures(mapper, disableDeserializationFeatures);
		}
		
		if(modules != null && !modules.isEmpty()) {
			ObjectMapperUtils.registerModules(mapper, modules);
		}
		
		if(deserializers != null && !deserializers.isEmpty()) {
			ObjectMapperUtils.registerDeserializers(mapper, deserializers);
		}
		
	}
	
	private static CsvFactory buildCsvFactory(
			List<CsvParser.Feature> enableCsvParserFeatures,
			List<CsvParser.Feature> disableCsvParserFeatures) {
		
		CsvFactoryBuilder csvFactoryBuilder = CsvFactory.builder();
		
		if(enableCsvParserFeatures != null && !enableCsvParserFeatures.isEmpty()) {
			enableCsvParserFeatures.forEach(csvFactoryBuilder::enable);
		}
		
		if(disableCsvParserFeatures != null && !disableCsvParserFeatures.isEmpty()) {
			disableCsvParserFeatures.forEach(csvFactoryBuilder::disable);
		}
		
		return csvFactoryBuilder.build();
		
	}

	private static boolean createCsvFactory(
			List<CsvParser.Feature> enableCsvParserFeatures,
			List<CsvParser.Feature> disableCsvParserFeatures) {
		if((enableCsvParserFeatures != null && !enableCsvParserFeatures.isEmpty())
				|| (disableCsvParserFeatures != null && !disableCsvParserFeatures.isEmpty())) {
			return true;
		}
		return false;
	}
	
}
