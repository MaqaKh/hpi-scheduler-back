package com.communitynotes.usecase.ad;

import lombok.RequiredArgsConstructor;
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

    @GetMapping
    public void getAdById(@PathVariable("id") String id) throws IOException {
        adUseCase.fetchAdById(id);
    }
}
