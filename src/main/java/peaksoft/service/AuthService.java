package peaksoft.service;

import peaksoft.dto.request.AuthRequest;
import peaksoft.dto.response.AuthResponse;

public interface AuthService {
    AuthResponse authenticate(AuthRequest authRequest);
}
