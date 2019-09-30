<!-- Header section -->
<header class="header-section">
	<div class="container-fluid">
		<!-- logo -->
		<div class="site-logo">
			<a href="/">
				<img src="/img/logo-white.png" alt="logo">
			</a>
		</div>
		<!-- responsive -->
		<div class="nav-switch">
			<i class="fa fa-bars"></i>
		</div>
		<div class="header-right">
			<span id="acc">
				<a href="cart" class="card-bag">
					<img src="/img/icons/bag.png" alt="">
					<span>${cartNumber}</span>
				</a>
				<span class="user-panel ml-1 dropdown">
					<i class="fa fa-user-circle"></i>
					<div class="dropdown-content">
						<ul>
							<li>
								<a href="account">${user.name}</a>
							</li>
							<li>
								<a href="account/change-password">Change password</a>
							</li>
							<li>
								<a id="logout" href="#">Logout</a>
							</li>
						</ul>
					</div>
				</span>
			</span>
			<span id="guest">
				<span class="user-panel ml-1" role="button" id="login-button"
				      title="Login">
					<i class="fa fa-user"></i>
				</span>
			</span>

		</div>
		<!-- site menu -->
		<ul class="main-menu">
			<li>
				<a href="/">Home</a>
			</li>
			<li>
				<a href="#">Dog</a>
			</li>
			<li>
				<a href="#">Cat</a>
			</li>
			<li>
				<a href="#">Fish</a>
			</li>
			<li>
				<a href="contact">Contact</a>
			</li>
		</ul>
	</div>
</header>
<!-- Header section end -->

