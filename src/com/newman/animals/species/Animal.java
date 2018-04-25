package com.newman.animals.species;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.io.Serializable;

public class Animal implements Serializable {
    public String name;
    public int price;
    public int maintenance; // per day; including food price as well
    public int reputation; //scale of 1-10; aka attention given
    public int level; // 1-10;
    private String file_path;
    

//    "res/Armadillo.aiff"

    public Animal(String name, int price, int maintenance, int reputation, int level, String file_path) {
        this.name = name;
        this.price = price;
        this.maintenance = maintenance;
        this.reputation = reputation;
        this.level = level;
        this.file_path = file_path;
    }

    public void PlaySound() {
        File sound = new File(this.file_path);
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(sound));
            clip.start();
            Thread.sleep(clip.getMicrosecondLength() / 1000);
        } catch (Exception e) {

        }
    }
}
