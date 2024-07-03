package io.github.paulmarcelinbejan.toolbox.utils.validation;

import java.math.BigInteger;
import java.util.List;

import jakarta.validation.ValidationException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class IdValidatorUtils {

	/**
	 * Validates the given ID.
	 *
	 * @param id the ID to validate
	 * @throws ValidationException if the ID is not valid
	 */
	public static void validateIdShort(Short id) {
		validateId(id, (short) 0);
	}

	/**
	 * Validates the given ID.
	 *
	 * @param id the ID to validate
	 * @throws ValidationException if the ID is not valid
	 */
	public static void validateIdInteger(Integer id) {
		validateId(id, 0);
	}

	/**
	 * Validates the given ID.
	 *
	 * @param id the ID to validate
	 * @throws ValidationException if the ID is not valid
	 */
	public static void validateIdLong(Long id) {
		validateId(id, 0L);
	}

	/**
	 * Validates the given ID.
	 *
	 * @param id the ID to validate
	 * @throws ValidationException if the ID is not valid
	 */
	public static void validateIdBigInteger(BigInteger id) {
		validateId(id, BigInteger.ZERO);
	}

	/**
	 * Validates the given IDs.
	 *
	 * @param ids the ID to validate
	 * @throws ValidationException if one of the ID is not valid
	 */
	public static void validateIdsShort(List<Short> ids) {
		validateIds(ids, (short) 0);
	}

	/**
	 * Validates the given IDs.
	 *
	 * @param ids the ID to validate
	 * @throws ValidationException if one of the ID is not valid
	 */
	public static void validateIdsInteger(List<Integer> ids) {
		validateIds(ids, 0);
	}

	/**
	 * Validates the given IDs.
	 *
	 * @param ids the ID to validate
	 * @throws ValidationException if one of the ID is not valid
	 */
	public static void validateIdsLong(List<Long> ids) {
		validateIds(ids, 0L);
	}

	/**
	 * Validates the given IDs.
	 *
	 * @param ids the ID to validate
	 * @throws ValidationException if one of the ID is not valid
	 */
	public static void validateIdsBigInteger(List<BigInteger> ids) {
		validateIds(ids, BigInteger.ZERO);
	}

	private static <ID extends Number & Comparable<? super ID>> void validateId(ID id, ID zero) {
		if (id == null) {
			throw new ValidationException("Id can not be null.");
		}

		if (id.compareTo(zero) <= 0) {
			throw new ValidationException("Id must be greater than 0.");
		}
	}

	private static <ID extends Number & Comparable<? super ID>> void validateIds(List<ID> ids, ID zero) {
		if (ids == null) {
			throw new ValidationException("ids can not be null.");
		}
		for (ID id : ids) {
			validateId(id, zero);
		}
	}

}
