var statuses_filtered = new Array();
var tweet_filtered = new Array();



 
$(document).ready(function() {
    preview_input_text("#img_box", "input[id=text]");
    
    $("input[id=text]").keyup(function(){
        if($("input[id=text]").val().length >= 66) notify("limit exceeded", "66 chars max. please reduce the text string", "alert");
        empty(".box-internal");
        preview_input_text("#img_box", "input[id=text]");
    });
    $("#_side_boxes").load(root+"contents/_side_admin.html");
    
});

function showStatuses(){
    showFbStatuses();
    showTwStatuses();
}

   

function reloadTagsCounter(){
    var tags = $("#hidden-tags").value;
    var tags_array = tags.split(",");
    console.log("ciao!!");
    document.getElementsByName("tags").placeholder = 15 - tags_array.length + " tags remaining";
    
    if(tags_array.length >= 14)
        document.getElementsByName("tags").placeholder = 15 - tags_array.length + " tag remaining";
    
    if(tags_array.length > 15)
        document.getElementsByName("tags").placeholder = "too much tags";
    
    if(tags_array.length == 0)
        document.getElementsByName("tags").placeholder = "15 tags remaining";
}
function showFbStatuses(){

    FB.getLoginStatus(function(response) {
        if (response.status === 'connected') {
            FB.api({
                method: 'fql.query',
                query: 'SELECT message,status_id FROM status WHERE uid = me()'
            },
            function(statuses) {
                var j = 0;
                var html = "";
                for(var i=0 ; i<statuses.length;i++){                    
                    //if msg is not an url
                    if(statuses[i].message.length <= 66 && statuses[i].message.indexOf("http") !== 0){
                        html += "<a style='font-size:12px;padding:5px;margin-bottom:5px;text-align:right;width:100%;color:black;opacity:0.8;' class='btn btn-alert' onclick=\"javascript:showFbStatus("+statuses[i].status_id+");\"><table><tr><td>"+statuses[i].message+"</td><td><i class='halflings-icon upload'></i></td></tr></table></a>";
                        statuses_filtered[j] = statuses[i];
                        j++;
                        if(j == 10){
                            break;
                        }
                    }
                    
                }
                
                                
                $("#fb_statuses").html(html);
            }
            );
        } else if (response.status === 'not_authorized') {
            notify("facebook login", "if you want to see all your facebook statuses, fb login first", "alert");
        } else {
            notify("facebook login", "if you want to see all your facebook statuses, fb login first", "alert");
        }
    });
    
}

function showFbStatus(id){
    console.log(JSON.stringify(statuses_filtered));
    for(var i = 0;i< statuses_filtered.length ;i++){
        if(statuses_filtered[i].status_id == id){
            console.log(statuses_filtered[i].status_id+"_"+id);
            document.status.text.value = statuses_filtered[i].message;
            document.status.status_type.value = "facebook";
            break;
        }
    }
}

function showTwStatuses(){

    var currentTime = new Date().getTime();
    
    /*oauth_nonce="K7ny27JTpKVsTgdyLdDfmQQWVLERj2zAK5BslRsqyw", 
    oauth_callback="http%3A%2F%2Fmyapp.com%3A3005%2Ftwitter%2Fprocess_callback", 
    oauth_signature_method="HMAC-SHA1", 
    oauth_timestamp="1300228849", 
    oauth_consumer_key="OqEqJeafRSF11jBMStrZz", 
    oauth_signature="Pc%2BMLdv028fxCErFyi8KXFM%2BddU%3D", oauth_version="1.0"
    
    
    $.ajax({
        type        :   "GET",
        crossDomain :   true,
        dataType    :   'jsonp',
        data        :   { 
            oauth_consumer_key       :   "l9vwEp7w1RI7QqIwevRCw",
            oauth_nonce              :   "T7NmaKOq",           
            oauth_signature          :   "qGbCayUAzf8nGHxkKZYYm7Gg%2BzY%3D",
            oauth_signature_method   :   "HMAC-SHA1",
            oauth_timestamp          :   currentTime,
            oauth_version            :   "1.0"
        },
        url         :   'https://api.twitter.com/oauth/request_token?callback=',
        success     :   function(res){
            console.log(res);
        },
        error       :   function(err){
            console.log(err);
        }
    })*/



    var tw = new Codebird();
    console.log(tw.oauth_authorize());
    console.log(tw.oauth_authenticate());

    var currentTime = new Date;
    currentTime = Math.floor(currentTime.getTime() / 1000);

    tw.__call('statuses/userTimeline',undefined,function(data){
        console.log(data);  
    });
    
    /*var currentTime = new Date;
    currentTime = Math.floor(currentTime.getTime() / 1000);
    $.ajax({
       type:"GET",
       crossDomain:true,
       dataType : "jsonp",
       url:"https://api.twitter.com/1.1/statuses/user_timeline.json?callback=",
       data:{
           oauth_consumer_key       :   "l9vwEp7w1RI7QqIwevRCw",
           oauth_nonce              :   "T7NmaKOq",
           oauth_signature_method   :   "HMAC-SHA1",
           oauth_timestamp          :   currentTime,
           oauth_token              :   "786481040-vQJRHjXg9orHG3x2kU4UKoUv13DKcibZ5M5xRyjm",
           oauth_version            :   "1.0",
           oauth_signature          :   "qGbCayUAzf8nGHxkKZYYm7Gg%2BzY%3D"
       },
       success:function(data){
           console.log(JSON.stringify(data));
       }, 
       error:function(e,err){
           console.log(JSON.stringify(e));
           console.log(JSON.stringify(err));
       }
       
    });*/
}

function showTwStatus(id){
    
}

