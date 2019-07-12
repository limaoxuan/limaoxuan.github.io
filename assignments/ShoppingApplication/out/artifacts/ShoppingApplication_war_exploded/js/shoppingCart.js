$(function () {


    $("#confirm").click((e) => {
        Cookies.set('shopping', JSON.stringify([]), {expires: 7});
        $('#checkoutModelButton').remove();
        $('#checkoutModel').modal('hide');

        $("#my-bottom"). append("<p>Thank you check Out.</p>");

    });

});