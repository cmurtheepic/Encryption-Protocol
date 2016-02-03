package com.cmurt.encryption_protocol;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * The Class ObjectCompressionUtil.
 *
 * @param <T> the generic type of the serializable object to be compressed
 */
@SuppressWarnings("unused")
class Compress_Util<T extends Serializable> {

    /**
     * Compress object.
     *
     * @param objectToCompress the object to compress
     * @param outstream the outstream
     * @return the compressed object
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public T compressObject(final T objectToCompress, final OutputStream outstream) throws IOException {

        final GZIPOutputStream gz = new GZIPOutputStream(outstream);

        try (ObjectOutputStream oos = new ObjectOutputStream(gz)) {
            oos.writeObject(objectToCompress);
            oos.flush();
            return objectToCompress;
        } finally {
            outstream.close();
        }

    }

    /**
     * Expand object.
     *
     * @param objectToExpand the object to expand
     * @param instream the instream
     * @return the expanded object
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws ClassNotFoundException the class not found exception
     */
    public T expandObject(@SuppressWarnings("UnusedParameters") final T objectToExpand, final InputStream instream) throws IOException,
            ClassNotFoundException {
        final GZIPInputStream gs = new GZIPInputStream(instream);

        try (ObjectInputStream ois = new ObjectInputStream(gs)) {
            @SuppressWarnings("unchecked")
            T expandedObject = (T) ois.readObject();
            return expandedObject;
        } finally {
            gs.close();

        }
    }

}