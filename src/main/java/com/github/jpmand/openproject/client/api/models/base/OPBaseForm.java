package com.github.jpmand.openproject.client.api.models.base;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class OPBaseForm extends OPBaseResource {

    @JsonProperty("_embedded")
    private Map<String, Object> embedded;
}
