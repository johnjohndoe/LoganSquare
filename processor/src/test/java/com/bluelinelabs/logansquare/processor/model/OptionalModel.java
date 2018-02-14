package com.bluelinelabs.logansquare.processor.model;

import com.bluelinelabs.logansquare.NonNullOptionalField;
import com.bluelinelabs.logansquare.OptionalField;
import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

@JsonObject(serializeNullObjects = true)
public class OptionalModel {

    @JsonField(name = "simpleField")
    public boolean simpleField;

    @JsonField(name = "nonNullOptionalField")
    public NonNullOptionalField<Boolean> nonNullOptionalField;

    @JsonField(name = "optionalField")
    public OptionalField<Boolean> optionalField;

}
