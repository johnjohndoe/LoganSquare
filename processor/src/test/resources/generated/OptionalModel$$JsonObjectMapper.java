package com.bluelinelabs.logansquare.processor.model;

import com.bluelinelabs.logansquare.JsonMapper;
import com.bluelinelabs.logansquare.NonNullOptionalField;
import com.bluelinelabs.logansquare.OptionalField;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.lang.Boolean;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

@SuppressWarnings({"unsafe", "unchecked"})
public final class OptionalModel$$JsonObjectMapper extends JsonMapper<OptionalModel> {
  @Override
  public OptionalModel parse(JsonParser jsonParser) throws IOException {
    OptionalModel instance = new OptionalModel();
    if (jsonParser.getCurrentToken() == null) {
      jsonParser.nextToken();
    }
    if (jsonParser.getCurrentToken() != JsonToken.START_OBJECT) {
      jsonParser.skipChildren();
      return null;
    }
    while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
      String fieldName = jsonParser.getCurrentName();
      jsonParser.nextToken();
      parseField(instance, fieldName, jsonParser);
      jsonParser.skipChildren();
    }
    return instance;
  }

  @Override
  public void parseField(OptionalModel instance, String fieldName, JsonParser jsonParser) throws IOException {
    if ("nonNullOptionalField".equals(fieldName)) {
      final Boolean value;
      value = jsonParser.getCurrentToken() == JsonToken.VALUE_NULL ? null : Boolean.valueOf(jsonParser.getValueAsBoolean());
      instance.nonNullOptionalField = NonNullOptionalField.value(value);
    } else if ("optionalField".equals(fieldName)) {
      final Boolean value;
      value = jsonParser.getCurrentToken() == JsonToken.VALUE_NULL ? null : Boolean.valueOf(jsonParser.getValueAsBoolean());
      instance.optionalField = OptionalField.value(value);
    } else if ("simpleField".equals(fieldName)) {
      instance.simpleField = jsonParser.getValueAsBoolean();
    }
  }

  @Override
  public void serialize(OptionalModel object, JsonGenerator jsonGenerator, boolean writeStartAndEnd) throws IOException {
    if (writeStartAndEnd) {
      jsonGenerator.writeStartObject();
    }
    if (object.nonNullOptionalField != null && !object.nonNullOptionalField.isEmpty()) {
      jsonGenerator.writeFieldName("nonNullOptionalField");
      if (object.nonNullOptionalField.getValue() != null) {
        jsonGenerator.writeBoolean(object.nonNullOptionalField.getValue());
      } else {
        jsonGenerator.writeNull();
      }
    }
    if (object.optionalField != null && !object.optionalField.isEmpty()) {
      jsonGenerator.writeFieldName("optionalField");
      if (object.optionalField.getValue() != null) {
        jsonGenerator.writeBoolean(object.optionalField.getValue());
      } else {
        jsonGenerator.writeNull();
      }
    }
    jsonGenerator.writeBooleanField("simpleField", object.simpleField);
    if (writeStartAndEnd) {
      jsonGenerator.writeEndObject();
    }
  }
}
