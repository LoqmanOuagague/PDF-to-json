package org.example;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

public class CircularReferenceExclusionStrategy implements ExclusionStrategy {
    @Override
    public boolean shouldSkipField(FieldAttributes fieldAttributes) {
        // Skip parent field and other transient fields to break circular references
        return fieldAttributes.getName().equals("parent") ||
                fieldAttributes.getName().equals("isHeader") ||
                fieldAttributes.getName().equals("headerSize") ||
                fieldAttributes.getName().equals("isRootTag") ||
                fieldAttributes.getName().equals("largestHeader") ||
                fieldAttributes.getName().equals("dropTagList") ||
                fieldAttributes.getName().equals("inList") ||
                fieldAttributes.getName().equals("rootHeader");
    }

    @Override
    public boolean shouldSkipClass(Class<?> aClass) {
        return false;
    }
}
