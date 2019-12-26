/**
 * p.72.html
 * 
 */
$(document).ready(function(){
	let getRandom = function(num){
		let my_num = Math.floor(Math.random()*num);
		return my_num;
	};
	
	let hideCode = function(){
		let numRand = getRandom(4);
		numRand = 0;
		$(".guess_box").each(function(index, value){
			if(numRand === index){
				$(this).append("<span id='has_discount'></span>");
				return false;
			}
		});
	};
	
	hideCode();
	let checkForCode = function(){
		let discount = 0;
		if($.contains(this, document.getElementById("has_discount"))){
			let my_num = getRandom(100);
			discount = "<p>Your Code: Code"+new Date().getTime()+my_num+"</p>";
		}else{
			discount = "<p>Sorry, no discount this time!</p>";
		}
		$(this).append(discount);
		$(".guess_box").each(function(){
			if($.contains(this, document.getElementById("has_discount")))
				{
					$(this).addClass("discount");
				}else{
					$(this).addClass("no_discount");
				}
			$(this).unbind("click");
		});
		$("#result").append(discount);
	};
	$(".guess_box").click(checkForCode);
});