package com.urs.bsi.repository;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

@Repository
public class CommonDaoImpl implements CommonDao {
	
	private static Logger logger = LogManager.getLogger(CommonDaoImpl.class);

	@Autowired
	private DataSource dataSource;
	
	
	@Autowired
	private Environment env;
	

}
