package com.ludumdare.codebase;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.ludumdare.codebase.scenes.HomeSceneGroup;
import com.ludumdare.codebase.scenes.SceneGroup;

/**
 * 
 * @author Hati Eth
 *
 */
public class Ludumdare30Main extends ApplicationAdapter
{

    float timeAccumulator = 0.0f;
    float UPDATE_FREQUENCY = 0.016f;

    Renderer renderer;
    Vector2 position;

    SceneGroup homeGroup;

    Vector2 mousePosition = new Vector2();

    GameData gameData;

    @Override
    public void create()
    {
        position = new Vector2();
        position.x = 50;

        gameData = new GameData();

        if (renderer == null)
        {
            renderer = new Renderer(gameData.cameraControl);
        }

        Gdx.input.setInputProcessor(new InputAdapter()
        {
            @Override
            public boolean mouseMoved(int screenX, int screenY)
            {
                mousePosition = gameData.cameraControl.screenToWorld(screenX,
                        screenY);

                return true;
            }
        });

        homeGroup = new HomeSceneGroup(gameData);
    }

    float degree = 0.0f;
    Vector2 positon2 = new Vector2();

    @Override
    public void render()
    {
        timeAccumulator = timeAccumulator + Gdx.graphics.getDeltaTime();

        while (timeAccumulator >= gameData.UPDATE_FREQUENCY)
        {
            timeAccumulator = timeAccumulator - gameData.UPDATE_FREQUENCY;
            homeGroup.update();
        }
        homeGroup.render(renderer);
    }

    @Override
    public void resize(int width, int height)
    {
        super.resize(width, height);
        gameData.cameraControl.resize(width, height);
    }

    @Override
    public void pause()
    {
        super.pause();
    }

    @Override
    public void resume()
    {
        super.resume();
    }

    @Override
    public void dispose()
    {
        super.dispose();
    }

}
