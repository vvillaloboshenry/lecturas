define(['datatables'], function () {
    if (window.Users) { //Prevents defining the module twice
        return false;
    }
    console.log('Run: Users.js');
    var Users = {
        //Initializer Methods
        run: function () {
            this.runViewController();
            this.bindEvents();
        },
        //Other Events
        bindEvents: function () {
            $body = $('body');
        },
        ///Call All Method, carga funciones generales que afecta a todo el controlador del servidor.
        runViewController: function () {
            Users.callPublic();
        },

        //funcion general que afecta a todo el controlador del servidor.
        //Metodo general del Cotroller, se ejecuta al inicializar el js
        callPublic: function () {
            //alert('Todo Controller');
            Users.createdatatables();
        },
        //Metodos del controlador del servidor(functiones) que se ejecuta cuando se displaya una pagina.
        //Soy una funcion del Controlador fileController y ejecuto la accion Index.
        createdatatables: function () {
            console.log("asd");
            $('#datatable').dataTable({
                "iDisplayLength": 50,
                "aLengthMenu": [
                    [50, 100, 200, 500, 1000],
                    [50, 100, 200, 500, 1000]
                ]
            });
        }
    };
    Users.run();
    return Users;
});