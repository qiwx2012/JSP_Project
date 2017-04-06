package com.qiwx.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.qiwx.bean.CollectionBean;
import com.qiwx.dao.CollDao;
import com.qiwx.util.DBUtils;

/**
 * @Author qiwx
 * @time 2017年4月6日 下午5:47:42
 * @Des
 **/
public class CollDaoImpl implements CollDao {

	@Override
	public void save(CollectionBean bean) {

		String sql = "insert into CollectionTbl(name,url)values(?,?)";
		DBUtils db = new DBUtils();
		Connection conn = db.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bean.getName());
			pstmt.setString(2, bean.getUrl());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeDb(conn);
		}

	}

	@Override
	public void update(CollectionBean bean) {
		String sql = "update  CollectionTbl set name=?,url=? where id=?";
		DBUtils db = new DBUtils();
		Connection conn = db.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bean.getName());
			pstmt.setString(2, bean.getUrl());
			pstmt.setInt(3, bean.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeDb(conn);
		}
	}
	@Override
	public void delete(String[] ids) {

		String sql = "delete from CollectionTbl where id=?";
		DBUtils db = new DBUtils();
		Connection conn = db.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			if (ids != null && ids.length > 0) {
				for (int i = 0; i < ids.length; i++) {
					pstmt.setInt(1, Integer.valueOf(ids[i]));
					pstmt.executeUpdate();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeDb(conn);
		}

	}

	@Override
	public List list() {
		String sql = "select * from CollectionTbl";
		DBUtils db = new DBUtils();
		Connection conn = db.getConnection();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			if (rs != null) {
				List list=new ArrayList();
				while (rs.next()) {
					int id=rs.getInt(1);
					String url=rs.getString(2);
					String name=rs.getString(3);
					CollectionBean bean=new CollectionBean();
					bean.setId(id);
					bean.setUrl(url);
					bean.setName(name);
					list.add(bean);
				}
				return list;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeDb(conn);
		}

		return null;
	}
}
