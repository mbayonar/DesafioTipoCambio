package com.tcs.marcosbr.repositorio;

import com.tcs.marcosbr.util.Criterio;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author MARCOS BAYONA
 * @param <Entidad>
 * @param <TipoLlave>
 */
public interface BaseRepositorio<Entidad, TipoLlave> {
    
    Entidad obtener(TipoLlave id);

    void crear(Entidad entidad);

    void actualizar(Entidad entidad);

    void grabarTodos(List<Entidad> list);
    
    Session getCurrentSession();

    List<Entidad> obtenerTodos();
    
    Entidad obtenerPorCriterio(Criterio filtro);

    Entidad obtenerInclusoEliminado(TipoLlave id);

    public List<Entidad> buscarPorCriteria(Criterio filtro);
    
    @SuppressWarnings("rawtypes")
    List proyeccionPorCriteria(Criterio filtro, Class resultado);
    
    public Object obtenerConResultSet(Criterio filtro, Class resultado);
    
}
