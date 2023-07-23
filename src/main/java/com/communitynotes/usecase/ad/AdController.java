package com.communitynotes.usecase.ad;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController()
@RequestMapping("/ad")
@RequiredArgsConstructor
public class AdController {
    private final AdUseCase adUseCase;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public AdResponse getAdById(@PathVariable("id") String id) throws IOException {
        return adUseCase.fetchAdById(id);
    }
}
