package com.my.phamacy.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;

@Getter
public class MetaDto {
    @JsonProperty("total_count")
    private Integer totalCount;
}
