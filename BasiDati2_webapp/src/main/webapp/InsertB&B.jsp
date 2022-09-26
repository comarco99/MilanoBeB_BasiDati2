<%--
  Created by IntelliJ IDEA.
  User: costa
  Date: 27/06/2022
  Time: 00:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MilanAirB&B</title>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<jsp:include page="Navbar.jsp"></jsp:include>

<center><h1>INSERISCI UN NUOVO AIRB&B NEL DATABASE</h1></center>
<div id="mainInsert">
    <form action="./insert-servlet" method="post" id="formInsert">
        <label>Id AirB&B:</label><br>
        <input type="text" id="idAir" name="idAir"><br>
        <label>Nome AirB&B:</label><br>
        <input type="text" id="nome" name="nome"><br>
        <label>Nome host:</label><br>
        <input type="text" id="nomeHost" name="nomeHost"><br>
        <label>Prezzo:</label><br>
        <input type="text" id="prezzoAir" name="prezzoAir" placeholder="$0"><br>
        <label>Latitudine:</label><br>
        <input type="text" id="latitudine" name="latitudine"><br>
        <label>Longitudine:</label><br>
        <input type="text" id="longitudine" name="longitudine"><br>
        <label>Quartiere AirB&B:</label><br>
        <select id="quartiere" name="quartiere" class="quartieriClass">
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
        <br>
        <label>Tipo camere:</label><br>
        <select id ="room" name="room">
            <option value="Entire home/apt">Entire home/apt</option>
            <option value="Private room">Private room</option>
            <option value="Shared room">Shared room</option>
        </select><br>
        <button id="submit" type="submit">INSERISCI</button>
    </form>
</div>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
