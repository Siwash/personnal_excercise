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
			hrefFormer : 'applyController/showApplyByUserName',
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

function maintain_finish(obj,maintainId) {
	layer.confirm('确认要提交报告吗？', function(index) {
		if ($(obj).attr('title') == '维修完成') {
			//发异步把用户状态进行更改
			$(obj).attr('title', '已提交')
			$(obj).find('i').html('&#xe626;');
			$(obj).parents("tr").find(".td-status").find('span')
					.addClass('layui-btn-disabled').html('已归还');
			layer.msg('提交成功!', {
				icon : 1,
				time : 500
			});
			
			$.ajax({
				type:"post",
				url:"maintainController/maintainFinish.ajax",
				data:{
					maintainId:maintainId
				},
				datatype:"text",
				success:function(result){
					$(obj).parents("tr").find(".td-manage").find('button')
					.addClass('layui-btn-disabled').html('<i class="layui-icon">&#xe605;</i>');
				},
				error:function(){
					alert("无法连接服务器");
				}
			});
		}

	});
}