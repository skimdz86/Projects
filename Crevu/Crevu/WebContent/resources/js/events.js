var ClickNumber = 0;
var num_results = 10;

$(document).ready(function() { 
    
    $("#_side_boxes").load("contents/_side_events.html");
    $("#_up_t-shirt").html("<div style=\"alignment-adjust: central;margin:15px;display: block;cursor:pointer;\"><h1><i class=\"fa-icon-chevron-up\"></i></h1></div>");
    $("#_down_t-shirt").html("<div style=\"alignment-adjust: central;margin:15px;display: block;cursor:pointer;\"></div>");
    
    ClickNumber = 3;
    setTimeout(function(){
        $("#_t-shirt_results_1").hide('normal');
        $("#_t-shirt_results_1").load(root+"contents/_events_results.html",function(){
            $("#_t-shirt_results_1").find(".title h4 a").html("1° message ° message ° message ° message ° message ° message123456");  
        
            $("#_t-shirt_results_1").mouseover(function(){
                empty('#_t-shirt_results_2');
                empty('#_t-shirt_results_3');
                preview('#_t-shirt_results_1',".title h4 a");
            });
        }); 
        $("#_t-shirt_results_1").show('slow');
    },0);
    
    
    setTimeout(function(){
        $("#_t-shirt_results_2").hide('normal');
        $("#_t-shirt_results_2").load(root+"contents/_events_results.html",function(){
            $("#_t-shirt_results_2").find(".title h4 a").html("2° message ° message ° message ° message ° message ° message123456"); 
        
            $("#_t-shirt_results_2").mouseover(function(){
                empty('#_t-shirt_results_1');
                empty('#_t-shirt_results_3');
                preview('#_t-shirt_results_2',".title h4 a");
            });
        }); 
        $("#_t-shirt_results_2").show('slow');
        clearTimeout(this);
    },500);
    
    
    setTimeout(function(){
        $("#_t-shirt_results_3").hide('normal');
        $("#_t-shirt_results_3").load(root+"contents/_events_results.html",function(){
            $("#_t-shirt_results_3").find(".title h4 a").html("3° message ° message ° message ° message ° message ° message123456"); 
        
            $("#_t-shirt_results_3").mouseover(function(){
                empty('#_t-shirt_results_1');
                empty('#_t-shirt_results_2');
                preview('#_t-shirt_results_3',".title h4 a");
            });
        }); 
        $("#_t-shirt_results_3").show('slow');
    },800);
    
    setTimeout(function(){
        $("#t-shirt_results_3 .title h4 a").html("3° message");
    },1000);
    
    $("#_down_t-shirt").click(function(){
        setTimeout(function(){
            $("#_t-shirt_results_3").html($("#_t-shirt_results_2").html());
            $("#_t-shirt_results_2").html($("#_t-shirt_results_1").html());
            newFirst();
        },0);
        
    });
    
    $("#_up_t-shirt").click(function(){
        
        setTimeout(function(){
            $("#_t-shirt_results_1").hide(300,function(){
                $("#_t-shirt_results_1").html($("#_t-shirt_results_2").html());
                $("#_t-shirt_results_2").html($("#_t-shirt_results_3").html());
                $("#_t-shirt_results_1").show();
                $("#_t-shirt_results_2").show();
            });
        },0);
        setTimeout(function(){
            $("#_t-shirt_results_3").hide();
           
            newLast(); 
        },300);
    });
});



function showComment(comment,user){
    console.log(comment);
    $("#current_comment").html(comment+"<span class='user_tag'>#"+user+"</span>");
}

function newFirst(){
    ClickNumber -- ;
    $("#_t-shirt_results_1").hide();
    $("#_t-shirt_results_1").load(root+"contents/_events_results.html",function(){
        $("#_t-shirt_results_1").find(".title h4 a").html(ClickNumber-2+"° message ° message ° message ° message ° message ° message123456"); 
        $("#_t-shirt_results_1").find("#_preview_image").src("images/logo.png"); 
    });
    $("#_t-shirt_results_1").show('slow');
    
    /*
     * 
     * 
     * if already favourite, change the button color
     * 
     * 
     */
    $("#favourite a").addClass("btn-danger").css({
        "color":"white"
    });
    /*
     * 
     * 
     * 
     * 
     * 
     */
    if(ClickNumber>3)
        $("#_down_t-shirt").html("<div style=\"alignment-adjust: central;margin:15px;display: block;cursor:pointer;\"><h1><i class=\"fa-icon-chevron-down\"></i></h1></div>");
    else
        $("#_down_t-shirt").html("<div style=\"alignment-adjust: central;margin:15px;display: block;cursor:pointer;\"></div>");

    if(ClickNumber<num_results)
        $("#_up_t-shirt").html("<div style=\"alignment-adjust: central;margin:15px;display: block;cursor:pointer;\"><h1><i class=\"fa-icon-chevron-up\"></i></h1></div>");
    else
        $("#_up_t-shirt").html("<div style=\"alignment-adjust: central;margin:15px;display: block;cursor:pointer;\"></div>");

}
function newLast(){
    ClickNumber ++ ;
    $("#_t-shirt_results_3").load(root+"contents/_t-shirt_results.html",function(){
        $("#_t-shirt_results_3").find(".title h4 a").html(ClickNumber+"° message ° message ° message ° message ° message ° message123456"); 
        $("#_t-shirt_results_1").find("#_preview_image").src("images/logo.png"); 
    });
    $("#_t-shirt_results_3").show('slow');
    
    /*
     * 
     * 
     * if not clicked on favourite, reset the button color
     * 
     * 
     */
    $("#favourite a").removeClass("btn-danger").css({
        "color":"red"
    });
    /*
     * 
     * 
     * 
     * 
     * 
     */
    if(ClickNumber>=3)
        $("#_down_t-shirt").html("<div style=\"alignment-adjust: central;margin:15px;display: block;cursor:pointer;\"><h1><i class=\"fa-icon-chevron-down\"></i></h1></div>");
    else
        $("#_down_t-shirt").html("<div style=\"alignment-adjust: central;margin:15px;display: block;cursor:pointer;\"></div>");


    if(ClickNumber<num_results)
        $("#_up_t-shirt").html("<div style=\"alignment-adjust: central;margin:15px;display: block;cursor:pointer;\"><h1><i class=\"fa-icon-chevron-up\"></i></h1></div>");
    else
        $("#_up_t-shirt").html("<div style=\"alignment-adjust: central;margin:15px;display: block;cursor:pointer;\"></div>");

}