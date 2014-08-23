#ifdef GL_ES
precision mediump float;
#endif

uniform sampler2D u_texture0;

varying vec4 v_color;
varying vec2 v_texCoords;

void main()
{
	gl_FragColor =  texture2D(u_texture0, v_texCoords);
}