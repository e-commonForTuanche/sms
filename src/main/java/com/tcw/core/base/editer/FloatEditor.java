package com.tcw.core.base.editer;

import org.springframework.beans.propertyeditors.PropertiesEditor;

import com.alibaba.druid.util.StringUtils;

public class FloatEditor extends PropertiesEditor {
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if (StringUtils.isEmpty(text)) {
			text = "0";
		}
		setValue(Float.parseFloat(text));
	}

	@Override
	public String getAsText() {
		return getValue().toString();
	}
}