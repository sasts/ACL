
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
        var select = $('#visitorSelect');
        if(array !== null || array == undefined || array.length == 0 || (array.length == 1 && array[0] == "")) {
            for (var i = 0; i < array.length; i++) {
                select.append('<option value="' + array[i].Id + '">' + array[i].fullName + '</option>')
            }
        } else {
            select.append("<option>Brak pracowników</option>")
        }

    }

});





