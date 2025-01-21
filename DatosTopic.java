package com.alura.ForoHub.domain.topic;

/**
 * Record para representar los datos de un topic.
 */
public record DatosTopic(
        Long id,
        String autor,
        String titulo,
        String mensaje,
        Curso curso,
        String fechaCreacion,
        Integer cantidadRespuestas,
        String estado
) {

    /**
     * Constructor que crea un objeto DatosTopic a partir de una entidad Topico.
     *
     * @param topico La entidad Topico de la cual se extraen los datos.
     */
    public DatosTopic(Topico topico) {
        this(topico.getId(), topico.getAutor(), topico.getTitulo(),
                topico.getMensaje(), topico.getCurso(), topico.getFechaCreacion().toString(),
                topico.getRespuestas(), topico.getStatus()
        );
    }
}
