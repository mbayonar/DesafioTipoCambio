package com.tcs.marcosbr.enums;

/**
 *
 * @author Marcos
 */
public enum NombreEntidadEnum {
    
    MONEDA("Moneda"),
    TIPO_CAMBIO("Tipo de cambio");
    
    private String valor;

    private NombreEntidadEnum(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
}
