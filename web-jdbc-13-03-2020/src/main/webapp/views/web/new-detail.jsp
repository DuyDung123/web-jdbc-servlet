<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/common/taglib.jsp"%>
<html>

<head>
	<title>Chỉnh sửa bài viết</title>
</head>

<body>
	<div class="new_detail">
		<h2 class="title_news mb-4">${model.title}</h2>
		<img class="new_detail_img" src="<c:url value='${model.thumbnail}'/>" alt="${model.title}" >
		<div class="new_detail_content">
			${model.content}
		</div>
		<div class="author"><span>Tác giả: </span> ${model.createdBy} <span>lượt xem: ${model.view}</span></div>
	</div>
	<br>
	<div class="related_posts">
		<div>BÀI VIẾT LIÊN QUAN</div>
		<hr>
		<div class="baivietliequan">
			<div class="one_new_rp">
				<img class="img_rp" src="<c:url value='/common/images/4.png'/>" alt="">
				<p class="title_rp">Lorem ipsum dolor sit amet consectetur adipisicing elit.</p>
			</div>
			<div class="one_new_rp">
				<img class="img_rp" src="<c:url value='/common/images/4.png'/>" alt="">
				<p class="title_rp">Lorem ipsum dolor sit amet consectetur adipisicing elit.</p>
			</div>
			<div class="one_new_rp">
				<img class="img_rp" src="<c:url value='/common/images/4.png'/>" alt="">
				<p class="title_rp">Lorem ipsum dolor sit amet consectetur adipisicing elit.</p>
			</div>
		</div>
	</div>
</body>

</html>