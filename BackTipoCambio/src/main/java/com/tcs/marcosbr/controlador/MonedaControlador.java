package com.tcs.marcosbr.controlador;

import com.tcs.marcosbr.entidad.Moneda;
import com.tcs.marcosbr.enums.NombreEntidadEnum;
import org.springframework.beans.factory.annotation.Autowired;

import com.tcs.marcosbr.servicio.MonedaServicio;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/server/moneda")
public class MonedaControlador extends BaseControladorImpl<Moneda, Long> implements BaseControlador<Moneda, Long> {

    @Autowired
    public MonedaControlador(MonedaServicio monedaServicio) {
        super(monedaServicio, NombreEntidadEnum.MONEDA.getValor());
    }

}