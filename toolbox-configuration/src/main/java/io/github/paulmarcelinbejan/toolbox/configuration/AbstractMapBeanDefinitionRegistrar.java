package io.github.paulmarcelinbejan.toolbox.configuration;

import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Supplier;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.core.env.Environment;

public abstract class AbstractMapBeanDefinitionRegistrar<Configuration> implements BeanDefinitionRegistryPostProcessor {

	protected AbstractMapBeanDefinitionRegistrar(
			Environment environment, 
			String property,
			Class<Configuration> configurationClass) {
		configurations = Binder.get(environment)
				.bind(property, Bindable.mapOf(String.class, configurationClass))
				.orElseThrow(IllegalStateException::new);
	}

	private final Map<String, Configuration> configurations;

	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		configurations.entrySet().forEach(entry -> registerBeanDefinition(registry, entry));
	}

	private void registerBeanDefinition(BeanDefinitionRegistry registry, Entry<String, Configuration> entry) {
		GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
		beanDefinition.setBeanClass(getBeanClass());
		beanDefinition.setInstanceSupplier(getBeanInstanceSupplier(entry));
		registry.registerBeanDefinition(getBeanName(entry), beanDefinition);
	}

	protected abstract Class<?> getBeanClass();
	
	protected abstract Supplier<?> getBeanInstanceSupplier(Entry<String, Configuration> entry);

	protected abstract String getBeanName(Entry<String, Configuration> entry);

}
