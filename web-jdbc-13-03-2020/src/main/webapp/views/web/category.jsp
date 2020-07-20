<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>${categoryTabBar.name}</title>
  <link href="<c:url value='/template/web/css/category.css'/>" rel="stylesheet" type="text/css" media="all" />
</head>

<body>
  <div>
    <form action="<c:url value='/category'/>" id="formSubmit" method="get">
      <div class="row">
        <img class="col-lg-6" src="<c:url value='${model.listResult[0].thumbnail}'/>" alt="">
        <div class="col-lg-6">
          <div class="title_banner">Công trình xanh cho nhà ở đô thị: Phải hướng đến sự phát triển bền vững</div>
          <p class="con_m_banner">Lorem ipsum dolor sit amet consectetur adipisicing elit. Ad cupiditate minus,
            alias accusamus, rem architecto cumque soluta dolorem nobis facilis molestias odio. Magnam,
            beatae ullam debitis nobis ipsum laborum quidem!</p>
        </div>
      </div>
      <div class="below_m_bn">
        <div class="row">
          <div class="col-lg-6 one_new_left">
            <img class="img_new" src="<c:url value='/common/images/5.png'/>" alt="">
            <p class="title_new">ngân hàng có kế hoạch tuyển hàng nghìn nhân sự giúp người nghèo vượt khó</p>
          </div>
          <div class="col-lg-6 one_new-right">
            <img class="img_new" src="<c:url value='/common/images/5.png'/>" alt="">
            <p class="title_new">ngân hàng có kế hoạch tuyển hàng nghìn nhân sự giúp người nghèo vượt khó</p>
          </div>
        </div>
        <div class="row">
          <div class="col-lg-6 one_new_left">
            <img class="img_new" src="<c:url value='/common/images/5.png'/>" alt="">
            <p class="title_new">ngân hàng có kế hoạch tuyển hàng nghìn nhân sự giúp người nghèo vượt khó</p>
          </div>
          <div class="col-lg-6 one_new-right">
            <img class="img_new" src="<c:url value='/common/images/5.png'/>" alt="">
            <p class="title_new">ngân hàng có kế hoạch tuyển hàng nghìn nhân sự giúp người nghèo vượt khó</p>
          </div>
        </div>
      </div>
      <div class="p_category">
        <c:forEach var="item" items="${model.listResult}">
          <div class="_1_new">
            <c:url var="detailURL" value="/category">
              <c:param name="categoryId" value="${item.categoryId}" />
              <c:param name="id" value="${item.id}" />
            </c:url>
            <a class="nav-link" href='${detailURL}'>
              <img src="<c:url value='${item.thumbnail}'/>" alt="" class="img_new_c">
            </a>
            <div class="c_new_c">
              <a class="" href='${detailURL}'>
                <div class="title_new_c">${item.title}</div>
                <div class="time_new"><i class="fa fa-clock-o time" aria-hidden="true"></i>${item.createdDate}</div>
                <p class="con_new_c">${item.shortDescription}</p>
              </a>
            </div>
          </div>
        </c:forEach>
      </div>
    </form>
  </div>
</body>

</html>