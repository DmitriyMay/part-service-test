<%@ page import="part.dto.Part" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Locale" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Parts</title>
    <script src="http://code.jquery.com/jquery-3.4.0.js" type="text/javascript"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js" type="text/javascript"></script>
    <script src="http://code.jquery.com/ui/1.9.2/jquery-ui.min.js" type="text/javascript"></script>
    <script src="https://cdn.jsdelivr.net/npm/table-to-json@0.13.0/lib/jquery.tabletojson.min.js"
            integrity="sha256-AqDz23QC5g2yyhRaZcEGhMMZwQnp8fC6sCZpf+e7pnw=" crossorigin="anonymous"></script>
    <style>
        #f_s_after {
            text-indent: -500px;
        }

        #f_s_before {
            text-indent: -500px;
        }

        #f_r_after {
            text-indent: -500px;
        }

        #f_r_before {
            text-indent: -500px;
        }

        form {
            margin: auto;
            border-collapse: collapse;
            border: 1px solid black;
            width: 40%;
        }

        body {
            font-family: Arial, sans-serif;
            font-size: 12px;
        }

        .field {
            clear: both;
        }

        table {
            margin: auto;
            border-collapse: collapse;
            border: 1px solid black;
            width: 80%;
        }

        th {
            cursor: pointer;
        }

        td {
            width: 200px;
            word-wrap: break-word;
            text-align: center;
        }
    </style>
</head>
<body>
<h3>
    <div id="filter_form">
        <form>
            <p class="field">
                <label style="padding-right:130px;">PN</label>
                <input style="width: 360px;" id="f_pn" type="text" name="PN" value="">
            </p>
            <p class="field">
                <label style="padding-right:80px;" for="f_p_name">Part Name</label>
                <input style="width: 360px;" id="f_p_name" type="text" name="Part Name" value="">
            </p>
            <p class="field">
                <label style="padding-right:103px;" for="f_p_vendor">Vendor</label>
                <input style="width: 360px;" id="f_p_vendor" type="text" name="Vendor" value="">
            </p>
            <p class="field">
                <label style="padding-right:127px;" for="f_p_qty">Qty</label>
                <input style="width: 100px;" id="f_p_qty" type="number" name="Qty" value="">
            </p>
            <p class="field">
                <label style="padding-right:95px;">Shipped</label>
                <label for="f_s_after">after</label>
                <input style="width: 137px; height:20px" id="f_s_after" type="date" dateformat="M d, yy"
                       name="Shipped after" value="">
                <span class="datepicker_label_ship_after" style="pointer-events: none;"></span>
                <label for="f_s_before">before</label>
                <input style="width: 137px; height:20px" id="f_s_before" type="date" dateformat="M d, yy"
                       name="Shipped before" value="">
                <span class="datepicker_label_ship_before" style="pointer-events: none;"></span>
            </p>
            <p class="field">
                <label style="padding-right:98px;">Receive</label>
                <label placeholder="MMM dd, yyyy" for="f_r_after">after</label>
                <input style="width: 137px; height:20px" id="f_r_after" type="date" dateformat="M d, yy"
                       name="Receive after" value="">
                <span class="datepicker_label_rec_after" style="pointer-events: none;"></span>
                <label for="f_r_before">before</label>
                <input style="width: 137px; height:20px" id="f_r_before" type="date" dateformat="M d, yy"
                       name="Receive before" value="">
                <span class="datepicker_label_rec_before" style="pointer-events: none;"></span>
            </p>
            <p align="center">
                <input id="filter" type="button" value="Filter">
            </p>
        </form>
    </div>
    <br>
    <br>

    <div>
        <table border="1" id="parts">
            <thead id="parts_thead">
            <tr style="background-color: silver;">
                <th onclick="sortFieldPartNumber()">PN</th>
                <th onclick="sortFieldPartName()">Part Name</th>
                <th onclick="sortFieldVendor()">Vendor</th>
                <th onclick="sortFieldQty()">Qty</th>
                <th onclick="sortFieldShipped()">Shipped</th>
                <th onclick="sortFieldReceive()">Receive</th>
            </tr>

            </thead>
            <tbody id="parts_body">

            <% SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
                for (Part p : (ArrayList < Part >) request.getAttribute("part")) {

            %>
            <tr>
                <td id="p_number"><%= p.getPartNumber() %>
                </td>
                <td id="p_name"><%= p.getPartName() %>
                </td>
                <td id="p_vendor"><%= p.getVendor() %>
                </td>
                <td id="p_qty"><%= p.getQty() %>
                </td>
                <td id="p_shipped"><%= sdf.format(p.getShipped()) %>
                </td>
                <td id="p_receive"><%= sdf.format(p.getReceive()) %>
                </td>
            </tr>

            <% } %>
            </tbody>
        </table>
    </div>
</h3>
</body>
<script>
    const appendPart = function (resp) {
        $('#parts_body').remove();
        $('#parts').append('<tbody id="parts_body"></tbody>');
        for (i in resp) {

            var partCode =
                "<td id=\"p_number\">" + resp[i]["PN"] + "</td>" +
                "<td id=\"p_name\">" + resp[i]["Part Name"] + "</td>" +
                "<td id=\"p_vendor\">" + resp[i]["Vendor"] + "</td>" +
                "<td id=\"p_qty\">" + resp[i]["Qty"] + "</td>" +
                "<td id=\"p_shipped\">" + resp[i]["Shipped"] + "</td>" +
                "<td id=\"p_receive\">" + resp[i]["Receive"] + "</td>";

            $('#parts_body').append("<tr>" + partCode + "</tr>");
        }

    };

    $("#f_s_after").on("change", function () {
        $(this).css("color", "rgba(0,0,0,0)").siblings(".datepicker_label_ship_after")
            .css({"text-align": "center", position: "absolute ", left: "750px", width: $(this).width()})
            .text($(this).val().length == 0 ? "" : ($.datepicker.formatDate($(this).attr("dateformat"), new Date($(this).val()))));
    });

    $("#f_s_before").on("change", function () {
        $(this).css("color", "rgba(0,0,0,0)").siblings(".datepicker_label_ship_before")
            .css({"text-align": "center", position: "absolute ", left: "937px", width: $(this).width()})
            .text($(this).val().length == 0 ? "" : ($.datepicker.formatDate($(this).attr("dateformat"), new Date($(this).val()))));
    });

    $("#f_r_after").on("change", function () {
        $(this).css("color", "rgba(0,0,0,0)").siblings(".datepicker_label_rec_after")
            .css({"text-align": "center", position: "absolute ", left: "750px", width: $(this).width()})
            .text($(this).val().length == 0 ? "" : ($.datepicker.formatDate($(this).attr("dateformat"), new Date($(this).val()))));
    });

    $("#f_r_before").on("change", function () {
        $(this).css("color", "rgba(0,0,0,0)").siblings(".datepicker_label_rec_before")
            .css({"text-align": "center", position: "absolute ", left: "937px", width: $(this).width()})
            .text($(this).val().length == 0 ? "" : ($.datepicker.formatDate($(this).attr("dateformat"), new Date($(this).val()))));
    });


    var filterParts = function () {
        $("input[id=filter]").click(function () {

            var data = $('#filter_form form').serialize();
            console.log(data);
            $.ajax({
                method: "GET",
                url: '/parts?',
                data: data,
                dataType: 'json',
                headers: {
                    'Cache-Control': 'no-cache, no-store, must-revalidate',
                    'Pragma': 'no-cache',
                    'Expires': '0'
                },
                success: function (resp) {
                    appendPart(resp);
                },
                error: function (response) {
                    if (response.status === 404) {
                        alert('Части не найдены!');

                    }
                }
            });
        });
    };

    filterParts();

    function sortFieldPartNumber() {
        var parts = $('#parts').tableToJSON();
        var partsObjects = {
            type: "PN",
            parts: parts
        };

        $.ajax({
            url: "/parts/sort",
            type: "POST",
            data: JSON.stringify(partsObjects),
            dataType: 'json',
            async: true,
            contentType: 'application/json; charset=utf-8',
            success: function (resp) {
                appendPart(resp);
            }
        });
    }

    function sortFieldPartName() {
        var parts = $('#parts').tableToJSON();
        var partsObjects = {
            type: "PART_NAME",
            parts: parts
        };

        $.ajax({
            url: "/parts/sort",
            type: "POST",
            data: JSON.stringify(partsObjects),
            dataType: 'json',
            async: true,
            contentType: 'application/json; charset=utf-8',
            success: function (resp) {
                appendPart(resp);
            }
        });
    }

    function sortFieldVendor() {
        var parts = $('#parts').tableToJSON();
        var partsObjects = {
            type: "VENDOR",
            parts: parts
        };

        $.ajax({
            url: "/parts/sort",
            type: "POST",
            data: JSON.stringify(partsObjects),
            dataType: 'json',
            async: true,
            contentType: 'application/json; charset=utf-8',
            success: function (resp) {
                appendPart(resp);
            }
        });
    }

    function sortFieldQty() {
        var parts = $('#parts').tableToJSON();
        var partsObjects = {
            type: "QTY",
            parts: parts
        };

        $.ajax({
            url: "/parts/sort",
            type: "POST",
            data: JSON.stringify(partsObjects),
            dataType: 'json',
            async: true,
            contentType: 'application/json; charset=utf-8',
            success: function (resp) {
                appendPart(resp);
            }
        });
    }

    function sortFieldShipped() {
        var parts = $('#parts').tableToJSON();
        var partsObjects = {
            type: "SHIPPED",
            parts: parts
        };

        $.ajax({
            url: "/parts/sort",
            type: "POST",
            data: JSON.stringify(partsObjects),
            dataType: 'json',
            async: true,
            contentType: 'application/json; charset=utf-8',
            success: function (resp) {
                appendPart(resp);
            }
        });
    }

    function sortFieldReceive() {
        var parts = $('#parts').tableToJSON();
        var partsObjects = {
            type: "RECEIVE",
            parts: parts
        };

        $.ajax({
            url: "/parts/sort",
            type: "POST",
            data: JSON.stringify(partsObjects),
            dataType: 'json',
            async: true,
            contentType: 'application/json; charset=utf-8',
            success: function (resp) {
                appendPart(resp);
            }
        });
    }
</script>
</html>