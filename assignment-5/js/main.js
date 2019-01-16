
var cities = {
    'london': 0.0,
    'bengaluru': 5.5,
    'sydney': 11.0,
    'singapore': 8.0
}
var img_base_url = "http://www.wearemiq.com/wp-content/uploads/2018/06/"

var getCityTime = function (offset) {
    var date = new Date();
    var utc = date.getTime() + (date.getTimezoneOffset() * 60000);
    // console.log(offset);
    var new_date = new Date(utc + offset * 60 * 60 * 1000);
   // console.log(new_date);
    return new_date;
}

var Image = function (city, offset) {

    this.city = city;
    this.src_url = img_base_url + city + ".jpg";
    this.offest = offset;
    this.time = getCityTime(offset);
}





var images = new Array();
for (var city in cities) {
    new_image = new Image(city, cities[city]);
    images.push(new_image);
}

var count = 0;
var parent_text = document.getElementsByClassName("carousel-indicators")[0];
var parent_image = document.getElementsByClassName("carousel-inner")[0];


//li data-target="#myCarousel" data-slide-to="0" class="active"></li>
for (var i =0; i < images.length; i++) {

    var image_node = document.createElement("div");
    image_node.classList.add("item");
    var img = document.createElement("img");
    img.setAttribute("src", images[i].src_url);
    var city_name = document.createElement('h2');
    city_id = document.createAttribute("id")
    city_id.value = images[i].city;
    city_name.setAttributeNode(city_id);
    var text = document.createTextNode(images[i].city + " " + images[i].time.toLocaleTimeString());
    city_name.appendChild(text);
    
    var city_name_node = document.createElement("li")
    var d1 = document.createAttribute("data-target");
    d1.value = "#myCarousel";
    var d2 = document.createAttribute("data-slide-to");
    d1.value = count;
    city_name_node.setAttributeNode(d1)
    city_name_node.setAttributeNode(d2);

    if (count == 0) {
       city_name_node.classList.add("active");
        image_node.classList.add("active");
    }

    image_node.appendChild(img);
    image_node.appendChild(city_name);
    parent_image.appendChild(image_node);
    parent_text.appendChild(city_name_node);
    count++;
}


var updateTime = function (){
    for ( var i = 0; i < images.length; i++){
    //    console.log(images[i]);
        var time_text = document.getElementById(images[i].city);
         //console.log(images[i].time);
        var offset = cities[images[i].city]
     //  console.log(offset);
        var new_time = getCityTime(offset);
         console.log(new_time);
       // images[i]['time'] = new_time;
        time_text.innerHTML= images[i].city + " " + new_time.toLocaleTimeString();
    }
    
}

var fun = function () {
    updateTime();
    setTimeout(fun, 500);
}

fun();
