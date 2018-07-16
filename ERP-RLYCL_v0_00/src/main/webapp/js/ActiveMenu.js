var obj = [{
	"authorityId": "61",
	"pId": "0",
	"cId": "62",
	"url": "#",
	"img": "images/boss.png",
	"name": "公司重大事宜管理"
}, {
	"authorityId": "62",
	"pId": "61",
	"cId": "-1",
	"url": "#",
	"name": "高额采购审批"
}, {
	"authorityId": "63",
	"pId": "61",
	"cId": "-1",
	"url": "#",
	"name": "采购历史记录"
}, {
	"authorityId": "65",
	"pId": "64",
	"cId": "-1",
	"url": "#",
	"name": "部门列表"
}, {
	"authorityId": "66",
	"pId": "64",
	"cId": "-1",
	"url": "#",
	"name": "部门增加"
}, {
	"authorityId": "67",
	"pId": "64",
	"cId": "-1",
	"url": "#",
	"name": "部门删除"
}, {
	"authorityId": "68",
	"pId": "64",
	"cId": "-1",
	"url": "#",
	"name": "部门修改"
}, {
	"authorityId": "64",
	"pId": "61",
	"cId": "65",
	"url": "#",
	"img": "images/adddepart.png",
	"name": "部门管理"
}, {
	"authorityId": "69",
	"pId": "61",
	"cId": "-1",
	"url": "#",
	"name": "特长请假审批"
}, {
	"authorityId": "01",
	"pId": "0",
	"cId": "02",
	"url": "#",
	"img": "images/sale.png",
	"name": "销售管理"
}, {
	"authorityId": "02",
	"pId": "01",
	"cId": "-1",
	"url": "#",
	"name": "销售单列表"
}, {
	"authorityId": "03",
	"pId": "01",
	"cId": "-1",
	"url": "#",
	"name": "销售单检索"
}, {
	"authorityId": "04",
	"pId": "01",
	"cId": "-1",
	"url": "#",
	"name": "销售单核算"
}];
var node = {
	"authorityId": "0"
};
//alert(node.child)
var nodes = [];
nodes.push(node);
//生成ztree类型的json
function getTree(obj, root) {
	for(var x in obj) {
		if(obj[x].pId == root.authorityId) {
			if(root.child == undefined) {
				root.child = [];
				root.name="&nbsp;"+root.name;
			}
			root.child.push(obj[x]);
			getTree(obj, obj[x]);
		}
	}
	return root;
}
//递归任意级的子菜单
function forEachNode(node) {
	var childMenu = "";
	var nodeprefix = "<li>";
	var nodesuffix = "</li>"
	if(node != undefined) {
		if(node.child == undefined) {
			childMenu += "<a _href=" + node.url + "> <i class='iconfont'>&#xe6a7;</i> <cite>" + node.name + "</cite></a>";
		} else {
			childMenu += "<a href='javascript:;'><img class='left-menu-icon' src=" + node.img + "><cite>" + node.name + "</cite><i class='iconfont nav_right'>&#xe697;</i></a>";
			childMenu += "<ul class='sub-menu'>";
			nodesuffix = "</ul>" + nodesuffix;
			for(var i in node.child) {
				childMenu += forEachNode(node.child[i]);
			}
		}
	}
	var htmlCode = nodeprefix + childMenu + nodesuffix;
	//console.log(htmlCode);
	return htmlCode;
}
//获得递归任意级子菜单后的代码
function getMenuCode(json, rootNum) {
	var menus = "";
	for(var i in json) {
		if(json[i].pId == rootNum) {
			menus += forEachNode(json[i]);
		}
	}
	return menus;
}
//最初版思路
function showTreeMenu(json, nodeNum) {
	var menus = "";
	for(var i in json) {
		var menu = "";
		var prefix = "<li>";
		var suffix = "</li>";
		if(json[i].pId == nodeNum && json[i].cId != [-1]) {

			menu += "<a href='javascript:;'> <img src=" + json[i].img + " class='left-menu-icon'> <cite>" + json[i].name + "</cite> <i class='iconfont nav_right'>&#xe697;</i></a>";
			var childNode = json[i].child;
			if(childNode != undefined) {
				menu += "<ul class='sub-menu'>";
				suffix = "</ul>" + suffix;
				for(var j in childNode) {
					if(childNode[j].child == undefined) {
						menu += "<li><a _href=" + childNode[j].url + "> <i class='iconfont'>&#xe6a7;</i> <cite>" + childNode[j].name + "</cite></a></li>";

					} else {
						var childMenu = "";
						var nodeprefix = "<li>";
						var nodesuffix = "</li>"
						childMenu += "<a href='javascript:;'><img class='left-menu-icon' src=" + childNode[j].img + "><cite>" + childNode[j].name + "</cite><i class='iconfont nav_right'>&#xe697;</i></a>";
						var grandchild = childNode[j].child;
						childMenu += "<ul class='sub-menu'>";
						nodesuffix = "</ul>" + nodesuffix;
						for(var k in grandchild) {
							if(grandchild[k].child == undefined) {

								childMenu += "<li><a _href=" + grandchild[k].url + "> <i class='iconfont'>&#xe6a7;</i><cite>" + grandchild[k].name + "</cite></a></li>";

							}
						}

						menu += nodeprefix + childMenu + nodesuffix;
					}
				}
			}

		}
		menu = prefix + menu + suffix;
		menus += menu;
	}
	return menus;
}

function initMenu(URL) {
	$.ajax({
		type: "post",
		url: URL,
		async:false,
		data: {},
		dataType: "text",
		success: function(result) {
			obj = JSON.parse(result);
			var json = getTree(obj, nodes[0]);
			var menu = getMenuCode(json.child, json.authorityId);
			$("#nav").append(menu);
		},
		error:function(){
			alert("无法请求服务器")
		}
	});
}

