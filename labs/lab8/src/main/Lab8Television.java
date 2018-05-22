package main;

// Do not modify the Hw8Television main class.  Make this code work
// by adding the appropriate classes with the appropriate methods as
// described by the test methods called by the main method.

// Note that you do not have to add any code to the test cases, though
// you do have to solve them with general-purpose solutions (and not just
// hard-code the example test cases!).

// Hint: to solve this incrementally, you may wish to comment out
// parts of the test code so the parts you have implemented will compile
// and can be tested as you go.

public class Lab8Television {
    public static void main(String[] args) throws Exception {
        testTelevisionClass();
    }

    //////////////////////////////////
    // testTelevisionClass
    //////////////////////////////////

    private static void testTelevisionClass() {
        System.out.print("Running Television class tests...  ");
        // default constructor:
        Television tv1 = new Television();
        assert(tv1.getStation() == 4);  // default station is channel 4
        assert(tv1.getVolume() == 3);   // default volume is 3 (min = 0, max = 10)
        assert(tv1.isMuted() == false); // default is not muted

        // getStation + setStation:
        tv1.setStation(23);             // legal stations in range [1,999]
        assert(tv1.getStation() == 23); // we just set it!
        tv1.setStation(-1);             // -1 is <=0, illegal station, has no effect
        assert(tv1.getStation() == 23); // -1 was illegal, had no effect
        tv1.setStation(999);
        assert(tv1.getStation() == 999);
        tv1.setStation(1000);           // too large, has no effect!
        assert(tv1.getStation() == 999);

        // getVolume and setVolume:
        tv1.setVolume(0);               // min legal value
        assert(tv1.getVolume() == 0);
        tv1.setVolume(-1);              // too small, no effect!
        assert(tv1.getVolume() == 0);
        tv1.setVolume(11);              // too large, no effect
        assert(tv1.getVolume() == 0);

        // isMuted and setMuted
        tv1.setMuted(true);
        assert(tv1.isMuted() == true);
        tv1.setMuted(false);
        assert(tv1.isMuted() == false);

        // toString
        assert(tv1.toString().equals("tv<station=999,volume=0,muted=false>"));

        // second instance, using a different constructor
        Television tv2 = new Television(5,6,true); // station, volume, isMuted
        assert(tv2.getStation() == 5);
        assert(tv2.getVolume() == 6);
        assert(tv2.isMuted() == true);
        assert(tv2.toString().equals("tv<station=5,volume=6,muted=true>"));

        // independence of two instances
        assert(tv1.getStation() == 999);
        assert(tv2.getStation() == 5);
        tv1.setStation(11);
        tv2.setStation(22);
        assert(tv1.getStation() == 11);
        assert(tv2.getStation() == 22);
        System.out.println("Passed all tests!!!");
    }
}

//////////////////////////////////
// Television class
//////////////////////////////////

class Television {
    // ADD CODE HERE!!!
}
