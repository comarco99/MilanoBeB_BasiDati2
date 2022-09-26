<%@ page import="java.util.Collection" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="model.Listing" %><%--
  Created by IntelliJ IDEA.
  User: costa
  Date: 30/06/2022
  Time: 21:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Collection<?> listings = (Collection<?>) request.getAttribute("listings");

    if(listings == null) {
        //inizialment la lista sarà vuota perciò la servlet gestira il suo riempimento
        response.sendRedirect(response.encodeRedirectURL("./carica-servlet"));
        return;
    }

%>
<html>
<head>
    <title>MilanoAirB&B</title>
    <link href="Style.css" type="text/css" rel="stylesheet">
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<jsp:include page="Navbar.jsp"></jsp:include>

<center><h1>LISTA DI TUTTI GLI AIRB&B DI MILANO</h1></center>
<div id="mainRemove">
    <table>
<%--        <thead>Nome</thead>--%>
<%--        <thead>Host</thead>--%>
<%--        <thead>Quartiere</thead>--%>
<%--        <thead>Recensioni</thead>--%>
<%--        <thead>Prezzo</thead>--%>
<%--        <thead>Tipo camera</thead>--%>
<%--        <thead>Elimina</thead>--%>
        <tbody>
<%
        //Carico tutti gli AirB&B presenti nel database con un bottone per eliminarlo
        if(listings != null && listings.size() > 0) {
            int i=0;
            Iterator<?> it  = listings.iterator();
            while(it.hasNext()) {
                i++;
                Listing bean = (Listing)it.next();	%>
                <tr>
                    <td><%=bean.getName()%></td>
                    <td><%=bean.getHostName()%></td>
                    <td><%=bean.getNeighbourhood()%></td>
                    <td><%=bean.getPrice()%>$</td>
                    <td><%=bean.getRoomType()%></td>
                    <td><a href="<%=response.encodeURL("rimuoviListing?nameAir="+bean.getName())%>" class="fas fa-minus-circle"></a></td>
                    <td><a href="<%=response.encodeURL("modificaListing?idUpdate="+bean.getListingId())%>" class="fas fa-pen"></a></td>
                </tr>
    <%}}%>
        </tbody>
    </table>
</div>


<jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>
