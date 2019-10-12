/**
 * Created by epc-news on 2018/12/7.
 */
// Vertex shader program 顶点着色器属性
var VSHADER_SOURCE =
    'attribute vec4 a_Position;\n' +
    'attribute float a_PointSize;\n' +
    'void main() {\n' +
    '  gl_Position = a_Position;\n' + // Set the vertex coordinates of the point
    '  gl_PointSize = a_PointSize;\n' +                    // Set the point size
    '}\n';

// Fragment shader program 片元着色器
var FSHADER_SOURCE =
    'precision mediump float; \n'+
    'uniform vec4 u_FragColor; \n'+
    'void main() {\n' +
    '  gl_FragColor = u_FragColor;\n' + // Set the point color
    '}\n';

function main() {
    // Retrieve <canvas> element
    var canvas = document.getElementById('webgl');
    // Get the rendering context for WebGL
    var gl = getWebGLContext(canvas);
    if (!gl) {
        console.log('Failed to get the rendering context for WebGL');
        return;
    }

    // Initialize shaders
    if (!initShaders(gl, VSHADER_SOURCE, FSHADER_SOURCE)) {
        console.log('Failed to intialize shaders.');
        return;
    }
    var a_Position =  gl.getAttribLocation(gl.program,'a_Position');
    var a_PointSize = gl.getAttribLocation(gl.program,'a_PointSize');
    //获取u_FragColor变量的存储位置
    var u_FragColor = gl.getUniformLocation(gl.program,'u_FragColor');
    gl.vertexAttrib1f(a_PointSize,10.0);
    if(a_Position<0){
        console.log("failed to get the storage location of a_Position");
        return;
    }
    if(a_PointSize<0){
        console.log("failed to get the storage location of a_PointSize");
        return;
    }
    // Specify the color for clearing <canvas>
    gl.clearColor(0.0, 0.0, 1.0, 1.0);
    canvas.onmousemove = function(ev){
      click(ev,gl,canvas,a_Position,u_FragColor);
    };

    // Clear <canvas>
    gl.clear(gl.COLOR_BUFFER_BIT);

}
//鼠标点击数组
var t_points = [];
var t_colors = [];

function click(ev,gl,canvas,a_Position,u_FragColor){
    var x = ev.clientX; //鼠标点击处x坐标
    var y = ev.clientY; //鼠标点击处y坐标

    var rect = ev.target.getBoundingClientRect();
    x = ((x-rect.left) -  canvas.height/2)/(canvas.height/2);
    y = (canvas.width/2 - (y- rect.top))/(canvas.width/2);

    t_points.push(x); t_points.push(y);
    t_colors = [];
    if(x>=0.0 && y>=0.0){
        t_colors.push([1.0,1.0,1.0,1.0]);
    }else if(x>0.0 && y<0.0){
        t_colors.push([0.0,1.0,0.0,1.0]);
    }else{
        t_colors.push([1.0,0.0,0.2,1.0]);
    }

    gl.clear(gl.COLOR_BUFFER_BIT);

    var len = t_points.length;

    for(var i=0; i<len;i+=2){
        var rgba = t_colors[0];
        gl.vertexAttrib3f(a_Position,t_points[i],t_points[i+1],0.0);
        gl.uniform4f(u_FragColor,rgba[0],rgba[1],rgba[2],rgba[3]);
    }

    //
    gl.drawArrays(gl.POINTS,0,1);
}
