package com.ppz.web.utils;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

/**
 * PpzExclusionStrategy class.
 */
public class PpzExclusionStrategy implements ExclusionStrategy {

	@Override
	public boolean shouldSkipField(final FieldAttributes f) {
		return f.getAnnotation(Exclude.class) != null;
	}

	@Override
	public boolean shouldSkipClass(final Class<?> clazz) {
		return false;
	}

}
