package com.qiwx.bean;
/**
 * @Author qiwx
 * @time 2017年4月6日 下午5:41:47
 * @Des
 **/

/*
 * 创建表sql语句 create table CollectionTbl( id int not null auto_increment primary
 * key, url varchar(100) ,name varchar(50)); Query OK, 0 rows affected (0.25
 * sec)
 */
public class CollectionBean {

	private int id;
	private String url;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
