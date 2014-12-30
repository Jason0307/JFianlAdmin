package com.jfinal.aceadmin.model;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSON;
import com.jfinal.aceadmin.util.FilterUtil;
import com.jfinal.aceadmin.vo.FilterVo;
import com.jfinal.aceadmin.vo.JqGridResponseVo;
import com.jfinal.aceadmin.vo.RuleVo;
import com.jfinal.ext.plugin.tablebind.TableBind;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;

public class BaseModel<M extends BaseModel<?>> extends Model<M> implements
		Serializable {

	private static final long serialVersionUID = 1L;
	private String tableName;
	private String LIST_SQL = null;
	private String QUERY_ATTR_SQL = null;

	@SuppressWarnings("unchecked")
	public BaseModel() {
		Class<M> modelClass = (Class<M>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		tableName = modelClass.getAnnotation(TableBind.class).tableName();
		LIST_SQL = "SELECT * FROM " + tableName;
		QUERY_ATTR_SQL = "SELECT * FROM " + tableName + " WHERE {0} = ?";
	}

	/**
	 * Find the unique record by the attr in the database
	 * 
	 * @param attr
	 * @param value
	 * @return
	 */
	public Record findByAttrUnique(String attr, String value) {
		Record record = Db.findFirst(
				MessageFormat.format(QUERY_ATTR_SQL, attr), value);
		return record;
	}

	public List<Record> findByAttrList(String attr, String value) {
		List<Record> records = new ArrayList<Record>();
		records = Db.find(MessageFormat.format(QUERY_ATTR_SQL, attr), value);
		return records;
	}

	/**
	 * Find all the records in the database
	 * 
	 * @return
	 */
	public JqGridResponseVo findByPagination(int page, int pagesize,
			String qtype, String query, String sortname, String sortorder,
			String filter) {
		JqGridResponseVo response = new JqGridResponseVo();
		StringBuilder sb = new StringBuilder();
		List<Object> params = new ArrayList<Object>();

		if (!StringUtils.isBlank(filter)) {
			FilterVo filterVo = JSON.parseObject(filter, FilterVo.class);
			String groupOp = filterVo.getGroupOp();
			List<RuleVo> rules = filterVo.getRules();
			if (!rules.isEmpty()) {
				sb.append(" WHERE ");
			}
			for (int i = 0 ; i < rules.size(); i++){
				RuleVo ruleVo = rules.get(i);
				String field = ruleVo.getField();
				String op = ruleVo.getOp();
				String data = ruleVo.getData();
				String sql = FilterUtil.getSqlOp(op, data);
				sb.append(field).append(sql);
				if(i < rules.size() - 1){
					sb.append(groupOp).append(" ");
				}
			}
		}

		if (!StringUtils.isBlank(query)) {
			sb.append(" WHERE ").append(qtype).append(" = ? ");
			params.add(query);
		}
		if (!StringUtils.isBlank(sortname)) {
			sb.append(" ORDER BY ").append(sortname).append(" ")
					.append(sortorder);
		}

		System.out.println("SQL " + sb.toString());
		Page<Record> pager = Db.paginate(page, pagesize, "SELECT *", "FROM "
				+ tableName + sb.toString(), params.toArray());
		List<Record> records = pager.getList();
		response.setData(records);
		response.setTotalpages(pager.getPageNumber());
		response.setCurrpage(page);
		response.setTotalrecords(pager.getTotalRow());
		return response;
	}

	public List<Record> findByList() {
		List<Record> records = new ArrayList<Record>();
		records = Db.find(LIST_SQL);
		return records;
	}

	public Map<String, Object> getAttrs() {
		return super.getAttrs();
	}
}
