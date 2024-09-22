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

/**
 * Abstract base class for registering a list of bean definitions from a configuration
 * class. This class implements {@link BeanDefinitionRegistryPostProcessor} and processes
 * a list of configurations to register bean definitions in the {@link BeanDefinitionRegistry}.
 * 
 * @param <Configuration> The type of configuration objects used to define beans.
 */
public abstract class AbstractListBeanDefinitionRegistrar<Configuration> implements BeanDefinitionRegistryPostProcessor {

	/**
     * Constructor to initialize the {@code AbstractListBeanDefinitionRegistrar} with
     * the environment, a property name, and the class type of the configuration.
     * The configurations are bound from the environment using the given property.
     * 
     * @param environment the {@link Environment} from which properties are retrieved.
     * @param property the property name that contains the configuration list.
     * @param configurationClass the class type of the configuration to be bound.
     * @throws IllegalStateException if the configurations cannot be bound from the environment.
     */
	protected AbstractListBeanDefinitionRegistrar(
			Environment environment, 
			String property,
			Class<Configuration> configurationClass) {
		configurations = Binder.get(environment)
				.bind(property, Bindable.listOf(configurationClass))
				.orElseThrow(IllegalStateException::new);
	}

	/**
     * List of configuration objects used to define and register beans.
     */
	private final List<Configuration> configurations;


	/**
     * Processes the {@link BeanDefinitionRegistry} to register bean definitions
     * for each configuration in the list of configurations.
     * 
     * @param registry the {@link BeanDefinitionRegistry} to register the beans with.
     * @throws BeansException if an error occurs during bean definition registration.
     */
	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		configurations.forEach(configuration -> registerBeanDefinition(registry, configuration));
	}

	/**
     * Registers a single bean definition in the provided {@link BeanDefinitionRegistry}
     * based on the given configuration object.
     * 
     * @param registry the registry where the bean definition should be registered.
     * @param configuration the configuration object used to create the bean definition.
     */
	private void registerBeanDefinition(BeanDefinitionRegistry registry, Configuration configuration) {
		GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
		beanDefinition.setBeanClass(getBeanClass());
		beanDefinition.setInstanceSupplier(getBeanInstanceSupplier(configuration));
		registry.registerBeanDefinition(getBeanName(configuration), beanDefinition);
	}

	/**
	 * Returns the class type of the bean to be instantiated. This method specifies
	 * the class that will be used as the blueprint for creating the bean instance
	 * during the registration process. Subclasses must provide the specific class
	 * that defines the bean's structure and behavior.
	 * 
	 * @return the {@code Class} of the bean to be instantiated.
	 */
	protected abstract Class<?> getBeanClass();
	
	/**
	 * Returns a {@code Supplier} that is used to create an instance of the bean based on
	 * the provided configuration object that defines the bean.
	 * 
	 * @param configuration the configuration object
	 * @return a {@code Supplier} that provides the bean instance.
	 */
	protected abstract Supplier<?> getBeanInstanceSupplier(Configuration configuration);

	/**
	 * Returns the name to apply to the bean based on the provided map entry. The key of
	 * the entry typically represents the desired bean name, and the value contains the
	 * configuration object.
	 * 
	 * @param configuration the configuration object
	 * @return the name to assign to the bean in the {@link BeanDefinitionRegistry}.
	 */
	protected abstract String getBeanName(Configuration configuration);

}
