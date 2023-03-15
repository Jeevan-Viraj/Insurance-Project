$(document).ready(function() {
	$("#dateId").datepicker({
		showButtonPanel: true,
		dateFormat: "dd/M/yy",
		beforeShow: function() {
			$(".ui-datepicker").css('font-size', 12)
		}
	});
	$.ajax({
		url: "/vehicle/action",
		method: "GET",
		data: { operation: 'country' },
		success: function(data, textStatus, jqXHR) {
			console.log(data);
			let obj = $.parseJSON(data);
			$.each(obj, function(key, value) {
				$('#year').append('<option value="' + value.id + '">' + value.name + '</option>')
			});
			$('select').formSelect();
		},
		error: function(jqXHR, textStatus, errorThrown) {
			$('#country').append('<option>Country Unavailable</option>');
		},
		cache: false
	});

});

// This function is used to enter only Float values in the text box.
function validateFloat(evt, txtObject) {
	var charCode = (evt.which) ? evt.which : evt.keyCode
	if (txtObject.value.indexOf(".") == -1 || charCode != 46) {
		if (charCode != 46 && charCode > 31 && (charCode < 48 || charCode > 57)) {
			return false;
		}
		return true;
	}
	return false;
}

function onchangeZip(url) {
	$("#error").html("");
	var zip = $("#zip").val();
	/*var form = $("#formId").serialize();*/
	alert(zip);
	$.ajax({
		url: url,
		type: "POST",
		contentType: "application/json; charset=utf-8",
		data: JSON.stringify({ 'zip': zip }),
		success: function(data) {
			$("#city").html(data.city);
			$("#state").html(data.state);
		},
		error: function(err) {
			$("#error").html("<span style='color: red'>Invalid zip code entered</span>");
			$("#city").html("");
			$("#state").html("");
		}
	});

	$("#carName").change(function() {
		var carNameId = $(this).value();
		/*var form = $("#formId").serialize();*/
		alert(zip);
		$.ajax({
			url: url,
			type: "GET",
			success: function(result) {
				var result = Json.parse(result);
				var s = '';
				for (var i = 0; i < result.length; i++) {
					s += '<option value="' + result[i].id + '">' + result[i].name + '</option>';
				}
				$('#carModelId').html(s)

			}

		});
	});
}



















