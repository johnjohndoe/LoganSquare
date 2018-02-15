package com.bluelinelabs.logansquare;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.Arrays;

public class JsonOptional<T> {

    @NonNull
    public static <T> JsonOptional<T> empty() {
        return new JsonOptional<>(true, null);
    }

    @NonNull
    public static <T> JsonOptional<T> value(@Nullable final T value) {
        return new JsonOptional<>(false, value);
    }

    private final boolean empty;
    @Nullable
    private final T value;

    protected JsonOptional(final boolean empty, @Nullable final T value) {
        this.empty = empty;
        this.value = value;
    }

    @Nullable
    public T get() {
        return value;
    }

    public boolean isEmpty() {
        return empty;
    }

    @Override
    public boolean equals(@Nullable final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        final JsonOptional<?> that = (JsonOptional<?>) object;
        return empty == that.empty
                && value == that.value || (value != null && value.equals(that.value));
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(new Object[]{empty, value});
    }

}
