'use strict';

$(window).on('load', function () {
    /*------------------
        Preloder
    --------------------*/
    $(".loader").fadeOut();
    $("#preloder").delay(400).fadeOut("slow");


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
        clearModalLogin();
        $('#signup-modal').modal('toggle');
        clearModalSignUp();
        $('#login-modal').modal('toggle');
    });

    /*------------------
        Login
    --------------------*/
    $('#login').click(function (e) {

    });

    /*------------------
        Sign up
    --------------------*/
    $('#signup').click(function (e) {

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
        $('#username').val('');
        $('#password').val('');
    }

    function clearModalSignUp() {
        $('#username-signup').val('');
        $('#password-signup').val('');
        $('#re-password').val('');
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

