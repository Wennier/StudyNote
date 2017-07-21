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

// 	for(var i = 0; i <len ; i++){

// 		(function(i){

// 			imgs[i].onmouseover = function(){

// 				setImgsPos();//先将每个图片复位

// 				for(var j = 0; j <len ; j++){

// 					if(j <= this.index){
// 						imgs[j].style.left = j * exposeWidth + 'px';
// 					}else{
// 						imgs[j].style.left = ( j-1) * exposeWidth + imgWidth + 'px';
// 					}
// 				}			
// 		}


// 	})(i);
// }


	
	for(var i = 0;i<len; i++){
		(function(i){

			imgs[i].onmouseover = function(){

				//先复位
				setImgsPos();
				for(var j =1;j<=i;j++){
					imgs[j].style.left = parseInt(imgs[j].offsetLeft) - translate +'px';
				}
			}

			

		})(i);
	}

	


};