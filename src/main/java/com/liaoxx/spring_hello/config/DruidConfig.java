package com.liaoxx.spring_hello.config;

import java.sql.SQLException;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.filter.config.ConfigFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

/**
 *<p>Title: DruidDataSourceConfig.java</p>
 *<p>Description: 数据源属性配置</p>
 *<p>CreateDate: 2017年5月18日</p>
 *@author shen
 *@version v1.0
 */
@Configuration
@Primary //在同样的DataSource中，首先使用被标注的DataSource
public class DruidConfig extends DataSourceProperties{

}
