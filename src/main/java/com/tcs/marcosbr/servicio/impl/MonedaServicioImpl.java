package com.tcs.marcosbr.servicio.impl;

import com.tcs.marcosbr.entidad.Moneda;
import com.tcs.marcosbr.enums.NombreEntidadEnum;
import com.tcs.marcosbr.excepcion.EntidadDuplicadaExcepcion;
import com.tcs.marcosbr.repositorio.MonedaRepositorio;
import com.tcs.marcosbr.servicio.MonedaServicio;
import com.tcs.marcosbr.util.RespuestaControlador;
import com.tcs.marcosbr.util.RespuestaControladorServicio;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MonedaServicioImpl extends BaseServicioImpl<Moneda, Long> implements MonedaServicio {

    private final Logger logger = LogManager.getLogger(getClass());

    @Autowired
    private RespuestaControladorServicio respuestaControladorServicio;

    @Autowired
    private MonedaRepositorio monedaRepositorio;

    @Autowired
    public MonedaServicioImpl(MonedaRepositorio monedaRepositorio) {
        super(monedaRepositorio);
    }

    @Override
    public RespuestaControlador crear(Moneda moneda) throws EntidadDuplicadaExcepcion {
        this.monedaRepositorio.crear(moneda);
        return this.respuestaControladorServicio.obtenerRespuestaDeExitoCrearConData(NombreEntidadEnum.MONEDA.getValor(), moneda.getId());
    }

    @Override
    public RespuestaControlador actualizar(Moneda moneda) throws EntidadDuplicadaExcepcion {
        this.monedaRepositorio.actualizar(moneda);
        return respuestaControladorServicio.obtenerRespuestaDeExitoActualizar(NombreEntidadEnum.MONEDA.getValor());
    }

    @Override
    public RespuestaControlador eliminar(Long monedaId) {
        RespuestaControlador respuesta;
        Moneda moneda;
        Boolean puedeEliminar;

        puedeEliminar = true;

        if (puedeEliminar == null || !puedeEliminar) {
            respuesta = RespuestaControlador.obtenerRespuestaDeError("El " + NombreEntidadEnum.MONEDA.getValor().toLowerCase() + " ha sido asignado a uno o varios usuarios y no se puede eliminar");
        } else {
            moneda = monedaRepositorio.obtener(monedaId);
            moneda.setEstado(Boolean.FALSE);
            monedaRepositorio.actualizar(moneda);
            respuesta = respuestaControladorServicio.obtenerRespuestaDeExitoEliminar(NombreEntidadEnum.MONEDA.getValor());
        }

        return respuesta;
    }
}
