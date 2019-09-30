<%--
  User: ManhHd
  Date: 25/09/2019

  This jsp contain some modal needed for web
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- Login Modal -->
<div class="modal fade" id="login-modal" tabindex="-1" role="dialog"
     aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">Login</h5>
				<button type="button" class="close" data-dismiss="modal"
				        aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form>
					<div class="form-group">
						<label for="username">Username</label>
						<input name="username" id="username"
						       type="text" class="form-control"
						       placeholder="Username...">
						<small class="text-danger"></small>
					</div>
					<div class="form-group">
						<label for="password">Password</label>
						<input name="password" id="password"
						       type="password" class="form-control"
						       placeholder="********">
						<small class="text-danger"></small>
					</div>
					<div>
						<label id="message-login"></label>
					</div>
				</form>
			</div>
			<div class="modal-footer">
						<span>
							Need a account?
							<a id="signup-button" href="#">
								Sign up
							</a>
						</span>
				<button id="login" type="button"
				        class="btn btn-primary">
					Login
				</button>
			</div>
		</div>
	</div>
</div>

<!-- Sign up Modal -->
<div class="modal fade" id="signup-modal" tabindex="-1" role="dialog"
     aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">Sign up a account</h5>
				<button type="button" class="close" data-dismiss="modal"
				        aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form>
					<div class="form-group">
						<label for="username-signup">Username</label>
						<input name="username-signup"
						       id="username-signup"
						       type="text" class="form-control"
						       placeholder="Username...">
						<small class="text-danger"></small>
					</div>
					<div class="form-group">
						<label for="password-signup">Password</label>
						<input name="password" id="password-signup"
						       type="password" class="form-control"
						       placeholder="********">
						<small class="text-danger"></small>
					</div>
					<div class="form-group">
						<label for="re-password">Re password</label>
						<input name="re-password" id="re-password"
						       type="password" class="form-control"
						       placeholder="********">
						<small class="text-danger"></small>
					</div>
					<div>
						<label id="message-signup"></label>
					</div>
				</form>
			</div>
			<div class="modal-footer">
						<span>
							Have a account?
							<a id="do-login" href="#">
								Login
							</a>
						</span>
				<button id="signup" type="button"
				        class="btn btn-primary">
					Sign up
				</button>
			</div>
		</div>
	</div>
</div>


<!-- Logout Modal -->
<div class="modal fade" id="logout-modal" tabindex="-1" role="dialog"
     aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">Logout</h5>
				<button type="button" class="close" data-dismiss="modal"
				        aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				Do you want to logout?
			</div>
			<div class="modal-footer">
				<button class="btn btn-secondary" data-dismiss="modal">
					Cancel
				</button>
				<button id="logout" type="button" class="btn btn-primary">
					logout
				</button>
			</div>
		</div>
	</div>
</div>

