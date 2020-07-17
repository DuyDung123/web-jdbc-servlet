<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <title>
        <dec:title default="Trang chủ" />
    </title>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!--import bootstrap css, js, font awesome here-->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
    </script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js">
    </script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <!-- import jquery -->
    <script src="js/jquery-1.12.4.js"></script>

    <!-- css -->
    <link href="<c:url value='/template/web/css/header.css' />" rel="stylesheet" type="text/css" media="all" />
    <link href="<c:url value='/template/web/css/footer.css' />" rel="stylesheet" type="text/css" media="all" />
    <link href="<c:url value='/template/web/css/contentRight.css' />" rel="stylesheet" type="text/css" media="all" />
    <link href="<c:url value='/template/web/css/style.css' />" rel="stylesheet" type="text/css" media="all" />
    <link href="<c:url value='/template/web/css/category.css'/>" rel="stylesheet" type="text/css" media="all" />
        <link href="<c:url value='/template/web/css/new-detail.css'/>" rel="stylesheet" type="text/css" media="all" />
</head>

<body>
    <!-- header -->
    <%@ include file="/common/web/header.jsp" %>
    <!-- header -->
    <c:if test="${ not empty categoryTabBar}">
        <div class="nav_bar jumbotron-fluid">
            <div class="container">
                <span class="home">Trang chủ</span><i class="fa fa-angle-right" aria-hidden="true"></i><span>${categoryTabBar.name}</span>
            </div>
        </div>
    </c:if>
    <div class="container mt-4">
        <div class="row">
            <div class="col-lg-9 content-left">
                <dec:body />
            </div>
            <div class="col-lg-3 content-right">
                <%@ include file="/common/web/contentRight.jsp" %>
            </div>
        </div>
    </div>
    <!-- footer -->
    <%@ include file="/common/web/footer.jsp" %>
    <!-- footer -->
</body>

</html>