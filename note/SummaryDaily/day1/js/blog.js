


window.onload = function(){

change_bg();

};

function change_bg(){

	var main_bg = document.getElementsByClassName("main-wrapper")[0];

	var arr_bg = new Array("bg.gif","bg1.gif","bg2.gif","bg3.gif");
	var num = Math.floor(Math.random()*4);
	

	main_bg.style.backgroundImage = "url(img/"+ arr_bg[num]+ ")";
}


