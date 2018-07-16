/**
 * 
 */

layui.use([ 'layer', 'form' ], function() {
			var layer = layui.layer, form = layui.form;
			form.on('select(myselect2)', function(data) {
				var bigtypeName = $("#quiz3").val();
				$.ajax({
					type : 'POST',
					url : 'propertyController/returnMalltypeName.ajax',
					data : {
						"bigtypeName" : bigtypeName
					},
					dataType : 'json',
					success : function(allproperty) {
						var str = "";
						$("#quiz4").empty();
						str += "<option>----从已有分类选择----</option>"
						$("#quiz4").html(str);

						for (var i = 0; i < allproperty.length; i++) {
							var property = allproperty[i];
							$("#quiz4").append(
									"<option >" + property.malltypeName
											+ "</option>");
							form.render('select');
							$("#quiz4").get(0).selectedIndex = 0;
						}
					},
					error : function(msg) {
						alert("无法连接服务器");
					}
				});
			});
			
			//22
			form.on('select(myselect3)', function(data) {
				var malltypeName = $("#quiz4").val();
				$.ajax({
					type : 'POST',
					url : 'propertyController/returnPropertyName.ajax',
					data : {
						"malltypeName" : malltypeName
					},
					dataType : 'json',
					success : function(allproperty) {
						var str = "";
						$("#quiz1").empty();
						str += "<option>----从已有资产选择----</option>"
						$("#quiz1").html(str);

						for (var i = 0; i < allproperty.length; i++) {
							var property = allproperty[i];
							$("#quiz1").append(
									"<option >" + property.propertyName
											+ "</option>");
							form.render('select');
							$("#quiz1").get(0).selectedIndex = 0;
						}
					},
					error : function(msg) {
						alert("无法连接服务器");
					}
				});
			});
			//33
			form.on('select(myselect)', function(data) {
				var propertyName = $("#quiz1").val();
				$.ajax({
					type : 'POST',
					url : 'applyController/returnType.do',
					data : {
						"propertyName" : propertyName
					},
					dataType : 'json',
					success : function(allproperty) {
						var str = "";
						$("#quiz2").empty();
						str += "<option>----从已有型号选择----</option>"
						$("#quiz2").html(str);

						for (var i = 0; i < allproperty.length; i++) {
							var property = allproperty[i];
							$("#quiz2").append(
									"<option >" + property.type + "</option>");
							form.render('select');
							$("#quiz2").get(0).selectedIndex = 0;
						}
					},
					error : function(msg) {
						alert("无法连接服务器");
					}
				});
			});
		});