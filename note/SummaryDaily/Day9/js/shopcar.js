
window.onload = function(){

	//IE以下没有getElementsByClassName的方法
	//处理： 

	if(!document.getElementsByClassName){
		 document.getElementsByClassName = function(cls){

		 	var ret = [];
		 	var els = document.getElementsTagName('*');
		 	for(var i =0,len = els.length;i<len ;i++){

		 		if(els[i].className === cls 
		 			|| els[i].indexOf(cls + ' ')>=0
		 			|| els[i].indexOf(' '+ cls + ' ')>=0
		 			|| els[i].indexOf(' ' + cls)>=0 ){

		 			ret.push(els[i]);
		 		}

		 	}
		 	return ret;

		 }
	}

	var carTable =  document.getElementById('cartable');
	var tr = carTable.children[1].rows;
	var checkInputs = document.getElementsByClassName('check');
	var checkAllInputs = document.getElementsByClassName('check-all');
	var selectTotal = document.getElementById('selectedTotal');
	var priceTotal = document.getElementById('priceTotal')


	for(var i = 0, len = checkInputs.length ; i < len; i++){

		checkInputs[i].onclick = function(){

			if(this.className === 'check-all check'){
				for(var j =0,len = checkInputs.length; j<len; j++){
					checkInputs[j].checked = this.checked;
				}
			}

			if(this.checked === false){
				for(var k = 0,len = checkAllInputs.length; k <len ; k++){
					checkAllInputs[k].checked = false;
				}
			}


			getTotal();

		}
	}


	//计算
	function getTotal(){

		var select = 0;
		var price = 0;

		for(var i = 0, len = tr.length; i < len; i++ ){
			if(tr[i].getElementsByTagName('input')[0].checked){
				select += parseInt(tr[i].getElementsByTagName('input')[1].value);
				price += parseFloat(tr[i].cells[4].innerHTML);
			}
		}

		selectTotal.innerHTML = select;
		priceTotal.innerHTML = price.toFixed(2);

	}

}