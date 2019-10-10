(function ($) {
	"use strict"; // Start of use strict
	
	let usernameRegex = new RegExp('^(?=.*[A-Za-z])[A-Za-z\\d]{4,50}$');
	let passwordRegex = new RegExp('^(?=.*[A-Za-z\\d])[A-Za-z\\d@$!%*#?&]{6,50}$');
	let nameConstraint = 'Name not valid.';
	let usernameConstraint = 'Username not valid. Username contain letter and number, ' +
		'minimum 4 characters, start with letter';
	let passwordConstraint = 'Password not valid. Password contain letter, number and special' +
		' character (@, $, !, %, *, #, ?, &), ' +
		'minimum 6 characters, start with letter or number';
	let rePasswordConstraint = 'Password and RePassword not match.';
	
	$("#login").on('submit', function (e) {
		let data = {};
		// Make sure you use the 'name' field on the inputs you want to grab.
		$(this).find('input').each(function (i, v) {
			let input = $(this), // resolves to current input element.
				name = input.attr('id');
			name = name.replace('Login', '');
			data[name] = input.val().trim();
		});
		e.preventDefault();
		if (validateLogin(data)) {
			$(this).prop("disabled", true);
			$.post("/api/user/login", {
					username: data['username'],
					password: data['password']
				},
				function (data) {
					processJson(data);
				});
			$('#login').prop("disabled", false);
		}
	});
	
	$('#register').on('submit', function (e) {
		let data = {};
		// Make sure you use the 'name' field on the inputs you want to grab.
		$(this).find('input').each(function (i, v) {
			let input = $(this), // resolves to current input element.
				name = input.attr('id');
			name = name.replace('Register', '');
			data[name] = input.val().trim();
		});
		e.preventDefault();
		let valid = validateRegister(data);
		
		if (valid) {
			$(this).prop("disabled", true);
			$.post("/api/user/register", {
					name: data['name'],
					username: data['username'],
					password: data['password']
				},
				function (data) {
					processJson(data);
				});
			$(this).prop("disabled", false);
		}
		
		console.log(data);
	});
	
	$('input').not('input[type=checkbox]').on('propertychange input', function (e) {
		var valueChanged = false;
		if (e.type === 'propertychange') {
			valueChanged = e.originalEvent.propertyName === 'value';
		} else {
			valueChanged = true;
		}
		if (valueChanged) {
			$(this).removeClass('is-invalid is-valid').next().html('');
		}
	});
	
	function validateLogin(data) {
		let valid = true;
		if (usernameRegex.test(data['username'])) {
			$('#usernameLogin').addClass('is-valid').removeClass('is-invalid')
				.next().html('');
		} else {
			$('#usernameLogin').addClass('is-invalid').removeClass('is-valid')
				.next().html(usernameConstraint);
			valid = false;
		}
		if (passwordRegex.test(data['password'])) {
			$('#passwordLogin').addClass('is-valid').removeClass('is-invalid')
				.next().html('');
		} else {
			$('#passwordLogin').addClass('is-invalid').removeClass('is-valid')
				.next().html(passwordConstraint);
			valid = false;
		}
		return valid;
	}
	
	function validateRegister(data) {
		let valid = true;
		
		if (data['name'] !== '') {
			$('#nameRegister').addClass('is-valid').removeClass('is-invalid')
				.next().html('');
		} else {
			$('#nameRegister').addClass('is-invalid').removeClass('is-valid')
				.next().html(nameConstraint);
			valid = false;
		}
		
		if (usernameRegex.test(data['username'])) {
			$('#usernameRegister').addClass('is-valid').removeClass('is-invalid')
				.next().html('');
		} else {
			$('#usernameRegister').addClass('is-invalid').removeClass('is-valid')
				.next().html(usernameConstraint);
			valid = false;
		}
		
		if (passwordRegex.test(data['password'])) {
			$('#passwordRegister').addClass('is-valid').removeClass('is-invalid')
				.next().html('');
		} else {
			$('#passwordRegister').addClass('is-invalid').removeClass('is-valid')
				.next().html(passwordConstraint);
			valid = false;
		}
		
		if (data['rePassword'] !== '' && data['rePassword'] === data['password']) {
			$('#rePasswordRegister').addClass('is-valid').removeClass('is-invalid')
				.next().html('');
		} else {
			$('#rePasswordRegister').addClass('is-invalid').removeClass('is-valid')
				.next().html(rePasswordConstraint);
			valid = false;
		}
		return valid;
	}
	
	$("#loginToAnotherAccount").click(function (e) {
		e.preventDefault();
		logout();
	});
	
	$("#logout").click(function (e) {
		e.preventDefault();
		logout();
	});
	
	function logout() {
		$.post("/api/user/logout", {
			token: Cookies.get('token')
		}, function (data) {
			console.log(data);
			if (data.code !== 200) {
				console.log('Token not found.');
			}
			Cookies.remove('token');
			location.reload();
		});
	}
	
	function countDown(element, time, message) {
		let x = setInterval(function () {
			// Display the result in the element with id="demo"
			element.html(message.format(time));
			// If the count down is finished, write some text
			time--;
			if (time < 0) {
				clearInterval(x);
				window.location.replace('/backend/');
			}
		}, 1000);
	}
	
	function processJson(data) {
		console.log(data);
		if (data.code === 200) {
			$('#message').html(data.message).parent().addClass('alert alert-success')
				.removeClass('alert-danger');
			Cookies.set('token', data.datas.token, {expires: 7});
			countDown($('#message'), 3, data.message + ' Redirect to Admin site' +
				' after {0}s');
		} else {
			$('#message').html(data.message).parent().addClass('alert alert-danger')
				.removeClass('alert-success');
		}
	}
	
	String.prototype.format = String.prototype.format ||
		function () {
			"use strict";
			var str = this.toString();
			if (arguments.length) {
				var t = typeof arguments[0];
				var key;
				var args = ("string" === t || "number" === t) ?
					Array.prototype.slice.call(arguments)
					: arguments[0];
				
				for (key in args) {
					str = str.replace(new RegExp("\\{" + key + "\\}", "gi"), args[key]);
				}
			}
			return str;
		};
	
})(jQuery); // End of use strict
