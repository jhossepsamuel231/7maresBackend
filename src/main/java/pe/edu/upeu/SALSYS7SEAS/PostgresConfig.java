package pe.edu.upeu.SALSYS7SEAS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories( entityManagerFactoryRef = "postgresEntityManagerFactory",
        transactionManagerRef = "postgresTransactionManager", basePackages = {
        "pe.edu.upeu.SALSYS7SEAS.negocioDB.dao"
})
public class PostgresConfig {

    @Autowired
    private Environment environment;

    @Bean(name = "postgresDatasource")
    public DataSource mysqlDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(environment.getProperty("postgres.datasource.url"));
        dataSource.setUsername(environment.getProperty("postgres.datasource.username"));
        dataSource.setPassword(environment.getProperty("postgres.datasource.password"));
        dataSource.setDriverClassName(environment.getProperty("postgres.datasource.driver-class-name"));

        return dataSource;
    }

    @Bean(name = "postgresEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(mysqlDataSource());
        em.setPackagesToScan("pe.edu.upeu.SALSYS7SEAS.negocioDB.entity");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", environment.getProperty("postgres.jpa.hibernate.ddl-auto"));
        properties.put("hibernate.show-sql", environment.getProperty("postgres.jpa.show-sql"));
        properties.put("hibernate.dialect", environment.getProperty("postgres.jpa.database-platform"));

        em.setJpaPropertyMap(properties);

        return em;

    }

    @Bean(name = "postgresTransactionManager")
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

        return transactionManager;
    }
}
