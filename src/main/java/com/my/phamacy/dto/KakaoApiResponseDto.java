package com.my.phamacy.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class KakaoApiResponseDto {
    @JsonProperty("documents")
    private List<DocumentDto> documentDtoList;

    @JsonProperty("meta")
    private MetaDto metaDto;
}
