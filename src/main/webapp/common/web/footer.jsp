<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<footer class="jumbotron jumbotron-fluid ft_con_m">
  <div class="container">
    <div class="row">
      <div class="col-lg-3">
        <div class="t_d_ft">VỀ CHÚNG TÔI</div>
        <div class="ft_con_it-me">
          <p class="ft_con_info"> VIETSOZ được thành lập vào tháng 8 năm 2016, hữa hẹn sẽ là một công ty hàng đầu sẽ
            cũng cấp các giải
            phải công nghệ
            mới và tiên tiến nhất trong nước và ngoài nước</p>
          <div class="mb-4"><i class="fa fa-envelope-o ft_mail" aria-hidden="true"></i> dinhvandung791@gmail.com</div>
          <div><i class="fa fa-phone ft_phone" aria-hidden="true"></i> 0974967791</div>
        </div>
      </div>
      <div class="col-lg-3">
        <div class="t_d_ft">DANH MỤC</div>
        <div class="ft_con_dm">
          <c:forEach var="item" items="${categories}">
            <div class="mb-2">
              <i class="fa fa-caret-right" aria-hidden="true"></i>
              <a class="nav-link" href='<c:url value="/category?category=${item.code}"/>'>${item.name}</a>
            </div>
          </c:forEach>
        </div>
      </div>
      <div class="col-lg-3">
        <div class="t_d_ft">TIN TỨC NỔI BẬT</div>
        <div class="ft_con_nb">
            <c:forEach var="item" items="${mostview}">
                <c:url var="detailURL" value="/category">
                  <c:param name="categoryId" value="${item.categoryId}" />
                  <c:param name="id" value="${item.id}" />
                </c:url>
                <div class="mb-2"><i class="fa fa-caret-right mr-2" aria-hidden="true"></i>
                  <a href="${detailURL}" style="text-decoration: none; color: white;" >${item.title}</a>
                </div>
            </c:forEach>
        </div>
      </div>
      <div class="col-lg-3">
        <div class="t_d_ft">FANPAGE</div>
        <div class="ft_con_fp">
          <div class="mb-4"><i class="fa fa-facebook" aria-hidden="true"></i> <a href="https://www.facebook.com/" target="_blank" rel="noopener noreferrer">DUY DŨNG</a></div>
          <div class="mb-4"><i class="fa fa-envelope-o ft_mail" aria-hidden="true"></i> dinhvandung791@gmail.com</div>
          <div><i class="fa fa-phone ft_phone" aria-hidden="true"></i> 0974967791</div>
        </div>
      </div>
    </div>
  </div>
</footer>