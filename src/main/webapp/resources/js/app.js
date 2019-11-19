"use strict"
var app = app || {}
app = (()=>{
	let context , js ;
	let run =x=>{
		
		$.getScript(x+'/resources/js/cmm/router.js',()=>{
			$.extend(new Session(x))
			init()
			onCreate()
		})
	}
	let init = ()=>{
		context = $.ctx()
		js = $.js()
	}
	let onCreate =()=>{
		setContentView()
	}
	let setContentView=()=>{
	    $('<table id ="tab"><tr></tr></table>')
	    .css({width :'80%', height:'800px', border:'1px solid pink', margin :'0 auto'
	   })
	   .appendTo('#tab')
	   $('<td/>',{id:'left'})
	   .css({width :'20%', height:'100%', border:'1px solid pink','vertical-align' :'top'})
	   .appendTo('tr')
	    $('<td/>',{id:'right'})
	   .css({width :'80%', height:'100%', border:'1px solid pink'})
	   .appendTo('tr')
	   $.each(['naver','cgv','bugs'],(i,j)=>{
		   $('<div/>')
		   .text(j)
		   .css({
			   width:'100%',
			   height: '100px',
			   border:'1px solid pink',
			   'text-align':'center'
		   })
		    .appendTo('#left')
		   .click(function(){
			  
			   $(this).css({'background-color':'yellow'})
			   $(this).siblings().css({'background-color':'white'})
			    context = $.ctx()
			   switch($(this).text()){
			   case 'naver' :
				   $.getJSON(context+'/crw/naver',d=>{
					   $('#right').empty()
					   $.each(d,(i,j)=>{
						   $('<div/>')
						   .html('<h1>'+j.origin+'<h1></br><h4>' + j.trans+'<h4>')
						   .css({
							   width:'40%',
							   height:'40%',
							   border:'3px solid red',
							   float :'left',
							   'text-align': 'center'
						   })
						   .appendTo('#right')
					   })
					   
				   })
				   break
			   case 'cgv' :
				   $.getJSON(context+'/crw/cgv',d=>{
					   $('#right').empty()
						   $.each(d,(i,j)=>{
							   $('<div><img style="width:200px" src="'+j.photo+'"/><br/><h4>'+j.title+'<br/>' + j.percent+'</h4><br/>' + j.info+'</div>')
							      .css({
									   border:'3px solid red',
									   float :'left',
									   'text-align': 'center'
								   })
								   .appendTo('#right')
						   })
					   
				   })
				   break
			   case 'bugs' :
				   $.getJSON(context+'/crw/bugs',d=>{
					   
				   })
				   break	   
			   }
		   })
		  
	   })
	}
	return{run}
})()