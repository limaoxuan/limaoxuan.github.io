let timerID = null;
let size = getFontSize();

function myClick() {
    // alert("Hello, world!");
    if (timerID == null) {

        size = parseInt(size);
        console.log(size);
        timerID = setInterval(changeFontSize, 500);
    } else {
        // setInterval()
        clearTimeout(timerID);
        timerID = null;
    }


}

function changeFontSize() {

    console.log(size);
    size = size + 2;
    document.getElementById("my-textarea").style.fontSize = size + "px";

}

function getFontSize() {
    let elem = document.getElementById("my-textarea");
    return window.getComputedStyle(elem, null).getPropertyValue("font-size");
}

document.getElementById("my-click").onclick = myClick;
document.getElementById("convert").onclick = convert;

function convert() {
    let element = document.getElementById("my-textarea");
    console.log(element);
    element.value = translate( element.value);
}

function translate(str) {
    str=str.toLowerCase();
    var n =str.search(/[aeiuo]/);
    switch (n){
        case 0: str = str+"way"; break;
        case -1: str = str+"ay"; break;
        default :
            //str= str.substr(n)+str.substr(0,n)+"ay";
            str=str.replace(/([^aeiou]*)([aeiou])(\w+)/, "$2$3$1ay");
            break;
    }
    return str;

}

let isChecked = false;

function myChange() {
    let element = document.getElementById("my-textarea");
    isChecked = !isChecked;

    let style = element.style.textDecoration;
    console.log(style);
    if (isChecked) {
        element.style.textDecoration = "underline green";
        element.style.fontWeight = "bold";
        document.getElementById("container").style.background = "url('https://courses.cs.washington.edu/courses/cse190m/CurrentQtr/labs/6/hundred-dollar-bill.jpg')";
    } else {
        element.style.textDecoration = "none";
        element.style.fontWeight = "normal";
        document.getElementById("container").style.background = "url('')";

    }
}

document.getElementById("my-checkbox").onchange = myChange;
