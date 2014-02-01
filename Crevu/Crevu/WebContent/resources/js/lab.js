
$(document).ready(function() { 
    
    
    $("#_side_boxes").load(root+"contents/_side_admin.html");
    
    $("#_lab_results").append("<span id='_lab_row_1'></span>");
    $("#_lab_row_1").load("contents/_lab_results.html",function(){
        $("#_lab_row_1").find(".title h5").html("1° message ° message ° message ° message ° message ° message123456");  
        setInterval('timeleft("#_lab_row_1","June 11, 2014 00:30:00")',1000);
        $("#_t-shirt_results_1").mouseover(function(){
            empty('#_t-shirt_results_2');
            empty('#_t-shirt_results_3');
            preview('#_t-shirt_results_1',".title h5");
        });
    });
    $("#_lab_results").append("<span id='_lab_row_2'></span>");
    $("#_lab_row_2").load("contents/_lab_results.html",function(){
        $("#_lab_row_2").find(".title h5").html("1° message ° message ° message ° message ° message ° message123456");  
        setInterval('timeleft("#_lab_row_2","June 11, 2014 11:30:00")',1000);
        $("#_t-shirt_results_2").mouseover(function(){
            empty('#_t-shirt_results_1');
            empty('#_t-shirt_results_3');
            preview('#_t-shirt_results_2',".title h5");
        });
    });
    $("#_lab_results").append("<span id='_lab_row_3'></span>");
    $("#_lab_row_3").load("contents/_lab_results.html",function(){
        $("#_lab_row_3").find(".title h5").html("1° message ° message ° message ° message ° message ° message123456");  
        setInterval('timeleft("#_lab_row_3","June 11, 2014 18:30:00")',1000);
        $("#_t-shirt_results_3").mouseover(function(){
            empty('#_t-shirt_results_1');
            empty('#_t-shirt_results_2');
            preview('#_t-shirt_results_3',".title h5");
        });
    });
    
    
    $(".dropt").live('mouseover',function(){
        var text = $(this).find(".title h5").html().split(" ");
        
        var line_strings = new Array(); line_strings[0] = line_strings[1] = line_strings[2] = "";
        
        var curr_line = 0;
        for(var i = 0; i < text.length;i++){
            var word = text[i] + " ";
            //
            //line = 22 chars
            //parole max di 22 caratteri
            if(word.length + line_strings[curr_line].length > 22){
                curr_line = curr_line + 1;
            }
            
            line_strings[curr_line] += word;
        }

        $(this).find("span").svg({
            onLoad: function(svg){
                svg.describe('Image Preview of The T-Shirt'); 
                //x,y,width,height,rel
                var img = svg.image(0, 0, 400, 300, 'images/t-shirt_default.png'); 
                svg.title(img, 't-shirt preview'); 
            
                var img = svg.image(150, 200, 100, 50, 'images/logo.png'); 
                svg.title(img, 'logo'); 

                var defs = svg.defs(); 
             
                svg.text(defs,200,110,line_strings[0],{id: 'Line1',fontFamily: 'Lucida Console', fontSize: 12, textAnchor: 'middle', fill:"red"});

                svg.use('#Line1');
        
                svg.text(defs,200,130, line_strings[1], {id: 'Line2', fontFamily: 'Lucida Console', fontSize: 12, textAnchor: 'middle', fill:"red"});

                svg.use('#Line2');
        
                svg.text(defs,200,150,line_strings[2], {id: 'Line3', fontFamily: 'Lucida Console', fontSize: 12, textAnchor: 'middle', fill:"red"});

                svg.use('#Line3');
            }
        }); 
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