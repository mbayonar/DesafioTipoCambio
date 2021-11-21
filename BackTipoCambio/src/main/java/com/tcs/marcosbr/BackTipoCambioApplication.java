package com.tcs.marcosbr;

import com.tcs.marcosbr.util.TablasH2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@ComponentScan(basePackages = {"com.tcs.marcosbr"})
public class BackTipoCambioApplication extends SpringBootServletInitializer implements CommandLineRunner {

    @Autowired
    private JdbcTemplate template;

    public static void main(String[] args) {
        SpringApplication.run(BackTipoCambioApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(BackTipoCambioApplication.class);
    }

    @Override
    public void run(String... args) throws Exception {
        // Para 'moneda'
        TablasH2.crearTablaMoneda(template);
        TablasH2.insertarRegistrosTablaMoneda(template);
        // Para 'tipocambio'
        TablasH2.crearTablaTipoCambio(template);
        TablasH2.insertarRegistrosTablaTipoCambio(template);
    }

}
