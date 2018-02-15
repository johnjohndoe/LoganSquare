package com.bluelinelabs.logansquare.processor.model;

import com.bluelinelabs.logansquare.JsonMapper;
import com.bluelinelabs.logansquare.JsonOptional;
import com.bluelinelabs.logansquare.NonNullJsonOptional;
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
  public void parseField(OptionalModel instance, String fieldName, JsonParser jsonParser) throws
          IOException {
    if ("jsonOptional".equals(fieldName)) {
      final Boolean value;
      value = jsonParser.getCurrentToken() == JsonToken.VALUE_NULL ? null : Boolean.valueOf(jsonParser.getValueAsBoolean());
      instance.jsonOptional = JsonOptional.value(value);
    } else if ("nonNullJsonOptional".equals(fieldName)) {
      final Boolean value;
      value = jsonParser.getCurrentToken() == JsonToken.VALUE_NULL ? null : Boolean.valueOf(jsonParser.getValueAsBoolean());
      instance.nonNullJsonOptional = NonNullJsonOptional.value(value);
    } else if ("simpleField".equals(fieldName)) {
      instance.simpleField = jsonParser.getValueAsBoolean();
    }
  }

  @Override
  public void serialize(OptionalModel object, JsonGenerator jsonGenerator, boolean writeStartAndEnd)
          throws IOException {
    if (writeStartAndEnd) {
      jsonGenerator.writeStartObject();
    }
    if (object.jsonOptional != null && !object.jsonOptional.isEmpty()) {
      jsonGenerator.writeFieldName("jsonOptional");
      if (object.jsonOptional.get() != null) {
        jsonGenerator.writeBoolean(object.jsonOptional.get());
      } else {
        jsonGenerator.writeNull();
      }
    }
    if (object.nonNullJsonOptional != null && !object.nonNullJsonOptional.isEmpty()) {
      jsonGenerator.writeFieldName("nonNullJsonOptional");
      if (object.nonNullJsonOptional.get() != null) {
        jsonGenerator.writeBoolean(object.nonNullJsonOptional.get());
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
