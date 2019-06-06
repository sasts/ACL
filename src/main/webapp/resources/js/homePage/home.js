
$(document).ready(function () {
    $('#companySelect').change(function () {
        var selectedCompany =
            $(this).children("option:selected").val();
        $.ajax({
            url: "http://localhost:8080/home/" + selectedCompany,
            data: {},
            type: "GET",
            dataType: "json",
            contentType: "aplication/json; charset=utf-8"
        }).done(function (result) {
            visitorsList(result);
        });

    });

    function visitorsList(array) {
        var select = $('#visitorSelect');
        if(array === null || array === undefined || array.length === 0 ) {
            select.find('option').remove().end().append("<option>Brak pracowników</option>")
        } else {
            select.find('option').remove().end();
            for (var i = 0; i < array.length; i++) {
                select.append('<option value="' + array[i].id + '">' + array[i].fullName + '</option>')
            }
        }

    }

    $.fn.datetimepicker.Constructor.Default = $.extend({}, $.fn.datetimepicker.Constructor.Default, {
        icons: {
            time: 'far fa-clock',
            date: 'far fa-calendar',
            up: 'far fa-arrow-up',
            down: 'far fa-arrow-down',
            previous: 'far fa-chevron-left',
            next: 'far fa-chevron-right',
            today: 'far fa-calendar-check-o',
            clear: 'far fa-trash',
            close: 'far fa-times'
        }
    });

    $(function () {
        $('#datetimepicker2').datetimepicker({
            sideBySide: true,
            debug: true,
            locale: 'pl',
            maskInput: true,
            format: 'YYYY-MM-DD HH:mm'
        });

        $('#datetimepicker3').datetimepicker({
            sideBySide: true,
            debug: true,
            locale: 'pl',
            maskInput: true,
            format: 'YYYY-MM-DD HH:mm'
        });

    });

});





