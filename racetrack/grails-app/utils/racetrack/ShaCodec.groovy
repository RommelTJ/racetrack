package racetrack

/**
 * Created by rommelrico on 9/12/14.
 */
import java.security.MessageDigest

class ShaCodec{
    static encode = {target->
        MessageDigest md = MessageDigest.getInstance('Sha')
        md.update(target.getBytes('UTF-8'))
        return new String(md.digest()).encodeAsBase64()
    }
}