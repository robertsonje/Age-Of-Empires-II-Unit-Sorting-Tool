$(document).ready(function () {
    $("#search-form").submit(function (event) {
        event.preventDefault();
        SubmitAjaxRequest();
    });
});

function SubmitAjaxRequest() {
    var search = {};
    search["name"] = $("#name").val();
    $("#btn-search").prop("disabled", true);
    
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/search",
        data: JSON.stringify(search),
        dataType: 'json',
        cache: false,
        timeout: 30000,
        success: function (data) {
            var units = JSON.parse(JSON.stringify(data, null, 4));
            var htmlTable = "<table class=\"table table-striped\">";
            htmlTable += "<thead>";
                htmlTable += "<tr>";
                    htmlTable += "<td><b>" + "ID" + "</b></td>";
                    htmlTable += "<td><b>" + "Name" + "</b></td>";
                    htmlTable += "<td><b>" + "Description" + "</b></td>";
                    htmlTable += "<td><b>" + "Expansion" + "</b></td>";
                    htmlTable += "<td><b>" + "Age" + "</b></td>";
                    htmlTable += "<td><b>" + "Food" + "</b></td>";
                    htmlTable += "<td><b>" + "Wood" + "</b></td>";
                    htmlTable += "<td><b>" + "Stone" + "</b></td>";
                    htmlTable += "<td><b>" + "Gold" + "</b></td>";
                    htmlTable += "<td><b>" + "Build Time" + "</b></td>";
                    htmlTable += "<td><b>" + "Reload Time" + "</b></td>";
                    htmlTable += "<td><b>" + "Line of Sight" + "</b></td>";
                    htmlTable += "<td><b>" + "Hit Points" + "</b></td>";
                    htmlTable += "<td><b>" + "Attack Delay" + "</b></td>";
                    htmlTable += "<td><b>" + "Movement Rate" + "</b></td>";
                    htmlTable += "<td><b>" + "Range" + "</b></td>";
                    htmlTable += "<td><b>" + "Attack" + "</b></td>";
                    htmlTable += "<td><b>" + "Armor" + "</b></td>";
                    htmlTable += "<td><b>" + "Search Radius" + "</b></td>";
                    htmlTable += "<td><b>" + "Accuracy" + "</b></td>";
                    htmlTable += "<td><b>" + "Blast Radius" + "</b></td>";
                htmlTable += "</tr>";
            htmlTable += "</thead>";
            htmlTable += "<tbody>";
            units.result.forEach(function(unit) {
                htmlTable += "<tr>";
                    htmlTable += "<td>" + unit.id + "</td>";
                    htmlTable += "<td>" + unit.name + "</td>";
                    htmlTable += "<td>" + unit.description + "</td>";
                    htmlTable += "<td>" + unit.expansion + "</td>";
                    htmlTable += "<td>" + unit.age + "</td>";
                    htmlTable += "<td>" + unit.cost.food + "</td>";
                    htmlTable += "<td>" + unit.cost.wood + "</td>";
                    htmlTable += "<td>" + unit.cost.stone + "</td>";
                    htmlTable += "<td>" + unit.cost.gold + "</td>";
                    htmlTable += "<td>" + unit.buildTime + "</td>";
                    htmlTable += "<td>" + unit.reloadTime + "</td>";
                    htmlTable += "<td>" + unit.lineOfSight + "</td>";
                    htmlTable += "<td>" + unit.hitPoints + "</td>";
                    htmlTable += "<td>" + unit.attackDelay + "</td>";
                    htmlTable += "<td>" + unit.movementRate + "</td>";
                    htmlTable += "<td>" + unit.range + "</td>";
                    htmlTable += "<td>" + unit.attack + "</td>";
                    htmlTable += "<td>" + unit.armor + "</td>";
                    htmlTable += "<td>" + unit.searchRadius + "</td>";
                    htmlTable += "<td>" + unit.accuracy + "</td>";
                    htmlTable += "<td>" + unit.blastRadius + "</td>";
                htmlTable += "</tr>";
            });
            htmlTable += "</tbody>";
            htmlTable += "</table>";
            $('#feedback').html(htmlTable);
        },  
        
        error: function (e) {
            var jsonMessage = JSON.parse(e.responseText, null, 4);
            var htmlMessage = "<p>Error: </p><br><p>" + jsonMessage.msg + "</p>";
            $('#feedback').html(htmlMessage);
        }
    });
}