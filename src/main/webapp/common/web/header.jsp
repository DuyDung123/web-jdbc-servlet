<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Navigation -->
<nav class="tab-bar navbar navbar-expand-lg navbar-light bg-light">
	<a class="navbar-brand" href='<c:url value="/trang-chu"/>'>VIETSOZ</a>
	<button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse" data-target="#collapsibleNavId"
		aria-controls="collapsibleNavId" aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="collapsibleNavId">
		<ul class="navbar-nav mr-auto mt-2 mx-auto mt-lg-0 fontweb">
			<c:forEach var="item" items="${categories}">
				<li class="nav-item">
					<a class="nav-link" href='<c:url value="/category?category=${item.code}"/>'>${item.name}</a>
				</li>
			</c:forEach>
			<li>
				<form class="frm_search">
					<div class="input-group">
						<input type="text" class="form-control" placeholder="Search" name="search"
							style="width: 100px;">
						<div class="input-group-btn">
							<button class="btn btn-default" type="submit"><i class="fa fa-search"
									aria-hidden="true"></i></button>
						</div>
					</div>
				</form>
			</li>
			<c:if test="${not empty USERMODEL}">
				<li class="nav-item"><a class="nav-link" href='#'>
						${USERMODEL.fullName}</a></li>
				<li class="nav-item"><a class="nav-link" href='<c:url value="/thoat?action=logout"/>'>LogOut</a></li>
			</c:if>
			<c:if test="${empty USERMODEL}">
				<li class="nav-item"><a class="nav-link" href='<c:url value="/dang-ky?action=register"/>'>LogUp</a></li>
				<li class="nav-item"><a class="nav-link" href='<c:url value="/dang-nhap?action=login"/>'>LogIn</a></li>
			</c:if>
		</ul>
	</div>
</nav>