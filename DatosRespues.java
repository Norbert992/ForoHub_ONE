package com.alura.ForoHub.domain.respuesta;

import jakarta.validation.constraints.NotNull;

public record DatosRespuesta(
        @NotNull String mensaje,
        @NotNull String autor
) {
    /**
     * Constructor que crea un objeto DatosRespuesta a partir de una entidad Respuesta.
     *
     * @param respuesta La entidad Respuesta de la cual se extraen los datos.
     */
    public DatosRespuesta(Respuesta respuesta) {
        this(respuesta.getMensaje(), respuesta.getAutor());
    }
}
