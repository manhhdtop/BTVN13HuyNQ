<%-- User: ManhHd
  Date: 27/09/2019
--%>
<%@ page contentType="text/html; utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<title>${title}</title>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<!-- Favicon -->
		<link href="/icon/favicon.png" rel="shortcut icon" />

		<!-- Google Fonts -->
		<link href="https://fonts.googleapis.com/css?family=Raleway:400,400i,500,500i,600,600i,700,700i"
		      rel="stylesheet">

		<!-- Stylesheets -->
		<link rel="stylesheet" href="/css/bootstrap.min.css" />
		<link rel="stylesheet" href="/css/font-awesome.min.css" />
		<link rel="stylesheet" href="/css/owl.carousel.css" />
		<link rel="stylesheet" href="/css/style.css" />
		<link rel="stylesheet" href="/css/animate.css" />

	</head>
	<body>
		<jsp:useBean id="date" class="java.util.Date" />
		<!-- Page Preloder -->
		<div id="preloder">
			<div class="loader"></div>
		</div>

		<%-- Header--%>
		<jsp:include page="/template/header.jsp" />


		<!-- Hero section -->
		<section class="account-section set-bg" data-setbg="/img/bg.jpg">
			<div class="row account">
				<div class="col-md-4 col-sm-12 left">
					<ul class="navbar-nav mr-auto sidenav"
					    id="navAccordion">
						<li class="nav-item active">
							<a class="nav-link" href="/account">Information
								<span class="sr-only">(current)</span>
							</a>
						</li>
						<li class="nav-item">
							<a class="nav-link"
							   href="/account/change-password">Change
								password
							</a>
						</li>
						<%-- <li class="nav-item">--%>
						<%-- <a class="nav-link nav-link-collapse"--%>
						<%-- href="#"--%>
						<%-- data-toggle="collapse"--%>
						<%-- data-target="#collapseSubItems2"--%>
						<%-- aria-controls="collapseSubItems2"--%>
						<%-- aria-expanded="false">--%>
						<%-- Item 2--%>
						<%-- </a>--%>
						<%-- <ul class="nav-second-level collapse"--%>
						<%-- id="collapseSubItems2"--%>
						<%-- data-parent="#navAccordion">--%>
						<%-- <li class="nav-item">--%>
						<%-- <a class="nav-link" href="#">--%>
						<%-- <span class="nav-link-text">Item 2.1</span>--%>
						<%-- </a>--%>
						<%-- </li>--%>
						<%-- <li class="nav-item">--%>
						<%-- <a class="nav-link" href="#">--%>
						<%-- <span class="nav-link-text">Item 2.2</span>--%>
						<%-- </a>--%>
						<%-- </li>--%>
						<%-- </ul>--%>
						<%-- </li>--%>
						<%-- <li class="nav-item">--%>
						<%-- <a class="nav-link" href="#">Item 3</a>--%>
						<%-- </li>--%>
						<%-- <li class="nav-item">--%>
						<%-- <a class="nav-link nav-link-collapse"--%>
						<%-- href="#"--%>
						<%-- id="hasSubItems"--%>
						<%-- data-toggle="collapse"--%>
						<%-- data-target="#collapseSubItems4"--%>
						<%-- aria-controls="collapseSubItems4"--%>
						<%-- aria-expanded="false">--%>
						<%-- Item 4--%>
						<%-- </a>--%>
						<%-- <ul class="nav-second-level collapse"--%>
						<%-- id="collapseSubItems4"--%>
						<%-- data-parent="#navAccordion">--%>
						<%-- <li class="nav-item">--%>
						<%-- <a class="nav-link" href="#">--%>
						<%-- <span class="nav-link-text">Item 4.1</span>--%>
						<%-- </a>--%>
						<%-- </li>--%>
						<%-- <li class="nav-item">--%>
						<%-- <a class="nav-link" href="#">--%>
						<%-- <span class="nav-link-text">Item 4.2</span>--%>
						<%-- </a>--%>
						<%-- </li>--%>
						<%-- <li class="nav-item">--%>
						<%-- <a class="nav-link" href="#">--%>
						<%-- <span class="nav-link-text">Item 4.2</span>--%>
						<%-- </a>--%>
						<%-- </li>--%>
						<%-- </ul>--%>
						<%-- </li>--%>
						<%-- <li class="nav-item">--%>
						<%-- <a class="nav-link" href="#">Item 5</a>--%>
						<%-- </li>--%>
					</ul>
				</div>
				<div class="col-md-8 col-sm-12 right">
					<section id="section-information" style="display: none"
					         class="col m-2">
						<h3 class="border-top border-bottom border-primary p-1">
							Information
						</h3>
						<div class="py-3 pt-1">
							<p class="text-white">Username: ${user.username}</p>
							<p class="text-white">Name: ${user.name}</p>
						</div>
					</section>
					<section id="section-change-password" style="display: none"
					         class="col m-2 p-3">
						<h3
								class="border-top border-bottom border-primary p-1 mb-2">
							Change your password
						</h3>
						<form>
							<div class="form-group">
								<label>Username</label>
								<input class="form-control"
								       value="${user.username}" readonly>
								<small class="text-danger"></small>
							</div>
							<div class="form-group">
								<label for="old-pass">Old password</label>
								<input class="form-control password"
								       id="old-pass" type="password"
								       placeholder="*********">
								<small class="text-danger"></small>
							</div>
							<div class="form-group">
								<label for="new-pass">New password</label>
								<input class="form-control password"
								       id="new-pass" type="password"
								       placeholder="*********">
								<small class="text-danger"></small>
							</div>
							<div class="form-group">
								<label for="re-pass">Re password</label>
								<input class="form-control" id="re-pass"
								       type="password" placeholder="*********">
								<small class="text-danger"></small>
							</div>
							<div>
								<label id="message"></label>
							</div>
							<div class="form-group">
								<button type="button" class="btn btn-primary"
								        id="change-password">
									Change password
								</button>
							</div>
						</form>
					</section>
				</div>
			</div>
		</section>
		<!-- Hero section end -->


		<!-- Footer section -->
		<footer class="footer-section">
			<div class="container">
				<p class="copyright">
					Copyright &copy;
					<fmt:formatDate value="${date}" pattern="yyyy" />
					All rights reserved
				</p>
			</div>
		</footer>
		<!-- Footer section end -->

		<%-- Modal--%>
		<jsp:include page="/template/modal.jsp" />

		<script>
            var user;
            var path = null;
            if ('${user}' !== '') {
                user = {
                    id: '${user.id}',
                    username: '${user.username}',
                };
            }
            if ('${path}' !== '') {
                path = '${path}';
            }
		</script>

		<!--====== Javascripts & Jquery ======-->
		<script src="/js/jquery.3.2.1.min.js"></script>
		<script src="/js/bootstrap.min.js"></script>
		<script src="/js/owl.carousel.min.js"></script>
		<script src="/js/mixitup.min.js"></script>
		<script src="/js/sly.min.js"></script>
		<script src="/js/jquery-cookie.js"></script>
		<script src="/js/jquery.nicescroll.min.js"></script>
		<script src="/js/jquery.showLoading.min.js"></script>
		<script src="/js/main.js"></script>
		<script src="/js/account.js"></script>
	</body>
</html>