<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Usuario</title>
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,400italic,700,800' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Raleway:300,200,100' rel='stylesheet' type='text/css'>
        <link href="<c:url value="/js/bootstrap/dist/css/bootstrap.css"/>" rel="stylesheet">
    </head>
    <body>
        <form method="POST" action="uploadFile" enctype="multipart/form-data">
            <table>
                <tr>
                    <td>NombreUsuario:</td>
                    <td><input type="text" name="nombreuser" size="50" /></td>
                </tr>
                <tr>
                    <td>Dirección:</td>
                    <td><input type="text" name="direccion" size="50" /></td>
                </tr>
                <tr>
                    <td>Teléfono:</td>
                    <td><input type="text" name="telefono" size="50" /></td>
                </tr>
                <tr>
                    <td>Imagen:</td>
                    <td><input type="file" name="file" size="50" /></td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Grabar" /></td>
                </tr>
            </table>
        </form>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="<c:url value="/js/require.js"/>"></script>
        <script>
            require.config({
                baseUrl: "../",
                waitSeconds: 60,
                paths: {
                    'bootstrap': 'js/bootstrap/dist/js/bootstrap.min',
                    'datatables': 'js/jquery.datatables/jquery.datatables.min',
                    'jquery': 'js/jquery'
                }, shim: {
                    'bootstrap': ['jquery']
                }
            });
            require(['app/users', 'jquery'], function () {
                //usuario.run();
            });
        </script>

    </body>
</html>
