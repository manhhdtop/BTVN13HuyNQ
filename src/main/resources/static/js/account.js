function countDown(element, time, message) {
    let x = setInterval(function () {
        // Display the result in the element with id="demo"
        element.html(message.format(time));
        // If the count down is finished, write some text
        time--;
        if (time < 0) {
            clearInterval(x);
            location.reload();
        }
    }, 1000);
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

$(window).on('load', function () {
    if (path == null) {
        $('#section-information').show();
    } else {
        id = '#section-' + path;
        $(id).show();
    }
});

(function ($) {

    /*------------------
        Change password
    --------------------*/
    $('#change-password').click(function (e) {
        e.preventDefault();
        if (validate()) {
            $('#message').html('').parent().removeClass('alert alert-success alert-danger');
            $(this).prop("disabled", true).removeClass('btn-primary').addClass('btn-disabled');
            $.post("/change-password", {
                    password: $('#new-pass').val().trim()
                },
                function (data) {
                    console.log(data);
                    data = JSON.parse(data);
                    if (data.code === 200) {
                        $('#message').html(data.message).parent().addClass('alert alert-success')
                            .removeClass('alert-danger');
                        Cookies.set('token', data.datas.token, {expires: 7});

                    } else {
                        $('#message').html(data.message).parent().addClass('alert alert-danger')
                            .removeClass('alert-success');
                    }
                });
            $('#change-password').prop("disabled", false)
                .removeClass('btn-disabled').addClass('btn-primary');
        }
    });

    function validate() {
        let valid = true;

        if (passwordRegex.test($('#old-pass').val().trim())) {
            $('#old-pass').addClass('is-valid').removeClass('is-invalid')
                .next().html('');
        } else {
            valid = false;
            $('#old-pass').addClass('is-invalid').removeClass('is-valid')
                .next().html(passwordConstraint);
        }

        if (passwordRegex.test($('#new-pass').val().trim())) {
            if ($('#old-pass').val().trim() === $('#new-pass').val().trim()) {
                $('#new-pass').addClass('is-invalid').removeClass('is-valid')
                    .next().html('Old password and new password must not be same.');
                valid = false;
            } else {
                $('#new-pass').addClass('is-valid').removeClass('is-invalid')
                    .next().html('');
            }
        } else {
            valid = false;
            $('#new-pass').addClass('is-invalid').removeClass('is-valid')
                .next().html(passwordConstraint);
        }

        if ($('#re-pass').val().trim() !== '') {
            if ($('#re-pass').val().trim() === $('#new-pass').val().trim()) {
                $('#re-pass').addClass('is-valid').removeClass('is-invalid')
                    .next().html('');
            } else {
                valid = false;
                $('#re-pass').addClass('is-invalid').removeClass('is-valid')
                    .next().html(rePasswordConstraint);
            }
        } else {
            valid = false;
            $('#re-pass').addClass('is-invalid').removeClass('is-valid')
                .next().html(rePasswordConstraint);
        }

        return valid;
    }

    $('#re-pass').on('propertychange input', function (e) {
        var valueChanged = false;
        if (e.type === 'propertychange') {
            valueChanged = e.originalEvent.propertyName === 'value';
        } else {
            valueChanged = true;
        }
        if (valueChanged) {
            if ($(this).val().trim() === $('#new-pass').val().trim()) {
                $(this).addClass('is-valid').removeClass('is-invalid')
                    .next().html('');
            } else {
                $(this).addClass('is-invalid').removeClass('is-valid')
                    .next().html(rePasswordConstraint);
            }
        }
    });

    $('input.password').on('propertychange input', function (e) {
        var valueChanged = false;
        if (e.type === 'propertychange') {
            valueChanged = e.originalEvent.propertyName === 'value';
        } else {
            valueChanged = true;
        }
        if (valueChanged) {
            if (passwordRegex.test($(this).val().trim())) {
                $(this).addClass('is-valid').removeClass('is-invalid')
                    .next().html('');
                if ($(this)[0].id === 'new-pass') {
                    if ($('#re-pass').val().trim() !== '') {
                        if ($('#re-pass').val().trim() === $('#new-pass').val().trim()) {
                            $('#re-pass').addClass('is-valid').removeClass('is-invalid')
                                .next().html('');
                        } else {
                            $('#re-pass').addClass('is-invalid').removeClass('is-valid')
                                .next().html(rePasswordConstraint);
                        }
                    }
                }
            } else {
                $(this).addClass('is-invalid').removeClass('is-valid')
                    .next().html(passwordConstraint);
            }
        }
    });

})(jQuery);