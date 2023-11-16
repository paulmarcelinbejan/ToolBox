package com.paulmarcelinbejan.toolbox.utils.jackson;

import java.util.Map;

import com.fasterxml.jackson.core.util.DefaultIndenter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ObjectMapperUtils {

	@SuppressWarnings("unchecked")
	public static <X> void addSerializers(final SimpleModule module, final Map<Class<?>, JsonSerializer<?>> serializers) {
		serializers.forEach((type, serializer) -> 
				module.addSerializer((Class<? extends X>) type, (JsonSerializer<X>) serializer));
	}

	@SuppressWarnings("unchecked")
	public static <X> void addDeserializers(final SimpleModule module, final Map<Class<?>, JsonDeserializer<?>> deserializers) {
		deserializers.forEach((type, deserializer) -> 
				module.addDeserializer((Class<X>) type, (JsonDeserializer<? extends X>) deserializer));
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
	
	public static <Mapper extends ObjectMapper> void registerJavaTimeModule(Mapper mapper) {
		mapper.registerModule(new JavaTimeModule());
	}
	
	public static ObjectMapper getMapperWithJavaTimeModule() {
		ObjectMapper mapper = new ObjectMapper();
		registerJavaTimeModule(mapper);
		return mapper;
	}
    
    public static ObjectWriter getWriterWithPrettyPrint(ObjectMapper mapper) {
    	ObjectWriter objectWriter = mapper.writer().with(prettyPrinter());
    	return objectWriter;
    }
    
    public static DefaultPrettyPrinter prettyPrinter() {
    	DefaultPrettyPrinter prettyPrinter = new DefaultPrettyPrinter();        
        prettyPrinter.indentArraysWith(DefaultIndenter.SYSTEM_LINEFEED_INSTANCE);
        return prettyPrinter;
    }
	
}
