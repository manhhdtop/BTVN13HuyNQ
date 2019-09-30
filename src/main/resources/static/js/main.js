'use strict';

let usernameRegex = new RegExp('^(?=.*[A-Za-z])[A-Za-z\\d]{4,50}$');
let passwordRegex = new RegExp('^(?=.*[A-Za-z\\d])[A-Za-z\\d@$!%*#?&]{6,50}$');
let usernameConstraint = 'Username not valid. Username contain letter and number, ' +
    'minimum 4 characters, start with letter';
let passwordConstraint = 'Password not valid. Password contain letter, number and special' +
    ' character (@, $, !, %, *, #, ?, &), ' +
    'minimum 6 characters, start with letter or number';
let rePasswordConstraint = 'Password and re-password not match.';

$(window).on('load', function () {

    $('.nav-link-collapse').on('click', function () {
        $('.nav-link-collapse').not(this).removeClass('nav-link-show');
        $(this).toggleClass('nav-link-show');
    });

    /*------------------
        Preloder
    --------------------*/
    $(".loader").fadeOut();
    $("#preloder").delay(400).fadeOut("slow");

    console.log(user);
    if (user == null) {
        $('#acc').hide();
        $('#guest').show();
    } else {
        $('#acc').show();
        $('#guest').hide();
    }

    /*------------------
        Product filter
    --------------------*/
    if ($('#product-filter').length > 0) {
        var containerEl = document.querySelector('#product-filter');
        var mixer = mixitup(containerEl);
    }

});

(function ($) {
    /*------------------
        Navigation
    --------------------*/
    $('.nav-switch').on('click', function (event) {
        $('.main-menu').slideToggle(400);
        event.preventDefault();
    });


    /*------------------
        Background Set
    --------------------*/
    $('.set-bg').each(function () {
        var bg = $(this).data('setbg');
        $(this).css('background-image', 'url(' + bg + ')');
    });

    /*------------------
        Login modal
    --------------------*/
    $('#login-button').click(function (e) {
        // Open modal
        clearModalLogin();
        $('#login-modal').modal('toggle');
    });

    /*------------------
        Signup to login modal
    --------------------*/
    $('#do-login').click(function (e) {
        e.preventDefault();
        clearModalLogin();
        $('#signup-modal').modal('toggle');
        clearModalSignUp();
        $('#login-modal').modal('toggle');
    });

    /*------------------
        Login
    --------------------*/
    $('#login').click(function (e) {
        e.preventDefault();
        if (validateLogin()) {
            $(this).prop("disabled", true).removeClass('btn-primary').addClass('btn-disabled');
            $.post("login", {
                    username: $('#username').val().trim(),
                    password: $('#password').val().trim()
                },
                function (data) {
                    data = JSON.parse(data);
                    console.log(data);
                    if (data.code === 200) {
                        $('#message').html(data.message).parent().addClass('alert alert-success')
                            .removeClass('alert-danger');
                        Cookies.set('token', data.datas.token);
                        countDown($('#message'), 3, data.message + ' Page reload after' +
                            ' {0}s');
                    } else {
                        $('#message').html(data.message).parent().addClass('alert alert-danger')
                            .removeClass('alert-success');
                    }
                });
            $('#login').prop("disabled", false)
                .removeClass('btn-disabled').addClass('btn-primary');
        }
    });
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

    function validateLogin() {
        let valid = true;
        if (usernameRegex.test($('#username').val().trim())) {
            $('#username').addClass('is-valid').removeClass('is-invalid')
                .next().html('');
        } else {
            $('#username').addClass('is-invalid').removeClass('is-valid')
                .next().html(usernameConstraint);
            valid = false;
        }
        if (passwordRegex.test($('#password').val().trim())) {
            $('#password').addClass('is-valid').removeClass('is-invalid')
                .next().html('');
        } else {
            $('#password').addClass('is-invalid').removeClass('is-valid')
                .next().html(passwordConstraint);
            valid = false;
        }
        return valid;
    }

    function validateSignUp() {
        let valid = true;
        if (usernameRegex.test($('#username-signup').val().trim())) {
            $('#username-signup').addClass('is-valid').removeClass('is-invalid')
                .next().html('');
        } else {
            $('#username-signup').addClass('is-invalid').removeClass('is-valid')
                .next().html(usernameConstraint);
            valid = false;
        }
        if (passwordRegex.test($('#password-signup').val().trim())) {
            $('#password-signup').addClass('is-valid').removeClass('is-invalid')
                .next().html('');
        } else {
            $('#password-signup').addClass('is-invalid').removeClass('is-valid')
                .next().html(passwordConstraint);
            valid = false;
        }
        if ($('#re-password').val().trim() !== '') {
            if ($('#password-signup').val().trim() === $('#re-password').val().trim()) {
                $('#re-password').addClass('is-valid').removeClass('is-invalid')
                    .next().html('');
            } else {
                $('#re-password').addClass('is-invalid').removeClass('is-valid')
                    .next().html(rePasswordConstraint);
                valid = false;
            }
        }
        return valid;
    }

    $('input[type=password]').on('propertychange input', function (e) {
        var valueChanged = false;
        if (e.type === 'propertychange') {
            valueChanged = e.originalEvent.propertyName === 'value';
        } else {
            valueChanged = true;
        }
        if (valueChanged) {
            if (passwordRegex.test($('#password-signup').val().trim())) {
                $('#password-signup').addClass('is-valid').removeClass('is-invalid')
                    .next().html('');
                if ($('#re-password').val().trim() !== '') {
                    if ($('#password-signup').val().trim() === $('#re-password').val().trim()) {
                        $('#re-password').addClass('is-valid').removeClass('is-invalid')
                            .next().html('');
                    } else {
                        $('#re-password').addClass('is-invalid').removeClass('is-valid')
                            .next().html(rePasswordConstraint);
                    }
                }
            } else {
                $('#password-signup').addClass('is-invalid').removeClass('is-valid')
                    .next().html(passwordConstraint);
            }
        }
    });

    /*------------------
        Logout
    --------------------*/
    $('#logout').click(function (e) {
        e.preventDefault();
        $.post("logout", {
            token: Cookies.get('token')
        }, function (data) {
            console.log(data);
            data = JSON.parse(data);
            if (data.code !== 200) {
                alert('Token not found.');
            }
            Cookies.remove('token');
            location.reload();
        });
    });

    /*------------------
        Sign up
    --------------------*/
    $('#signup').click(function (e) {
        e.preventDefault();
        if (validateSignUp()) {
            $('#message-signup').html('').parent().removeClass('alert alert-success alert-danger');
            $(this).prop("disabled", true).removeClass('btn-primary').addClass('btn-disabled');
            $.post("signup", {
                    username: $('#username-signup').val().trim(),
                    password: $('#password-signup').val().trim()
                },
                function (data) {
                    data = JSON.parse(data);
                    console.log(data);
                    if (data.code === 200) {
                        $('#message-signup').html(data.message).parent().addClass('alert alert-success')
                            .removeClass('alert-danger');
                        Cookies.set('token', data.datas.token);
                        countDown($('#message-signup'), 3, data.message + ' Page reload after' +
                            ' {0}s');
                    } else {
                        $('#message-signup').html(data.message).parent().addClass('alert alert-danger')
                            .removeClass('alert-success');
                    }
                });
            $('#signup').prop("disabled", false)
                .removeClass('btn-disabled').addClass('btn-primary');
        }
    });

    /*------------------
        Signup modal
    --------------------*/
    $('#signup-button').click(function (e) {
        e.preventDefault();

        clearModalSignUp();
        // Open modal
        $('#login-modal').modal('toggle');
        clearModalLogin();
        $('#signup-modal').modal('toggle');
    });

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

    /*------------------
        Add to cart
    --------------------*/
    $('a.add-to-cart').click(function (e) {
        e.preventDefault();

        $.post("/add-to-cart",
            {
                id: 1,
                name: "guest1"
            },
            function (e) {
                console.log(e);
            });
    });

    /*------------------
        Hero Slider
    --------------------*/
    $('.hero-slider').owlCarousel({
        loop: true,
        nav: true,
        navText: ['<i class="fa fa-angle-left"></i>', '<i class="fa fa-angle-right"></i>'],
        dots: true,
        mouseDrag: false,
        animateOut: 'fadeOut',
        animateIn: 'fadeIn',
        items: 1,
        autoplay: true
    });

    function clearModalLogin() {
        $('#message').html('').parent().removeClass('alert alert-success alert-danger');
        $('#username').val('').removeClass('is-valid is-invalid').next().html('');
        $('#password').val('').removeClass('is-valid is-invalid').next().html('');
    }

    function clearModalSignUp() {
        $('#message-signup').html('').parent().removeClass('alert alert-success alert-danger');
        $('#username-signup').val('').removeClass('is-valid is-invalid').next().html('');
        $('#password-signup').val('').removeClass('is-valid is-invalid').next().html('');
        $('#re-password').val('').removeClass('is-valid is-invalid').next().html('');
    }

    /*------------------
        Intro Slider
    --------------------*/
    if ($('.intro-slider').length > 0) {
        var $scrollbar = $('.scrollbar');
        var $frame = $('.intro-slider');
        var sly = new Sly($frame, {
            horizontal: 1,
            itemNav: 'forceCentered',
            activateMiddle: 1,
            smart: 1,
            activateOn: 'click',
            //mouseDragging: 1,
            touchDragging: 1,
            releaseSwing: 1,
            startAt: 10,
            scrollBar: $scrollbar,
            //scrollBy: 1,
            activatePageOn: 'click',
            speed: 200,
            moveBy: 600,
            elasticBounds: 1,
            dragHandle: 1,
            dynamicHandle: 1,
            clickBar: 1,
        }).init();
    }


    /*------------------
        ScrollBar
    --------------------*/
    $(".cart-table, .product-thumbs").niceScroll({
        cursorborder: "",
        cursorcolor: "#afafaf",
        boxzoom: false
    });


    /*------------------
        Single Product
    --------------------*/
    $('.product-thumbs-track > .pt').on('click', function () {
        var imgurl = $(this).data('imgbigurl');
        var bigImg = $('.product-big-img').attr('src');
        if (imgurl != bigImg) {
            $('.product-big-img').attr({src: imgurl});
        }
    })

})(jQuery);

