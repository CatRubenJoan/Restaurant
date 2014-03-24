<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login client</title>
    </head>
    <body>
        <form method="POST" action="controllerPrincipal?section=pageLogin">
            <table align="center">
                <tr>
                    <td>
                        N° DE TABLE: <input type="text" name="identifier" size="4">
                    </td>
                </tr>
            </table>
            <table align="center">
                <tr>
                    <td>
                        Nombre de convives: <input type="text" name="places" size="2">
                    </td>
                </tr>
            </table>            
            <table align="center">   
                <tr>
                    <td>
                        <INPUT type="submit" name="doIt" value="OK"/>
                    </td>
                    <td>
                        <INPUT type="submit" name="reset" value="Effacer"/>                        
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
