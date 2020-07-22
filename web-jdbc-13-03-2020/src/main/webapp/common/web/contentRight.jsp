<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- content-right -->
<div class="side-content-light">
	<img class="img-slide-right" src="<c:url value='${Latestpost.listResult[6].thumbnail}'/>" alt="/images/1.png">
</div>
<div class="con_r_b">
	<div class="most-read">ĐỌC NHIỀU NHẤT</div>
	<!-- phần nội dung -->
	<c:forEach var="item" items="${mostview}">
		<div class="content-body-right">
			<c:url var="detailURL" value="/category">
				<c:param name="categoryId" value="${item.categoryId}" />
				<c:param name="id" value="${item.id}" />
			</c:url>
			<a href='${detailURL}'><img class="img_r_b" src="<c:url value='${item.thumbnail}'/>" alt="/images/1.png"></a>
			<a style="text-decoration: none; color: black;" href='${detailURL}'><p class="title_c_r">${item.title}</p></a>
		</div>
	</c:forEach>
	<div class="pt-4 pb-4"><img class="" src="<c:url value='common/images/Bannerads01.png'/>" alt="/images/1.png"></div>
	<div class="pt-4"><img src="<c:url value='common/images/Bannerads02.png'/>" alt="/images/1.png"></div>
	<!-- <div class="pt-4 pb-4"><img class="" src="<c:url value='${Latestpost.listResult[7].thumbnail}'/>" alt="/images/1.png"></div>
	<div class="pt-4"><img src="<c:url value='${Latestpost.listResult[8].thumbnail}'/>" alt="/images/1.png"></div> -->
</div>