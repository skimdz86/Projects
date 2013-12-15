function preview(div,text_div){
    
    var text = $(div).find(text_div).html().split(" ");
        
    var line_strings = new Array();
    line_strings[0] = line_strings[1] = line_strings[2] = "";
        
    var curr_line = 0;
    for(var i = 0; i < text.length;i++){
        var word = text[i] + " ";
        //line = 22 chars
        //parole max di 22 caratteri
        if(word.length + line_strings[curr_line].length > 22){
            curr_line = curr_line + 1;
        }
            
        line_strings[curr_line] += word;
    }
    
    $(div).find("#_preview_t-shirt").svg({
        onLoad: function(svg){
            
            svg.describe('Image Preview of The T-Shirt - '+div); 
            //x,y,width,height,rel
            var img = svg.image(0, 0, 400, 300, '/Crevu/resources/images/t-shirt_default.png'); 
            svg.title(img, 't-shirt preview'); 
            
            var img = svg.image(150, 200, 100, 50, '/Crevu/resources/images/logo.png'); 
            svg.title(img, 'logo'); 

            var defs = svg.defs(); 
             
            svg.text(defs,200,110,line_strings[0],{
                id: 'Line1',
                fontFamily: 'Lucida Console', 
                fontSize: 12, 
                textAnchor: 'middle', 
                fill:"red"
            });

            svg.use('#Line1');
        
            svg.text(defs,200,130, line_strings[1], {
                id: 'Line2', 
                fontFamily: 'Lucida Console', 
                fontSize: 12, 
                textAnchor: 'middle', 
                fill:"red"
            });

            svg.use('#Line2');
        
            svg.text(defs,200,150,line_strings[2], {
                id: 'Line3', 
                fontFamily: 'Lucida Console', 
                fontSize: 12, 
                textAnchor: 'middle', 
                fill:"red"
            });

            svg.use('#Line3');
        }
    });
    
}
function preview_input_text(div,input){
    
    var text = $(input).attr('value').split(" ");
            
    var line_strings = new Array();
    line_strings[0] = line_strings[1] = line_strings[2] = "";
        
    if($(input).attr('value').length > 66) notify("limit exceeded", "there's a limitation of 66 chars message. please correct the string", "alert");
        
    var curr_line = 0;
    for(var i = 0; i < text.length;i++){
        var word = text[i] + " ";
        //line = 22 chars
        //parole max di 22 caratteri
        if(word.length > 22) notify("limit exceeded", "there's a limitation of 22 chars for a single word. please correct the string", "alert");
        
        if(word.length + line_strings[curr_line].length > 22){
            curr_line = curr_line + 1;
        }
            
        line_strings[curr_line] += word;
    }
    
    
    $(div).find("#_preview_t-shirt").svg({
        onLoad: function(svg){
            
            svg.describe('Image Preview of The T-Shirt - '+div); 
            //x,y,width,height,rel
            var img = svg.image(0, 0, 200, 150, '/Crevu/resources/images/t-shirt_default.png'); 
            svg.title(img, 't-shirt preview'); 
            
            var img = svg.image(75, 100, 50, 25, '/Crevu/resources/images/logo.png'); 
            svg.title(img, 'logo'); 

            var defs = svg.defs(); 
             
            svg.text(defs,100,55,line_strings[0],{
                id: 'Line1',
                fontFamily: 'Lucida Console', 
                fontSize: 6, 
                textAnchor: 'middle', 
                fill:"red"
            });

            svg.use('#Line1');
        
            svg.text(defs,100,65, line_strings[1], {
                id: 'Line2', 
                fontFamily: 'Lucida Console', 
                fontSize: 6, 
                textAnchor: 'middle', 
                fill:"red"
            });

            svg.use('#Line2');
        
            svg.text(defs,100,75,line_strings[2], {
                id: 'Line3', 
                fontFamily: 'Lucida Console', 
                fontSize: 6, 
                textAnchor: 'middle', 
                fill:"red"
            });

            svg.use('#Line3');
        }
    });
    
}

function empty(div){
    $(div).find("#_preview_t-shirt").svg("destroy");
}