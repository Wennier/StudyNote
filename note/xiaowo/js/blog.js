


change_bg();
head_animate();


function change_bg(){

	var main_bg = document.getElementsByClassName("main-wrapper")[0];

	var arr_bg = new Array("bg.gif","bg1.gif","bg2.gif","bg3.gif");
	var num = Math.floor(Math.random()*4);
	

	main_bg.style.backgroundImage = "url(img/"+ arr_bg[num]+ ")";
}

function head_animate(){
	var line_left = document.getElementsByClassName("left-line")[0];
	var line_right = document.getElementsByClassName("right-line")[0];
	

	line_left.style.left = 30 +"px";
	line_right.style.right = 30 +"px";
}

