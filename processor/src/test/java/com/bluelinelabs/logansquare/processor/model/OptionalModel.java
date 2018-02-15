package com.bluelinelabs.logansquare.processor.model;

import com.bluelinelabs.logansquare.JsonOptional;
import com.bluelinelabs.logansquare.NonNullJsonOptional;
import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

@JsonObject(serializeNullObjects = true)
public class OptionalModel {

    @JsonField(name = "simpleField")
    public boolean simpleField;

    @JsonField(name = "nonNullJsonOptional")
    public NonNullJsonOptional<Boolean> nonNullJsonOptional;

    @JsonField(name = "jsonOptional")
    public JsonOptional<Boolean> jsonOptional;

}
