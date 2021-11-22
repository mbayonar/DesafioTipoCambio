export class RespuestaServicio {

    estado: string;
    mensaje: string;
    data: any;

    constructor(estado: string, mensaje: string = "", data: any = null) {
        this.estado = estado;
        this.mensaje = mensaje;
        this.data = data;
    }
}