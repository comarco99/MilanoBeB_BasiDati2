<%@ page import="java.util.Collection" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="model.Review" %><%--
  Created by IntelliJ IDEA.
  User: costa
  Date: 30/06/2022
  Time: 21:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Collection<?> reviews = (Collection<?>) request.getAttribute("cercaReviews");

 /*   if(reviews == null) {
        //inizialment la lista sarà vuota perciò la servlet gestira il suo riempimento
        response.sendRedirect(response.encodeRedirectURL("./carica2-servlet"));
        return;
    }*/

%>

<!DOCTYPE html>
<html>
<head>
    <title>MilanoAirB&B</title>
    <link href="Style.css" type="text/css" rel="stylesheet">
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<jsp:include page="Navbar.jsp"></jsp:include>

<div id="recensioniView">
    <center><h2>LISTA DELLE RECENSIONI DEL B&B SELEZIONATO</h2></center><br>
    <table id="revtable"  cellpadding="30"  cellspacing="30">
        <tbody>
    <%
        //Carico tutti gli AirB&B presenti nel database con un bottone per eliminarlo
        if(reviews != null && reviews.size() > 0) {
            Iterator<?> it  = reviews.iterator();
            int i=0;
            while(it.hasNext()) {
                i++;
                Review bean = (Review)it.next();	%>

            <tr>
                <td><b><%=bean.getReviewerName()%>: </b></td>
                <td><%=bean.getComment()%></td>
            </tr>
            <tr><td colspan="2"><hr></td></tr>

    <%}}%>
        </tbody>
    </table>

</div>


<jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>
