$(function() {
	$.ajax({
		type: 'post',
		url: '/person/getList',
		success: function(data) {
			console.log(JSON.stringify(data));
			
			$.each(data, function(index, item) {
				var html = `<tr>
							    <td align="center"><img src="/storage/${item.photo}" /></td>
							    <td align="center">${item.name}</td>
							    <td align="center">${item.age}</td>
						    </tr>`;
						   
				$('#listTable').append(html);
			}); //each
		},
		error: function(err) {
			console.log(err);
		}
	});
});
