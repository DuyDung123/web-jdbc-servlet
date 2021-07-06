<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api-admin-new"/>
<c:url var ="NewURL" value="/admin-new"/>
<html>
<head>
        <title>Testupload</title>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
            </script>
            <ul class="breadcrumb"> 
            </ul><!-- /.breadcrumb -->
        </div>
        <div class="page-content">
            <div class="row">
                <div class="col-xs-12">
                        <form method="post" action="<c:url value='/admin-new/UploadFileServlet'/>" enctype="multipart/form-data">
    						<input type="file" name="file" multiple="multiple"/>
    						<input type="submit" value="Upload" />
  						</form>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
/*   async function uploadFile() {
    let formData = new FormData(); 
    formData.append("file", ajaxfile.files[0]);
    await fetch('/admin-new/UploadFileServlet', {
      method: "POST", 
      body: formData
    }); 
    alert('The file upload with Ajax and Java was a success!');
  } */
  </script>
</body>
</html>
