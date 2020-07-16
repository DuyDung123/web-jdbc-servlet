<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	<div class="container">
		<a class="navbar-brand" href="/web-jdbc-13-03-2020/trang-chu"><i
			class="fa fa-home" aria-hidden="true"></i> Tin Tức Thái Nguyên</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto float-left">
				<li class="float-left nav-item active">
					<div class="input-group mx-auto mt-1" style="width: 150%">
						<input type="text" class="form-control" placeholder="tìm kiếm"
							id="mail" name="email">
						<div class="input-group-append">
							<span class="input-group-text"><i class="fa fa-search"
								aria-hidden="true"></i></span>
						</div>
					</div>
				</li>
				<c:if test="${not empty USERMODEL}">
					<li class="nav-item"><a class="nav-link font_size" href='#'>Wellcome:
							${USERMODEL.fullName}</a></li>
					<li class="nav-item"><a class="nav-link font_size"
						href='<c:url value="/thoat?action=logout"/>'>Thoát</a></li>
				</c:if>
				<c:if test="${empty USERMODEL}">
					<li class="nav-item"><a class="nav-link font_size"
						href='<c:url value="/dang-ky?action=register"/>'>Đăng ký</a></li>
					<li class="nav-item"><a class="nav-link font_size"
						href='<c:url value="/dang-nhap?action=login"/>'>Đăng nhập</a></li>
				</c:if>
			</ul>
		</div>
	</div>
</nav>
<div class="menutop">
	<ul class="menuhorizontal">
		<c:forEach var="item" items="${categories}">
			<li><a href='<c:url value="/category?category=${item.code}"/>'
				class="">${item.name}</a></li>
		</c:forEach>
	</ul>
</div>