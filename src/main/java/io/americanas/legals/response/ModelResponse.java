package io.americanas.legals.response;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record ModelResponse(String message, HttpStatus status, LocalDateTime dateStatus, Object data, int counterRegistry) {}

