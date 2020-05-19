const dataDisplayMode = {
    SIMPLE: 0,
    DETAILED: 1,
    VERY_DETAILED: 2
};

var displayMode = dataDisplayMode.SIMPLE;

$(document).ready(function () {
    $("#search-form").submit(function (event) {
        event.preventDefault();
        SubmitAjaxRequest();
    });
    $("#dataDisplaySimple").click(function (event) { 
        displayMode = dataDisplayMode.SIMPLE;
        $(".aoe_advanced").hide();
        $(".aoe_super_advanced").hide();
    });
    $("#dataDisplayDetailed").click(function (event) { 
        displayMode = dataDisplayMode.DETAILED;
        $(".aoe_advanced").show();
        $(".aoe_super_advanced").hide();
    });
    $("#dataDisplayVeryDetailed").click(function (event) { 
        displayMode = dataDisplayMode.VERY_DETAILED;
        $(".aoe_advanced").show();
        $(".aoe_super_advanced").show();
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
                    htmlTable += "<td class=\"aoe_advanced\"><b>" + "ID" + "</b></td>";
                    htmlTable += "<td><b>" + "Name" + "</b></td>";
                    htmlTable += "<td><b>" + "Description" + "</b></td>";
                    htmlTable += "<td class=\"aoe_advanced\"><b>" + "Expansion" + "</b></td>";
                    htmlTable += "<td><b>" + "Age" + "</b></td>";
                    htmlTable += "<td><b>" + "Cost" + "</b></td>";
                    htmlTable += "<td class=\"aoe_advanced\"><b>" + "Build Time" + "</b></td>";
                    htmlTable += "<td class=\"aoe_super_advanced\"><b>" + "Reload Time" + "</b></td>";
                    htmlTable += "<td class=\"aoe_advanced\"><b>" + "Line of Sight" + "</b></td>";
                    htmlTable += "<td><b>" + "HP" + "</b></td>";
                    htmlTable += "<td class=\"aoe_super_advanced\"><b>" + "Attack Delay" + "</b></td>";
                    htmlTable += "<td class=\"aoe_super_advanced\"><b>" + "Movement Rate" + "</b></td>";
                    htmlTable += "<td class=\"aoe_advanced\"><b>" + "Range" + "</b></td>";
                    htmlTable += "<td><b>" + "Attack" + "</b></td>";
                    htmlTable += "<td class=\"aoe_advanced\"><b>" + "Armor" + "</b></td>";
                    htmlTable += "<td class=\"aoe_super_advanced\"><b>" + "Search Radius" + "</b></td>";
                    htmlTable += "<td class=\"aoe_advanced\"><b>" + "Accuracy" + "</b></td>";
                    htmlTable += "<td class=\"aoe_super_advanced\"><b>" + "Blast Radius" + "</b></td>";
                htmlTable += "</tr>";
            htmlTable += "</thead>";
            htmlTable += "<tbody>";
            units.result.forEach(function(unit) {
                htmlTable += "<tr>";
                    htmlTable += "<td class=\"aoe_advanced\">" + unit.id + "</td>";
                    htmlTable += "<td>" + unit.name + "</td>";
                    htmlTable += "<td>" + unit.description + "</td>";
                    htmlTable += "<td class=\"aoe_advanced\">" + unit.expansion + "</td>";
                    htmlTable += "<td>";
                    switch (unit.age) {
                        case "Imperial":
                            htmlTable += "<img src=\"https://vignette.wikia.nocookie.net/ageofempires/images/3/36/ImperialageDE.png\"  width=\"24\" height=\"24\" alt=\"Imperial Age\">";
                            break;
                        case "Castle":
                            htmlTable += "<img src=\"https://vignette.wikia.nocookie.net/ageofempires/images/d/de/CastleageDE.png\"  width=\"24\" height=\"24\" alt=\"Castle Age\">";
                            break;
                        case "Feudal":
                            htmlTable += "<img src=\"https://vignette.wikia.nocookie.net/ageofempires/images/8/85/FeudalageDE.png\"  width=\"24\" height=\"24\" alt=\"Feudal Age\">";
                            break;
                        case "Dark":
                        default:
                            htmlTable += "<img src=\"https://vignette.wikia.nocookie.net/ageofempires/images/e/e7/DarkageDE.png\"  width=\"24\" height=\"24\" alt=\"Dark Age\">";
                    }
                    htmlTable += "</td>";
                    htmlTable += "<td>";
                    if (unit.cost.food !== 0) {
                        htmlTable += "<img src=\"https://vignette.wikia.nocookie.net/ageofempires/images/5/5f/Aoe2de_food.png\"  width=\"24\" height=\"24\" alt=\"Food cost\"> " + unit.cost.food + " ";
                    }
                    if (unit.cost.wood !== 0) {
                        htmlTable += "<img src=\"https://vignette.wikia.nocookie.net/ageofempires/images/8/84/Aoe2de_wood.png\"  width=\"24\" height=\"24\" alt=\"Wood cost\"> " + unit.cost.wood + " ";
                    }
                    if (unit.cost.stone !== 0) {
                        htmlTable += "<img src=\"https://vignette.wikia.nocookie.net/ageofempires/images/7/7d/Aoe2de_stone.png.png\"  width=\"24\" height=\"24\" alt=\"Stone cost\"> " + unit.cost.stone + " ";
                    }
                    if (unit.cost.gold !== 0) {
                        htmlTable += "<img src=\"https://vignette.wikia.nocookie.net/ageofempires/images/4/49/Aoe2de_gold.png\"  width=\"24\" height=\"24\" alt=\"Gold cost\"> " + unit.cost.gold + " ";
                    }
                    htmlTable += "</td>";
                    htmlTable += "<td class=\"aoe_advanced\">" + unit.buildTime + "</td>";
                    htmlTable += "<td class=\"aoe_super_advanced\">" + unit.reloadTime + "</td>";
                    htmlTable += "<td class=\"aoe_advanced\">" + unit.lineOfSight + "</td>";
                    htmlTable += "<td>" + unit.hitPoints + "</td>";
                    htmlTable += "<td class=\"aoe_super_advanced\">" + unit.attackDelay + "</td>";
                    htmlTable += "<td class=\"aoe_super_advanced\">" + unit.movementRate + "</td>";
                    htmlTable += "<td class=\"aoe_advanced\">" + unit.range + "</td>";
                    htmlTable += "<td>" + unit.attack + "</td>";
                    htmlTable += "<td class=\"aoe_advanced\">" + unit.armor + "</td>";
                    htmlTable += "<td class=\"aoe_super_advanced\">" + unit.searchRadius + "</td>";
                    htmlTable += "<td class=\"aoe_advanced\">" + unit.accuracy + "</td>";
                    htmlTable += "<td class=\"aoe_super_advanced\">" + unit.blastRadius + "</td>";
                htmlTable += "</tr>";
            });
            htmlTable += "</tbody>";
            htmlTable += "</table>";
            $('#feedback').html(htmlTable);
            switch(displayMode) {
                case dataDisplayMode.VERY_DETAILED:
                    $(".aoe_advanced").show();
                    $(".aoe_super_advanced").show();
                    break;
                case dataDisplayMode.DETAILED:
                    $(".aoe_advanced").show();
                    $(".aoe_super_advanced").hide();
                    break;
                case dataDisplayMode.SIMPLE:
                default:
                    $(".aoe_advanced").hide();
                    $(".aoe_super_advanced").hide();
            }
        },  
        
        error: function (e) {
            var jsonMessage = JSON.parse(e.responseText, null, 4);
            var htmlMessage = "<p>Error: </p><br><p>" + jsonMessage.msg + "</p>";
            $('#feedback').html(htmlMessage);
        }
    });
}