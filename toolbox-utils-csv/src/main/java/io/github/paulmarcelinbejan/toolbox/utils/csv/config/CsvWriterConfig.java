package io.github.paulmarcelinbejan.toolbox.utils.csv.config;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerator.Feature;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.csv.CsvFactory;
import com.fasterxml.jackson.dataformat.csv.CsvFactoryBuilder;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvParser;

import io.github.paulmarcelinbejan.toolbox.utils.jackson.ObjectMapperUtils;

import lombok.Builder;
import lombok.Getter;

public class CsvWriterConfig {

	@Builder
	public CsvWriterConfig(
			List<CsvParser.Feature> enableCsvParserFeatures,
			List<CsvParser.Feature> disableCsvParserFeatures,
			List<SerializationFeature> enableSerializationFeatures,
			List<SerializationFeature> disableSerializationFeatures,
			List<Module> modules, 
			Map<Class<?>, JsonSerializer<?>> serializers) {
		
		boolean createCsvFactory = createCsvFactory(enableCsvParserFeatures, disableCsvParserFeatures);
		
		if(createCsvFactory) {
			CsvFactory csvFactory = buildCsvFactory(enableCsvParserFeatures, disableCsvParserFeatures);
			this.csvMapper = buildCsvMapper(csvFactory, enableSerializationFeatures, disableSerializationFeatures, modules, serializers);
		} else {
			this.csvMapper = buildCsvMapper(enableSerializationFeatures, disableSerializationFeatures, modules, serializers);
		}
		
	}
	
	public static final CsvWriterConfig DEFAULT = new CsvWriterConfig(
			Collections.emptyList(), 
			Collections.emptyList(), 
			Collections.emptyList(), 
			Collections.emptyList(), 
			Collections.emptyList(), 
			Collections.emptyMap());
	
	@Getter
	private final CsvMapper csvMapper;
	
	private static CsvMapper buildCsvMapper(
			List<SerializationFeature> enableSerializationFeatures,
			List<SerializationFeature> disableSerializationFeatures,
			List<Module> modules, 
			Map<Class<?>, JsonSerializer<?>> serializers) {
		
		CsvMapper mapper = new CsvMapper();
		mapper.enable(Feature.IGNORE_UNKNOWN);
		
		configureCsvMapper(mapper, enableSerializationFeatures, disableSerializationFeatures, modules, serializers);
		
		return mapper;
	}
	
	private static CsvMapper buildCsvMapper(
			CsvFactory csvFactory,
			List<SerializationFeature> enableSerializationFeatures,
			List<SerializationFeature> disableSerializationFeatures,
			List<Module> modules, 
			Map<Class<?>, JsonSerializer<?>> serializers) {
		CsvMapper mapper = new CsvMapper(csvFactory);
		mapper.enable(Feature.IGNORE_UNKNOWN);
		
		configureCsvMapper(mapper, enableSerializationFeatures, disableSerializationFeatures, modules, serializers);
		
		return mapper;
	}

	private static void configureCsvMapper(CsvMapper mapper,
			List<SerializationFeature> enableSerializationFeatures,
			List<SerializationFeature> disableSerializationFeatures,
			List<Module> modules, 
			Map<Class<?>, JsonSerializer<?>> serializers) {
		
		if(enableSerializationFeatures != null && !enableSerializationFeatures.isEmpty()) {
			ObjectMapperUtils.enableSerializationFeatures(mapper, enableSerializationFeatures);
		}
		
		if(disableSerializationFeatures != null && !disableSerializationFeatures.isEmpty()) {
			ObjectMapperUtils.disableSerializationFeatures(mapper, disableSerializationFeatures);
		}
		
		if(modules != null && !modules.isEmpty()) {
			ObjectMapperUtils.registerModules(mapper, modules);
		}
		
		if(serializers != null && !serializers.isEmpty()) {
			ObjectMapperUtils.registerSerializers(mapper, serializers);
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
