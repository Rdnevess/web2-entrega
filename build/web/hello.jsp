<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="entidades.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Produtos</title>
        <link rel="stylesheet" type="text/css" href="resources/css/bootstrap.min.css">
    </head>
    <body>
        <h1>Produtos</h1>

        <%
            List<Produto> lista = (List<Produto>) session
                    .getAttribute("lista");

            if (lista == null) {
                lista = new ArrayList<Produto>();
            }
        %>

        <table class="table">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">Nome do produto</th>
                    <th scope="col">Marca</th>
                    <th scope="col">Qauntidade</th>
                    <th scope="col">Valor</th>
                </tr>
            </thead>
            <tbody>
                <% for (Produto c : lista) {%>
                <tr>
                    <td><%= c.getProduto() %></td>
                    <td><%= c.getMarca() %></td>
                    <td><%= c.getQuantidade() %></td>
                    <td><%= c.getValor() %></td>
                </tr>
                <%}%>
            </tbody>
        </table>
    </body>
</html>
