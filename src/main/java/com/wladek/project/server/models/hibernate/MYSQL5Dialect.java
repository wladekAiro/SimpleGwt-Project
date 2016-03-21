package com.wladek.project.server.models.hibernate;

import org.hibernate.dialect.MySQL5Dialect;
import org.hibernate.dialect.unique.UniqueDelegate;

public class MYSQL5Dialect extends MySQL5Dialect{

	private final UniqueDelegate uniqueDelegate;
	
	public MYSQL5Dialect() {
		super();
		uniqueDelegate = new Mysql5UniqueDelegate(this);
	}
	
	@Override
	public UniqueDelegate getUniqueDelegate() {
		return uniqueDelegate;
	}
}
