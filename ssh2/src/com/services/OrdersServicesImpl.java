package com.services;

import java.io.IOException;
import java.util.List;

import com.dao.IOrdersDAO;
import com.entity.Order;

public class OrdersServicesImpl implements IOrdersServices {
	private IOrdersDAO IOrdersDao;
	public void setIUsersDao(IOrdersDAO usersDao) {
		IOrdersDao = usersDao;
	}
	public void update(Order order) {
		// TODO Auto-generated method stub
		IOrdersDao.attachDirty(order);
	}

	public void delete(java.lang.Integer id) {
		// TODO Auto-generated method stub
		IOrdersDao.delete(id);
	}
	/**
	 * ͨ��id�鿴һ������
	 */

	public List list() {
		// TODO Auto-generated method stub
		return IOrdersDao.findAll();
	}


	public void add(Order order) {
		// TODO Auto-generated method stub
		IOrdersDao.save(order);
	}	
}
