package com.bluelinelabs.logansquare.processor.model;

import com.bluelinelabs.logansquare.OptionalField;
import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

@JsonObject(serializeNullObjects = true)
public class OptionalModel {

    @JsonField(name = "testField")
    public OptionalField<Boolean> testField;

}
