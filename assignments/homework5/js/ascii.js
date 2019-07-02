const ANIMATION = [BLANK, EXERCISE, JUGGLER, BIKE, DIVE];
let index = 0;
let clearNumber;
let speed;
function start() {
    if (clearNumber) {
        clearInterval(clearNumber);
    }

    let animationType = document.getElementById("animation").value;

    let size = document.getElementById("size").value;

    let checked = document.getElementById("my-check").checked;

    speed = checked == true ? 50 : 250;

    let element = document.getElementById("my-textarea");

    element.style.fontSize = size;
    let array = ANIMATION[animationType].split("=====\n");
    clearNumber = setInterval(animation, speed, element, array);
}

function stop() {
    if (clearNumber) {
        clearInterval(clearNumber);
    }
    let element = document.getElementById("my-textarea");
    let animationType = document.getElementById("animation").value;
    element.value = ANIMATION[animationType].split("=====\n")[0];
}

function animation(element, array) {
    // console.log(str);
    element.value = array[index];
    index = (index + 1) % array.length;
}

document.getElementById("start").onclick = start;
document.getElementById("stop").onclick = stop;
