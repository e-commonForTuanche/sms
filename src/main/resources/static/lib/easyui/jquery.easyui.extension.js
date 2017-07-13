$.extend($.fn.validatebox.defaults.rules, {
	minLength : {
		validator : function(value, param) {
			return value.length >= param[0];
		},
		message : '请至少输入{0}字符.'
	}
});