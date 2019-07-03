(function () {
    "use strict";
    $(document).ready(function () {
        let count = 0;
        $(".boundary").mouseover(function () {
            var me = $(this);
            if (!me.hasClass("youlose") && !me.hasClass("example")) {
                me.addClass("youlose");
                count++;
            }
        })
        $("#start").click(function () {
            $(".boundary").removeClass("youlose");
            count = 0;
        })
        $("#end").mouseover(function () {
            var str = "";
            if (count < 5) {
                str = "you win";
                // alert("you win");
            } else {
                str = "you lost";
            }
            $("#status").text(str);
        })

        $("#maze").mouseleave(function () {
            $(".boundary").addClass("youlose");
            $("#status").text("you lost");
        })
    });
})();

