package com.alura.ForoHub.domain.usuario;

import jakarta.validation.constraints.NotNull;

/**
 * Record para representar los datos necesarios para validar un usuario.
 */
public record DatosValidarUsuario(
        @NotNull String user,
        @NotNull String pass
) {
}
