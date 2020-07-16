<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/common/taglib.jsp"%>
<html>
<head>
<title>Chỉnh sửa bài viết</title>
</head>
<body>
	<div class="main-content">
		<div class="main-content-inner">
			<div class="breadcrumbs" id="breadcrumbs">
				<script type="text/javascript">
                try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
            </script>
				<!-- /.breadcrumb -->
			</div>
			<div class="page-content">
				<div class="row">
					<div class="col-xs-12">
						<c:forEach var="item" items="${model.listResult}">
							<div>${item.content}</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
