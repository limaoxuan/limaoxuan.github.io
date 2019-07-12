console.log("sds")

$(function () {
    let products;

    function getShoppingCart() {

        // document.cookie
        products = Cookies.get('shopping') == undefined ? [] : JSON.parse(Cookies.get('shopping'));
        $("#shopping-cart-number").text(products.length);
    }

    // function addShoppingCart(e) {
    //
    // }

    $(".add-shopping").click((e) => {
        var myId = $(e.target).attr("my-id");
        let hasProduct = false;
        for (let product of products) {

            if (product.id == myId) {
                product.number = parseInt(product.number) + 1;
                hasProduct = true;
                break;
            }

        }
        if (!hasProduct) {
            products.push({
                id: myId,
                number: 1
            })
        }

        Cookies.set('shopping', JSON.stringify(products), {expires: 7});

        $("#shopping-cart-number").text(products.length);
        console.log(JSON.parse(Cookies.get('shopping')))
    });
    getShoppingCart();

});