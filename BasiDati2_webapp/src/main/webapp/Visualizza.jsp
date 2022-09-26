<%--
  Created by IntelliJ IDEA.
  User: costa
  Date: 30/06/2022
  Time: 21:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html>
<head>
    <title>MilanoAirB&B</title>
    <link href="Style.css" type="text/css" rel="stylesheet">
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<jsp:include page="Navbar.jsp"></jsp:include>

<div class="tot">
    <div class="in1">
        <h3>CERCA PER ZONA</h3>
        <form id="byZonaForm" >
            <select id="quartieriId" name="quartieri" class="quartieriClass">
                <option value="ADRIANO">ADRIANO</option>
                <option value="AFFORI">AFFORI</option>
                <option value="BAGGIO">BAGGIO</option>
                <option value="BANDE NERE">BANDE NERE</option>
                <option value="BARONA">BARONA</option>
                <option value="BICOCCA">BICOCCA</option>
                <option value="BOVISA">BOVISA</option>
                <option value="BOVISASCA">BOVISASCA</option>
                <option value="BRERA">BRERA</option>
                <option value="BRUZZANO">BRUZZANO</option>
                <option value="BUENOS AIRES - VENEZIA">BUENOS AIRES - VENEZIA</option>
                <option value="CANTALUPA">CANTALUPA</option>
                <option value="CASCINA TRIULZA - EXPO">CASCINA TRIULZA - EXPO</option>
                <option value="CENTRALE">CENTRALE</option>
                <option value="CHIARAVALLE">CHIARAVALLE</option>
                <option value="CITTA' STUDI">CITTA' STUDI</option>
                <option value="COMASINA">COMASINA</option>
                <option value="CORSICA">CORSICA</option>
                <option value="DE ANGELI - MONTE ROSA">DE ANGELI - MONTE ROSA</option>
                <option value="DERGANO">DERGANO</option>
                <option value="DUOMO">DUOMO</option>
                <option value="EX OM - MORIVIONE">EX OM - MORIVIONE</option>
                <option value="FARINI">FARINI</option>
                <option value="FIGINO">FIGINO</option>
                <option value="FORZE ARMATE">FORZE ARMATE</option>
                <option value="GALLARATESE">GALLARATESE</option>
                <option value="GARIBALDI REPUBBLICA">GARIBALDI REPUBBLICA</option>
                <option value="GHISOLFA">GHISOLFA</option>
                <option value="GIAMBELLINO">GIAMBELLINO</option>
                <option value="GIARDINI PORTA VENEZIA">GIARDINI PORTA VENEZIA</option>
                <option value="GRATOSOGLIO - TICINELLO">GRATOSOGLIO - TICINELLO</option>
                <option value="GRECO">GRECO</option>
                <option value="GUASTALLA">GUASTALLA</option>
                <option value="ISOLA">ISOLA</option>
                <option value="LAMBRATE">LAMBRATE</option>
                <option value="LODI - CORVETTO">LODI - CORVETTO</option>
                <option value="LORENTEGGIO">LORENTEGGIO</option>
                <option value="LORETO">LORETO</option>
                <option value="MACIACHINI - MAGGIOLINA">MACIACHINI - MAGGIOLINA</option>
                <option value="MAGENTA - S. VITTORE">MAGENTA - S. VITTORE</option>
                <option value="MAGGIORE - MUSOCCO">MAGGIORE - MUSOCCO</option>
                <option value="MECENATE">MECENATE</option>
                <option value="MUGGIANO">MUGGIANO</option>
                <option value="NAVIGLI">NAVIGLI</option>
                <option value="NIGUARDA - CA' GRANDA">NIGUARDA - CA' GRANDA</option>
                <option value="ORTOMERCATO">ORTOMERCATO</option>
                <option value="PADOVA">PADOVA</option>
                <option value="PAGANO">PAGANO</option>
                <option value="PARCO AGRICOLO SUD">PARCO AGRICOLO SUD</option>
                <option value="PARCO BOSCO IN CITT">PARCO BOSCO IN CITT</option>
                <option value="PARCO DEI NAVIGLI">PARCO DEI NAVIGLI</option>
                <option value="PARCO DELLE ABBAZIE">PARCO DELLE ABBAZIE</option>
                <option value="PARCO FORLANINI - ORTICA">PARCO FORLANINI - ORTICA</option>
                <option value="PARCO LAMBRO - CIMIANO">PARCO LAMBRO - CIMIANO</option>
                <option value="PARCO MONLUE' - PONTE LAMBRO">PARCO MONLUE' - PONTE LAMBRO</option>
                <option value="PARCO NORD">PARCO NORD</option>
                <option value="PARCO SEMPIONE">PARCO SEMPIONE</option>
                <option value="PORTA ROMANA">PORTA ROMANA</option>
                <option value="PORTELLO">PORTELLO</option>
                <option value="QT 8">QT 8</option>
                <option value="QUARTO CAGNINO">QUARTO CAGNINO</option>
                <option value="QUARTO OGGIARO">QUARTO OGGIARO</option>
                <option value="QUINTO ROMANO">QUINTO ROMANO</option>
                <option value="QUINTOSOLE">QUINTOSOLE</option>
                <option value="RIPAMONTI">RIPAMONTI</option>
                <option value="ROGOREDO">ROGOREDO</option>
                <option value="RONCHETTO DELLE RANE">RONCHETTO DELLE RANE</option>
                <option value="RONCHETTO SUL NAVIGLIO">RONCHETTO SUL NAVIGLIO</option>
                <option value="SACCO">SACCO</option>
                <option value="SARPI">SARPI</option>
                <option value="SCALO ROMANA">SCALO ROMANA</option>
                <option value="S. CRISTOFORO">S. CRISTOFORO</option>
                <option value="SELINUNTE">SELINUNTE</option>
                <option value="S. SIRO">S. SIRO</option>
                <option value="STADERA">STADERA</option>
                <option value="STEPHENSON">STEPHENSON</option>
                <option value="TIBALDI">TIBALDI</option>
                <option value="TICINESE">TICINESE</option>
                <option value="TORTONA">TORTONA</option>
                <option value="TRENNO">TRENNO</option>
                <option value="TRE TORRI">TRE TORRI</option>
                <option value="TRIULZO SUPERIORE">TRIULZO SUPERIORE</option>
                <option value="UMBRIA - MOLISE">UMBRIA - MOLISE</option>
                <option value="VIALE MONZA">VIALE MONZA</option>
                <option value="VIGENTINA">VIGENTINA</option>
                <option value="VILLAPIZZONE">VILLAPIZZONE</option>
                <option value="WASHINGTON">WASHINGTON</option>
                <option value="XXII MARZO">XXII MARZO</option>
            </select>
            <button type="button" onclick="visualizzaByZona('byZona',document.getElementById('quartieriId').value);">cerca</button>
        </form>
    </div>

    <div class="in2">
        <h3>CERCA PER RECENSIONI</h3>
        <form id="byRevForm" >
            <label>Min:</label>
            <input type="number" id="revFindMin" name="revFindMin" placeholder="Recensioni"><br>
            <label>Max:</label>
            <input type="number" id="revFindMax" name="revFindMax" placeholder="Recensioni"><br>
            <button type="button" onclick="visualizzaByReviews('byRev',document.getElementById('revFindMin').value,document.getElementById('revFindMax').value);">cerca</button>
        </form>
    </div>

    <div class="in3" >
        <h3>CERCA PER PREZZI</h3>
        <form id="byPriceForm" >
            <label>Min:</label>
            <input type="text" id="priceFindMin" name="priceFindMin" placeholder="$50"><br>
            <label>Max:</label>
            <input type="text" id="priceFindMax" name="priceFindMax"placeholder="$150"><br>
            <button type="button" onclick="visualizzaByPrice('byPrice',document.getElementById('priceFindMin').value,document.getElementById('priceFindMax').value);">cerca</button>
        </form>
    </div>

    <div class="in4">
        <h3>CERCA PER CAMERA</h3>
        <form id="byRoomForm" >
            <label>Tipo camera:</label>
            <select id="roomId" name="roomId" class="roomClass">
                <option value="Private room">Private room</option>
                <option value="Shared room">Shared room</option>
            </select>
            <button type="button" onclick="visualizzaByRoom('byRoom',document.getElementById('roomId').value);">cerca</button>
        </form>
    </div>

    <div class="in5">
        <h3>CERCA VICINO A LOCATION</h3>
        <form id="byDuomoForm">
            <label>Vicino a: </label>
            <select id="nearPlace" name="nearPlace" class="nearPlace">
                <option value="duomo">Duomo di Milano</option>
                <option value="citylife">City Life</option>
                <option value="navigli">Navigli</option>
                <option value="sforzesco">Castello Sforzesco</option>
            </select>
            <button type="button" onclick="visualizzaByDuomo(document.getElementById('nearPlace').value);">cerca</button>
        </form>
    </div>

    <div class="all">
        <button type="button" onclick="applicaTutti('byAll', document.getElementById('quartieriId').value, document.getElementById('revFindMin').value,document.getElementById('revFindMax').value, document.getElementById('priceFindMin').value,document.getElementById('priceFindMax').value, document.getElementById('roomId').value);">TUTTI I FILTRI</button>
    </div>
</div>
<br>
<hr>
<br>
<div class="bySomethingOut"> </div>

<jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>
