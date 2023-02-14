package com.paulmarcelinbejan.architecture.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;

import com.paulmarcelinbejan.validator.algorithm.bfs.ValidatorBFS;
import com.paulmarcelinbejan.validator.algorithm.dfs.ValidatorDFS;
import com.paulmarcelinbejan.validator.config.ValidatorConfig;
import com.paulmarcelinbejan.validator.exception.ValidatorException;import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class AbstractTest {

	/**
	 * assert that two object are equals based on fields of actual,
	 * <br> if expected object have more fields than actual, they will be skipped.
	 * <p>
	 * Example and more configuration can be found at <a href="https://assertj.github.io/doc/#basic-usage">assertj.github.io/doc</a>
	 */
	protected <T> void assertDeepEquals(@NonNull T expected, @NonNull T actual) {
		assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
	}
	
	/**
	 * Create a new instance with random values of the given class using {@link EasyRandom}.
	 */
	protected <T> T buildObject(@NonNull final Class<T> objectClass) {
		return new EasyRandom().nextObject(objectClass);
	}
	
	/**
	 * Create a new instance with random values of the given class using {@link EasyRandom}.
	 * <br> Use {@link EasyRandomParameters} to:
	 * <br> - customize the randomness of values
	 * <br> - exclude fields to be valorized
	 */
	protected <T> T buildObject(@NonNull final Class<T> objectClass, @NonNull EasyRandomParameters easyRandomParameters) {
		return new EasyRandom(easyRandomParameters).nextObject(objectClass);
	}
	
	/**
	 * Validate output object through BFS (Breadth-first search).
	 * <br> A default {@link ValidatorConfig} will be used to validate the object.
	 */
	protected void validateObjectBFS(@NonNull Object root) throws ValidatorException {
		ValidatorConfig defaultValidatorConfig = ValidatorConfig.builder().getDefault().build();
		validateObjectBFS(root, defaultValidatorConfig);
	}
	
	/**
	 * Validate output object through BFS (Breadth-first search)
	 * <br> Use {@link ValidatorConfig} to:
	 * <br> - validate only the first level, or the entire hierarchy.
	 * <br> - exclude Classes to be validated
	 * <br> - choose what is valid and what is not
	 */
	protected void validateObjectBFS(@NonNull Object root, @NonNull ValidatorConfig validatorConfig) throws ValidatorException {
		ValidatorBFS validatorBFS = new ValidatorBFS(validatorConfig);
		validatorBFS.isValid(root);
	}
	
	/**
	 * Validate output object through DFS (Depth-first search)
	 * <br> A default {@link ValidatorConfig} will be used to validate the object.
	 */
	protected void validateObjectDFS(@NonNull Object root) throws ValidatorException {
		ValidatorConfig defaultValidatorConfig = ValidatorConfig.builder().getDefault().build();
		validateObjectDFS(root, defaultValidatorConfig);
	}
	
	/**
	 * Validate output object through DFS (Depth-first search)
	 * <br> Use {@link ValidatorConfig} to:
	 * <br> - validate only the first level, or the entire hierarchy.
	 * <br> - exclude Classes to be validated
	 * <br> - choose what is valid and what is not
	 */
	protected void validateObjectDFS(@NonNull Object root, @NonNull ValidatorConfig validatorConfig) throws ValidatorException {
		ValidatorDFS validatorDFS = new ValidatorDFS(validatorConfig);
		validatorDFS.isValid(root);
	}
	
}
