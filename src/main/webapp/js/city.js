/**
 * Created by admin on 6/19/2017.
 */

$('#saveCity').click(function () {

    console.log('click')

});

// loadCities();

function loadCities() {

    console.log(11111)

    $.ajax({

        url : '/city?'+ $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        method : 'GET',
        success : function (res) {
            console.log(res);
        },
        error : function (err) {
            console.log(err);
        }

    });


}


