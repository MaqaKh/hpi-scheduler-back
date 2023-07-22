package com.communitynotes.usecase.ad;

import com.communitynotes.infra.scrapper.Scrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class AdUseCase {
    private final Scrapper scrapper;

    public void fetchAdById(String id) throws IOException {
        scrapper.findSingleApartment(id); //"3586033"
    }
}
