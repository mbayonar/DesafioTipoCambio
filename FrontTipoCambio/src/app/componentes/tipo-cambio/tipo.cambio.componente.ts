import { RespuestaServicio } from '../../util/respuesta.servicio';
import { ApiServicio } from '../../servicio/api.servicio';
import { MonedaEntidad } from './../../entidad/moneda';
import { Component, OnInit } from '@angular/core';

@Component({
    selector: 'tipo-cambio',
    templateUrl: './tipo.cambio.componente.html',

})
export class TipoCambio implements OnInit {

    public respuestaServicio?: RespuestaServicio;
    public listaMonedas?: MonedaEntidad[];
    public monedaOrigenId?: number;
    public monedaDestinoId?: number;
    public monto?: number;
    public multiplicadorTipoCambio?: number;
    public montoTipoCambio?: number;
    public mensajeResultado?: String;
    public mensajeError?: String;
    public datosMostrar = {
        fecha: null,
        tipoCambio: null,
        monedaOrigen: null,
        monto: null,
        montoTipoCambio: null,
        monedaDestino: null,
        extraInfo: ""
    }

    constructor(private apiServicio: ApiServicio) {
    }

    iniciarComponentes() {
        this.obtenerListaMonedas();
    }

    obtenerListaMonedas() {
        this.apiServicio.obtenerMonedas().subscribe(resp => {
            this.respuestaServicio = JSON.parse(JSON.stringify(resp));
            this.listaMonedas = this.respuestaServicio?.data;
        });
    }

    procesarTipoCambio(monedaOrigenId: any, monedaDestinoId: any, valorMonto: any) {
        this.limpiar();
        if (this.validarFormulario(monedaOrigenId.value, monedaDestinoId.value, valorMonto.value)) {
            let datosEnviar = {
                monedaDestinoId: monedaOrigenId.value,
                monedaOrigenId: monedaDestinoId.value,
                monto: valorMonto.value
            };
            console.log(datosEnviar);
            this.apiServicio.procesarTipoCambio(datosEnviar).subscribe(resp => {
                this.datosMostrar = JSON.parse(JSON.stringify(resp));
                this.mensajeError = this.datosMostrar?.extraInfo;
            });
        }
    }

    validarFormulario(monedaOrigenId: number, monedaDestinoId: number, valorMonto: number){
        this.mensajeError = "";
        console.log(valorMonto);
        if (valorMonto == null || valorMonto == undefined || valorMonto == NaN || valorMonto <= 0) {
            this.mensajeError = "Ingrese un valor correcto";
            return false;
        }
        if (monedaOrigenId == monedaDestinoId) {
            this.mensajeError = "Debe seleccionar monedas diferentes";
            return false;
        }
        return true;

    }

    limpiar(){
        this.mensajeError = "";
        this.datosMostrar = {
            fecha: null,
            tipoCambio: null,
            monedaOrigen: null,
            monto: null,
            montoTipoCambio: null,
            monedaDestino: null,
            extraInfo: ""
        }
    }

    ngOnInit() {
        this.iniciarComponentes();
    }
}