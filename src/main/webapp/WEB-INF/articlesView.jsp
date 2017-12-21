<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="col-sm-offset-1 col-sm-10">

    <%--<legend>--%>
        <%--<spring:message code="table.user.title" />--%>
    <%--</legend>--%>

    <div>
        <table id="dataTable" class="table table-striped table-bordered">
            <thead>
            <tr>
                <th><"1"/></th>
                <th><"2"/></th>
            </tr>
            <thead>
            <tbody>
            <c:forEach var="u" items="${articlesModel}">
            <tr>
                <td>${u.id}</td>
                <td>${u.titleArticle}</td>
            <tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>