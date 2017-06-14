<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!--引入CSS-->
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/webuploader/css/webuploader.css" />">

<link rel="stylesheet" type="text/css" href="<c:url value="/resources/webuploader/css/single.css" />">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/ueditor/themes/default/css/ueditor.min.css" />">

<!-- BEGIN SAMPLE FORM PORTLET-->
<div class="portlet box green">
    <div class="portlet-title">
        <div class="caption">
        	<i class="icon-settings"></i>
				<span><i class="fa fa-angle-right"></i>
				详情</span>
        </div>
        <div class="actions">
			<a class="btn btn-circle btn-icon-only btn-default" href="<c:url value='/admin/tuser/get?mid='/>${entity.mid}">
				<i class="icon-cloud-upload"></i>
			</a>
    	</div>
    </div>
    <div class="portlet-body form">
        <form class="form-horizontal" id="editForm" method="post" action="<c:url value='/admin/tuser/put'/>" autocomplete="off">
			<div class="form-body">
	            <div class="form-group">
	                <label class="col-md-1 control-label" for="userId">用户编号</label>
	                <div class="col-md-4">
	                    <input type="text"  name="userId" value="${entity.userId}" class="form-control" >
					</div>
	            </div>
	
	            <div class="form-group">
	                <label class="col-md-1 control-label" for="username">用户帐号</label>
	                <div class="col-md-4">
	                    <input type="text" placeholder="用户帐号" name="username"  value="${entity.username}"  class="form-control"> </div>
	            </div>
	            
	            <div class="form-group">
	                <label class="col-md-1 control-label" for="name">真实姓名</label>
	                <div class="col-md-4">
	                    <input type="text" placeholder="真实姓名" name="name" value="${entity.name}"  class="form-control"> </div>
	            </div>
	
	            <div class="form-group">
	                <label class="col-md-1 control-label" for="nick">昵&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称</label>
	                <div class="col-md-4">
	                    <input type="text" placeholder="昵&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称" name="nick" value="${entity.nick}" class="form-control"> </div>
	            </div>
	
				 <div class="form-group">
	                <label class="col-md-1 control-label" for="avatar">头&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;像</label>
	                <div class="col-md-4">
	                    <div id="uploader-single">
	                        <div style="width: 150px; height: 100px;" class="thumbnail" id="filelist">
	                            <img src="${applicationScope.commConfig['img_comm_url'] }${entity.avatar }" style="width: 150px; height: 90px;" alt="" id="imgUrl2" name="imgUrl2" >
	                        </div>
	                        <div id="singleBtn">选择图片</div>
	                    </div>
	                </div>
	                <input type="hidden" name="avatar" id="imgUrl" value="${entity.avatar }"/>
	            </div>
	
	            <div class="form-group">
	                <label class="col-md-1 control-label" for="idcard">身&nbsp;&nbsp;份&nbsp;&nbsp;证</label>
	                <div class="col-md-4">
	                    <input type="text" maxlength="18" placeholder="身&nbsp;&nbsp;份&nbsp;&nbsp;证" name="idcard"  value="${entity.idcard}" class="form-control"> </div>
	            </div>
	
	            <div class="form-group">
	                <label class="col-md-1 control-label" for="email">邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱</label>
	                <div class="col-md-4">
	                    <input type="text" placeholder="邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱" name="email" value="${entity.email}" class="form-control">
	                </div>
	            </div>
	            
	            <div class="form-group">
	                <label class="col-md-1 control-label" for="mobile">手&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;机</label>
	                <div class="col-md-4">
	                    <input type="text" maxlength="11" placeholder="手&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;机" name="mobile" value="${entity.mobile}" class="form-control">
	                </div>
	            </div>
	            
	            <div class="form-group">
	                <label class="col-md-1 control-label" for="userType">用户类型</label>
	                <div class="col-md-4">
	                	<select name="userType" id="userType" class="form-control">
		                	<c:if test="${entity.userType == 2}">
		                		<option value="2" selected="selected">个&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;人</option>
	                			<option value="1">企&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;业</option>
		                	</c:if>
		                	<c:if test="${entity.userType == 1}">
		                		<option value="2">个&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;人</option>
		                		<option value="1" selected="selected">企&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;业</option>
		                	</c:if>
	                	</select>
<!-- 	                	<input type="text" id="userTypeInput" class="form-control"> -->
	                </div>
	            </div>
	
			</div>
            
            <div class="form-actions">
	            <div class="row">
	                <div class="col-md-offset-1 col-md-10">
<!-- 	                	<button class="btn btn-lg blue" type="button" id="update" onclick="updateAfter();">修 改</button> -->
	                    <button class="btn btn-lg blue" type="submit" id="subBtn">提  交</button>
	                    <button class="btn btn-lg blue" type="button" onclick="deleteOne(${entity.userId});">删 除</button>
	                    <a class="btn btn-lg grey-salsa" href="javascript:history.go(-1);">返回</a>
	                </div>
	            </div>
             </div>
            
        </form>
    </div>
</div>
<!-- END SAMPLE FORM PORTLET-->

<!--引入JS-->
<script type="text/javascript" charset="utf-8" src="<c:url value="/resources/ueditor/ueditor.config.js" />"></script>
<script type="text/javascript" charset="utf-8" src="<c:url value="/resources/ueditor/ueditor.all.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/ueditor/lang/zh-cn/zh-cn.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/admin/global/plugins/jquery-validation/js/jquery.validate.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/admin/global/plugins/jquery-validation/js/additional-methods.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/webuploader/js/webuploader.js" />"></script>

<script type="text/javascript">
	var selectText ;
	
	function updateBefore(){
// 		$("#userTypeInput").val(selectText);
// 		$("input").attr("style","border:0");
		$("input[name='userId']").attr("style","border:0");
		$("input[name='username']").attr("style","border:0");
// 		$("select").hide();
// 		$("#singleBtn").hide();
// 		$("#subBtn").hide();
// 		$("#update").show();
	}
	
	function updateAfter(){
		$("input").removeAttr("style");
		$("#userTypeInput").hide();
		$("input[name='userId']").attr("style","border:0");
		$("input[name='username']").attr("style","border:0");
		$("select").show();
		$("#singleBtn").show();
		$("#subBtn").show();
		$("#update").hide();
	}
    // 图片上传
    $(document).ready(function(){ 
    	selectText = $('#userType option:selected').text();
    	
        handleValidation();
	        $opt={		
				serverUrl:'<c:url value="/admin/image/saveEditorImg" />',
				imageActionName: "uploadimage", /* 执行上传图片的action名称 */
			    imageFieldName: "upfile", /* 提交的图片表单名称 */
			    imageMaxSize: 2048000, /* 上传大小限制，单位B */
			    imageAllowFiles: [".png", ".jpg", ".jpeg", ".gif", ".bmp"], /* 上传图片格式显示 */
			    //imageCompressEnable: true, /* 是否压缩图片,默认是true */
			   // imageCompressBorder: 1600, /* 图片压缩最长边限制 */
			    imageInsertAlign: "none", /* 插入的图片浮动方式 */
			    imageUrlPrefix: "", /* 图片访问路径前缀 */
			    imagePathFormat: ""
			};
			var $js_loan_windInfo = UE.getEditor('allText',$opt);
        // 初始化Web Uploader
        var single = WebUploader.create({
            // 自动上传。
            fileVal:'imgFile',
            // 自动上传。
            auto: true,
            compress: false,
            // swf文件路径
            swf: '<c:url value="/resources/webuploader/js/Uploader.swf" />',
            // 文件接收服务端。
            server: '<c:url value="/admin/image/saveCommImg" />',
            // 选择文件的按钮。可选。
            // 内部根据当前运行是创建，可能是input元素，也可能是flash.
            pick: {
                id: '#singleBtn',
                label: '点击选择图片'
            },
            //文件数量
            fileNumLimit: 2,
            fileSingleSizeLimit: 5 * 1024 * 1024,    // 5M
            // 只允许选择文件，可选。
            accept: {
                title: 'Images',
                extensions: 'gif,jpg,jpeg,bmp,png',
                mimeTypes: 'image/*'
            }
        });

        // 当有文件添加进来的时候
        single.on( 'fileQueued', function( file ) {
            single.makeThumb( file, function( error, src ) {
                if ( error ) {
                    $("#imgUrl2").replaceWith('<span>不能预览</span>');
                    return;
                }
                $.each(single.getFiles(),function() {
                    if(file.name!=this.name)
                        single.removeFile( this );
                });
              //  alert(file.size)
                $("#imgUrl2").attr( 'src', src );
            });
        });

        // 文件上传成功，提交表单
        single.on( 'uploadSuccess', function( file ,json) {
            $('#imgUrl').val(json.name);
        });

        // 文件上传失败，现实上传出错。
        single.on( 'uploadError', function( file ) {
            alert("图片上传失败.")
        });
        updateBefore();
    });


    // basic validation
    var handleValidation = function() {

        var form1 = $('#editForm');
        var error1 = $('.alert-danger', form1);
        var success1 = $('.alert-success', form1);
        form1.validate({
            errorElement : 'span', //default input error message container
            errorClass : 'help-block help-block-error', // default input error message class
            focusInvalid : false, // do not focus the last invalid input
            ignore : "", // validate all fields including form hidden input
            rules : {
            	username : {
                    required : true
                },
                name : {
                    required : true
                },
                nick : {
                  required : true
                },
                avatar : {
                  required : true
                },
                idcard : {
                  required : true
                },
                email : {
                    required : true,
                    email:true
                },
                mobile : {
                    required : true
                }
            },
			messages : {
				username : {
                    required : "必须输入用户账号",
              	},
              	name : {
                    required : "必须输入真实姓名"
              	},
                nick : {
                    required : "必须输入昵称"
                },
                avatar : {
                  required : "必须上传头像"
                },
                idcard : {
                  required : "必须输入身份证"
                },
                email : {
                    required : "必须输入邮箱",
                    email:"邮箱格式不正确"
                },
                mobile : {
                    required : "必须输入手机"
                }
			},
            invalidHandler : function(event, validator) { //display error alert on form submit
                success1.hide();
                error1.show();
            },

            highlight : function(element) { // hightlight error inputs
                $(element).closest('.form-group').addClass('has-error'); // set error class to the control group
            },

            unhighlight : function(element) { // revert the change done by hightlight
                $(element).closest('.form-group').removeClass('has-error'); // set error class to the control group
            },

            success : function(label) {
                label.closest('.form-group').removeClass('has-error'); // set success class to the control group
            },

            submitHandler : function(form) {
                success1.show();
                error1.hide();
                if(confirm("你确定提交吗！")) {
                	var formData = {
                			userId:$("input[name='userId']").val(),
                			username:$("input[name='username']").val(),
                			name:$("input[name='name']").val(),
                			nick:$("input[name='nick']").val(),
                			avatar:$("input[name='avatar']").val(),
                			idcard:$("input[name='idcard']").val(),
                			email:$("input[name='email']").val(),
                			mobile:$("input[name='mobile']").val(),
                			userType:$('#userType option:selected').val()
                	};
                	$.post("<c:url value='/admin/tuser/put'/>",formData,function(data){
                		var dat = $.parseJSON( data );
                	    alert(dat.msg);
                	    if(dat.result){
                	    	window.location.href = "<c:url value='/admin/tuser/get?mid='/>"+${entity.mid};
                	    }
                	});
                }
            }
        });
    }
    
    function deleteOne(id){
    	var formData = {userId:id};
    	$.post("<c:url value='/admin/tuser/delete'/>",formData,function(data){
    		var dat = $.parseJSON( data );
    	    alert(dat.msg);
    	    if(dat.result){
    	    	window.location.href = "<c:url value='/admin/tuser/get?mid='/>"+${entity.mid};
    	    }
    	});
    }

</script>