import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
    providedIn: 'root'
})
export class ApiServicio{

    private apiRoot: String = 'http://localhost:8091/server/';

    constructor(private http: HttpClient){
    }

    obtenerMonedas() {
        let header = new HttpHeaders().set('Type-content', 'aplication/json');
        let peticion = this.apiRoot + 'moneda/';

        return this.http.get(peticion, {
            headers: header
        });
    }

    procesarTipoCambio(data: any){
        let peticion = this.apiRoot + 'tipoCambio/procesarTipoDeCambio/';
        peticion = peticion + '?monto=' + data.monto + '&';
        peticion = peticion + 'monedaOrigenId=' + data.monedaOrigenId + '&';
        peticion = peticion + 'monedaDestinoId=' + data.monedaDestinoId;
        console.log(peticion);
        return this.http.post(peticion, data);
    }
}