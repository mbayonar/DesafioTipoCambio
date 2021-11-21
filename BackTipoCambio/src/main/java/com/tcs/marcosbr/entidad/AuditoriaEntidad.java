package com.tcs.marcosbr.entidad;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

/**
 *
 * @author MARCOS BAYONARIJALBA
 */
@MappedSuperclass
@JsonAutoDetect
public class AuditoriaEntidad implements Serializable {

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @Column(nullable = false)
    private Boolean estado;

    @Transient
    private Boolean eliminar;

    @Transient
    private Object extraInfo;

    public AuditoriaEntidad() {
        eliminar = Boolean.FALSE;
    }

    public AuditoriaEntidad(Long id) {
        this();
        this.id = id;
    }
/*
    protected void copy(final AuditoriaEntidad source) {
        this.nick = source.nick;
        this.fecha = source.fecha;
        this.nickMod = source.nickMod;
    }
*/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
/*
    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPc() {
        return pc;
    }

    public void setPc(String pc) {
        this.pc = pc;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public String getNickMod() {
        return nickMod;
    }

    public void setNickMod(String nickMod) {
        this.nickMod = nickMod;
    }

    public String getPcMod() {
        return pcMod;
    }

    public void setPcMod(String pcMod) {
        this.pcMod = pcMod;
    }

    public String getIpMod() {
        return ipMod;
    }

    public void setIpMod(String ipMod) {
        this.ipMod = ipMod;
    }

    public Timestamp getFechaMod() {
        return fechaMod;
    }

    public void setFechaMod(Timestamp fechaMod) {
        this.fechaMod = fechaMod;
    }
*/
    public Boolean getEliminar() {
        return eliminar;
    }

    public void setEliminar(Boolean eliminar) {
        this.eliminar = eliminar;
    }
/*
    public boolean esNuevo() {
        return this.id == null && this.nick == null && this.fecha == null;
    }
*/
    public Object getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(Object extraInfo) {
        this.extraInfo = extraInfo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AuditoriaEntidad other = (AuditoriaEntidad) obj;
        return Objects.equals(this.id, other.id);
    }

}
