package uvsq.fr.lylia.dao;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * . class abstract Serialization.
 *
 * @author lylia touazi
 * @param <T> objet
 */
public abstract class Serialization<T extends Serializable> {
/**
 * methode createFile.
 *
 * @param obj      obj a créee.
 * @param filename nom ficher.
 * @return obj crée
 */
public final T createFile(final T obj, final String filename) {
if (exists(filename)) {
deleteFile(filename);
}
writeFile(obj, filename);
return obj;
}

/**
 * methode readFile.
 *
 * @param filename nom ficher.
 * @return obj lue
 */
public final T readFile(final String filename) {
try (ObjectInputStream in = new ObjectInputStream(
new BufferedInputStream(
new FileInputStream(filename)))) {
@SuppressWarnings("unchecked")
T obj = (T) in.readObject();
return obj;
} catch (ClassNotFoundException | IOException e) {
return null;
}
}

/**
 * methode updateFile.
 *
 * @param obj    obj a créee.
 * @param filename nom ficher.
 * @return obj modifier
 */
public final T updateFile(final T obj, final String filename) {
if (!exists(filename)) {
createFile(obj, filename);
}
deleteFile(filename);
writeFile(obj, filename);
return obj;
}

/**
 * methode deleteFile.
 *
 * @param filename nom ficher.
 */
public final void deleteFile(final String filename) {
File file = new File(filename);
file.delete();
}

/**
 * methode exists.
 *
 * @param filename nom ficher.
 * @return true si l'objet existe et false sinon.
 */
private boolean exists(final String filename) {
File file = new File(filename);
return file.exists();
}

/**
 * methode writeFile.
 *
 * @param obj      à ecrire.
 * @param filename nom ficher.
 */
public final void writeFile(final T obj, final
String filename) {
ObjectOutputStream oos = null;
try {
final FileOutputStream fichier =
new FileOutputStream(filename);
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
