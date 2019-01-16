//Offset with respect to GMT of the different cities
var timeOffsets= {'New York': -5, 'London': 0, 'Paris':+1, 'Moscow':+3, 'New Delhi':+5.5 , 'Beijing' :+8, 'Dubai':+4, 'Sydney':+11}


function getTimeForCity(city , offset) {
    // create Date object for current location
    var d = new Date();
    // convert to msec
    // subtract local time zone offset
    // get UTC time in msec
    var utc = d.getTime() + (d.getTimezoneOffset() * 60000);
    // create new Date object for different city
    var nd = new Date(utc + (3600000*offset));
    // return time as a string
    return "The local time for city "+ city +" is "+ nd.toLocaleString();
}





function setTimeZone() {
	var elems = document.getElementsByClassName("carousel-caption");
	for(var i=0; i<elems.length; i+=1)
	{
		var c = elems[i].childNodes;
		console.log(elems[i].children[0])
		if(elems[i].childElementCount == 1)
		{
			var p = document.createElement('p');
			console.log(elems[i].children[0].innerHTML);
			p.id = elems[i].children[0].innerHTML;
			elems[i].appendChild(p);
			
		}
		else
		{
			var p = document.getElementById(elems[i].children[0].innerHTML);
		}
		console.log(getTimeForCity(elems[i].children[0].innerHTML, timeOffsets[elems[i].children[0].innerHTML]))
		p.innerHTML = getTimeForCity(elems[i].children[0].innerHTML, timeOffsets[elems[i].children[0].innerHTML]);
		

	}
	setTimeout(setTimeZone, 1000);
	

}

setTimeZone()