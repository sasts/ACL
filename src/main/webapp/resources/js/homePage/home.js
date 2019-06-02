
$(document).ready(function () {
    $('#companySelect').change(function () {
        var selectedCompany =
            $(this).children("option:selected").val();
        $.ajax({
            url: "http://localhost:8080/home/" + selectedCompany,
            data: {},
            type: "GET",
            dataType: "json",
            contentType: "aplication/json"
        }).done(function (result) {
            visitorsList(result);
        });
    });

    function visitorsList(array) {
        var select = $("#visitorSelect");
        for (var i = 0; i < array.length; i++) {
            select.appendChild('<option value="' + array[i].visitorId + '">' + array[i].firstName + '</option>option>');
        }

    }

});





