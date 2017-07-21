window.onload = function(){

	var box = document.getElementById('wrapper');

	var imgs = box.getElementsByTagName('img');

	var imgWidth = imgs[0].offsetWidth;

	var exposeWidth = 160;

	var boxWidth = imgWidth + (imgs.length - 1) * exposeWidth;

	box.style.width = boxWidth + 'px';
	var len = imgs.length;

	for(var i = 0; i <len ; i++ ){
		imgs[i].index = i;
	}

	function setImgsPos(){

		for(var i = 1; i <len ; i++){

			imgs[i].style.left = imgWidth + exposeWidth *(i-1) +'px';

		}
	}

	setImgsPos();





	var translate = imgWidth - exposeWidth;

	for(var i = 0; i <len ; i++){

		(function(i){

			imgs[i].onmouseover = function(){

				setImgsPos();//先将每个图片复位

				for(var i = 0; i <len ; i++){

					if(i <= this.index){
						imgs[i].style.left = i * exposeWidth + 'px';
					}else{
						imgs[i].style.left = (i-1) * exposeWidth + imgWidth + 'px';
					}
				}			
		}


	})(i);
}

	


};