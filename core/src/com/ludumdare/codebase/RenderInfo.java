package com.ludumdare.codebase;

import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.Texture;

public class RenderInfo implements Comparable<RenderInfo>
{
    Mesh meshtype;
    Texture texture;

    float width;
    float height;

    float x;
    float y;
    float layer;

    float u0, v0, u1, v1;

    @Override
    public int compareTo(RenderInfo o)
    {
        // if (layer == o.layer)
        // {
        // return texture.getTextureObjectHandle()
        // - o.texture.getTextureObjectHandle();
        // }
        // else
        // {
        // if (layer < o.layer)
        // {
        // return -1;
        // }
        // else
        // {
        // return 1;
        // }
        // }
        if (layer > o.layer) return 1;
        if (layer < o.layer) return -1;
        else
        {
            return texture.getTextureObjectHandle()
                    - o.texture.getTextureObjectHandle();
        }
    }
}
