package com.tcs.marcosbr.controlador;

import com.tcs.marcosbr.util.RespuestaControlador;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author MARCOS BAYONA
 * @param <Entidad>
 * @param <TipoLlave>
 */
public interface BaseControlador<Entidad, TipoLlave> {

    public ResponseEntity<RespuestaControlador> crear(Entidad entidad);

    public ResponseEntity<RespuestaControlador> obtener(TipoLlave id);

    public ResponseEntity<RespuestaControlador> actualizar(Entidad entidad);

    public ResponseEntity<RespuestaControlador> eliminar(TipoLlave entidadId);

    public ResponseEntity<RespuestaControlador> obtenerTodos();

}
