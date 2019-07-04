// record random point;
let record = [];
(function () {
    let myDiv;
    let empty = {left: 300, top: 300};
    let stack = [];
    var divs = [];


    init = function () {
        var puzzleArea = document.getElementById('puzzlearea');
        divs = puzzleArea.getElementsByTagName("div");

        // initialize each piece
        for (var i = 0; i < divs.length; i++) {
            var div = divs[i];

            // calculate x and y for this piece
            var x = ((i % 4) * 100);
            var y = (Math.floor(i / 4) * 100);

            // set basic style and background
            div.className = "puzzlepiece";
            div.style.left = x + 'px';
            div.style.top = y + 'px';
            div.style.backgroundImage = 'url("images/background.jpg")';
            div.style.backgroundPosition = -x + 'px ' + (-y) + 'px';

            // store x and y for later
            div.x = x;
            div.y = y;
        }
        myDiv = divs;
    };
    window.onload = function () {
        init();
        $(".puzzlepiece").click(move);
        $(".puzzlepiece").mouseover(couldMove);
        $("#shufflebutton").click(shufflebutton);
    };

    function shufflebutton() {

        let random = Math.floor(Math.random() * 10) + 10;

        for (let index = 0; index < random; index++) {
            let movePoint = getNextPoint(empty.left, empty.top);

            let div = queryElement(movePoint);
            // pop because we has checked the  nearest changing point
            if (stack.length !== 0) {
                stack.pop();
            }
            // add new nearest changing point in stack
            stack.push({x: empty.left, y: empty.top});
            record.push(movePoint);
            pointMove(div, empty, movePoint.x, movePoint.y);

        }
    }

// get point element
    function queryElement(movePoint) {
        for (var i = 0; i < divs.length; i++) {
            var div = divs[i];
            if (div.x === movePoint.x && div.y === movePoint.y) {
                return div;
            }
        }
    }

    function getNextPoint(x, y) {
        let isNext = false;
        let point = {};
        while (!isNext) {

            // four directions
            let random = Math.floor(Math.random() * 4);
            if (random === 0) {
                point = {x: 100 + x, y: y};
                isNext = bound(point.x, point.y);
            }
            if (random === 1) {
                point = {x: -100 + x, y: y};
                isNext = bound(point.x, point.y);
            }
            if (random === 2) {
                point = {x: x, y: 100 + y};
                isNext = bound(point.x, point.y);
            }
            if (random === 3) {
                point = {x: x, y: -100 + y};
                isNext = bound(point.x, point.y);
            }
        }
        return point;

    }

    function bound(x, y) {

        // the nearest changing point doesn't allow change
        if (stack.length !== 0) {
            let o = stack[stack.length - 1];
            let x1 = o.x;
            let y1 = o.y;
            if (x1 === x && y === y1) {
                // console.log("false");
                return false;
            }
        }

        if (x > 300 || x < 0) {
            return false;
        }
        if (y > 300 || y < 0) {
            return false;
        }
        return true;
    }

    function couldMove() {
        let el = $(this)[0].style;
        let left = parseInt(el.left);
        let top = parseInt(el.top);
        // console.log(left, top);
        // console.log(empty.left,empty.top);

        if (isMove(empty.left, empty.top, left, top)) {
            $(".puzzlepiece").removeClass("movablepiece");
            $(this).addClass("movablepiece");
        }
    }

    function move() {
        let el = $(this)[0];
        let left = parseInt(el.style.left);
        let top = parseInt(el.style.top);

        if (isMove(empty.left, empty.top, left, top)) {
            pointMove(el, empty, left, top);
        }
    }

    // exchange from empty to point
    function pointMove(el, empty, left, top) {
        let oldEmpty = {left: empty.left, top: empty.top};
        empty.left = left;
        empty.top = top;
        el.x = oldEmpty.left;
        el.y = oldEmpty.top;
        el.style.left = oldEmpty.left + 'px';
        el.style.top = oldEmpty.top + 'px';
    }

    // check whether can move
    function isMove(l, t, l1, t1) {
        return Math.abs(l + t - (l1 + t1)) === 100 && ((l === l1) || (t === t1));
    }

})();
