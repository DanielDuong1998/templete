package com.ss.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.ss.commons.Tweens;
import com.ss.core.util.GAssetsManager;
import com.ss.core.util.GLayer;
import com.ss.core.util.GLayerGroup;
import com.ss.core.util.GScreen;
import com.ss.core.util.GStage;
import com.ss.core.util.GUI;
import com.ss.gameLogic.StaticObjects.Config;
import com.ss.gameLogic.objects.Spine;

public class GameScene extends GScreen{
    private TextureAtlas atlas;
    private GLayerGroup mainGroup;
    private Image bg;

    @Override
    public void dispose() {

    }

    @Override
    public void init() {
        initTexture();
        initGroup();
        initUI();
    }

    private void initTexture(){
        atlas = GAssetsManager.getTextureAtlas("atlas.atlas");
    }

    private void initGroup(){
        mainGroup = new GLayerGroup();
        GStage.addToLayer(GLayer.ui, mainGroup);
    }

    private void initUI(){
        bg = GUI.createImage(atlas, "bg");
        mainGroup.addActor(bg);

        Spine spine = new Spine();

        spine.skeleton.setPosition(200, 916*Config.ratioY);
        mainGroup.addActor(spine);

        System.out.println("w-h: " + spine.skeleton.getData().getWidth()+ "-" + spine.skeleton.getData().getHeight());
        mainGroup.addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                spine.state.setAnimation(0, "shoot", false);
                spine.state.addAnimation(0, "idle", true, 0);
                System.out.println("time: ");
                return super.touchDown(event, x, y, pointer, button);
            }
        });
    }

    @Override
    public void run() {

    }
}