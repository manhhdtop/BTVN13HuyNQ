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

		<link rel="icon" href="/icon/favicon.png">
		<!-- Custom fonts for this template-->
		<link href="/css/all.min.css" rel="stylesheet"
		      type="text/css">
		<link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
		      rel="stylesheet">

		<!-- Custom styles for this template-->
		<link href="/css/pagination.css" rel="stylesheet">
		<!-- Custom styles for this page-->
		<link href="/css/sb-admin-2.css" rel="stylesheet">

	</head>

	<body id="page-top">

		<!-- Page Wrapper -->
		<div id="wrapper">

			<!-- Include Sidebar -->
			<jsp:include page="/template/sidebar.jsp" />

			<!-- Content Wrapper -->
			<div id="content-wrapper" class="d-flex flex-column">

				<!-- Main Content -->
				<div id="content">

					<!-- Include Sidebar -->
					<jsp:include page="/template/topbar.jsp" />

					<!-- Begin Page Content -->
					<div class="container-fluid">

						<h1 class="h3 mb-2 text-gray-800">Add Products</h1>
						<hr />

						<!-- Page Heading -->
						<p class="mb-4">
							Add more product
						</p>

						<hr />
						<!-- DataTales Example -->
						<div class="card shadow mb-4">
							<div class="card-header py-3">
								<h6 class="m-0 font-weight-bold text-primary">
									Product
								</h6>
							</div>
							<div class="card-body">
								<form id="add-product">
									<div class="row">
										<div class="col-md-6 col-sm-12">
											<div class="form-group">
												<label>Upload Image</label>
												<div class="input-group">
										            <span class="input-group-btn">
										                <span class="btn btn-default btn-file">
										                    Browse...
											                <input type="file">
										                </span>
										            </span>
													<input type="text"
													       class="form-control"
													       readonly>
												</div>
												<img id="image" alt=""
												     class="img-fluid" />
											</div>
										</div>
										<div class="col-md-6 col-sm-12">
											<div class="form-group">
												<label for="name">
													Product Name
												</label>
												<input class="form-control"
												       id="name"
												       placeholder="Input product name...">
											</div>
											<div class="form-group">
												<label for="description">
													Product Description
												</label>
												<textarea class="form-control"
												          id="description"
												          rows="3"
												          placeholder="Input product description..."></textarea>
											</div>
											<div class="form-group">
												<label for="price">
													Product Price
												</label>
												<input type="number"
												       class="form-control"
												       id="price"
												       placeholder="Input product price...">
											</div>
											<div class="form-group">
												<button class="btn btn-primary">
													Add Product
												</button>
											</div>
										</div>
									</div>
								</form>
							</div>
						</div>

					</div>
					<!-- /.container-fluid -->

				</div>
				<!-- End of Main Content -->

				<!-- Footer -->
				<footer class="sticky-footer bg-white">
					<div class="container my-auto">
						<div class="copyright text-center my-auto">
							<span>Copyright &copy; Pet Shop 2019</span>
						</div>
					</div>
				</footer>
				<!-- End of Footer -->

			</div>
			<!-- End of Content Wrapper -->

		</div>
		<!-- End of Page Wrapper -->

		<!-- Scroll to Top Button-->
		<a class="scroll-to-top rounded" href="#page-top">
			<i class="fas fa-angle-up"></i>
		</a>

		<!-- Logout Modal-->
		<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
		     aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">
							Ready to Leave?
						</h5>
						<button class="close" type="button" data-dismiss="modal"
						        aria-label="Close">
							<span aria-hidden="true">x</span>
						</button>
					</div>
					<div class="modal-body">Select "Logout" below if you are
						ready to end your current session.
					</div>
					<div class="modal-footer">
						<button class="btn btn-secondary" type="button"
						        data-dismiss="modal">Cancel
						</button>
						<a id="logout" class="btn btn-primary"
						   href="#">
							Logout
						</a>
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

		<!-- Page level custom scripts -->
		<script src="/js/product.js"></script>
		<script src="/js/jquery-cookie.js"></script>
		<script src="/js/admin-account.js"></script>

	</body>

</html>
