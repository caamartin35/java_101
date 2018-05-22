package musicalNotePlayer;

// MusicalNotePlayer.java

// Simple demo of a simple musical note player.
// It takes two arrays -- one containing the notes, the other containing the times for each note.
// For the notes, 60 is middle C.  61 is C# (the next note).  62 is D (the note after that).
// Legal note range:  1 to 88 (inclusive)
// For the times, 64 is a typical quarter note, 256 a typical whole note
// Legal time range:  1 to 256 (inclusive)
// If the "times" array is null, it will play all quarter notes.

import javax.sound.midi.*;

public class MusicalNotePlayer {

    public static void main(String[] args) throws Exception {
        //                  C, D, E, F, G, A, B, C (middleC)
        int[] scaleNotes ={48,50,52,53,55,57,59,60};
        playNotes(scaleNotes,null); // scale in all quarter notes

        //                   1/4, 1/4, 1/8, 1/8, 1/16, 1/16, 1/2, 1 (whole)
        int[] scaleTimes = {  64,  64,  32,  32,   16,   16, 128, 256};
        playNotes(scaleNotes,scaleTimes); // scale in different-length notes (see above)

        int[] songNotes = { 48, 50, 52, 48, 48, 50, 52, 48,
                52, 53, 55, 52, 53, 55,
                55, 57, 55, 53, 52, 48, 55, 57, 55, 53, 52, 48,
                48, 43, 48, 48, 43, 48 };
        int[] songTimes = { 64, 64, 64, 64, 64, 64, 64, 64,
                64, 64, 128, 64, 64, 128,
                32, 32, 32, 32, 64, 64, 32, 32, 32, 32, 64, 64,
                64, 64, 128, 64, 64, 128 };
        playNotes(songNotes, songTimes); // a familiar song
    }

    /////////////////////////////////////
    // playNotes()
    // You do not have to understand how this code works.
    // You just have to understand how to USE this code.
    /////////////////////////////////////

    public static void playNotes(int[] notes, int[] times) throws Exception {
        int pp4 = 64; // pulses per 1/4 note
        Sequence sequence = new Sequence(Sequence.PPQ,pp4);
        Track track = sequence.createTrack();

        int time = 0;
        for(int i=0;i<notes.length;i++) {
            int dtime = ((times == null) ? pp4 : times[i]);
            track.add(newMidiEvent(ShortMessage.NOTE_ON, notes[i], 64, time));
            track.add(newMidiEvent(ShortMessage.NOTE_OFF, notes[i], 64, time+dtime-1));
            time += dtime;
        }

        track.add(newMidiEvent(ShortMessage.NOTE_ON, 0, 64, time));
        track.add(newMidiEvent(ShortMessage.NOTE_OFF, 0, 64, time+pp4));

        Sequencer sequencer = MidiSystem.getSequencer();
        sequencer.open();
        sequencer.setSequence(sequence);
        sequencer.setTempoInBPM(120);  // place after setSequence
        sequencer.start();

        while (sequencer.getTickPosition() < track.ticks()) {
            try {  Thread.sleep(100); }
            catch (Exception e) { }
        }

        sequencer.stop();
        sequencer.close();
    }

    public static MidiEvent newMidiEvent(int status, int data1, int data2, int ticks)
            throws InvalidMidiDataException {
        ShortMessage msg = new ShortMessage();
        msg.setMessage(status, data1, data2);
        return new MidiEvent(msg,ticks);
    }
}
