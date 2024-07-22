<%-- 
    Document   : index
    Created on : Jul 16, 2024, 1:16:51 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1 class="text-center text-primary mt-1">DANH MỤC SẢN PHẨM</h1>
<div class="row">
    <div class="col-md-3 col-12 bg-secondary">
        <c:url value="/" var="action"/>
        <form action="${action}">
            <div class="mb-3 mt-3">
                <label for="q" class="form-label">Từ khóa:</label>
                <input type="search" class="form-control" id="q" placeholder="Từ khóa..." name="q">
            </div>
            <div class="mb-3 mt-3">
                <label for="fromPrice" class="form-label">Từ giá:</label>
                <input type="number" class="form-control" id="fromPrice" placeholder="Từ giá..." name="fromPrice">
            </div>
            <div class="mb-3 mt-3">
                <label for="toPrice" class="form-label">Đến giá:</label>
                <input type="number" class="form-control" id="toPrice" placeholder="Đến giá..." name="toPrice">
            </div>
            <div class="mb-3 mt-3">
                <input type="submit" value="Tìm SP" class="btn btn-success"/>
            </div>
        </form>
    </div>
    <div class="col-md-9 col-12">
        <a  href="<c:url value="/products" />" class="btn btn-info mb-1">Thêm sản phẩm</a>
        <table class = "table table-striped">
            <tr>
                <th></th>
                <th>Id</th>
                <th>Tên sản phẩm</th>
                <th>Giá bán</th>
                <th></th>
            </tr>
            <c:forEach items="${products}" var="p">
                <tr id="product${p.id}">
                    <td>
                        <img src="${p.image}" alt="${p.name}" width="120"/>
                    </td>
                    <td>${p.id}</td>
                    <td>${p.name}</td>
                    <td>${String.format("%,d",p.price)} VND</td>
                    <td>
                        <a href="<c:url value="/products/${p.id}"/>" class="btn btn-info">&#128394;</a>
                        <c:url value="/api/products/${p.id}" var="endpoint"/>
                        <button onclick="deleteProduct ('${endpoint}', ${p.id})"  class="btn btn-danger">&times;</button>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
