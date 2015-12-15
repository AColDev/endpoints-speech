package com.gdg.javaspeechendpoints;

import com.sun.speech.freetts.VoiceManager;

/**
 * Created by Spartan on 12/15/15.
 */
public class JavaSpeechEndPoints {
    public static void main(String[] args)
    {
        Voice voiceKevin16 = new Voice("kevin16");

        String[] thingsToSay = new String[]
                {
                        "Welcome to GDG",
                };

        voiceKevin16.say(thingsToSay);
    }
}

class Voice
{
    private String name;
    private com.sun.speech.freetts.Voice systemVoice;

    public Voice(String name)
    {
        this.name = name;
        this.systemVoice = VoiceManager.getInstance().getVoice(this.name);
        this.systemVoice.allocate();
    }

    public void say(String[] thingsToSay)
    {
        for (int i = 0; i < thingsToSay.length; i++)
        {
            this.say( thingsToSay[i] );
        }
    }

    public void say(String thingToSay)
    {
        this.systemVoice.speak(thingToSay);
    }

    public void dispose()
    {
        this.systemVoice.deallocate();
    }
}

    /**VoiceManager freettsVM;
    Voice freettsVoice;

    public JavaSpeechEndPoints(String words) {
        // Most important part!
        System.setProperty("mbrola.base", "/Users/Spartan/Dropbox/GDG/JavaSpeechEndPoints/data/mbrola");
        freettsVM = VoiceManager.getInstance();

        // Simply change to MBROLA voice
        freettsVoice = freettsVM.getVoice("mbrola_us1");

        // Allocate your chosen voice
        freettsVoice.allocate();
        sayWords(words);
    }

    public void sayWords(String words) {
        // Make her speak!
        freettsVoice.speak(words);
    }

    public static void main(String[] args) {
        JavaSpeechEndPoints orangutan = new JavaSpeechEndPoints("String");
        orangutan.sayWords("Something");

        //new JavaSpeechEndPoints("Hello there! Now M BROLA and Free T T S work together!");
    }
}*/