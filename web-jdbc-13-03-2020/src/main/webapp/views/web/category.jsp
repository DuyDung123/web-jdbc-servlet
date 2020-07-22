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
        <img class="col-lg-6" src="<c:url value='${Latestpost.listResult[1].thumbnail}'/>" alt="">
        <div class="col-lg-6">
          <div class="title_banner">${Latestpost.listResult[1].title}</div>
          <p class="con_m_banner">${model.listResult[1].shortDescription}</p>
        </div>
      </div>
      <div class="below_m_bn">
        <div class="row">
          <div class="col-lg-6 one_new_left">
            <img class="img_new" src="<c:url value='${Latestpost.listResult[2].thumbnail}'/>" alt="">
            <p class="title_new">${Latestpost.listResult[1].title}</p>
          </div>
          <div class="col-lg-6 one_new-right">
            <img class="img_new" src="<c:url value='${Latestpost.listResult[3].thumbnail}'/>" alt="">
            <p class="title_new">${Latestpost.listResult[3].title}</p>
          </div>
        </div>
        <div class="row">
          <div class="col-lg-6 one_new_left">
            <img class="img_new" src="<c:url value='${Latestpost.listResult[4].thumbnail}'/>" alt="">
            <p class="title_new">${Latestpost.listResult[4].title}</p>
          </div>
          <div class="col-lg-6 one_new-right">
            <img class="img_new" src="<c:url value='${Latestpost.listResult[5].thumbnail}'/>" alt="">
            <p class="title_new">${Latestpost.listResult[5].title}</p>
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
            <a href='${detailURL}' class="img_1New"><img class="img_new_c" src="<c:url value='${item.thumbnail}'/>"
                alt=""></a>
            <div class="c_new_c">
              <a href='${detailURL}' class="content_1_new">
                <div class="title_new_c">${item.title}</div>
                <div class="time_new"><i class="fa fa-clock-o time" aria-hidden="true"></i>${item.createdDate}</div>
                <p class="con_new_c">${item.shortDescription}</p>
              </a>
            </div>
          </div>
        </c:forEach>
      </div>
      <ul class="pagination" id="pagination"></ul>
      <input type="hidden" value="" id="page" name="page" />
      <input type="hidden" value="" id="maxPageItem" name="maxPageItem" />
      <input type="hidden" value="" id="sortName" name="sortName" />
      <input type="hidden" value="" id="sortBy" name="sortBy" />
      <input type="hidden" value="" id="type" name="type" />
    </form>
  </div>
  <script>
    var totalPages = ${ model.totalPage };
    var currentPage = ${ model.page };
    var limit = 4;
    $(function () {
      window.pagObj = $('#pagination').twbsPagination({
        totalPages: totalPages,
        visiblePages: 10,
        startPage: currentPage,
        onPageClick: function (event, page) {
          if (currentPage != page) {
            $('#maxPageItem').val(limit);
            $('#page').val(page);
            $('#sortName').val('title');
            $('#sortBy').val('desc');
            $('#type').val('list');
            $('#formSubmit').submit();
          }
        }
      });
    });
  </script>
</body>

</html>