package com.bluelinelabs.logansquare;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class OptionalField<T> {

    @NonNull
    public static <T> OptionalField<T> empty() {
        return new OptionalField<>(true, null);
    }

    @NonNull
    public static <T> OptionalField<T> value(@Nullable final T value) {
        return new OptionalField<>(false, value);
    }

    private final boolean empty;
    @Nullable
    private final T value;

    protected OptionalField(final boolean empty, @Nullable final T value) {
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
