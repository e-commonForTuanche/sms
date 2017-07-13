$("[rel=tooltip]").tooltip();
$(function() {
	$("#submitBtn").click(function() {
		if (validate()) {
			var paramObj = new Object();
			paramObj.loginId = $("#loginId").val();
			paramObj.loginPw = $.md5($("#loginPw").val());
			$.ajax({
				type : 'POST',
				url : '/login/validate',
				data : paramObj,
				dataType : 'json',
				beforeSend : function() {
					$.messager.progress({title : '提示', msg : '处理中..', text : ''});
				},
				complete : function() {
					$.messager.progress('close');
				},
				success : function(data) {
					if (data.rtnCode == "000000") {
						window.location.href="/main";
					} else {
						alert(data.rtnMesg);
					}
				},
				error: function() {
					$.messager.alert('提示', '登录失败, 请联系管理员'); 
				}
			});
		}
	});
});

function validate() {
	$("#loginId").val($.trim($("#loginId").val()));
	$("#loginPw").val($.trim($("#loginPw").val()));
	if ($("#loginId").val() == '') {
		$.messager.alert('提示', '请输入用户名');
		return false;
	}
	if ($("#loginPw").val() == '') {
		$.messager.alert('提示', '请输入密码');
		return false;
	}
	return true;
}