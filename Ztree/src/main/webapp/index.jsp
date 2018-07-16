<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<base href="<%=basePath%>" />
<meta charset="UTF-8">
<title>新建项目</title>
<link rel="stylesheet" href="css/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="js/jquery.ztree.all.min.js"></script>
<SCRIPT type="text/javascript">
	var curMenu = null, zTree_Menu = null;
	var setting = {
		data : {
			simpleData : {
				enable : true,
				pIdKey: "pid",
			}
		},
		edit: {
			enable: true,
			showRemoveBtn: false,
			showRenameBtn: false,
		},
		callback : {
			onClick: zTreeOnClick,
			beforeDrag: zTreeBeforeDrag,
			onDrop: zTreeOnDrop
		},
		check: {
			enable: true,
			chkboxType: { "Y": "ps", "N": "ps" },
			
		}
	};
	function zTreeBeforeDrag(treeId, treeNodes) {
		return !treeNodes[0].isParent;
	};
	function zTreeOnDrop(event, treeId, treeNodes, targetNode, moveType) {
		console.log("本次移动的tree是："+treeNodes[0].name+"|"+treeNodes[0].id+"|"+treeNodes[0].pid);
		$.ajax({
			type:"POST",
			url:"indexController/updataZtree.ajax",
			data:{
				id:treeNodes[0].id,
				pid:treeNodes[0].pid==null? 0:treeNodes[0].pid
			},
			dataType:"text",
			success:function(result){
				if(result=="erro"){
					alert("修改失败")
				}else{
					console.log(result)
				}
			},
			erro:function(){
				
			}
		})	
		
		
	};
	var zNodes = [ {
		id : 1,
		pId : 0,
		name : "文件夹",
		open : true
	}, {
		id : 11,
		pId : 1,
		name : "收件箱"
	}, {
		id : 111,
		pId : 11,
		name : "收件箱1"
	}, {
		id : 112,
		pId : 111,
		name : "收件箱2"
	}, {
		id : 113,
		pId : 112,
		name : "收件箱3"
	}, {
		id : 114,
		pId : 113,
		name : "收件箱4"
	}, {
		id : 12,
		pId : 1,
		name : "垃圾邮件"
	}, {
		id : 13,
		pId : 1,
		name : "草稿"
	}, {
		id : 14,
		pId : 1,
		name : "已发送邮件"
	}, {
		id : 15,
		pId : 1,
		name : "已删除邮件"
	}, {
		id : 3,
		pId : 0,
		name : "快速视图"
	}, {
		id : 31,
		pId : 3,
		name : "文档"
	}, {
		id : 32,
		pId : 3,
		name : "照片"
	} ];


	
	function zTreeOnClick(event, treeId, treeNode) {
		var treeObj = $.fn.zTree.getZTreeObj(treeId);
		treeObj.expandNode(treeNode);
		console.log(treeNode.tId + ", " + treeNode.name);
	};
	


	$(document).ready(function() {
		var treeObj = $("#treeDemo");

		$.ajax({
			type : "post",
			url : "indexController/getTree.ajax",
			async:false,
			data : {

			},
			dataType : "text",
			success : function(result) {
				console.log(result);
				var znodes = eval("(" + result + ")");
				$.fn.zTree.init(treeObj, setting, znodes);
			},
			error : function() {
				$.fn.zTree.init(treeObj, setting, zNodes);
			}
		});
		$("#checkboxs").click(function(){
			var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
			//var nodes = treeObj.getCheckedNodes(true);
			var nodes = treeObj.getChangeCheckedNodes();
			function treeNode(id,checked) {
				this.id = id;
				this.checked = checked;
			}
			var nodeArry=[];
			for (i in nodes) {
				nodeArry.push(new treeNode(nodes[i].id,nodes[i].checked))
			};
			$.ajax({
				type:"post",
				url:"indexController/updataCheck.ajax",
				data:{
					nodes:JSON.stringify(nodeArry)
				},
				dataType:"text",
				success:function(result){
					alert(result);
				},
				error:function(){
					
				}
			});	
			for (i in nodes) {
				console.log(nodes[i].name)
			}
		});
		
	});
</SCRIPT>

</head>

<body>
	<div>
		<ul id="treeDemo" class="ztree"></ul>
		<button id="checkboxs">提交checkbox</button>
	</div>
</body>
</html>