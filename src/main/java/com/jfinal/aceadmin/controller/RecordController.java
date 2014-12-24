package com.jfinal.aceadmin.controller;

import com.jfinal.aceadmin.model.CommodityRecord;
import com.jfinal.core.Controller;

public class RecordController extends Controller {

	public void index() {
		int page = getParaToInt("page", 0);
		int pagesize = getParaToInt("rows", 10);
		String qtype = getPara("qtype");
		String query = getPara("query");
		String sortname = getPara("sortname");
		String sortorder = getPara("sortorder");
		renderJson(CommodityRecord.dao.findByPagination(page, pagesize, qtype, query, sortname,
				sortorder));
	}
}
