/*
 * Created on May 10, 2018
 *
 */
package music;

public class Synchronizer {
    
    private boolean firstVoiceFlag;
    private boolean secondVoiceFlag;

    public Synchronizer(boolean firstVoiceFlag, boolean secondVoiceFlag) {
        super();
        this.firstVoiceFlag = firstVoiceFlag;
        this.secondVoiceFlag = secondVoiceFlag;
    }
    
    public synchronized void singFirstVoice(String lyrics, int delay) {
        while (!firstVoiceFlag || secondVoiceFlag) {
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        sing(lyrics, delay);
    }
    
    public synchronized void singSecondVoice(String lyrics, int delay) {
        while (firstVoiceFlag || !secondVoiceFlag) {
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        sing(lyrics, delay);
    }
    
    public synchronized void singTogether(String lyrics, int delay) {
    	while (firstVoiceFlag || secondVoiceFlag) {
    		try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	sing(lyrics, delay);
    }
    
    private void sing(String lyrics, int delay) {
        System.out.println(lyrics);
        try {
            wait(delay);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        firstVoiceFlag = !firstVoiceFlag;
        secondVoiceFlag = !secondVoiceFlag;
        notifyAll();
    }

}

