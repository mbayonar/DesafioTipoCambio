package com.tcs.marcosbr.servicio;

import com.tcs.marcosbr.excepcion.EntidadDuplicadaExcepcion;
import com.tcs.marcosbr.util.RespuestaControlador;
import java.util.List;

/**
 *
 * @author MARCOS BAYONA
 * @param <Entidad>
 * @param <TipoLlave>
 */
public interface BaseServicio<Entidad, TipoLlave> {

    Entidad obtener(TipoLlave id);

    void grabarTodos(List<Entidad> list) throws EntidadDuplicadaExcepcion;

    List<Entidad> obtenerTodos();

    public RespuestaControlador crear(Entidad entidad) throws EntidadDuplicadaExcepcion;

    public RespuestaControlador actualizar(Entidad entidad) throws EntidadDuplicadaExcepcion;

    public RespuestaControlador eliminar(TipoLlave entidadId);

}
