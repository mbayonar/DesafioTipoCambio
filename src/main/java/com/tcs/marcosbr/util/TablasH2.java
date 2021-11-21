package com.tcs.marcosbr.util;

import java.util.Date;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Marcos
 */
public class TablasH2 {

    public static void crearTablaMoneda(JdbcTemplate template) {
        String sqlTablaMoneda;

        sqlTablaMoneda = "DROP TABLE moneda IF EXISTS;";
        sqlTablaMoneda = "CREATE TABLE moneda(";
        sqlTablaMoneda = sqlTablaMoneda + "id INTEGER(11) PRIMARY KEY auto_increment, ";
        sqlTablaMoneda = sqlTablaMoneda + "nombre VARCHAR(50), ";
        sqlTablaMoneda = sqlTablaMoneda + "abreviatura VARCHAR(5), ";
        sqlTablaMoneda = sqlTablaMoneda + "jerarquia INTEGER(11), ";
        sqlTablaMoneda = sqlTablaMoneda + "estado boolean DEFAULT true";
        sqlTablaMoneda = sqlTablaMoneda + ");";
        template.execute(sqlTablaMoneda);
    }

    public static void insertarRegistrosTablaMoneda(JdbcTemplate template) {
        String sqlInsertarMoneda;
        String[] monedas = {"EUROS", "DÓLAR", "SOLES"};
        String[] abreviaturas = {"EUR", "USD", "PEN"};
        int[] jerarquias = {1, 2, 3};

        for (int i = 0; i < monedas.length; i++) {
            sqlInsertarMoneda = "";
            sqlInsertarMoneda = sqlInsertarMoneda + "INSERT INTO moneda(nombre, abreviatura, jerarquia) VALUES (";
            sqlInsertarMoneda = sqlInsertarMoneda + "'" + monedas[i] + "', '" + abreviaturas[i] + "', " + jerarquias[i] + ");";
            template.update(sqlInsertarMoneda);
        }
    }

    public static void crearTablaTipoCambio(JdbcTemplate template) {
        String sqlTablaTipoCambio;

        sqlTablaTipoCambio = "DROP TABLE tipocambio IF EXISTS;";
        sqlTablaTipoCambio = "CREATE TABLE tipocambio(";
        sqlTablaTipoCambio = sqlTablaTipoCambio + "id INTEGER(11) PRIMARY KEY auto_increment, ";
        sqlTablaTipoCambio = sqlTablaTipoCambio + "idmoneda INTEGER(11), ";
        sqlTablaTipoCambio = sqlTablaTipoCambio + "preciocompra DECIMAL(10,3), ";
        sqlTablaTipoCambio = sqlTablaTipoCambio + "precioventa DECIMAL(10,3), ";
        sqlTablaTipoCambio = sqlTablaTipoCambio + "fechacambio DATE, ";
        sqlTablaTipoCambio = sqlTablaTipoCambio + "estado boolean DEFAULT true,";
        sqlTablaTipoCambio = sqlTablaTipoCambio + "FOREIGN KEY (idmoneda) references moneda(id)";
        sqlTablaTipoCambio = sqlTablaTipoCambio + ");";
        template.execute(sqlTablaTipoCambio);
    }

    public static void insertarRegistrosTablaTipoCambio(JdbcTemplate template) {
        String sqlInsertarTipoCambio;
        String fechaActual;

        // Obtenemos la fecha actual
        fechaActual = SistemaUtil.obtenerFechaComoString(new Date(), "yyyy/MM/dd");
//        fechaActual = SistemaUtil.obtenerFechaComoString(SistemaUtil.agregarDias(new Date(), 1), "yyyy/MM/dd");

        System.out.println("\n\n\nFECHA: " + fechaActual + "\n\n\n");

        int[] monedas = {1, 2, 3}; // ID de las monedas
        Double[] precioCompra = {1.1284, 1.0, 3.996};
        Double[] precioVenta = {1.1285, 1.0, 4.001};

        for (int i = 0; i < monedas.length; i++) {
            sqlInsertarTipoCambio = "";
            sqlInsertarTipoCambio = sqlInsertarTipoCambio + "INSERT INTO tipocambio(idmoneda, preciocompra, precioventa, fechacambio) VALUES (";
            sqlInsertarTipoCambio = sqlInsertarTipoCambio + monedas[i] + ", " + precioCompra[i] + ", " + precioVenta[i] + ", TO_DATE ('" + fechaActual + "','yyyy-MM-dd'));";
            template.update(sqlInsertarTipoCambio);
        }
    }
}
