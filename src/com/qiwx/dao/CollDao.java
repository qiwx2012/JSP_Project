package com.qiwx.dao;

import java.util.List;

import com.qiwx.bean.CollectionBean;

/**
 * @Author qiwx
 * @time 2017-4-6 5:45:02
 * @Des
 **/
public interface CollDao {

	public void save(CollectionBean bean);
	public void update(CollectionBean bean);
	public void delete(String[] ids);
	public List<CollectionBean> list();
	public CollectionBean get(int id);
	

}
