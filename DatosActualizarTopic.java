package com.alura.ForoHub.domain.topic;

import jakarta.validation.constraints.NotNull;

/**
 * Record para representar los datos necesarios para actualizar un topic.
 */
public record DatosActualizarTopic(
        @NotNull String titulo,
        @NotNull String autor,
        @NotNull String mensaje,
        @NotNull Curso curso,
        @NotNull String status
) {
}
