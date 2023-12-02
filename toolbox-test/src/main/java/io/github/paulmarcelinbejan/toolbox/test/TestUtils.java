package io.github.paulmarcelinbejan.toolbox.test;

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
	
	/**
	 * Create a new instance with random values of the given class using {@link EasyRandom}.
	 */
	public static <T> T buildRandomObject(@NonNull final Class<T> objectClass) {
		return new EasyRandom().nextObject(objectClass);
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
