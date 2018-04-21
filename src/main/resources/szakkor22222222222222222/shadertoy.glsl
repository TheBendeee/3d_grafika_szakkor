uniform vec2 iResolution;
uniform float iTime;

void mainImage( out vec4 fragColor, in vec2 fragCoord )
{
     //Normalized pixel coordinates (from 0 to 1)
    vec2 uv = fragCoord/iResolution.xy;

    vec2 center = vec2(0.5,0.5);
    vec2 center2 = vec2(0.5,0.77);
    vec2 sz1 = vec2(0.41,0.5);
    vec2 sz2 = vec2(0.59,0.5);
    vec2 szg1 = vec2(0.40,0.5);
    vec2 szg2 = vec2(0.58,0.5);



    float d = distance(center,uv);
    float d2 = distance(center2,uv);
    float d3 = distance(sz1,uv);
    float d4 = distance(sz2,uv);
    float d5 = distance(szg1,uv);
    float d6 = distance(szg2,uv);

    vec3 col = 0.5 + 0.5*cos(iTime+uv.xyx+vec3(0,2,4));

    if (d > 0.3 * (sin(iTime)/2.+0.5)+0.1){
        col = 0.5 + 0.5*cos(iTime+uv.xyx+vec3(2,2,4));
    }else if(d3 <= 0.025 * (cos(iTime) +0.9)+ 0.015){
        col = 0.5 + 0.5*cos(iTime+uv.xyx+vec3(2,2,1));

    }else if(d5 <= 0.025 * (cos(iTime) +0.9)+ 0.035){
        col = 0.5 + 0.6*cos(iTime+uv.xyx+vec3(2,2,1));

    }else if(d4 <= 0.025 * (cos(iTime) +0.9)+ 0.015){
        col = 0.5 + 0.5*cos(iTime+uv.xyx+vec3(2,2,1));

    }else if(d6 <= 0.025 * (cos(iTime) +0.9)+ 0.035){
        col = 0.5 + 0.6*cos(iTime+uv.xyx+vec3(2,2,1));

    }else if(d2 < 0.5){
        col = 0.5 + 0.5*cos(iTime+uv.xyx+vec3(2,2,4));
    }else{
        col = 0.5 + 0.5*cos(iTime+uv.xyx+vec3(2,2,1));
    }

    //Output to screen
    fragColor = vec4(col,1.0);
}

void main(){
    mainImage(gl_FragColor,gl_FragCoord.xy);
}