package com.tcs.marcosbr.servicio;

import com.tcs.marcosbr.entidad.TipoCambio;
import java.util.Map;

/**
 *
 * @author Marcos
 */
public interface TipoCambioServicio extends BaseServicio<TipoCambio, Long> {

    public TipoCambio obtenerTipoCambioDeMoneda(Long monedaId);

    public Map<String, Object> procesarTipoDeCambio(Double monto, Long monedaOrigenId, Long monedaDestinoId);

}
