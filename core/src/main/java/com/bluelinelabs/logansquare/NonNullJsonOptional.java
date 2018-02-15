package com.bluelinelabs.logansquare;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class NonNullJsonOptional<T> extends JsonOptional<T> {

    @NonNull
    public static <T> NonNullJsonOptional<T> empty() {
        return new NonNullJsonOptional<>(true, null);
    }

    @NonNull
    @SuppressWarnings("NullableProblems")
    public static <T> NonNullJsonOptional<T> value(@NonNull final T value) {
        return new NonNullJsonOptional<>(false, value);
    }

    private NonNullJsonOptional(final boolean empty, @Nullable final T value) {
        super(empty, value);
    }

}
