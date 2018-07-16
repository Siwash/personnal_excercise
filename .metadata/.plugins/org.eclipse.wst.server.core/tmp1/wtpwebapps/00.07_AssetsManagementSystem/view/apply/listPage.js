//init
function arrayPage(pages, total) {
	function getParameter(name) {
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
		var r = window.location.search.substr(1).match(reg);
		if (r != null)
			return unescape(r[2]);
		return null;
	}

	// init
	$(function() {
		var totalPage = pages;
		var totalRecords = total;
		var pageNo = getParameter('pageNumber');
		if (!pageNo) {
			pageNo = 1;
		}
		// 生成分页
		jpager.generPageHtml({
			pno : pageNo,
			// 总页码
			total : totalPage,
			// 总数据条数
			totalRecords : totalRecords,
			// 链接前部
			hrefFormer : 'applyController/showAllapply',
			// 链接尾部
			hrefLatter : '.do',
			getLink : function(n) {
				// alert(n);
				return this.hrefFormer + this.hrefLatter + "?pageNumber=" + n;
			},
		/*
		 * lang : { firstPageText : '|<', lastPageText : '>|', prePageText : '<',
		 * nextPageText : '>', totalPageBeforeText : '共', totalPageAfterText :
		 * '页', totalRecordsAfterText : '条数据', gopageBeforeText : '转到',
		 * gopageButtonOkText : '确定', gopageAfterText : '页', buttonTipBeforeText :
		 * '第', buttonTipAfterText : '页' }
		 */
		// ,
		// mode : 'click',//默认值是link，可选link或者click
		/*
		 * click : function(n){ //this.selectPage(n); alert(n); return false; }
		 */
		});
	});
}

function ajaxc(obj,applyId){
	$.ajax({
		type:"post",
		url:"applyController/updateState.ajax",
		data:{
			applyId:applyId
		},
		datatype:"text",
		success:function(result){
			if(result=="库存不足"){
				$(obj).parents("tr").find(".td-status").find('span')
				.addClass('layui-btn-disabled').html('未批准');
				layer.msg('库存不够，启用失败!', {
					icon : 1,
					time : 500
				});
			}else {
				$(obj).find('i').html('&#xe627;');
				$(obj).parents("tr").find(".td-status").find('span')
				.removeClass('layui-btn-disabled').html('已启用');
				layer.msg('申请成功!', {
					icon : 1,
					time : 500
				});
			}
		},
		error:function(){
			alert("无法连接服务器");
		}
	});
}

function member_stop(obj,applyId) {
	layer.confirm('确认要批准该申请吗？', function(index) {
		if ($(obj).attr('title') == '启用') {
			//发异步把用户状态进行更改
			$(obj).attr('title', '未批准')
			$(obj).find('i').html('&#xe626;');
			$(obj).parents("tr").find(".td-status").find('span')
					.addClass('layui-btn-disabled').html('未批准');
			layer.msg('申请失败!', {
				icon : 1,
				time : 500
			});
			
			$.ajax({
				type:"post",
				url:"applyController/updateStateDo.ajax",
				data:{
					applyId:applyId
				},
				datatype:"text",
				success:function(result){
					
				},
				error:function(){
					alert("无法连接服务器");
				}
			});
		} else {
			$(obj).attr('title', '启用')
			ajaxc(obj,applyId);
			
			
		}

	});
} 
function member_del(obj, applyId) {
	layer.confirm('确认要删除吗？', function(index) {
		//发异步删除数据
		layer.msg('已删除!', {
			icon : 1,
			time : 500
		});
		window.location.href = "applyController/deleteApply.do?applyId="+applyId+"";
		
	});
}		
