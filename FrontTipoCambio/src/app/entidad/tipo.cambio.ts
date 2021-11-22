import { MonedaEntidad } from './moneda';

export class TipoCambioEntidad {
    id?: number;
    moneda?: MonedaEntidad;
    precioCompra?: number;
    precioVenta?: number;
    fechaCambio?: Date;
    estado?: boolean;

    constructor(){
    }
}