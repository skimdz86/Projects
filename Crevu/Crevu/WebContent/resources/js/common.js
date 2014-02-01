/*
 * rispetto a pagina html corrente
 */
var root = "";
    
$("#_side_menu_main").load(root+"contents/_side_menu_main.html");

$(document).ready(function() {
    
    $("#_t-shirt_to_the_shop").click(function(){
       notify("shopping chart", "the t-shirt selected is in your shopping chart. when you are ready, checkout at the Shopping Cart section in the menu.", "success") 
    });
    $("#_top_bar").load(root+"contents/_top_bar.html"); 
    $("#_footer").load(root+"contents/_footer.html");
});


function changePage(page){
    document.location.href = page;
}
function facebookLogin(){
    
    notify('facebook login','doing login. please wait for the response...','alert');
    FB.login(function(response) {
        if (response.authResponse) {

            FB.api('/me', function(response) {
                
                notify('facebook login','fully authorized','success');
            });
        } else {
            notify('facebook login','not authorized facebook login','error');
        }
    }, {
        scope: 'email,read_stream'
    });
}
function notify(title,message,msg_type){
    $.pnotify({
        title: title,
        text: message,
        type: msg_type,
        opacity: .8
    });
}

function readURL(ele)
{


    $('#lowresDemo').css('background-image', 'url('+ele.value+')'); // for IE
    if (ele.files && ele.files[0]) {

        var reader = new FileReader();

        reader.onload = function (e) {
            $('#lowresDemo').css('background-image', 'url('+e.target.result+')');
        }

        reader.readAsDataURL(ele.files[0]);
    }
}