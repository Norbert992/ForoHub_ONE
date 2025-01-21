package com.alura.ForoHub.domain.topic;

import jakarta.validation.constraints.NotNull;

/**
 * Record para representar los datos necesarios para agregar un nuevo topic.
 */
public record DatosAgregarTopic(
        @NotNull String titulo,
        @NotNull String autor,
        @NotNull String mensaje,
        @NotNull Curso curso
) {
}
