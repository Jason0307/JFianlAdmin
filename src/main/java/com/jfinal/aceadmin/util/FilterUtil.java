package com.jfinal.aceadmin.util;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class FilterUtil {

	@SuppressWarnings({ "unchecked" })
	public static String getSqlOp(String op, String data) {
		SAXReader reader = new SAXReader();
		InputStream is = FilterUtil.class.getClassLoader().getResourceAsStream(
				"filter.xml");
		try {
			Document doc = reader.read(is);
			Element root = doc.getRootElement();
			List<Element> keys = root.elements("key");
			for (Element key : keys) {
				Attribute nameAttr = key.attribute("name");
				if (null != nameAttr) {
					if (op.equals(nameAttr.getStringValue())) {
						Attribute valueAttr = key.attribute("value");
						Attribute dataAttr = key.attribute("data");
						String sqlOp = valueAttr.getStringValue();
						String sqlValue = "";
						if (null != dataAttr) {
							if ("in".equals(op) || "ni".equals(op)) {
								data = SqlUtil.replaceSql(data);
							}
							String sqlData = dataAttr.getStringValue();
							Map<String, String> map = new HashMap<String, String>();
							map.put("data", data);
							sqlValue = getTemplateValue(sqlData, map);
						}
						String sql = sqlOp + sqlValue + " ";
						System.out.println(sql);
						return sql;
					}
				}
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

		return null;
	}

	public static String getTemplateValue(String template,
			Map<String, String> map) {
		Pattern pattern = Pattern.compile("\\$\\{(.*?)\\}");
		Matcher matcher = pattern.matcher(template);
		StringBuffer sb = new StringBuffer();
		while (matcher.find()) {
			matcher.appendReplacement(sb, map.get(matcher.group(1)).toString());
		}
		matcher.appendTail(sb);
		return sb.toString();
	}

	public static void main(String[] args) throws Exception {
		getSqlOp("nn", "5");
	}
}
