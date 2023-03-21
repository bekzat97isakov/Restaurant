package peaksoft.dto.request;

import lombok.Builder;

@Builder
public record AuthRequest(
        String email,
        String password
) {
}
