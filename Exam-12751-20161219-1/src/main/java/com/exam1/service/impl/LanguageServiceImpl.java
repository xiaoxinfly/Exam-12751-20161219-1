package com.exam1.service.impl;

import java.util.List;

import com.exam1.dao.ILanguageDao;
import com.exam1.dao.impl.LanguageDaoImpl;
import com.exam1.pojo.Language;
import com.exam1.service.ILanguageService;

public class LanguageServiceImpl implements ILanguageService {

	private ILanguageDao iLanguage = new LanguageDaoImpl();

	@Override
	public List<Language> getLanguageList() {
		return  this.iLanguage.selectAll();
	}

}
