package ru.geekbrains.Catch_the_drop;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) {
        getScanTime();
        BeeBee();
        System.out.println(getScanTime());
        Alaaaaaaarm();
    }
//Будильник
    public static void BeeBee() {
        while (true) {
            try {
                File soundFile = new File(String.valueOf("C:/java/pipidaster/src/ru/geekbrains/Catch_the_drop/Sound.wav"));
                AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);
                Clip clip = AudioSystem.getClip();
                clip.open(ais);

                clip.setFramePosition(0);
                clip.start();


                Thread.sleep(clip.getMicrosecondLength() / 1000);
                clip.stop();
                clip.close();

            } catch (UnsupportedAudioFileException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (LineUnavailableException e) {
                e.printStackTrace();
            } catch (InterruptedException exc) {

            }
        }
        }


    public static String getScanTime(){
       System.out.println("Напишите время в формате 00:00");
            Scanner scan = new Scanner(System.in);
            String s = scan.nextLine();
//            System.out.println(s);
            return s;
    }
    public static void Alaaaaaaarm() {




        while (true) {

            if (LocalTime.now().isAfter(LocalTime.parse(""+ getScanTime() +""))) {
                Main.BeeBee();
            }
        }
    }
}
