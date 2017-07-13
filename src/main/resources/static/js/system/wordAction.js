function addOrEditWordDialog(actionMode) {
	
	var title = '';
	var id = '';
	var wordText = '';
	
	if (actionMode == 'add') {
		title = '新建敏感词';
	} else if (actionMode == 'edit') {
		title = '编辑敏感词';
		id = '';
		wordText = '';
	}
	
	$('#ACTION_DIALOG').dialog({
		title: title,
		width: 400,
		height: 350,
		modal: true,
		href: "../../html/system/wordAction.html",
		buttons:[
			{id:'submitFormBtn', text:'提交', handler:function(){
				submitAction();
			}}
		],
		onLoad: function () {
			$("#wordText").textbox({
				multiline:true,
				prompt:'请输入敏感词'
			});
			
			if (actionMode == 'edit') {
				$("#wordActionForm #id").val(id);
				$("#wordActionForm #wordText").textbox('setValue', '');
				$("#wordActionForm #wordText").textbox('setText', '');
			}
		},
		onOpen:function(){
			$(this).find("div.dialog-button").find("a.l-btn:first").removeClass("l-btn-small l-btn").addClass("subBtn");
		}
	});
}

function deleteWordDialog() {
	
	var rows = $('#listDatagrid').datagrid('getSelections');
	var idArray = new Array();
	var messageContent = "";
    if (rows && rows.length > 0) {
        $.each(rows, function (key, wordObj) {
        	idArray.push(wordObj.id);
        	var value = wordObj.word;
        	value = value.substring(1, value.length - 1);
        	value = value.replace(new RegExp(/\|/g), ',');
        	messageContent += "[" + value + "]";
        });
    } else {
    	$.messager.alert('提示', '请选择要删除的敏感词');
    	return;
    }
    
    $.messager.confirm('确认','确定要删除以下敏感词吗?<br>' + messageContent, function(r) {    
        if (r) {    
        	var paramObj = new Object();
	    	paramObj.idArray = idArray.join(',');
	        $.ajax({
	    		type : 'POST',
	    		url : '/wordList/delete',
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
	paramObj.id = $("#wordActionForm #id").val();
	
	var wordText = $("#wordText").textbox('getValue');
	wordText = wordText.replace(/\r\n/g,"|");    
	wordText = wordText.replace(/\n/g,"|");
    paramObj.word = '|' + wordText + '|';
    
    $.ajax({
		type : 'POST',
		url : '/wordList/action',
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
			addOrEditWordDialog('add');
			reLoadData();
		},
		error: function() {
			$.messager.alert('提示', '操作失败, 请联系管理员'); 
		}
	});
}