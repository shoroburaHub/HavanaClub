/**
 * Created by admin on 6/19/2017.
 */

$('#saveCity').click(function () {

    var city = {
        name: $('#cityName').val()
    };

    $('#cityName').val('');

    $.ajax({

        url: '/city?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        method: 'POST',
        dataType: 'json',
        contentType: 'application/json; charset=UTF-8',
        data: JSON.stringify(city),
        success: function (res) {
            var citiesFromDb = '';

            for(var i in res){
                citiesFromDb += '<tr><td>'+res[i].name+'</td><td><button class="btn btn-default" id="deleteCity" onclick="deleteCity('+res[i].id+')">delete</button></td></tr>';
            }

            document.getElementById('result').innerHTML = citiesFromDb;

        },
        error: function (err) {
            console.log(err)
        }
    })
});


function loadCities() {
    $.ajax({

        url: '/city?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        method: 'GET',
        success: function (res) {
            var citiesFromDb = '';
            for(var i in res){
                citiesFromDb += '<tr><td>'+res[i].name+'</td><td><button class="btn btn-default" id="deleteCity" onclick="deleteCity('+res[i].id+')">delete</button></td></tr>';
            }
            document.getElementById('result').innerHTML = citiesFromDb;
        },
        error: function (err) {
            console.log(err)
        }
    })

};

loadCities();

function deleteCity(idCity) {

    $.ajax({

        url: '/city?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        method: 'DELETE',
        data: JSON.stringify(idCity),
        success: function (res) {
            var citiesFromDb = '';
            for(var i in res){
                citiesFromDb += '<tr><td>'+res[i].name+'</td><td><button class="btn btn-default" id="deleteCity" onclick="deleteCity('+res[i].id+')">delete</button></td></tr>';
            }
            document.getElementById('result').innerHTML = citiesFromDb;
        },
        error: function (err) {
            console.log(err)
        }
    })

}