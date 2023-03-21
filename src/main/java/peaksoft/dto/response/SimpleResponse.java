package peaksoft.dto.response;

import org.springframework.http.HttpStatus;

public record SimpleResponse(
        HttpStatus status,
        String massage
) {
}
