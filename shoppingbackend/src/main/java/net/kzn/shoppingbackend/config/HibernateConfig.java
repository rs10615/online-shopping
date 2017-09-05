package net.kzn.shoppingbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages={"net.kzm.shoppingbackend.dto"})
@EnableTransactionManagement
public class HibernateConfig {
private final String DATABASE_URL="jdbc:h2:tcp://localhost/~/onlineshopping";
private final String DATABASE_DRIVER="org.h2.Driver";
private final String DATABASE_DIALECT="org.hibernate.dialect.H2Dialect";
private final String DATABASE_USERNAME="sa";
private final String DATABASE_PASSWPRD="";


@Bean
public DataSource getDataSource(){
	
	BasicDataSource dataSource=new BasicDataSource();
	dataSource.setUrl(DATABASE_URL);
	dataSource.setUsername(DATABASE_USERNAME);
	dataSource.setPassword(DATABASE_PASSWPRD);
	dataSource.setDriverClassName(DATABASE_DRIVER);
	
	return dataSource;
	
}
@Bean
public SessionFactory getSessionFactory(DataSource dataSource){
	
	LocalSessionFactoryBuilder builder=new LocalSessionFactoryBuilder(dataSource);
builder.addProperties(getHibernateProperties());
builder.scanPackages("net.kzm.shoppingbackend.dto");
return builder.buildSessionFactory();

}

//all the hibernate properties will be returned in this method
private Properties getHibernateProperties() {
Properties prop=new Properties();
prop.put("hibernate.dialect", DATABASE_DIALECT);
prop.put("hibernate.show_sql", true);
prop.put("hibernate.format_sql", true);




	return prop;
}
//transaction manager bean
@Bean
public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
{
HibernateTransactionManager transactionManager=new HibernateTransactionManager(sessionFactory);

return transactionManager;
}
}
