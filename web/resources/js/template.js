jQuery(document).ready(function($) {

	$(".headroom").headroom({
		"tolerance": 20,
		"offset": 50,
		"classes": {
			"initial": "animated",
			"pinned": "slideDown",
			"unpinned": "slideUp"
		}
	});
});

$(document).keypress(function(e) {
    if (e.keyCode == 27) { 
        $("#popdiv").fadeOut(500);
        //or
        window.close();
    } 
});

function validarSenha (input){
	if (input.value != document.getElementById("primeiraSenha").value) {
		$("#submitButton").addClass("disabled");
	} else {
		$("#submitButton").removeClass("disabled");
		$("#submitButton").addClass("active");
	}
}
