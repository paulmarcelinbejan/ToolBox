package io.github.paulmarcelinbejan.toolbox.utils.jackson;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.util.DefaultIndenter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ObjectMapperUtils {

	@SuppressWarnings("unchecked")
	public static <T> void addSerializers(final SimpleModule module, final Map<Class<?>, JsonSerializer<?>> serializers) {
		serializers.forEach((type, serializer) -> 
				module.addSerializer((Class<? extends T>) type, (JsonSerializer<T>) serializer));
	}

	@SuppressWarnings("unchecked")
	public static <T> void addDeserializers(final SimpleModule module, final Map<Class<?>, JsonDeserializer<?>> deserializers) {
		deserializers.forEach((type, deserializer) -> 
				module.addDeserializer((Class<T>) type, (JsonDeserializer<? extends T>) deserializer));
	}
	
	public static <Mapper extends ObjectMapper> void registerSerializers(Mapper mapper, Map<Class<?>, JsonSerializer<?>> serializers) {
		SimpleModule module = new SimpleModule();
		addSerializers(module, serializers);
		mapper.registerModule(module);
	}
	
	public static <Mapper extends ObjectMapper> void registerDeserializers(Mapper mapper, Map<Class<?>, JsonDeserializer<?>> deserializers) {
		SimpleModule module = new SimpleModule();
		addDeserializers(module, deserializers);
		mapper.registerModule(module);
	}
	
	public static <Mapper extends ObjectMapper> void registerModule(Mapper mapper, Module module) {
		mapper.registerModule(module);
	}
	
	public static <Mapper extends ObjectMapper> void registerModules(Mapper mapper, List<Module> modules) {
		modules.forEach(module -> registerModule(mapper, module));
	}
	
	public static <Mapper extends ObjectMapper> void registerJavaTimeModule(Mapper mapper) {
		registerModule(mapper, new JavaTimeModule());
	}
	
	public static <Mapper extends ObjectMapper> void enableDeserializationFeature(Mapper mapper, DeserializationFeature feature) {
		mapper.enable(feature);
	}
	
	public static <Mapper extends ObjectMapper> void enableDeserializationFeatures(Mapper mapper, List<DeserializationFeature> features) {
		features.forEach(feature -> enableDeserializationFeature(mapper, feature));
	}
	
	public static <Mapper extends ObjectMapper> void disableDeserializationFeature(Mapper mapper, DeserializationFeature feature) {
		mapper.disable(feature);
	}
	
	public static <Mapper extends ObjectMapper> void disableDeserializationFeatures(Mapper mapper, List<DeserializationFeature> features) {
		features.forEach(feature -> disableDeserializationFeature(mapper, feature));
	}
	
	public static <Mapper extends ObjectMapper> void enableSerializationFeature(Mapper mapper, SerializationFeature feature) {
		mapper.enable(feature);
	}
	
	public static <Mapper extends ObjectMapper> void enableSerializationFeatures(Mapper mapper, List<SerializationFeature> features) {
		features.forEach(feature -> enableSerializationFeature(mapper, feature));
	}
	
	public static <Mapper extends ObjectMapper> void disableSerializationFeature(Mapper mapper, SerializationFeature feature) {
		mapper.disable(feature);
	}
	
	public static <Mapper extends ObjectMapper> void disableSerializationFeatures(Mapper mapper, List<SerializationFeature> features) {
		features.forEach(feature -> disableSerializationFeature(mapper, feature));
	}
    
    public static ObjectWriter getWriterWithPrettyPrinter(ObjectMapper mapper) {
		return mapper.writer().with(prettyPrinter());
    }
    
    public static DefaultPrettyPrinter prettyPrinter() {
    	DefaultPrettyPrinter prettyPrinter = new DefaultPrettyPrinter();        
        prettyPrinter.indentArraysWith(DefaultIndenter.SYSTEM_LINEFEED_INSTANCE);
        return prettyPrinter;
    }
	
}
