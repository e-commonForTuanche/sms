// 菜单基础数据
var MENU_BASIC_OBJ = {
  "template/templateList.html"   : {menuLevel: "menu",            menuText: "模板管理"}
, "template/templateAction.html" : {menuLevel: "page",            menuText: "模板管理{pageActionText}"}
, "task/taskList.html"           : {menuLevel: "menu",            menuText: "定时任务"}
, "statistics/phoneList.html#"   : {menuLevel: "menu",            menuText: "数据统计"}
, "statistics/phoneList.html"    : {menuLevel: "childMenu first", menuText: "手机号查数据"}
, "statistics/replyList.html"    : {menuLevel: "childMenu",       menuText: "查看上行"}
, "statistics/supplierList.html" : {menuLevel: "childMenu",       menuText: "供应商统计"}
, "statistics/cityList.html"     : {menuLevel: "childMenu",       menuText: "城市统计"}
, "statistics/messageList.html"  : {menuLevel: "childMenu last",  menuText: "综合统计"}
, "system/blackList.html"        : {menuLevel: "menu",            menuText: "黑名单管理"}
, "system/wordList.html"         : {menuLevel: "menu",            menuText: "敏感词管理"}
};

/**
 * 加载公共布局内容
 */
function SMS_LAYOUT_LOAD(pageActionText) {
	// 加载内容中导航部分
	$("#baseContentDiv").prepend(SMS_LAYOUT_LOAD_NAVIGATION_CONTENT(pageActionText));
	
	// 加载左侧菜单
	$("body").prepend(SMS_LAYOUT_LOAD_LEFT());
	
	// 加载头部内容
	$("body").prepend(SMS_LAYOUT_LOAD_TOP());
}
/**
 * 加载头部内容
 * @returns {String}
 */
function SMS_LAYOUT_LOAD_TOP() {
	var html = '';
	html += '<div class="navbar">';
	html += '  <div class="navbar-inner">';
	html += '    <ul class="nav pull-right">';
	html += '      <li id="fat-menu" class="dropdown">';
	html += '          <a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown">';
	html += '              <i class="icon-user"></i> 用户名';
	html += '              <i class="icon-caret-down"></i>';
	html += '          </a>';
	html += '          <ul class="dropdown-menu">';
	html += '              <li><a tabindex="-1" href="#">My Account</a></li>';
	html += '              <li class="divider"></li>';
	html += '              <li><a tabindex="-1" class="visible-phone" href="#">Settings</a></li>';
	html += '              <li class="divider visible-phone"></li>';
	html += '              <li><a tabindex="-1" href="sign-in.html">Logout</a></li>';
	html += '          </ul>';
	html += '      </li>';
	html += '    </ul>';
	html += '    <a class="brand" href="/main"><span class="first">团车</span> <span class="second">短信平台</span></a>';
	html += '  </div>';
	html += '</div>';
	return html;
}

/**
 * 加载左侧菜单
 * @returns {String}
 */
function SMS_LAYOUT_LOAD_LEFT() {
	var html = '';
    html += '<div class="sidebar-nav">';
    $.each(MENU_BASIC_OBJ, function(menuPath, menuObj) {
    	
    	if (menuObj.menuLevel == 'menu') {
    		html += '  <a href="load?htmlFile=' + menuPath + '" class="nav-header" >' + menuObj.menuText + '</a>';
    	} else if (menuObj.menuLevel.indexOf('childMenu') > -1) {
    		if (menuObj.menuLevel.indexOf('first') > -1) {
    			html += '<ul id="dashboard-menu" class="nav nav-list collapse in">';
    		}
    		
    		html += '<li><a href="load?htmlFile=' + menuPath + '">' + menuObj.menuText + '</a></li>';
    		
    		if (menuObj.menuLevel.indexOf('last') > -1) {
    			html += '</ul>';
    		}
    	}
    });
    html += '</div>';
	return html;
}

/**
 * 加载内容中导航部分
 * @returns {String}
 */
function SMS_LAYOUT_LOAD_NAVIGATION_CONTENT(pageActionText) {
	var html = '';
	var menuName = '首页';
	if (typeof(MENU_BASIC_OBJ[$.getUrlParam('htmlFile')]) != "undefined") {
		menuName = MENU_BASIC_OBJ[$.getUrlParam('htmlFile')].menuText;
		
		if (pageActionText) {
			menuName = menuName.replace("{pageActionText}", pageActionText);
		}
	}
    html += '  <ul class="breadcrumb">';
    if (menuName == '首页') {
    	html += '    <li><a href="main.html">首页</a></li>';
    } else {
    	html += '    <li><a href="main.html">首页</a> <span class="divider">/</span></li>';
    	html += '    <li class="active">' + menuName + '</li>';
    }
    html += '  </ul>';
    return html;
}