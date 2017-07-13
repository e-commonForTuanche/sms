function addOrEditPhoneDialog(actionMode) {
	
	var title = '';
	var id = '';
	var wordText = '';
	
	if (actionMode == 'add') {
		title = '添加手机号黑名单';
	} else if (actionMode == 'edit') {
		title = '编辑手机号黑名单';
		id = '';
		wordText = '';
	}
	
	$('#ACTION_DIALOG').dialog({
		title: title,
		width: 400,
		height: 150,
		modal: true,
		href: "../../html/system/blackAction.html",
		buttons:[
			{id:'submitFormBtn', text:'提交', handler:function(){
				submitAction();
			}}
		],
		onLoad: function () {
			$("#phoneText").textbox({
				prompt:'请输入手机号'
			});
			
			if (actionMode == 'edit') {
				$("#phoneActionForm #id").val(id);
				$("#phoneActionForm #phoneText").val('');
			}
		},
		onOpen:function(){
			$(this).find("div.dialog-button").find("a.l-btn:first").removeClass("l-btn-small l-btn").addClass("subBtn");
		}
	});
}

function deletePhoneDialog() {
	
	var rows = $('#listDatagrid').datagrid('getSelections');
	var idArray = new Array();
	var messageContent = "";
    if (rows && rows.length > 0) {
        $.each(rows, function (key, phoneObj) {
        	idArray.push(phoneObj.id);
        	messageContent += "[" + phoneObj.phone + "]";
        });
    } else {
    	$.messager.alert('提示', '请选择要删除的手机号');
    	return;
    }
    
    $.messager.confirm('确认','确定要删除以下手机号吗?<br>' + messageContent, function(r) {    
        if (r) {    
        	var paramObj = new Object();
	    	paramObj.idArray = idArray.join(',');
	        $.ajax({
	    		type : 'POST',
	    		url : '/blackList/delete',
	    		data : paramObj,
	    		dataType : 'json',
	    		beforeSend : function() {
	    			$.messager.progress({title : '提示', msg : '处理中..', text : ''});
	    		},
	    		complete : function() {
	    			$.messager.progress('close');
	    		},
	    		success : function(data) {
	    			reLoadData();
	    		},
	    		error: function() {
	    			$.messager.alert('提示', '操作失败, 请联系管理员'); 
	    		}
	    	});
        }
    }); 
}

function submitAction() {
	var paramObj = new Object();
	paramObj.id = $("#phoneActionForm #id").val();
	paramObj.phone = $.trim($("#phoneText").textbox('getValue'));
    
    $.ajax({
		type : 'POST',
		url : '/blackList/action',
		data : paramObj,
		dataType : 'json',
		beforeSend : function() {
			$.messager.progress({title : '提示', msg : '处理中..', text : ''});
		},
		complete : function() {
			$.messager.progress('close');
		},
		success : function(data) {
			$("#ACTION_DIALOG").dialog('close');
			addOrEditPhoneDialog('add');
			reLoadData();
		},
		error: function() {
			$.messager.alert('提示', '操作失败, 请联系管理员'); 
		}
	});
}