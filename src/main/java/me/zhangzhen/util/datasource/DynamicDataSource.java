package me.zhangzhen.util.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;


public class DynamicDataSource extends AbstractRoutingDataSource{

	
	
	@Override
	protected Object determineCurrentLookupKey() {
		// TODO Auto-generated method stub
		return DbContextHolder.getDbType();
	}

}
