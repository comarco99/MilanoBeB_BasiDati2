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
        response.sendRedirect(response.encodeRedirectURL("./carica2-servlet"));
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

<center><h1>RICERCA RECENSIONI DI TUTTI GLI AIRB&B DI MILANO</h1></center>
<div id="mainUpdate">
    <br>
    <table>
        <tbody>
    <%
        //Carico tutti gli AirB&B presenti nel database con un bottone per eliminarlo
        if(listings != null && listings.size() > 0) {
            Iterator<?> it  = listings.iterator();
            int i=0;
            while(it.hasNext()) {
                i++;
                Listing bean = (Listing)it.next();	%>

    <tr>
        <td><%=bean.getName()%></td>
        <td><%=bean.getHostName()%></td>
        <td><%=bean.getNeighbourhood()%></td>
        <td><%=bean.getPrice()%>$</td>
        <td><%=bean.getRoomType()%></td>
        <td><a href="<%=response.encodeURL("visualizza-reviews?id="+bean.getListingId())%>"><i class="fas fa-info-circle"></i></a></td>
    </tr>

    <%}%><%}%>
        </tbody>
    </table>

</div>

<jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>
