package com.my.phamacy.controller;

import com.my.phamacy.dto.DocumentDto;
import com.my.phamacy.dto.InputDto;
import com.my.phamacy.dto.KakaoApiResponseDto;
import com.my.phamacy.dto.OutputDto;
import com.my.phamacy.service.KakaoAddressSearchService;
import com.my.phamacy.service.KakaoCategorySearchService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Indexed;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class FormController {
    public FormController(KakaoAddressSearchService kakaoAddressSearchService, KakaoCategorySearchService kakaoCategorySearchService) {
        this.kakaoAddressSearchService = kakaoAddressSearchService;
        this.kakaoCategorySearchService = kakaoCategorySearchService;
    }

    private final KakaoAddressSearchService kakaoAddressSearchService;
    private final KakaoCategorySearchService kakaoCategorySearchService;

    @GetMapping("/")
    public String mainForm() {
        return "main";
    }

    @GetMapping("/output")
    public String output() {
        return "output";
    }

    @PostMapping("/search")
    public String searchAddress(InputDto dto, Model model) {
        KakaoApiResponseDto kakaoApiResponseDto = kakaoAddressSearchService
                .requestAddressSearch(dto.getAddress());
        DocumentDto documentDto = kakaoApiResponseDto.getDocumentDtoList().get(0);

        double radius = 1000D;

        KakaoApiResponseDto responseDto =
                kakaoCategorySearchService.resultCategorySearch(
                        documentDto.getLatitude(),
                        documentDto.getLongitude(),
                        radius);


        List<OutputDto> outputDtoList = kakaoCategorySearchService.makeOutputDto(responseDto.getDocumentDtoList());
        System.out.println(outputDtoList);
        model.addAttribute("outputList",outputDtoList);
        return "output";
    }

}
