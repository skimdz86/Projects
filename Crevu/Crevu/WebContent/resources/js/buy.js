
$(document).ready(function() { 
    
    
    $("#_side_boxes").load(root+"contents/_side_admin.html");
    
    $("#_lab_results").append("<span id='_lab_row_1'></span>");
    $("#_lab_row_1").load("contents/_shopping_cart_results.html",function(){
        $("#_lab_row_1").find(".title h5").html("1° message ° message ° message ° message ° message ° message123456");  
        
        $("#_lab_row_1").mouseover(function(){
            empty('#_lab_row_2');
            empty('#_lab_row_3');
            preview('#_lab_row_1',".title h5");
        });
        setInterval('timeleft("#_lab_row_1","June 11, 2014 00:30:00")',1000);
    });
    $("#_lab_results").append("<span id='_lab_row_2'></span>");
    $("#_lab_row_2").load("contents/_shopping_cart_results.html",function(){
        $("#_lab_row_2").find(".title h5").html("2° message ° message ° message ° message ° message ° message123456");  
        
        $("#_lab_row_2").mouseover(function(){
            empty('#_lab_row_1');
            empty('#_lab_row_3');
            preview('#_lab_row_2',".title h5");
        });
        setInterval('timeleft("#_lab_row_2","June 11, 2014 11:30:00")',1000);
    });
    $("#_lab_results").append("<span id='_lab_row_3'></span>");
    $("#_lab_row_3").load("contents/_shopping_cart_results.html",function(){
        $("#_lab_row_3").find(".title h5").html("3° message ° message ° message ° message ° message ° message123456");  
        
        $("#_lab_row_3").mouseover(function(){
            empty('#_lab_row_2');
            empty('#_lab_row_1');
            preview('#_lab_row_3',".title h5");
        });
        setInterval('timeleft("#_lab_row_3","June 11, 2014 18:30:00")',1000);
    });
});
function timeleft(div,date){
    
    now         = new Date();
    var kickoff = new Date();
    kickoff  = Date.parse(date);
    diff = kickoff - now;

    days  = Math.floor( diff / (1000*60*60*24) );
    hours = Math.floor( diff / (1000*60*60) );
    mins  = Math.floor( diff / (1000*60) );
    secs  = Math.floor( diff / 1000 );

    dd = days;
    hh = hours - days  * 24;
    mm = mins  - hours * 60;
    ss = secs  - mins  * 60;

    
    $(div).find("#time_left").html("<div class='countdown'>"+dd+" days "+
        hh + ' hours ' +
        mm + ' minutes ' +
        ss + ' seconds'+"</div>");
}