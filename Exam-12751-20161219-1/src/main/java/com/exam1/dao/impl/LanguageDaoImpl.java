package com.exam1.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.exam1.dao.ILanguageDao;
import com.exam1.pojo.Language;
import com.exam1.util.DBUtil;
import com.exam1.util.SQLUitl;

public class LanguageDaoImpl implements ILanguageDao {

	@Override
	public int deleteByPrimaryKey(Byte languageId) {
		return 0;
	}

	@Override
	public int insert(Language record) {
		return 0;
	}

	@Override
	public int insertSelective(Language record) {
		return 0;
	}

	@Override
	public Language selectByPrimaryKey(Byte languageId) {
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(Language record) {
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Language record) {
		return 0;
	}

	@Override
	public List<Language> selectAll() {
		List<Language> list = new ArrayList<Language>();
		ResultSet resultSet = DBUtil.query(SQLUitl.LANGUAGE_SELET_ALL);
		try {
			while (resultSet.next()) {
				Language language = new Language();
				language.setLanguageId(resultSet.getByte("language_id"));
				language.setName(resultSet.getString("name"));
				language.setLastUpdate(resultSet.getDate("last_update"));
				list.add(language);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
