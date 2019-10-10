<!DOCTYPE html>
<html lang="en">

	<head>

		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport"
		      content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<meta name="description" content="">
		<meta name="author" content="">

		<title>${title}</title>

		<!-- Custom fonts for this template-->
		<link href="/css/all.min.css" rel="stylesheet" type="text/css">
		<link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
		      rel="stylesheet">

		<!-- Custom styles for this template-->
		<link href="/css/sb-admin-2.css" rel="stylesheet">

	</head>

	<body class="bg-gradient-primary">

		<div class="container">

			<!-- Outer Row -->
			<div class="row justify-content-center">

				<div class="col-xl-10 col-lg-12 col-md-9">

					<div class="card o-hidden border-0 shadow-lg my-5">
						<div class="card-body p-0">
							<!-- Nested Row within Card Body -->
							<div class="row">
								<div class="col-lg-6 d-none d-lg-block bg-login-image"></div>
								<div class="col-lg-6">
									<div class="p-5">
										<div class="text-center">
											<h1 class="h4 text-gray-900 mb-4">
												Create an Account!
											</h1>
										</div>
										<form id="register" class="user"
										      method="post">
											<div class="form-group">
												<label for="nameRegister">
													Name
												</label>
												<input class="form-control form-control-user"
												       id="nameRegister"
												       placeholder="Enter Name...">
												<small class="text-danger"></small>
											</div>
											<div class="form-group">
												<label for="usernameRegister">
													Username
												</label>
												<input class="form-control form-control-user"
												       id="usernameRegister"
												       placeholder="Enter Username...">
												<small class="text-danger"></small>
											</div>
											<div class="form-group">
												<label for="passwordRegister">
													Password
												</label>
												<input type="password"
												       class="form-control form-control-user"
												       id="passwordRegister"
												       placeholder="Password...">
												<small class="text-danger"></small>
											</div>
											<div class="form-group">
												<label for="rePasswordRegister">
													Re Password
												</label>
												<input type="password"
												       class="form-control form-control-user"
												       id="rePasswordRegister"
												       placeholder="Re Password...">
												<small class="text-danger"></small>
											</div>
											<div>
												<label id="message"></label>
											</div>
											<button class="btn btn-primary btn-user btn-block">
												Register
											</button>
										</form>
										<hr>
										<div class="text-center">
											<a class="small"
											   href="backend/login">
												Login to your account!
											</a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>

				</div>

			</div>

		</div>

		<!-- Bootstrap core JavaScript-->
		<script src="/js/jquery.3.2.1.min.js"></script>
		<script src="/js/bootstrap.bundle.min.js"></script>

		<!-- Core plugin JavaScript-->
		<script src="/js/jquery.easing.min.js"></script>

		<!-- Custom scripts for all pages-->
		<script src="/js/sb-admin-2.min.js"></script>
		<!-- Custom scripts for all pages-->
		<script src="/js/jquery-cookie.js"></script>
		<script src="/js/admin-account.js"></script>

	</body>

</html>
