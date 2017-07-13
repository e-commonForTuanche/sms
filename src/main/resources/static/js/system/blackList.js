$("[rel=tooltip]").tooltip();
$(function() {
	SMS_LAYOUT_LOAD();
	page_init();
	gridInit();
});

// 初始化函数
function page_init() {
	$('#searchItem').textbox({
		width: 200,
	    prompt:'请输入手机号'
	});
	$('#searchBtn').linkbutton({iconCls: 'icon-search'});
	
	$("#searchBtn").click(function() {
		reLoadData();
	});
}
function gridInit() {
	$('#listDatagrid').datagrid({
	    url:'/blackList/getList',
	    method: 'post',
	    width: 'auto',
	    height: 500,
	    autoLoad:true,
	    rownumbers: true,
	    fitcolumns: true,
	    singleselect: false,
	    pagination: true,
	    columns:[[
            {field:'ck', title:'全选', checkbox:true, width:60}
            , {field:'id',title:'',width:5, hidden: true} 
            , {field:'phone',title:'手机号',width:200}
            , {field:'createDtStr',title:'添加时间',width:100}
            , {field:'createName',title:'操作人',width:100}
	    ]],
	    toolbar: [
	        {id: 'addPhoneBtn', text:'添加', iconCls: 'icon-add'},
	        {id: 'editPhoneBtn', text:'删除', iconCls: 'icon-edit-remove'}
	    ],
        pageSize: 10, 
        pageNumber: 1,
        pageList: [10, 20, 30, 40, 50]
	});
	$("#addPhoneBtn").click(function() {
		addOrEditPhoneDialog('add');
	});
	$("#editPhoneBtn").click(function() {
		deletePhoneDialog();
	});
}
function reLoadData() {
	$('#searchItem').val($.trim($("#searchItem").val()));
	
	$("#listDatagrid").datagrid("load",{
		searchItem : $("#searchItem").val()
	});
}