
function calcTip() {
    //var subtotalElem =
    //var tipElem =
    var subtotal = document.getElementById('subtotal').value;
    var tip = document.getElementById('tip').value;


    if (subtotal == "") {
        alert("Please input subtotal");
        return;
    }
    if (tip == "") {
        alert("Please input tip");
        return;
    }

    totalElem = document.getElementById('total');
    totalElem.innerHTML = '$' + (parseFloat(subtotal) + subtotal * tip * 0.01);
}
