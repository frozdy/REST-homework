function getData() {
	$.ajax({
		url: "http://localhost:8080/rst2/api/cars",
		type: "GET",
		dataType: "json",
		success: function(data) {
			$.each(data, function(index){
				var tr = $('<tr>');
				tr.append('<td>' + data[index].id + '</td>');
				tr.append('<td>' + data[index].brand + '</td>');
				tr.append('<td>' + data[index].model + '</td>');
				tr.append('<td>' + data[index].price + '</td>');
				tr.append('<td>' + data[index].year + '</td>');
				tr.append('<td>' + data[index].hp + '</td>');
				tr.append('</tr>');
				$('#carsTable').append(tr);
			});
		}
	});
}

function addCar(){
	var car = {
			brand:$("#brand").val(),
			model:$("#model").val(),
			price:$("#price").val(),
			year:$("#year").val(),
			hp:$("#hp").val()
			
	}
	$.ajax({
		url: "http://localhost:8080/rst2/api/cars",
		type: "POST",
		dataType: "json",
		data: JSON.stringify(car),
		contentType: "application/json",
		success: function(data) {
			var tr = $('<tr>');
			tr.append('<td>' + data + '</td>');
			tr.append('<td>' + car.brand + '</td>');
			tr.append('<td>' + car.model + '</td>');
			tr.append('<td>' + car.price + '</td>');
			tr.append('<td>' + car.year + '</td>');
			tr.append('<td>' + car.hp + '</td>');
			tr.append('</tr>');
			$('#carsTable').append(tr);
			console.log(car);
		}
	});
}

function filter(){
	$.ajax({
		url: "http://localhost:8080/rst2/api/cars",
		type: "GET",
		dataType: "json",
		data:{brandFilter:$("#brandFilter").val(), modelFilter:$("#modelFilter").val()},
		success: function(data) {
			$("#carsTable tr").remove();
			$.each(data, function(index){
				var tr = $('<tr>');
				tr.append('<td>' + data[index].id + '</td>');
				tr.append('<td>' + data[index].brand + '</td>');
				tr.append('<td>' + data[index].model + '</td>');
				tr.append('<td>' + data[index].price + '</td>');
				tr.append('<td>' + data[index].year + '</td>');
				tr.append('<td>' + data[index].hp + '</td>');
				tr.append('</tr>');
				$('#carsTable').append(tr);
			});
			
		}
	});
}



$(document).ready(function() {
	$.ajax({
		url: "http://localhost:8080/rst2/api/cars/autocomplete",
		type: "GET",
		dataType: "json",
		success: function(data) {
			$( "#brandFilter" ).autocomplete({
				source: data
			});
		}
	});
	getData();
	
	
});