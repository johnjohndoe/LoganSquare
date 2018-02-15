package com.bluelinelabs.logansquare;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

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
    public T getValue() {
        return value;
    }

    public boolean isEmpty() {
        return empty;
    }

}
