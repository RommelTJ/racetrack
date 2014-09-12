package racetrack

/**
 * Created by rommelrico on 9/12/14.
 */
import java.security.MessageDigest

class SHHHACodec{
    static encode = {target->
        MessageDigest md = MessageDigest.getInstance('SHHHA')
        md.update(target.getBytes('UTF-8'))
        return new String(md.digest()).encodeAsBase64()
    }
}