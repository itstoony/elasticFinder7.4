<%@ page contentType="text/html; charset=UTF-8" %>


<%@ include file="init.jsp" %>

<portlet:actionURL name="<%=CommandNames.HANDLE_FORM%>" var="handleForm" />

<portlet:defineObjects/>

<aui:form action="${handleForm}" name="fm" id="search">

    <div class="container">

    <div class="row">
        <div class="col-md-6">
            <label for="projeto">Digite o projeto que deseja buscar:</label>
            <input type="text" class="form-control" id="projeto"/>
        </div>
    </div>

    <div class="row mt-4">

        <div class="col-md-12">
            <h3>Filtros</h3>
        </div>

        <div class="col-md-12">
            <aui:button type="button" value="Limpar Filtros"/>
        </div>

        <c:forEach var="entry" items="${categorias}">
            <c:set var="key" value="${entry.key}" />

            <div class="col-md-6">
                <aui:select name="select${key}" label="${key}">
                    <aui:option value="">Todos</aui:option>

                    <c:forEach var="categoria" items="${entry.value}">
                        <aui:option value="${categoria.categoryId}">
                            ${categoria.name}
                        </aui:option>
                    </c:forEach>
                </aui:select>
            </div>

        </c:forEach>

        <hr>

    </div>



</aui:form>
