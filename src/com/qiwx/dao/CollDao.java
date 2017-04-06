package com.qiwx.dao;

import java.util.List;

import com.qiwx.bean.CollectionBean;

/**
 * @Author qiwx
 * @time 2017年4月6日 下午5:45:02
 * @Des
 **/
public interface CollDao {

	public void save(CollectionBean bean);
	public void update(CollectionBean bean);
	public void delete(String[] ids);
	public List list();

}
