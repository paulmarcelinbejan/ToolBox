package io.github.paulmarcelinbejan.toolbox.configuration;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.core.env.Environment;

public abstract class AbstractListBeanDefinitionRegistrar<Configuration> implements BeanDefinitionRegistryPostProcessor {

	protected AbstractListBeanDefinitionRegistrar(
			Environment environment, 
			String property,
			Class<Configuration> configurationClass) {
		configurations = Binder.get(environment)
				.bind(property, Bindable.listOf(configurationClass))
				.orElseThrow(IllegalStateException::new);
	}

	private final List<Configuration> configurations;

	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		configurations.forEach(configuration -> registerBeanDefinition(registry, configuration));
	}

	private void registerBeanDefinition(BeanDefinitionRegistry registry, Configuration configuration) {
		GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
		beanDefinition.setBeanClass(getBeanClass());
		beanDefinition.setInstanceSupplier(getBeanInstanceSupplier(configuration));
		registry.registerBeanDefinition(getBeanName(configuration), beanDefinition);
	}

	protected abstract Class<?> getBeanClass();
	
	protected abstract Supplier<?> getBeanInstanceSupplier(Configuration configuration);

	protected abstract String getBeanName(Configuration configuration);

}
