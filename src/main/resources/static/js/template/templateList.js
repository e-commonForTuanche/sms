$("[rel=tooltip]").tooltip();
$(function() {
	SMS_LAYOUT_LOAD();
	page_init();
	gridInit();
});
function page_init() {
	$('#searchItem').textbox({
		width: 100,
	    prompt:'请输入模板名称'
	});
	
	var comboValueArray = [
	    {"id":1, "text":"text1"}
	  , {"id":2, "text":"text2"}
	  , {"id":3, "text":"text3"}
	];
	var comboObj = {valueField:'id', textField:'text', data:comboValueArray};
	$('#comboBox1').combobox(comboObj);
	$('#comboBox2').combobox(comboObj);
	$('#comboBox3').combobox(comboObj);
	
	$('#searchBtn').linkbutton({iconCls: 'icon-search'});
	$("#searchBtn").click(function() {
		reLoadData();
	});
}
function gridInit() {
	$('#listDatagrid').datagrid({
	    url:'/testDB?dbName=ecpdb',
	    width: 'auto',
	    height: 500,
	    rownumbers: true,
	    fitcolumns: true,
	    singleselect: false,
	    columns:[[
	        {field:'loginId',title:'模板类型',width:100},
	        {field:'loginPw',title:'模板名称',width:100},
	        {field:'loginPw',title:'适用业务',width:100},
	        {field:'loginPw',title:'适用系统',width:100},
	        {field:'loginPw',title:'适用城市',width:100},
	        {field:'loginPw',title:'状态',width:100},
	        {field:'loginPw',title:'修改时间',width:100},
	        {field:'loginPw',title:'修改人',width:100},
	        {field:'loginPw',title:'操作',width:100, formatter: function (value, rowData, rowIndex) {  
                return "a";  
            }}
	    ]],
	    toolbar: [
      	    {id: 'addTemplateBtn', text:'创建模板', iconCls: 'icon-add'}
      	]
	});
	$("#addTemplateBtn").click(function() {
		window.location.href="/load?htmlFile=template/templateAction.html";
	});
}
function reLoadData() {
	$('#searchItem').val($.trim($("#searchItem").val()));
	
	$("#listDatagrid").datagrid("load",{
		searchItem : $("#searchItem").val()
	});
}