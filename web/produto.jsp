<%@page import="java.util.List"%>
<%@page import="entidades.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Produtos</title>
        <script src='resources/js/bootstrap.min.js'></script>
        <link rel="stylesheet" type="text/css" href="resources/css/bootstrap.min.css">
    </head>
    <body>
        <h1>Formulário do produto</h1>
        <%
            int id =0;
            String produto = "";
            double quantidade = 0;
            double valor = 0;
            String marca = "";
            if(request.getAttribute("produto") != null){
                Produto ed = (Produto) request.getAttribute("produto");
                
                id = ed.getId();
                produto = ed.getProduto();
                quantidade = ed.getQuantidade();
                valor = ed.getValor();
                marca= ed.getMarca();
            }
        %>
        
        
        
        <div class="container">
            <form method="POST" action="produto">
                <input type="hidden" name="id" value="<%= id %>"/>
                <div class="form-group">
                    <label id="labelProduto" for="produto">Produto:</label>
                    <input id="produto" class="form-control" name="produto" type="text" required value ="<%= produto%>"/>
                </div>
                <div class="form-group">
                    <label id="labelProduto" for="produto">Marca:</label>
                    <input id="marca" class="form-control" name="marca" type="text" required value ="<%= marca%>"/>
                </div>
                <div class="form-group">
                    <label id="labelProduto" for="valor">Valor:</label>
                    <input id="valor" class="form-control" name="valor" type="number" required value ="<%= valor%>" />
                </div>
                <div class="form-group">
                    <label id="labelProduto" for="quantidade">Quantidade:</label>
                    <input id="quantidade" class="form-control" name="quantidade" type="number" required value ="<%= quantidade%>"/>
                </div>
                <button type="submit" class="btn btn-success">Salvar</button>
                <br >
            </form>
        </div>
        <div class="divider"></div>
        <div class="container">
            <table class="table">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">Produto</th>
                        <th scope="col">Marca</th>
                        <th scope="col">Quantidade</th>
                        <th scope="col">Valor</th>
                        <th scope="col">Ações</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        List<Produto> lista;
                        lista = (List<Produto>) request.getAttribute("lista");
                    %>
                    <% for (Produto p : lista) {%>
                    <tr>
                        <td><%= p.getProduto()%></td>
                        <td><%= p.getMarca()%></td>
                        <td><%= p.getQuantidade()%></td>
                        <td><%= p.getValor()%></td>
                        <td>
                            <a href="produto?editar=<%= p.getId()%>">
                                <button class="btn btn-primary">Editar</button>
                            </a>
                            <a href="produto?excluir=<%= p.getId()%>">
                                <button class="btn btn-danger">Excluir</button>
                            </a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
    </body>
</html>
