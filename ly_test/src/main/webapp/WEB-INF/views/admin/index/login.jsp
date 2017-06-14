<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>

<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
    <!--<![endif]-->
    <!-- BEGIN HEAD -->

    <head>
        <meta charset="utf-8" />
        <title>后台用户登录</title>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta content="width=device-width, initial-scale=1" name="viewport" />
        <meta content="" name="description" />
        <meta content="" name="author" />
        <!-- BEGIN GLOBAL MANDATORY STYLES -->
        <link href="<c:url value="/resources/admin/global/plugins/font-awesome/css/font-awesome.min.css" />" rel="stylesheet" type="text/css" />
		<link href="<c:url value="/resources/admin/global/plugins/simple-line-icons/simple-line-icons.min.css" />" rel="stylesheet" type="text/css" />
		<link href="<c:url value="/resources/admin/global/plugins/bootstrap/css/bootstrap.min.css" />" rel="stylesheet" type="text/css" />
		<link href="<c:url value="/resources/admin/global/plugins/uniform/css/uniform.default.css" />" rel="stylesheet" type="text/css" />
		<link href="<c:url value="/resources/admin/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css" />" rel="stylesheet" type="text/css" />
        <!-- END GLOBAL MANDATORY STYLES -->
        <!-- BEGIN PAGE LEVEL PLUGINS -->
        <link href="<c:url value="/resources/admin/global/plugins/select2/css/select2.min.css" />" rel="stylesheet" type="text/css" />
        <link href="<c:url value="/resources/admin/global/plugins/select2/css/select2-bootstrap.min.css" />" rel="stylesheet" type="text/css" />
        <!-- END PAGE LEVEL PLUGINS -->
        <!-- BEGIN THEME GLOBAL STYLES -->
        <link href="<c:url value="/resources/admin/global/css/components.min.css" />" rel="stylesheet" id="style_components" type="text/css" />
		<link href="<c:url value="/resources/admin/global/css/plugins.min.css" />" rel="stylesheet" type="text/css" />
        <!-- END THEME GLOBAL STYLES -->
        <!-- BEGIN PAGE LEVEL STYLES -->
        <link href="<c:url value="/resources/admin/pages/css/login.min.css" />" rel="stylesheet" type="text/css"/>
        <!-- END PAGE LEVEL STYLES -->
        <!-- BEGIN THEME LAYOUT STYLES -->
        <!-- END THEME LAYOUT STYLES -->
        <link rel="shortcut icon" href="<c:url value="/resources/comm/img/favicon.ico" />"/>
    <!-- END HEAD -->

    <body class=" login">
        <!-- BEGIN LOGO 
        <div class="logo">
            <a href="index.html">
                <img src="<c:url value="/resources/admin/pages/img/logo-big.png" />" alt="" /> </a>
        </div>
        END LOGO -->
        <!-- BEGIN LOGIN -->
        <div class="content">
            <!-- BEGIN LOGIN FORM -->
            <form class="login-form" action="<c:url value="/j_spring_security_check" />" method="post">
                <h3 class="form-title font-green">后台管理系统</h3>
                <div class="alert alert-danger 		
                <c:if test="${sessionScope['SPRING_SECURITY_LAST_EXCEPTION'].message==null}">
		 		display-hide
				</c:if>">
                    <button class="close" data-close="alert"></button>
                    <span> ${sessionScope['SPRING_SECURITY_LAST_EXCEPTION'].message}. </span>
                </div>
                <div class="form-group">
                    <!--ie8, ie9 does not support html5 placeholder, so we just show field title for that-->
                    <label class="control-label visible-ie8 visible-ie9">帐号</label>
                    <input class="form-control form-control-solid placeholder-no-fix" type="text" autocomplete="off" placeholder="帐号" name="j_username" value="admin"  /> </div>
                <div class="form-group">
                    <label class="control-label visible-ie8 visible-ie9">密码</label>
                    <input class="form-control form-control-solid placeholder-no-fix" type="password" autocomplete="off" placeholder="密码" name="j_password"  value="123456" /> </div>
                <div class="form-group">
					<!--ie8, ie9 does not support html5 placeholder, so we just show field title for that-->
					<label class="control-label visible-ie8 visible-ie9">验证码</label>
					<div class="input-group ">
						<input class="form-control form-control-solid placeholder-no-fix" type="text" placeholder="验证码(4位)" name="j_code">
						<span class="input-group-btn">
						<img id="kImage" alt="" src="<c:url value="/admin/login/startCaptcha" />"/>
						</span>					
						<a id="refreshBtn" class="input-group-addon">
						<i class="fa fa-refresh"></i>
						</a>
					</div>
				</div>
                     
                <div class="form-actions">
                    <button type="submit" class="btn green uppercase">登录</button>
                    <label class="rememberme check">
                        <input type="checkbox" name="remember" value="1" />记住我 </label>
                   
                </div>
                <div class="create-account">
                    <!-- <p>
                        <a href="javascript:;" id="register-btn" class="uppercase">建立账号</a>
                    </p> -->
                </div>
            </form>
            <!-- END LOGIN FORM -->
            <!-- BEGIN FORGOT PASSWORD FORM -->
            <form class="forget-form" action="http://www.keenthemes.com/preview/metronic/theme/admin_2/index.html" method="post">
                <h3 class="font-green">Forget Password ?</h3>
                <p> Enter your e-mail address below to reset your password. </p>
                <div class="form-group">
                    <input class="form-control placeholder-no-fix" type="text" autocomplete="off" placeholder="Email" name="email" /> </div>
                <div class="form-actions">
                    <button type="button" id="back-btn" class="btn btn-default">Back</button>
                    <button type="submit" class="btn btn-success uppercase pull-right">Submit</button>
                </div>
            </form>
            <!-- END FORGOT PASSWORD FORM -->
            <!-- BEGIN REGISTRATION FORM -->
            <form class="register-form" action="http://www.keenthemes.com/preview/metronic/theme/admin_2/index.html" method="post">
                <h3 class="font-green">Sign Up</h3>
                <p class="hint"> Enter your personal details below: </p>
                <div class="form-group">
                    <label class="control-label visible-ie8 visible-ie9">Full Name</label>
                    <input class="form-control placeholder-no-fix" type="text" placeholder="Full Name" name="fullname" /> </div>
                <div class="form-group">
                    <!--ie8, ie9 does not support html5 placeholder, so we just show field title for that-->
                    <label class="control-label visible-ie8 visible-ie9">Email</label>
                    <input class="form-control placeholder-no-fix" type="text" placeholder="Email" name="email" /> </div>
                <div class="form-group">
                    <label class="control-label visible-ie8 visible-ie9">Address</label>
                    <input class="form-control placeholder-no-fix" type="text" placeholder="Address" name="address" /> </div>
                <div class="form-group">
                    <label class="control-label visible-ie8 visible-ie9">City/Town</label>
                    <input class="form-control placeholder-no-fix" type="text" placeholder="City/Town" name="city" /> </div>
                <div class="form-group">
                    <label class="control-label visible-ie8 visible-ie9">Country</label>
                   
                </div>
                <p class="hint"> Enter your account details below: </p>
                <div class="form-group">
                    <label class="control-label visible-ie8 visible-ie9">Username</label>
                    <input class="form-control placeholder-no-fix" type="text" autocomplete="off" placeholder="Username" name="username" /> </div>
                <div class="form-group">
                    <label class="control-label visible-ie8 visible-ie9">Password</label>
                    <input class="form-control placeholder-no-fix" type="password" autocomplete="off" id="register_password" placeholder="Password" name="password" /> </div>
                <div class="form-group">
                    <label class="control-label visible-ie8 visible-ie9">Re-type Your Password</label>
                    <input class="form-control placeholder-no-fix" type="password" autocomplete="off" placeholder="Re-type Your Password" name="rpassword" /> </div>
                <div class="form-group margin-top-20 margin-bottom-20">
                    <label class="check">
                        <input type="checkbox" name="tnc" /> I agree to the
                        <a href="javascript:;"> Terms of Service </a> &
                        <a href="javascript:;"> Privacy Policy </a>
                    </label>
                    <div id="register_tnc_error"> </div>
                </div>
                <div class="form-actions">
                    <button type="button" id="register-back-btn" class="btn btn-default">Back</button>
                    <button type="submit" id="register-submit-btn" class="btn btn-success uppercase pull-right">Submit</button>
                </div>
            </for  m>
            <!-- END REGISTRATION FORM -->
        </div>
        <div class="copyright">${applicationScope.commConfig["admin_site_copyright"] }  </div>
        <!--[if lt IE 9]>
		<script src="../assets/global/plugins/respond.min.js"></script>
		<script src="../assets/global/plugins/excanvas.min.js"></script> 
		<![endif]-->
        <!-- BEGIN CORE PLUGINS -->
		<script src="<c:url value="/resources/admin/global/plugins/jquery.min.js" />" type="text/javascript"></script>
		<script src="<c:url value="/resources/admin/global/plugins/bootstrap/js/bootstrap.min.js" />" type="text/javascript"></script>
		<script src="<c:url value="/resources/admin/global/plugins/js.cookie.min.js" />" type="text/javascript"></script>
		<script src="<c:url value="/resources/admin/global/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js" />" type="text/javascript"></script>
		<script src="<c:url value="/resources/admin/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js" />" type="text/javascript"></script>
		<script src="<c:url value="/resources/admin/global/plugins/jquery.blockui.min.js" />" type="text/javascript"></script>
		<script src="<c:url value="/resources/admin/global/plugins/uniform/jquery.uniform.min.js" />" type="text/javascript"></script>
		<script src="<c:url value="/resources/admin/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js" />" type="text/javascript"></script>
        <!-- END CORE PLUGINS -->
        <!-- BEGIN PAGE LEVEL PLUGINS -->
        <script src="<c:url value="/resources/admin/global/plugins/jquery-validation/js/jquery.validate.min.js" />" type="text/javascript"></script>
        <script src="<c:url value="/resources/admin/global/plugins/jquery-validation/js/additional-methods.min.js" />" type="text/javascript"></script>
        <script src="<c:url value="/resources/admin/global/plugins/select2/js/select2.full.min.js" />" type="text/javascript"></script>
        <!-- END PAGE LEVEL PLUGINS -->
        <!-- BEGIN THEME GLOBAL SCRIPTS -->
        <script src="<c:url value="/resources/admin/global/scripts/app.min.js" />" tppabs="http://www.keenthemes.com/preview/metronic/theme/assets/global/scripts/app.min.js" type="text/javascript"></script>
        <!-- END THEME GLOBAL SCRIPTS -->
        <!-- BEGIN PAGE LEVEL SCRIPTS -->
        <script src="<c:url value="/resources/admin/pages/scripts/login.min.js" />" tppabs="http://www.keenthemes.com/preview/metronic/theme/assets/pages/scripts/login.min.js" type="text/javascript"></script>
        <!-- END PAGE LEVEL SCRIPTS -->
        <!-- BEGIN THEME LAYOUT SCRIPTS -->
        <!-- END THEME LAYOUT SCRIPTS -->
        
        <script>
        jQuery(document).ready(function() {     

			$('#kImage').click(function(){
		    	$('#kImage').hide().attr('src', '<c:url value="/admin/login/startCaptcha/" />?' + Math.floor(Math.random()*100) ).fadeIn();
		    });
			$('#refreshBtn').click(function(){
		    	$('#kImage').hide().attr('src', '<c:url value="/admin/login/startCaptcha/" />?' + Math.floor(Math.random()*100) ).fadeIn();
		    });
		});
        </script>
</body>


</html>