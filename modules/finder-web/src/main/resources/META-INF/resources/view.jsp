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

            <div class="col-md-6">
                <aui:select name="selectSegmentos" label="Segmento">

                    <aui:option>Todos</aui:option>

                    <c:forEach var="segmento" items="${categorias['Segmentos']}">
                        <aui:option>${segmento.name}</aui:option>
                    </c:forEach>

                </aui:select>
            </div>

            <div class="col-md-6">
                <aui:select name="selectFaseProjeto" label="Fase do projeto">

                    <aui:option>Todos</aui:option>

                    <c:forEach var="fase" items="${categorias['Fase do projeto']}">
                        <aui:option>${fase.name}</aui:option>
                    </c:forEach>

                </aui:select>
            </div>

            <div class="col-md-6">
                <aui:select name="selectClassificacao" label="Classificação de Entrega">

                    <aui:option>Todos</aui:option>

                    <c:forEach var="classificacao" items="${categorias['Classificação de Entrega']}">
                        <aui:option>${classificacao.name}</aui:option>
                    </c:forEach>

                </aui:select>
            </div>

            <div class="col-md-6">
                <aui:select name="selectMercado" label="Mercado">

                    <aui:option>Todos</aui:option>

                    <c:forEach var="mercado" items="${categorias['Mercado']}">
                        <aui:option>${mercado.name}</aui:option>
                    </c:forEach>

                </aui:select>
            </div>

            <div class="col-md-6">

                <aui:select name="selectStatus" label="Status">

                    <aui:option>Todos</aui:option>

                    <c:forEach var="status" items="${categorias['Status']}">
                        <aui:option>${status.name}</aui:option>
                    </c:forEach>

                </aui:select>

            </div>


        </div>

    </div>

</aui:form>

