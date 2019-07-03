let bicycle = (function () {
    "use strict";
    // 1. Create a function expression named createBicyclePrototye which returns an object literal with one property speed set to value 0 and two methods
// a. applyBrake that takes a parameter and decrement the current speed of the object by that given value.
// b. speedup that takes a parameter increment current speed by given value.
    function createBicyclePrototype() {
        let speed = 0;

        function applyBrake(decrease) {
            speed = -decrease;
        }

        function speedup(increment) {
            speed += increment;
        }

        return {
            speed,
            applyBrake: applyBrake,
            speedup: speedup
        }
    }

// 2. Create another function expression named createMountainBikeProtoype
// that take a prototype parameter and
// returns an object created using Object.create (prototype) with
// one additional property gear set to value 1
// and  one additional method setGear which takes a parameter and sets gear value for the object.
    // a prototype parameter  function??
    function createMountainBikePrototype(obj) {
        //__proto__
        let newObj = Object.create(obj);
        newObj.gear = 1;
        newObj.setGear = (value) => {
            newObj.gear = value;
        };
        return newObj;
    }


//Write third function expression named start that
// first make bicyclePrototype object using first function and
// then mountainBikePrototype object using second function,
// passing bicyclePrototype as argument.

    function start() {
        let bicyclePrototype = createBicyclePrototype();
        return createMountainBikePrototype(bicyclePrototype);
    }



    return {
        createBicyclePrototype,
        createMountainBikePrototype,
        start
    }
})();
// console.log(bicycle.start());

console.log(bicycle.start());


class Bicycle {
    constructor() {
        this._speed = 0;
    }

    applyBrake(value) {
        this._speed -= value;
    }

    speedup(value) {
        this._speed += value;
    }
}

class MountainBike extends Bicycle {
    constructor() {
        super();
        this._gear = 1;
    }

    setGear(value) {
        this._gear = value;
    }
}

var mountainBike = new MountainBike();
console.log(mountainBike)


