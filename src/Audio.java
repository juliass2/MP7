import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Audio {

	private Clip clip;

	public Audio(String fileName) {
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(Audio.class.getResource(fileName));
			clip = AudioSystem.getClip();
			clip.open(ais);
		} catch (Exception e) {
		} // Satisfy the catch
	}

	public void play() {
		try {
			if (clip != null) {
				new Thread() {
					public void run() {
						synchronized (clip) {
							clip.stop();
							clip.setFramePosition(0);
							clip.start();
						}
					}
				}.start();
			}
		} catch (Exception e) {
		} // Satisfy the catch
	}

	public void stop() {
		if (clip == null)
			return;
		clip.stop();
	}

	public void loop() {
		try {
			if (clip != null) {
				new Thread() {
					public void run() {
						synchronized (clip) {
							clip.stop();
							clip.setFramePosition(0);
							clip.loop(Clip.LOOP_CONTINUOUSLY);
						}
					}
				}.start();
			}
		} catch (Exception e) {
		} // Satisfy the catch
	}

	public boolean isActive() {
		return clip.isActive();
	}
}