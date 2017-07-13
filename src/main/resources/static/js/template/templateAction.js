$("[rel=tooltip]").tooltip();
var templateConfigCombo = [{"id":1, "text":"即时类短信", "selected":true},{"id":2, "text":"营销类短信"},{"id":3, "text":"验证码类短信"}]; 
var cityCombo = [{"id":0, "text":"全国", "selected":true},{"id":1, "text":"北京"},{"id":2, "text":"上海"}];
var bussinessCombo = [{"id":0, "text":"全部", "selected":true},{"id":1, "text":"CC"},{"id":2, "text":"团车节"}];
var systemCombo = [{"id":0, "text":"全部", "selected":true},{"id":1, "text":"ERP"},{"id":2, "text":"ECP"}];

$(function() {
	SMS_LAYOUT_LOAD("(新建模板)");
	page_init();
});
function page_init() {
	
	$("#templateForm #templateConfigId").combobox({
		width: 100,
		valueField: 'id',
		textField: 'text',
		data: templateConfigCombo
	});
	
	$('#templateForm #templateName').validatebox({
		required : true,
		prompt:'请输入模板名称'
	});
	
	$('#templateForm #limitWordCounts').validatebox({
		required : true,
		min: 1
	});
	
	$("#templateForm #templateCityIds").textbox({
		multiline:true,
		disabled: true,
		cls: "my-textarea-disable-background"
	});
	
	$("#templateForm #cityCombo").combobox({
		width: 100,
		multiple:true,
		valueField: 'id',
		textField: 'text',
		data: cityCombo
	});
	
	$("#templateForm #templateBusinessIds").textbox({
		multiline:true,
		disabled: true,
		cls: "my-textarea-disable-background"
	});
	
	$("#templateForm #bussinessCombo").combobox({
		width: 100,
		multiple:true,
		valueField: 'id',
		textField: 'text',
		data: bussinessCombo
	});
	
	$("#templateForm #templateSystemIds").textbox({
		multiline:true,
		disabled: true,
		cls: "my-textarea-disable-background"
	});
	
	$("#templateForm #systemCombo").combobox({
		width: 100,
		multiple:true,
		valueField: 'id',
		textField: 'text',
		data: systemCombo
	});
	
	$("#templateForm #templateContent").textbox({
		multiline:true
	});
	
	$('#addParamBtn').linkbutton({});
	
	$("#addParamBtn").click(function() {
		reLoadData();
	});
	
	$('#addMultParamBtn').linkbutton({});
	
	$("#addMultParamBtn").click(function() {
		reLoadData();
	});
	
	$("#templateForm #extraMemo").textbox({
		multiline:true
	});
	
	$("#templateForm #preview").textbox({
		multiline:true,
		disabled: true,
		cls: "my-textarea-disable-background"
	});
	
	$('#submitBtn').linkbutton({});
	
	$("#submitBtn").click(function() {
		reLoadData();
	});
	
	$('#cancelBtn').linkbutton({});
	
	$("#cancelBtn").click(function() {
		reLoadData();
	});
}