$(function() {

	$(".red").click(function() {

		var idSujet1 = $("select#select1").val();
		var idSujet2 = $("select#select2").val();
		var idSujet3 = $("select#select3").val();
		var idSujet4 = $("select#select4").val();
		var idSujet5 = $("select#select5").val();
		
		if (idSujet1 != idSujet2 && idSujet1 != idSujet3 && idSujet1 != idSujet4 && idSujet1 != idSujet5
				&& idSujet2 != idSujet3 && idSujet2 != idSujet4 && idSujet2 != idSujet5 && idSujet3 != idSujet4
				&& idSujet3 != idSujet5 && idSujet4 != idSujet5 ) {
			
			return true ; 
		}else
		{
			$.growl({
	            icon: '',
	            title: 'Attention ',
	            message: 'vous devez choisir des sujets different . ',
	            url: ''
	        },{
	            element: 'body',
	            type: 'danger',
	            allow_dismiss: true,
	            placement: {
	                from: 'top',
	                align: 'right'
	            },
	            offset: {
	                x: 30,
	                y: 30
	            },
	            spacing: 10,
	            z_index: 999999,
	            delay: 4500,
	            timer: 1000,
	            url_target: '_blank',
	            mouse_over: false,
	            animate: {
	                enter: 'animated fadeInRight',
	                exit: 'animated fadeOutRight'
	            },
	            icon_type: 'class',
	            template: '<div data-growl="container" class="alert" role="alert">' +
	            '<button type="button" class="close" data-growl="dismiss">' +
	            '<span aria-hidden="true">&times;</span>' +
	            '<span class="sr-only">Close</span>' +
	            '</button>' +
	            '<span data-growl="icon"></span>' +
	            '<span data-growl="title"></span>' +
	            '<span data-growl="message"></span>' +
	            '<a href="#" data-growl="url"></a>' +
	            '</div>'
	        });
		return false;
		
		}
			
			

	});

});