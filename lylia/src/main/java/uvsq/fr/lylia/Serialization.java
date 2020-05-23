package uvsq.fr.lylia;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * class abstract Serialization
 * 
 * @author lylia
 */
public abstract class Serialization<T extends Serializable> {
	/***/
	public T createFile(T obj, String filename) {
		if (exists(filename)) {
			deleteFile(filename);
		}
		writeFile(obj, filename);
		return obj;
	}

	public T readFile(String filename) {
		try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filename)))) {
			T obj = (T) in.readObject();
			return obj;
		} catch (ClassNotFoundException | IOException e) {
			return null;
		}
	}

	public T updateFile(T obj, String filename) {
		if (!exists(filename)) {
			createFile(obj, filename);
		}
		deleteFile(filename);
		writeFile(obj, filename);
		return obj;
	}

	public void deleteFile(String filename) {
		File file = new File(filename);
		file.delete();
	}

	private boolean exists(String filename) {
		File file = new File(filename);
		return file.exists();
	}

	public void writeFile(T obj, String filename) {
		ObjectOutputStream oos = null;
		try {
			final FileOutputStream fichier = new FileOutputStream(filename);
			oos = new ObjectOutputStream(fichier);
			oos.writeObject(obj);
		} catch (final java.io.IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (oos != null) {
					oos.flush();
					oos.close();
				}
			} catch (final IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}