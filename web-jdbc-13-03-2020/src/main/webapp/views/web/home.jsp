<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Trang chủ</title>
</head>

<body>
  <div class="main-content-banner">
    <div class="row ">
      <div class="col-lg-7">
        <div class="main-content-left">
          <img class="img_m_bn" src="<c:url value='${Latestpost.listResult[0].thumbnail}'/>" alt="">
          <div class="title_m_bn">${Latestpost.listResult[0].title}</div>
          <p class="con_m_bn">${model.listResult[0].shortDescription}</p>
        </div>
      </div>
      <div class="col-lg-5 smail-content-right">
        <div class="main-content-right">
          <img class="img_r_b" src="<c:url value='${Latestpost.listResult[1].thumbnail}'/>" alt=""></td>
          <p class="title_c_r">${Latestpost.listResult[1].title}</p>
        </div>
        <div class="main-content-right">
          <img class="img_r_b" src="<c:url value='${Latestpost.listResult[2].thumbnail}'/>" alt=""></td>
          <p class="title_c_r">${Latestpost.listResult[2].title}</p>
        </div>
        <div class="main-content-right">
          <img class="img_r_b" src="<c:url value='${Latestpost.listResult[3].thumbnail}'/>" alt=""></td>
          <p class="title_c_r">${Latestpost.listResult[3].title}</p>
        </div>
        <div class="main-content-right">
          <img class="img_r_b" src="<c:url value='${Latestpost.listResult[4].thumbnail}'/>" alt=""></td>
          <p class="title_c_r">${Latestpost.listResult[4].title}</p>
        </div>
        <div class="main-content-right">
          <img class="img_r_b" src="<c:url value='${Latestpost.listResult[5].thumbnail}'/>" alt=""></td>
          <p class="title_c_r">${Latestpost.listResult[5].title}</p>
        </div>
        <!-- <div class="main-content-right">
          <img class="img_r_b" src="<c:url value='/common/images/6.png'/>" alt=""></td>
          <p class="title_c_r">ngân hàng có kế hoạch tuyển hàng nghìn nhân sự</p>
        </div> -->
      </div>
    </div>
  </div>
  <c:forEach var="item" items="${categories}" varStatus="loop">
    <section class="main-content-event">
      <div class="title-event">
        <a class="colorwhite" href='<c:url value="/category?category=${item.code}"/>'>
          <p class="text_event">${model.listResult[loop.index*3].category.name}</p>
        </a>
        <hr>
      </div>
      <div class="row ">
        <div class="col-lg-7">
          <div class="main-content-event">
            <a class="colorblack"
              href='<c:url value="/category?categoryId=${model.listResult[loop.index*3].categoryId}&id=${model.listResult[loop.index*3].id}"/>'>
              <div class="title_m_evn">${model.listResult[loop.index*3].title}</div>
              <img class="img_m_evn" src="<c:url value='${model.listResult[loop.index*3].thumbnail}'/>" alt="">
              <p class="con_m_evn">${model.listResult[loop.index*3].shortDescription}</p>
            </a>
          </div>
        </div>
        <div class="col-lg-5 smail-content-right">
          <div class="main-content-right">
            <a class="colorblack"
              href='<c:url value="/category?categoryId=${model.listResult[(3*loop.index)+1].categoryId}&id=${model.listResult[(3*loop.index)+1].id}"/>'>
              <img class="img_r_b" src="<c:url value='${model.listResult[(3*loop.index)+1].thumbnail}'/>" alt=""></td>
              <p class="title_c_r">${model.listResult[(3*loop.index)+1].title}</p>
            </a>
          </div>
          <div class="main-content-right">
            <a class="colorblack"
              href='<c:url value="/category?categoryId=${model.listResult[(3*loop.index)+2].categoryId}&id=${model.listResult[(3*loop.index)+2].id}"/>'>
              <img class="img_r_b" src="<c:url value='${model.listResult[(3*loop.index)+2].thumbnail}'/>" alt=""></td>
              <p class="title_c_r">${model.listResult[(3*loop.index)+2].title}</p>
            </a>
          </div>
        </div>
      </div>
    </section>
  </c:forEach>
</body>

</html>