/**
 * Created by admin on 6/21/2017.
 */
function search() {

    $.ajax({
        url: '/searchDrink?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        method: 'POST',
        dataType: 'json',
        contentType: 'application/json; charset=UTF-8',
        data: $('#searchIn').val(),
        success: function (res) {

            console.log(res);

            // var drinks = '';
            //
            // for (var i in res) {
            //     drinks += res[i].name + '<br>'
            // }
            // document.getElementById('indexResult').innerHTML = drinks;
        }

    })

}