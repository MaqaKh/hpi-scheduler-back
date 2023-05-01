package com.communitynotes;

import java.io.IOException;

public interface Statistics{
    double averagePricePerSquareOf1room() throws IOException;
    Double highestPricePerSquareOf1room() throws IOException;
    Double lowestPricePerSquareOf1room() throws IOException;
}
