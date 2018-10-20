(function () {


    var $username,$firstname,$lastname;

    function init() {

        $username = $('#username');
        $firstname = $('#firstname');
        $lastname = $('#lastname');


        findUserByID(1)
            .then(renderUser);

    }

    init();
    
    function renderUser(user) {
        $username.val(user.username);  //set the input field, same function as setter
        $firstname.val(user.firstName);
        $lastname.val(user.lastName);
    }


    function findUserByID(userID) {
        return fetch("api/user/" + userID)
            .then(function (responds) {
                return responds.json();
            });
    }
    
})();