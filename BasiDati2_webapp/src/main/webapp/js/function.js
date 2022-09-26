function visualizzaByZona(azione,zona){
        $.ajax({
            url: "./visualizza-servlet?",
            method: "POST",
            cache: false,
            data:{
                criterio:zona,
                azione: azione,
            },
            success: function (response) {
                $(".bySomethingOut").empty();

                $(".bySomethingOut").css("text-align", "left");
                $(".bySomethingOut").css("margin", "0 auto");
                $(".bySomethingOut").css("position", "relative");
                $(".bySomethingOut").css("width", "90%");

                $(".bySomethingOut").append("<th>ID</th><th>Nome</th><th>Host</th><th>Quartiere</th><th>Tipo camere</th><th>Prezzo</th><th>Numero recensioni</th>")
                response.map(el=>{$(".bySomethingOut").append("<tr><td>"+el.listingId+"</td><td>"+el.name+"</td><td>"+el.hostName+"</td><td>"+el.neighbourhood+"</td><td>"+el.roomType+"</td><td>"+el.price+"$</td><td>"+el.numberOfReviews+"</td></tr>")});

                $("th, tr, td").css("text-align","left");
                $("th, tr, td").css("padding","1em");

            },
            error: function () {
                alert("ERRORE CHIAMATA ASINCRONA");
            }
        });
}

function visualizzaByReviews(azione,min,max){
    $.ajax({
        url: "./visualizza-servlet?",
        method: "POST",
        cache: false,
        data:{
            min :min,
            max: max,
            azione: azione,
        },
        success: function (response) {
            $(".bySomethingOut").empty();

            $(".bySomethingOut").css("text-align", "center");
            $(".bySomethingOut").css("margin", "0 auto");
            $(".bySomethingOut").css("position", "relative");
            $(".bySomethingOut").css("width", "90%");

            $(".bySomethingOut").append("<th>ID</th><th>Nome</th><th>Host</th><th>Quartiere</th><th>Tipo camere</th><th>Prezzo</th><th>Numero recensioni</th>")
            response.map(el=>{$(".bySomethingOut").append("<tr><td>"+el.listingId+"</td><td>"+el.name+"</td><td>"+el.hostName+"</td><td>"+el.neighbourhood+"</td><td>"+el.roomType+"</td><td>"+el.price+"$</td><td>"+el.numberOfReviews+"</td></tr>")});

            $("th, tr, td").css("text-align","left");
            $("th, tr, td").css("padding","1em");
        },
        error: function () {
            alert("ERRORE CHIAMATA ASINCRONA");
        }
    });
}

function visualizzaByPrice(azione,min,max){
    $.ajax({
        url: "./visualizza-servlet?",
        method: "POST",
        cache: false,
        data:{
            min :min,
            max: max,
            azione: azione,
        },
        success: function (response) {
            $(".bySomethingOut").empty();

            $(".bySomethingOut").css("text-align", "center");
            $(".bySomethingOut").css("margin", "0 auto");
            $(".bySomethingOut").css("position", "relative");
            $(".bySomethingOut").css("width", "90%");


            $(".bySomethingOut").append("<th>ID</th><th>Nome</th><th>Host</th><th>Quartiere</th><th>Tipo camere</th><th>Prezzo</th><th>Numero recensioni</th>")
            response.map(el=>{$(".bySomethingOut").append("<tr><td>"+el.listingId+"</td><td>"+el.name+"</td><td>"+el.hostName+"</td><td>"+el.neighbourhood+"</td><td>"+el.roomType+"</td><td>"+el.price+"$</td><td>"+el.numberOfReviews+"</td></tr>")});

            $("th, tr, td").css("text-align","left");
            $("th, tr, td").css("padding","1em");

        },
        error: function () {
            alert("ERRORE CHIAMATA ASINCRONA");
        }
    });
}

function visualizzaByRoom(azione,room){
    $.ajax({
        url: "./visualizza-servlet?",
        method: "POST",
        cache: false,
        data:{
            room :room,
            azione: azione,
        },
        success: function (response) {

            $(".bySomethingOut").empty();

            $(".bySomethingOut").css("text-align", "center");
            $(".bySomethingOut").css("margin", "0 auto");
            $(".bySomethingOut").css("position", "relative");
            $(".bySomethingOut").css("width", "90%");


            $(".bySomethingOut").append("<th>ID</th><th>Nome</th><th>Host</th><th>Quartiere</th><th>Tipo camere</th><th>Prezzo</th><th>Numero recensioni</th>")
            response.map(el=>{$(".bySomethingOut").append("<tr><td>"+el.listingId+"</td><td>"+el.name+"</td><td>"+el.hostName+"</td><td>"+el.neighbourhood+"</td><td>"+el.roomType+"</td><td>"+el.price+"$</td><td>"+el.numberOfReviews+"</td></tr>")});

            $("th, tr, td").css("text-align","left");
            $("th, tr, td").css("padding","1em");

        },
        error: function () {
            alert("ERRORE CHIAMATA ASINCRONA");
        }
    });
}

function visualizzaByDuomo(place){
    $.ajax({
        url: "./near-duomo",
        method: "POST",
        cache: false,
        data:{
            place: place,
        },
        success: function (response) {
            $(".bySomethingOut").empty();

            $(".bySomethingOut").css("text-align", "center");
            $(".bySomethingOut").css("margin", "0 auto");
            $(".bySomethingOut").css("position", "relative");
            $(".bySomethingOut").css("width", "90%");

            $(".bySomethingOut").append("<th>ID</th><th>Nome</th><th>Host</th><th>Quartiere</th><th>Tipo camere</th><th>Prezzo</th><th>Numero recensioni</th>")
            response.map(el=>{$(".bySomethingOut").append("<tr><td>"+el.listingId+"</td><td>"+el.name+"</td><td>"+el.hostName+"</td><td>"+el.neighbourhood+"</td><td>"+el.roomType+"</td><td>"+el.price+"$</td><td>"+el.numberOfReviews+"</td></tr>")});

            $("th, tr, td").css("text-align","left");
            $("th, tr, td").css("padding","1em");

        },
        error: function () {
            alert("ERRORE CHIAMATA ASINCRONA");
        }
    });
}

function applicaTutti(azione, zona,minR, maxR, minP, maxP, room){
    $.ajax({
        url: "./visualizza-servlet?",
        method: "POST",
        cache: false,
        data:{
            zona: zona,
            minR: minR,
            maxR: maxR,
            minP: minP,
            maxP: maxP,
            room :room,
            azione: azione,
        },
        success: function (response) {
            $(".bySomethingOut").empty();

            $(".bySomethingOut").css("text-align", "center");
            $(".bySomethingOut").css("margin", "0 auto");
            $(".bySomethingOut").css("position", "relative");
            $(".bySomethingOut").css("width", "90%");


            $(".bySomethingOut").append("<th>ID</th><th>Nome</th><th>Host</th><th>Quartiere</th><th>Tipo camere</th><th>Prezzo</th><th>Numero recensioni</th>")
            response.map(el=>{$(".bySomethingOut").append("<tr><td>"+el.listingId+"</td><td>"+el.name+"</td><td>"+el.hostName+"</td><td>"+el.neighbourhood+"</td><td>"+el.roomType+"</td><td>"+el.price+"$</td><td>"+el.numberOfReviews+"</td></tr>")});

            $("th, tr, td").css("text-align","left");
            $("th, tr, td").css("padding","1em");

        },
        error: function () {
            alert("ERRORE CHIAMATA ASINCRONA");
        }
    });

}
