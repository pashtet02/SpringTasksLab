package com.example.library.registration.token;

import java.util.Optional;

public interface ConfirmationTokenService {
    void saveConfirmationToken(ConfirmationToken token);

    int setConfirmedAt(String token);

    Optional<ConfirmationToken> getToken(String token);
}
