function display(){
	
	document.getElementById('demo').innerHTML=calculate(1);
	document.getElementById('demo1').innerHTML=calculate(1);
	document.getElementById('demo2').innerHTML=calculate(1);
	document.getElementById('demo3').innerHTML=calculate(1);
	//document.getElementById('demo1').innerHTML=
}
function calculate(city,offset)
{
	
	var date=new Date();
	var offset1 = date.getTimezoneOffset();
	var utc	= date.getTime() + (offset1 * 60000);
	var nd=new Date(utc + (3600000*offset);
	return nd.toLocaleString();

}
