package org.hibernate.internal.util;

import java.util.Arrays;

/**
 * Analog of JDK7 java.util.Objects
 *
 * @author Nikolay Shestakov
 */
public class Objects {

	/**
	 * Returns the hash code of a non-{@code null} argument and 0 for
	 * a {@code null} argument.
	 *
	 * @param o an object
	 * @return the hash code of a non-{@code null} argument and 0 for
	 * a {@code null} argument
	 * @see Object#hashCode
	 */
	public static int hashCode(Object o) {
		return o != null ? o.hashCode() : 0;
	}

	/**
	 * Generates a hash code for a sequence of input values. The hash
	 * code is generated as if all the input values were placed into an
	 * array, and that array were hashed by calling {@link
	 * java.util.Arrays#hashCode(Object[])}.
	 *
	 * <p>This method is useful for implementing {@link
	 * Object#hashCode()} on objects containing multiple fields. For
	 * example, if an object that has three fields, {@code x}, {@code
	 * y}, and {@code z}, one could write:
	 *
	 * <blockquote><pre>
	 * &#064;Override public int hashCode() {
	 *     return Objects.hash(x, y, z);
	 * }
	 * </pre></blockquote>
	 *
	 * <b>Warning: When a single object reference is supplied, the returned
	 * value does not equal the hash code of that object reference.</b> This
	 * value can be computed by calling {@link #hashCode(Object)}.
	 *
	 * @param values the values to be hashed
	 * @return a hash value of the sequence of input values
	 * @see java.util.Arrays#hashCode(Object[])
	 * @see java.util.List#hashCode
	 */
	public static int hash(Object... values) {
		return Arrays.hashCode( values );
	}

	/**
	 * Perfomance optimization version of {@link #hash(Object...)}
	 *
	 * @param values  the values to be hashed
	 * @return  a hash value of the sequence of input values
	 */
	public static int hash(byte[] values) {
		if ( null == values ) {
			return 0;
		}
		int hashCode = 1;
		for ( byte aByte : values ) {
			hashCode = 31 * hashCode + aByte;
		}
		return hashCode;
	}

	/**
	 * Perfomance optimization version of {@link #hash(Object...)}
	 *
	 * @param values  the values to be hashed
	 * @return  a hash value of the sequence of input values
	 */
	public static int hash(char[] values) {
		if ( null == values ) {
			return 0;
		}
		int hashCode = 1;
		for ( char aByte : values ) {
			hashCode = 31 * hashCode + aByte;
		}
		return hashCode;
	}
}
