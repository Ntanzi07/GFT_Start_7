package br.com.dio.dto;

import java.time.OffsetDateTime;

public record CardDetailsDTO(
        Long id,
        boolean blocked,
        OffsetDateTime blockedAt,
        String blockReason,
        int blocksAmounth,
        Long columnId,
        String columnName
        ) {
}
