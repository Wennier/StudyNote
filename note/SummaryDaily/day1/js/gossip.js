

window.onload = function(){

	var box = document.getElementsByClassName('gossip-list')[0];

	var text = document.getElementsByTagName('textarea')[0];
	var send = document.getElementsByClassName('send')[0];

	var list = document.getElementsByClassName('gossip-list-ul')[0]; 

	// var listData = list.getElementsByClassName('data');
	// var listText = list.getElementsByClassName('text');

	

	send.onclick = function(){
		var liCopy = list.cloneNode(true);
		var listData = liCopy.getElementsByClassName('data');
		var listText = liCopy.getElementsByClassName('text');

		listText.innerHTML = "hello"; 
		alert(text.innerHTML);
		
		box.insertBefore(liCopy,box.children[0]);


	}

	function getData(){

	}


}