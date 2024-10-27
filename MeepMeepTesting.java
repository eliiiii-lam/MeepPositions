package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class MeepMeepTesting {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .build();

        myBot.runAction(myBot.getDrive().actionBuilder(new Pose2d(35, 62, Math.toRadians(270)))
                        .splineToLinearHeading(new Pose2d(8,34, Math.toRadians(270)), Math.toRadians(270))
                        .waitSeconds(2)
                        .setReversed(true)
                        .splineToLinearHeading(new Pose2d(40,40, Math.toRadians(120)), Math.toRadians(120))
                        .waitSeconds(2)
                        .splineTo(new Vector2d(55,55), Math.toRadians(45))
                        .waitSeconds(2)
                        .setReversed(true)
                        .splineTo(new Vector2d(50,42), Math.toRadians(300))
                        .waitSeconds(2)
                        .setReversed(false)
                        .splineTo(new Vector2d(55,55), Math.toRadians(45))
                        .waitSeconds(2)
                        .setReversed(true)
                        .splineTo(new Vector2d(54,26), Math.toRadians(360))
                        .waitSeconds(2)
                        .setReversed(false)
                        .splineTo(new Vector2d(55,55), Math.toRadians(45))
                        .waitSeconds(3)
                        .setReversed(true)
                        .splineTo(new Vector2d(-50,60), Math.toRadians(180))


                .build());

        meepMeep.setBackground(MeepMeep.Background.FIELD_INTO_THE_DEEP_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}