/*
 * Created on May 9, 2018
 *
 */
package test;

import javax.swing.JTextArea;
import music.Performance;
import music.Singer;
import music.Synchronizer;
import music.Voice;

public class Test {
    
    private Singer pattiSmith;
    private Singer bruceSpringsteen;
    private Singer pattiAndBruce;
    
    private void initializeSingingInThreads(JTextArea textArea) {
    	String preChorus = "Come on now try and understand\n" + 
        		"The way I feel when I'm in your hands\n" + 
        		"Take my hand come undercover\n" + 
        		"They can't hurt you now\r\n" + 
        		"Can't hurt you now, can't hurt you now\n";
        String chorus = "Because the night belongs to lovers\n" +
        		"Because the night belongs to lust\n" +
        		"Because the night belongs to lovers\n" +
        		"Because the night belongs to us\n";
        String verse2 = "Have I doubt when I'm alone\n" +
        		"Love is a ring, the telephone\n" +
        		"Love is an angel disguised as lust\n" +
        		"Here in our bed until the morning comes\n";
        
        
        boolean stopIt = false;
        Synchronizer synch = new Synchronizer(true,false, false, textArea);
        
        Performance firstVoicePerformance = new Performance(preChorus, 6000);
        Performance secondVoicePerformance = new Performance(verse2, 6000);
        Performance together = new Performance(chorus, 6000);
        
        pattiSmith = new Singer("Patti Smith", Voice.FIRST, firstVoicePerformance, stopIt, synch);
        bruceSpringsteen = new Singer("Bruce Springsteen", Voice.SECOND, secondVoicePerformance, stopIt, synch);
        pattiAndBruce = new Singer("Patti Smith & Bruce Springsteen", Voice.TOGETHER, together, stopIt, synch);
    }
    
    public void startThreads(JTextArea textArea) {
        initializeSingingInThreads(textArea);
        
        pattiSmith.start();
        bruceSpringsteen.start();
        pattiAndBruce.start();
        
    }
    
    public void stopAll() {
    	pattiSmith.setStopIt(true);
        bruceSpringsteen.setStopIt(true);
        pattiAndBruce.setStopIt(true);
    }
    
    public void simpleDelay() {
        long l1 = System.currentTimeMillis();
        System.out.println("Wait 2sec...");
        while (System.currentTimeMillis() < (l1 + 2000)) {
        }
        System.out.println("Done.");
    }
    
    public synchronized void waitDelay() {
        System.out.println("Wait 2sec...");
        try {
            wait(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Done.");
    }
    
    public synchronized void loopDelay() {
        System.out.println("Wait 5 times 2sec...");
        for (int i = 0; i < 4; i++) {
            try {
                wait(2000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } 
            System.out.println(i + 1);
        }
        System.out.println("Done.");
    }
    
    public synchronized void threadWaitDelay() {
        WaitThread w1 = new WaitThread("t1");
        WaitThread w2 = new WaitThread("t2");
        System.out.println("Two threads...");
        w1.start();
        try {
            wait(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        w2.start();
    }
    
}

