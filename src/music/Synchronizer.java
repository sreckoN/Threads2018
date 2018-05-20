/*
 * Created on May 10, 2018
 *
 */
package music;

import javax.swing.JTextArea;

public class Synchronizer {
    
    private boolean firstVoiceFlag;
    private boolean secondVoiceFlag;
    private volatile JTextArea ekran;
    
    private boolean togetherFlag;

    public Synchronizer(boolean firstVoiceFlag, boolean secondVoiceFlag, boolean together, JTextArea ekran) {
        super();
        this.firstVoiceFlag = firstVoiceFlag;
        this.secondVoiceFlag = secondVoiceFlag;
        this.togetherFlag = together;
        this.ekran = ekran;
    }
    
    public synchronized void singFirstVoice(String lyrics, int delay) {
        while (!firstVoiceFlag) {
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
        while (!secondVoiceFlag) {
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
    	while (!togetherFlag) {
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
        String s = ekran.getText();
        ekran.setText(s+lyrics+"\n");
        try {
            wait(delay);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if(firstVoiceFlag) {
        	firstVoiceFlag = !firstVoiceFlag;
        	togetherFlag = !togetherFlag;
        	notifyAll();
        } else if (togetherFlag) {
        	togetherFlag = !togetherFlag;
        	secondVoiceFlag = !secondVoiceFlag;
        	notifyAll();
        } else if (secondVoiceFlag) {
        	secondVoiceFlag = !secondVoiceFlag;
        	firstVoiceFlag = !firstVoiceFlag;
        	notifyAll();
        }
    }

}

