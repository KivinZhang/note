/**
 * Created by epc-news on 2018/12/7.
 */
//顶点着色器
var VSHADER_SOURCE ='void main (){\n'+
    'g1_Position = vec4(0.0,0.0,0.0,1.0);\n'+
    'g1_PointSize = 10.0;\n'+
    '}\n';

//片元着色器
var FSHADER_SOURCE = 'void main() {\n'+
        'g1_FragColor = vec4(1.0,0.0,0.0,1.0); \n'+
        '}\n';

function  main() {
    //获取canvas元素
    var canvas = document.getElementById('webgl');
    //获取webgl绘制上下文
    var gl = getWebGLContext(canvas);
    if(!gl){
        console.log("failed to get the webgl");
        return;
    }
    //初始化着色器
    if(!initShaders(gl,VSHADER_SOURCE,FSHADER_SOURCE)){
        console.log("failed to load the shaders");
        return;
    }
    //设置canvas的背景色
    gl.clearColor(0.0,0.0,0.0,1.0);
    //
    gl.clear(gl.COLOR_BUFFER_BIT);

    //
    gl.drawArrays(gl.POINTS,0,1);

















}
