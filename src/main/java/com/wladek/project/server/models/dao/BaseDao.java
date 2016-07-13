package com.wladek.project.server.models.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.wladek.project.server.models.base.PO;

public class BaseDao {
	@Inject
	Provider<EntityManager> provider;

	public EntityManager getEntityManager() throws RuntimeException {
		EntityManager em = provider.get();
		return em;
	}
	
	public PO save(PO po) throws RuntimeException {
		try {
			getEntityManager().persist(po);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return po;

	}

	public void flush() throws RuntimeException {
		try {
			getEntityManager().flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void merge(PO po) {
		try {
			getEntityManager().merge(po);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void delete(PO po) throws RuntimeException {
		try {
			getEntityManager().remove(po);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public <T> T getSingleResultOrNull(Query query) throws RuntimeException {
		T value = null;
		try {
			value = (T) query.getSingleResult();
		} catch (NoResultException e) {
			if (!(e instanceof NoResultException)) {
				e.printStackTrace();
			}
		}

		return value;
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> getResultList(Query query, Integer offSet, Integer limit) throws RuntimeException {
		List<T> values = null;

		try {
			if (limit == null || offSet == null) {
				values = query.getResultList();
			} else {
				values = query.setFirstResult(offSet).setMaxResults(limit).getResultList();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return values;
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> getResultList(Query query) throws RuntimeException {
		List<T> values = null;
		try {
			values = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return values;
	}

	public <T> T getById(Class<T> clazz, long id) {
		return getEntityManager().find(clazz, id);
	}

	public <T> T findById(Class<?> clazz, Long id, boolean throwExceptionIfNull) throws RuntimeException {
		T po = getSingleResultOrNull(getEntityManager()
				.createQuery("from " + clazz.getName() + " u where u.id=:id").setParameter("id", id));

		if (po == null && throwExceptionIfNull) {
//			throw new ServiceException(ErrorCodes.NOTFOUND, clazz.getName(), "'" + refId + "'");
		}

		return po;
	}

	public <T> T findById(Long id, Class<?> clazz) throws RuntimeException {
		return findById(id, clazz, true);
	}

	public <T> T findById(Long id, Class<?> clazz, boolean throwExceptionIfNull) throws RuntimeException {
		return findById(id, clazz, new HashMap<String, Object>(), throwExceptionIfNull);
	}

	public <T> T findById(Long id, Class<?> clazz, Map<String, Object> params, boolean throwExceptionIfNull) {

		StringBuffer buff = new StringBuffer("from " + clazz.getName() + " c where c.id=:id");

		// Variables
		if (params != null) {
			for (String key : params.keySet()) {
				buff.append(" and " + key + "=:" + key);
			}
		}
		Query query = getEntityManager().createQuery(buff.toString()).setParameter("id", id);
		// Params
		if (params != null) {
			for (String key : params.keySet()) {
				query.setParameter(key, params.get(key));
			}
		}

		T rtn = getSingleResultOrNull(query);
		if (rtn == null && throwExceptionIfNull) {
//			throw new ServiceException(ErrorCodes.NOTFOUND, clazz.getName(), "'" + refId + "'");
		}

		return rtn;
	}
}
