(function ($) {
	"use strict"; // Start of use strict
	
	$(document).ready(function () {
	
	});
	
	$('input[type=file]').on('change', function (e) {
		let label = $(this).val().replace(/\\/g, '/').replace(/.*\//, '');
		readURL(this);
		$(this).trigger('fileSelect', [label]);
	}).on('fileSelect', function (event, label) {
		let input = $(this).parents('.input-group').find(':text'),
			log = label;
		if (input.length) {
			input.val(log);
		} else {
			if (log) {
				alert(log);
			}
		}
	});
	
	$('#add-product').on('submit', function (e) {
		e.preventDefault();
		
		
		
	});
	
})(jQuery); // End of use strict
