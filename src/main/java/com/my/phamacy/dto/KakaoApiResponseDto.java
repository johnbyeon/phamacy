package com.my.phamacy.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class KakaoApiResponseDto {
    @JsonProperty("documents")
    private List<DocumentDto> documentDtoList;

    @JsonProperty("meta")
    private MetaDto metaDto;
}
