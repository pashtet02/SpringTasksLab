package com.example.library.registration.token;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ConfirmationTokenServiceImpl implements ConfirmationTokenService {
    private final ConfirmationTokenRepository tokenRepository;

    @Override
    public void saveConfirmationToken(ConfirmationToken token){
        tokenRepository.save(token);
    }

    @Override
    public int setConfirmedAt(String token) {
        return tokenRepository.updateConfirmedAt(
                token, LocalDateTime.now());
    }

    @Override
    public Optional<ConfirmationToken> getToken(String token) {
        return tokenRepository.findByToken(token);
    }
}
