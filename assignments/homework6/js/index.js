(function () {
    "use strict";
    // let


    let userModule = function () {
        let account = {
            accountName: "",
            accountBalance: ""
        };
        function createAccount(name, deposit) {
            account.accountName = name;
            account.accountBalance = deposit;
            return account;
        }

        return {createAccount: createAccount}
    };

    let accountInfoList = [];

    function f() {
        let account = userModule().createAccount(document.getElementById("account-name").value,
            document.getElementById("deposit").value);

        accountInfoList.push(account);
        let result = "";
        for (const account of accountInfoList) {
            result += `Account name: ${account.accountName}  Balance: ${account.accountBalance} \n`;
        }

        document.getElementById("textarea").value = result;
    }


    window.onload = function () {
        document.getElementById("create").onclick = f;
    }
})();