package io.github.paulmarcelinbejan.toolbox.test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;

import io.github.paulmarcelinbejan.toolbox.validathor.bfs.ValidathorBFS;
import io.github.paulmarcelinbejan.toolbox.validathor.dfs.ValidathorDFS;
import io.github.paulmarcelinbejan.toolbox.validathor.exception.ValidathorException;
import io.github.paulmarcelinbejan.toolbox.validathor.registry.ValidathorRegistry;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TestUtils {
	
	private static final EasyRandom EASY_RANDOM = new EasyRandom();

	/**
	 * Create a new instance with random values of the given class using {@link EasyRandom}.
	 */
	public static <T> T buildRandomObject(@NonNull final Class<T> objectClass) {
		return EASY_RANDOM.nextObject(objectClass);
	}
	
	/**
	 * Create a new instance with random values of the given class using {@link EasyRandom}.
	 * <br> Use {@link EasyRandomParameters} to:
	 * <br> - customize the randomness of values
	 * <br> - exclude fields to be valorized
	 */
	public static <T> T buildRandomObject(@NonNull final Class<T> objectClass, @NonNull EasyRandomParameters easyRandomParameters) {
		return new EasyRandom(easyRandomParameters).nextObject(objectClass);
	}
	
	/**
	 * Create a Stream of random values of the given class using {@link EasyRandom}.
	 */
	public static <T> Stream<T> buildRandomStream(@NonNull final Class<T> objectClass, final Integer numberOfElements) {
		return EASY_RANDOM.objects(objectClass, numberOfElements);
	}
	
	/**
	 * Create a Stream of random values of the given class using {@link EasyRandom}.
	 * <br> Use {@link EasyRandomParameters} to:
	 * <br> - customize the randomness of values
	 * <br> - exclude fields to be valorized
	 */
	public static <T> Stream<T> buildRandomStream(@NonNull final Class<T> objectClass, final Integer numberOfElements, @NonNull EasyRandomParameters easyRandomParameters) {
		return new EasyRandom(easyRandomParameters).objects(objectClass, numberOfElements);
	}
	
	/**
	 * Create a List of random values of the given class using {@link EasyRandom}.
	 */
	public static <T> List<T> buildRandomList(@NonNull final Class<T> objectClass, final Integer numberOfElements) {
		return buildRandomStream(objectClass, numberOfElements).collect(Collectors.toList());
	}
	
	/**
	 * Create a List of random values of the given class using {@link EasyRandom}.
	 * <br> Use {@link EasyRandomParameters} to:
	 * <br> - customize the randomness of values
	 * <br> - exclude fields to be valorized
	 */
	public static <T> List<T> buildRandomList(@NonNull final Class<T> objectClass, final Integer numberOfElements, @NonNull EasyRandomParameters easyRandomParameters) {
		return buildRandomStream(objectClass, numberOfElements, easyRandomParameters).collect(Collectors.toList());
	}
	
	/**
	 * Validate output object through BFS (Breadth-first search)
	 * <br> Use {@link ValidathorRegistry} to configure the validation.
	 * @throws ValidathorException 
	 */
	public static void validateObjectBFS(@NonNull Object root, ValidathorRegistry validathorRegistry, boolean collectAllValidationException) throws ValidathorException {
		ValidathorBFS validathorBFS = new ValidathorBFS(validathorRegistry, collectAllValidationException);
		validathorBFS.validate(root);
	}
	
	/**
	 * Validate output object through DFS (Depth-first search)
	 * <br> Use {@link ValidathorRegistry} to configure the validation.
	 * @throws ValidathorException 
	 */
	public static void validateObjectDFS(@NonNull Object root, ValidathorRegistry validathorRegistry, boolean collectAllValidationException) throws ValidathorException {
		ValidathorDFS validathorDFS = new ValidathorDFS(validathorRegistry, collectAllValidationException);
		validathorDFS.validate(root);
	}
	
}
