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
          <img class="img_m_bn" src="<c:url value='/common/images/5.png'/>" alt="">
          <div class="title_m_bn">Công trình xanh cho nhà ở đô thị: Phải hướng đến sự phát triển bền vững</div>
          <p class="con_m_bn">Lorem ipsum dolor sit amet consectetur adipisicing elit. Ad cupiditate minus,
            alias accusamus, rem architecto cumque soluta dolorem nobis facilis molestias odio. Magnam,
            beatae ullam debitis nobis ipsum laborum quidem!</p>
        </div>
      </div>
      <div class="col-lg-5 smail-content-right">
        <div class="main-content-right">
          <img class="img_r_b" src="<c:url value='/common/images/1.png'/>" alt=""></td>
          <p class="title_c_r">ngân hàng có kế hoạch tuyển hàng nghìn nhân sự</p>
        </div>
        <div class="main-content-right ">
          <img class="img_r_b" src="<c:url value='/common/images/2.png'/>" alt=""></td>
          <p class="title_c_r">ngân hàng có kế hoạch tuyển hàng nghìn nhân sự</p>
        </div>
        <div class="main-content-right ">
          <img class="img_r_b" src="<c:url value='/common/images/4.png'/>" alt=""></td>
          <p class="title_c_r">ngân hàng có kế hoạch tuyển hàng nghìn nhân sự</p>
        </div>
        <div class="main-content-right ">
          <img class="img_r_b" src="<c:url value='/common/images/5.png'/>" alt=""></td>
          <p class="title_c_r">ngân hàng có kế hoạch tuyển hàng nghìn nhân sự</p>
        </div>
        <div class="main-content-right">
          <img class="img_r_b" src="<c:url value='/common/images/6.png'/>" alt=""></td>
          <p class="title_c_r">ngân hàng có kế hoạch tuyển hàng nghìn nhân sự</p>
        </div>
      </div>
    </div>
  </div>
  <c:forEach var="model" items="${model.listResult}" varStatus="loop">
    <section class="main-content-event">
      <div class="title-event">
        <p class="text_event">Sử kiện</p>
        <hr>
      </div>
      <div class="row ">
        <div class="col-lg-7">
          <div class="main-content-event">
            <div class="title_m_evn">${model[loop.index*3].title}</div>
            <img class="img_m_evn" src="<c:url value='${model[loop.index*3].thumbnail}'/>" alt="">
            <p class="con_m_evn">${model[loop.index*3].shortDescription}</p>
          </div>
        </div>
        <div class="col-lg-5 smail-content-right">
          <div class="main-content-right">
            <img class="img_r_b" src="<c:url value='${model[(3*loop.index)+1].thumbnail}'/>" alt=""></td>
            <p class="title_c_r">${model[(3*loop.index)+1].title}</p>
          </div>
          <div class="main-content-right">
            <img class="img_r_b" src="<c:url value='${model[(3*loop.index)+2].thumbnail}'/>" alt=""></td>
            <p class="title_c_r">${model[(3*loop.index)+2].title}</p>
          </div>
        </div>
      </div>
    </section>
  </c:forEach>

  <!-- <section class="main-content-event">
    <div class="title-event">
      <p class="text_event">SỰ KIỆN</p>
      <hr>
    </div>
    <div class="row ">
      <div class="col-lg-7">
        <div class="main-content-event">
          <div class="title_m_evn">Việt nam sớm kí hiệp định thương mai tự do với EU</div>
          <img class="img_m_evn" src="<c:url value='/common/images/5.png'/>" alt="">
          <p class="con_m_evn">Lorem ipsum dolor sit amet consectetur adipisicing elit. Ad cupiditate minus,
            alias accusamus, rem architecto cumque soluta dolorem nobis facilis molestias odio. Magnam</p>
        </div>
      </div>
      <div class="col-lg-5 smail-content-right">
        <div class="main-content-right">
          <img class="img_r_b" src="<c:url value='/common/images/1.png'/>" alt=""></td>
          <p class="title_c_r">ngân hàng có kế hoạch tuyển hàng nghìn nhân sự</p>
        </div>
        <div class="main-content-right">
          <img class="img_r_b" src="<c:url value='/common/images/2.png'/>" alt=""></td>
          <p class="title_c_r">ngân hàng có kế hoạch tuyển hàng nghìn nhân sự</p>
        </div>
      </div>
    </div>
  </section>
  <section class="main-content-event">
    <div class="title-event">
      <p class="text_event">SỰ KIỆN</p>
      <hr>
    </div>
    <div class="row ">
      <div class="col-lg-7">
        <div class="main-content-event">
          <div class="title_m_evn">Việt nam sớm kí hiệp định thương mai tự do với EU</div>
          <img class="img_m_evn" src="<c:url value='/common/images/5.png'/>" alt="">
          <p class="con_m_evn">Lorem ipsum dolor sit amet consectetur adipisicing elit. Ad cupiditate minus,
            alias accusamus, rem architecto cumque soluta dolorem nobis facilis molestias odio. Magnam</p>
        </div>
      </div>
      <div class="col-lg-5 smail-content-right">
        <div class="main-content-right">
          <img class="img_r_b" src="<c:url value='/common/images/1.png'/>" alt=""></td>
          <p class="title_c_r">ngân hàng có kế hoạch tuyển hàng nghìn nhân sự</p>
        </div>
        <div class="main-content-right">
          <img class="img_r_b" src="<c:url value='/common/images/2.png'/>" alt=""></td>
          <p class="title_c_r">ngân hàng có kế hoạch tuyển hàng nghìn nhân sự</p>
        </div>
      </div>
    </div>
  </section>
  <section class="main-content-event">
    <div class="title-event">
      <p class="text_event">SỰ KIỆN</p>
      <hr>
    </div>
    <div class="row ">
      <div class="col-lg-7">
        <div class="main-content-event">
          <div class="title_m_evn">Việt nam sớm kí hiệp định thương mai tự do với EU</div>
          <img class="img_m_evn" src="<c:url value='/common/images/5.png'/>" alt="">
          <p class="con_m_evn">Lorem ipsum dolor sit amet consectetur adipisicing elit. Ad cupiditate minus,
            alias accusamus, rem architecto cumque soluta dolorem nobis facilis molestias odio. Magnam</p>
        </div>
      </div>
      <div class="col-lg-5 smail-content-right">
        <div class="main-content-right">
          <img class="img_r_b" src="<c:url value='/common/images/1.png'/>" alt=""></td>
          <p class="title_c_r">ngân hàng có kế hoạch tuyển hàng nghìn nhân sự</p>
        </div>
        <div class="main-content-right">
          <img class="img_r_b" src="<c:url value='/common/images/2.png'/>" alt=""></td>
          <p class="title_c_r">ngân hàng có kế hoạch tuyển hàng nghìn nhân sự</p>
        </div>
      </div>
    </div>
  </section>
  <section class="main-content-event">
    <div class="title-event">
      <p class="text_event">SỰ KIỆN</p>
      <hr>
    </div>
    <div class="row ">
      <div class="col-lg-7">
        <div class="main-content-event">
          <div class="title_m_evn">Việt nam sớm kí hiệp định thương mai tự do với EU</div>
          <img class="img_m_evn" src="<c:url value='/common/images/5.png'/>" alt="">
          <p class="con_m_evn">Lorem ipsum dolor sit amet consectetur adipisicing elit. Ad cupiditate minus,
            alias accusamus, rem architecto cumque soluta dolorem nobis facilis molestias odio. Magnam</p>
        </div>
      </div>
      <div class="col-lg-5 smail-content-right">
        <div class="main-content-right">
          <img class="img_r_b" src="<c:url value='/common/images/1.png'/>" alt=""></td>
          <p class="title_c_r">ngân hàng có kế hoạch tuyển hàng nghìn nhân sự</p>
        </div>
        <div class="main-content-right">
          <img class="img_r_b" src="<c:url value='/common/images/2.png'/>" alt=""></td>
          <p class="title_c_r">ngân hàng có kế hoạch tuyển hàng nghìn nhân sự</p>
        </div>
      </div>
    </div>
  </section> -->
</body>

</html>