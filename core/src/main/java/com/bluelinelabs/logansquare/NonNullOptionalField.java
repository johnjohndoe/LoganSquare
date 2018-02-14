package com.bluelinelabs.logansquare;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class NonNullOptionalField<T> extends OptionalField<T> {

    @NonNull
    public static <T> NonNullOptionalField<T> empty() {
        return new NonNullOptionalField<>(true, null);
    }

    @NonNull
    @SuppressWarnings("NullableProblems")
    public static <T> NonNullOptionalField<T> value(@NonNull final T value) {
        return new NonNullOptionalField<>(false, value);
    }

    private NonNullOptionalField(final boolean empty, @Nullable final T value) {
        super(empty, value);
    }

}
