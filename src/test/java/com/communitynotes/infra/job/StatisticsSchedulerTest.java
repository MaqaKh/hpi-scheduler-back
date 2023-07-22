package com.communitynotes.infra.job;

import com.communitynotes.domain.childdisctrict.ChildDistrictRepository;
import com.communitynotes.domain.childdisctrict.DistrictInfo;
import com.communitynotes.domain.statistics.Statistics;
import com.communitynotes.domain.statistics.StatisticsRepository;
import com.communitynotes.infra.scrapper.Scrapper;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@Disabled
public class StatisticsSchedulerTest {

    @InjectMocks
    private StatisticsScheduler scheduler;

    @Mock
    private ChildDistrictRepository childDistrictRepository;

    @Mock
    private Scrapper scrapper;

    @Mock
    private StatisticsRepository statisticsRepository;

    @Test
    @DirtiesContext
    public void testRunStatisticsFor1RoomApartments() throws IOException {
        // Mock the child district data
        List<DistrictInfo> mockDistricts = Arrays.asList(
                new DistrictInfo(1, "ChildDistrict1","mainDistrict1", 1),
                new DistrictInfo(2, "ChildDistrict2","mainDistrict2", 2)
                // Add more mock district data as needed
        );
        when(childDistrictRepository.findAllDistrictsWithParentName()).thenReturn(mockDistricts);

        // Mock the result of the scrapper
        List<Double> mockScrapperResult = Arrays.asList(1000.0, 2000.0, 3000.0);
        when(scrapper.findPrices(anyString(), anyString(), anyString(), anyString(), anyString()))
                .thenReturn(mockScrapperResult);

        // Run the scheduler method
        scheduler.runStatisticsFor1RoomApartments();

        // Verify that the statistics were saved correctly
        ArgumentCaptor<List<Statistics>> statisticsCaptor = ArgumentCaptor.forClass(List.class);
        verify(statisticsRepository).saveAll(statisticsCaptor.capture());

        List<Statistics> savedStatistics = statisticsCaptor.getValue();
        // Assert the expected statistics based on the mocked data
        // Add your own assertions here

        // Optionally, you can also verify if certain methods were called
        verify(childDistrictRepository).findAllDistrictsWithParentName();
        verify(scrapper, times(mockDistricts.size())).findPrices(anyString(), anyString(), anyString(), anyString(), anyString());
    }

}