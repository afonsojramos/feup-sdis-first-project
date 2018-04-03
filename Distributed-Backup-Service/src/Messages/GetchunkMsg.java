package Messages;

/**
 * Class representing a Getchunk Message
 */
public class GetchunkMsg extends CommonMsg implements msgGenerator {

    /**
     * Regex used to parse a String containing a 'getchunk' message
     */
    private final static String REGEX_STRING =
            "\\s*?GETCHUNK\\s+?(\\d\\.\\d)\\s+?(\\d+?)\\s+(([a-f0-9]){64})\\s+((\\d){1,6})\\s+?\\r\\n\\r\\n";

    /**
     * Getchunk Message Constructor
     *
     * @param receivedMsg Received Message to parse
     */
    public GetchunkMsg(String receivedMsg) {
        super(receivedMsg, REGEX_STRING);
    }

    /**
     * Gethcunk Message constructor
     *
     * @param protocolVersion The communication protocol version
     * @param senderID The peer identifier that will send this message
     * @param fileID The file identifier
     * @param chunkNum The number of the chunk to be sent
     */
    public GetchunkMsg(float protocolVersion, int senderID, String fileID, int chunkNum) {
        super(protocolVersion, senderID, fileID, chunkNum);
    }

    @Override
    public byte[] genMsg() {
        return ("GETCHUNK" + " " +
                protocolVersion + " " +
                senderID + " " +
                fileID + " " +
                chunkNum + " " +
                (char) ASCII_CR + (char) ASCII_LF +
                (char) ASCII_CR + (char) ASCII_LF).getBytes();
    }
}
