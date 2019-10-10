(function ($) {
	"use strict"; // Start of use strict
	
	var datas = [];
	
	$(document).ready(function () {
		paging(2);
	});
	
	function paging(page) {
		let url =  '/api/products';
		if (new RegExp(/[0-9]+/).test(page)){
			url += '?page=' + page;
		}
		$.ajax({
			method: 'post',
			url: '/api/products',
			contentType: "application/json",
			dataType: 'json',
			success: function (e) {
				console.log(e);
				datas = e.data;
			},
			error: function (e) {
				console.log(e);
			}
		});
		$('#pagination').pagination({
			dataSource: data,
			pageSize: 5,
			ajax: {
				beforeSend: function () {
					$('#products > tbody').html('<td colspan="5">Loading data...</td>');
				},
			},
			callback: function (datas, pagination) {
				let html = '';
				$.each(datas, function (index, item) {
					html += '<tr><td>' + item[0] + '</td>';
					html += '<td>Accountant</td>';
					html += '<td>Tokyo</td>';
					html += '<td>63</td>';
					html += '<td>2011/07/25</td>';
					html += '<td>$170,750</td></tr>';
				});
				$('#products > tbody').html(html);
			}, beforePaging: function (e) {
				console.log(e);
				$.ajax({
					method: 'post',
					url: '/api/products',
					contentType: "application/json",
					data: {
						page: page,
					},
					dataType: 'json',
					success: function (e) {
						console.log(e);
						datas = e.data;
						paging(page, datas);
					}, error: function (e) {
						console.log(e);
					}
				});
			}
		});
		$("#pagination").pagination("selectedPage", page);
	}
	
})(jQuery); // End of use strict
