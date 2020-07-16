<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>

<head>
    <title>Register</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script
        type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!-- Custom Theme files -->
    <!-- //Custom Theme files -->
    <!-- web font -->
    <link href="//fonts.googleapis.com/css?family=Roboto:300,300i,400,400i,700,700i" rel="stylesheet">
    <!-- //web font -->
</head>

<body>
    <!-- main -->
    <div class="main-w3layouts wrapper">
        <h1>Thế giới tin tức</h1>
        <div class="main-agileinfo">
            <div class="agileits-top">
                <form action="<c:url value='/dang-ky'/>" id="formRegister" method="post">
                    <input class="text" type="text" name="userName" placeholder="Username" required="">
                    <input class="text fullname" type="text" name="fullName" placeholder="Fullname" required="">
                    <input class="text email" type="email" name="email" placeholder="Email" required="">
                    <input class="text" type="password" name="password" placeholder="Password" required="">
                    <input class="text w3lpass" type="password" name="password" placeholder="Confirm Password"
                        required="">
                    <div class="wthree-text">
                        <label class="anim">
                            <input type="checkbox" class="checkbox" required="">
                            <span>I Agree To The Terms & Conditions</span>
                        </label>
                        <div class="clear"> </div>
                    </div>
                    <input type="hidden" value="register" name="action" />
                    <input type="submit" value="SIGNUP">
                </form>
                <p>Don't have an Account? <a href='<c:url value="/dang-nhap?action=login"/>'> Login Now!</a></p>
            </div>
        </div>
        <!-- copyright -->
        <div class="colorlibcopy-agile">
            <p>© 2018 Colorlib Signup Form. All rights reserved | Design by <a
                    href="https://www.facebook.com/duy.dung.1254" target="_blank">Colorlib</a></p>
        </div>
    </div>
</body>

</html>

<!-- insert into user(username,password,fullname,status, roleid) values('nguyenvana','123456','nguyen van a',1,2); -->